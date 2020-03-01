package com.mccm.poc.JsonTodoc4j.decorators.content.impl;

import com.mccm.poc.JsonTodoc4j.decorators.content.ContentDecorator;
import com.mccm.poc.JsonTodoc4j.document.content.impl.Html;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.AltChunkType;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HtmlDecorator extends ContentDecorator {

    Html content;

    Logger logger = LoggerFactory.getLogger(HtmlDecorator.class);

    public HtmlDecorator(Html content) {
        super(content);
        this.content = content;
    }

    @Override
    public void decorate(WordprocessingMLPackage wordprocessingMLPackage) {
        try {
            MainDocumentPart mainDocumentPart = wordprocessingMLPackage.getMainDocumentPart();
            mainDocumentPart.addAltChunk(AltChunkType.Html, this.content.getHtml().getBytes());
        } catch (Docx4JException e) {
            logger.error("HTML EXCEPTION----------------", e);
        }
    }
}
