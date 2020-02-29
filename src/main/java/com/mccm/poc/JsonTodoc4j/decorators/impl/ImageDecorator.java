package com.mccm.poc.JsonTodoc4j.decorators.impl;

import com.mccm.poc.JsonTodoc4j.decorators.ContentDecorator;
import com.mccm.poc.JsonTodoc4j.document.content.impl.Image;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

public class ImageDecorator extends ContentDecorator {

    public ImageDecorator(Image content) {
        super(content);
    }

    @Override
    public void decorate(MainDocumentPart mainDocumentPart) {

    }

}
