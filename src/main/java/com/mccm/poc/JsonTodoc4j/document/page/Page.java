package com.mccm.poc.JsonTodoc4j.document.page;

import com.mccm.poc.JsonTodoc4j.document.paragraph.Paragraph;

import java.util.List;

public abstract class Page {
    public final PageType type;

    public PageType getType() {
        return type;
    }

    final List<Paragraph> paragraphs;

    protected Page(PageType pageType, List<Paragraph> paragraphs) {
        this.type = pageType;
        this.paragraphs = paragraphs;
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }
}
