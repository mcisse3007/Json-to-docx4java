package com.mccm.poc.JsonTodoc4j.document.content;

public abstract class Content {

    private final ContentType type;

    protected Content(ContentType type) {
        this.type = type;
    }

    public ContentType getType() {
        return type;
    }
}
