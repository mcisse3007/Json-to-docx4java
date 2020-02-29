package com.mccm.poc.JsonTodoc4j.document.content;

public abstract class Content {

    public final ContentType type;
    protected Content(ContentType type) {
        this.type = type;
    }
}
