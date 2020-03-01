package com.mccm.poc.JsonTodoc4j.document.paragraph;

import com.mccm.poc.JsonTodoc4j.document.content.Content;

import java.util.List;

public abstract class Paragraph {

   final List<Content> contents;

    protected Paragraph(List<Content> contents) {
        this.contents = contents;
    }

    public List<Content> getContents() {
        return contents;
    }
}
