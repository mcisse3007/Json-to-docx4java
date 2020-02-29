package com.mccm.poc.JsonTodoc4j.decorators;

import com.mccm.poc.JsonTodoc4j.document.content.Content;

public abstract class ContentDecorator implements JsonToDocx4JDecorator {

    protected final Content content;

    protected ContentDecorator(Content content) {
        this.content = content;
    }

}
