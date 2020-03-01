package com.mccm.poc.JsonTodoc4j.decorators.content.impl;

import com.mccm.poc.JsonTodoc4j.decorators.content.ContentDecorator;
import com.mccm.poc.JsonTodoc4j.document.content.impl.Table;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.*;

import java.math.BigInteger;

public class TableDecorator extends ContentDecorator {

    
    public TableDecorator(Table content) {
        super(content);
    }

    private static void setFontSize(RPr runProperties, String fontSize) {
        HpsMeasure size = new HpsMeasure();
        size.setVal(new BigInteger(fontSize));
        runProperties.setSz(size);
        runProperties.setSzCs(size);
    }

    private static void addBoldStyle(RPr runProperties) {
        BooleanDefaultTrue b = new BooleanDefaultTrue();
        b.setVal(true);
        runProperties.setB(b);
    }

    private static void addBorders(Tbl table) {
        table.setTblPr(new TblPr());
        CTBorder border = new CTBorder();
        border.setColor("auto");
        border.setSz(new BigInteger("4"));
        border.setSpace(new BigInteger("0"));
        border.setVal(STBorder.SINGLE);

        TblBorders borders = new TblBorders();
        borders.setBottom(border);
        borders.setLeft(border);
        borders.setRight(border);
        borders.setTop(border);
        borders.setInsideH(border);
        borders.setInsideV(border);
        table.getTblPr().setTblBorders(borders);
    }

    @Override
    public void decorate(WordprocessingMLPackage wordprocessingMLPackage) {

        Tbl docxTable = getContextFactory().createTbl();
        Tr tableRow = getContextFactory().createTr();

        MainDocumentPart mainDocumentPart = wordprocessingMLPackage.getMainDocumentPart();
        addRegularTableCell(tableRow, mainDocumentPart.createParagraphOfText("Normal text"));
        addStyledTableCell(tableRow, "Bold text", true, null);
        addStyledTableCell(tableRow, "Bold large text", true, "40");

        docxTable.getContent().add(tableRow);
        addBorders(docxTable);
    }

    private void addRegularTableCell(Tr tableRow, P content) {
        Tc tableCell = getContextFactory().createTc();
        tableCell.getContent().add(content);
        tableRow.getContent().add(tableCell);
    }

    private void addStyledTableCell(Tr tableRow, String content, boolean bold, String fontSize) {
        Tc tableCell = getContextFactory().createTc();
        addStyling(tableCell, content, bold, fontSize);
        tableRow.getContent().add(tableCell);
    }

    private void addStyling(Tc tableCell, String content, boolean bold, String fontSize) {
        P paragraph = getContextFactory().createP();
        Text text = getContextFactory().createText();
        text.setValue(content);
        R run = getContextFactory().createR();
        run.getContent().add(text);
        paragraph.getContent().add(run);

        RPr runProperties = getContextFactory().createRPr();
        if (bold) {
            addBoldStyle(runProperties);
        }

        if (fontSize != null && !fontSize.isEmpty()) {
            setFontSize(runProperties, fontSize);
        }

        run.setRPr(runProperties);

        tableCell.getContent().add(paragraph);
    }


}
