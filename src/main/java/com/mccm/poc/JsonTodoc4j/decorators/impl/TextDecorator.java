package com.mccm.poc.JsonTodoc4j.decorators.impl;

import com.mccm.poc.JsonTodoc4j.decorators.ContentDecorator;
import com.mccm.poc.JsonTodoc4j.document.content.impl.Text;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

public class TextDecorator extends ContentDecorator {

    public TextDecorator(Text text) {
        super(text);
    }

    @Override
    public void decorate(MainDocumentPart mainDocumentPart) {

    }

}
