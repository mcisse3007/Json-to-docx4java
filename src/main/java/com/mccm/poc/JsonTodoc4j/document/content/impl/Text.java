package com.mccm.poc.JsonTodoc4j.document.content.impl;

import com.mccm.poc.JsonTodoc4j.document.content.Content;
import com.mccm.poc.JsonTodoc4j.document.content.ContentType;

public class Text extends Content {

    String content;

    public Text(String content) {
        super(ContentType.TEXT);
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
