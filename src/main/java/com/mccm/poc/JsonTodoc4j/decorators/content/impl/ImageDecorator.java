package com.mccm.poc.JsonTodoc4j.decorators.content.impl;

import com.mccm.poc.JsonTodoc4j.decorators.content.ContentDecorator;
import com.mccm.poc.JsonTodoc4j.document.content.impl.Image;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

public class ImageDecorator extends ContentDecorator {

    public ImageDecorator(Image content) {
        super(content);
    }

    @Override
    public void decorate(WordprocessingMLPackage wordprocessingMLPackage) {

    }

}
