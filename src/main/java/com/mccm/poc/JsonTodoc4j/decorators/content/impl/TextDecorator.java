package com.mccm.poc.JsonTodoc4j.decorators.content.impl;

import com.mccm.poc.JsonTodoc4j.decorators.content.ContentDecorator;
import com.mccm.poc.JsonTodoc4j.document.content.impl.Text;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

public class TextDecorator extends ContentDecorator {

    public TextDecorator(Text text) {
        super(text);
    }

    @Override
    public void decorate(WordprocessingMLPackage wordprocessingMLPackage) {
        MainDocumentPart mainDocumentPart = wordprocessingMLPackage.getMainDocumentPart();
        Text text = (Text) this.getContent();
        mainDocumentPart.addParagraphOfText(text.getContent());
    }

}
