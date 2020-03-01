package com.mccm.poc.JsonTodoc4j.decorators.content;

import com.mccm.poc.JsonTodoc4j.decorators.JsonToDocx4JDecorator;
import com.mccm.poc.JsonTodoc4j.document.content.Content;

public abstract class ContentDecorator implements JsonToDocx4JDecorator {

    protected final Content content;

    protected ContentDecorator(Content content) {
        this.content = content;
    }

    public Content getContent() {
        return content;
    }
}
