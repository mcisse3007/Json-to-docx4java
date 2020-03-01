package com.mccm.poc.JsonTodoc4j.document.content.impl;

import com.mccm.poc.JsonTodoc4j.document.content.Content;
import com.mccm.poc.JsonTodoc4j.document.content.ContentType;

public class Html extends Content {

    public Html(String html) {
        super(ContentType.HTML);
        this.html = html;
    }

    private String html;

    public String getHtml() {
        return html;
    }
}
