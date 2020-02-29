package com.mccm.poc.JsonTodoc4j.document.content.impl;

import com.mccm.poc.JsonTodoc4j.document.content.Content;
import com.mccm.poc.JsonTodoc4j.document.content.ContentType;

public class Html extends Content {

    protected Html() {
        super(ContentType.HTML);
    }

    private String html;

    public String getHtml() {
        return html;
    }
}
