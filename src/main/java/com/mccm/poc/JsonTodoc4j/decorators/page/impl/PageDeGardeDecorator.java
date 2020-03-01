package com.mccm.poc.JsonTodoc4j.decorators.page.impl;

import com.mccm.poc.JsonTodoc4j.decorators.page.PageDecorator;
import com.mccm.poc.JsonTodoc4j.document.page.impl.PageDeGarde;
import org.docx4j.openpackaging.contenttype.ContentType;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.PartName;
import org.docx4j.openpackaging.parts.WordprocessingML.AlternativeFormatInputPart;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.org.apache.poi.util.IOUtils;
import org.docx4j.relationships.Relationship;
import org.docx4j.wml.CTAltChunk;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;

public class PageDeGardeDecorator extends PageDecorator {

    private Logger logger = LoggerFactory.getLogger(PageDeGardeDecorator.class);

    private static final String CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";


    public PageDeGardeDecorator(PageDeGarde page) {
        super(page);
    }

    @Override
    public void decorate(WordprocessingMLPackage wordprocessingMLPackage) {
        WordprocessingMLPackage pdgMlPackage;
        try {

            FileInputStream pdg = new FileInputStream(new File("/tmp/Document.docx"));
            MainDocumentPart mainDocumentPart = wordprocessingMLPackage.getMainDocumentPart();
            byte[] pdgAsBytes = IOUtils.toByteArray(pdg);
            String partName = "/pdg0.docx";
            AlternativeFormatInputPart afiPart = new AlternativeFormatInputPart(new PartName(partName));
            afiPart.setContentType(new ContentType(CONTENT_TYPE));
            afiPart.setBinaryData(pdgAsBytes);
            Relationship altChunkRel = mainDocumentPart.addTargetPart(afiPart);
            CTAltChunk chunk = getContextFactory().createCTAltChunk();
            chunk.setId(altChunkRel.getId());
            mainDocumentPart.addObject(chunk);
            mainDocumentPart.convertAltChunks();
            super.decorate(wordprocessingMLPackage);

        } catch (Exception e) {
            logger.error("PAGE ERR _________", e);
        }
    }

}
