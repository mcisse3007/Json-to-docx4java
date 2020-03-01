package com.mccm.poc.JsonTodoc4j.document.page.impl;

import com.mccm.poc.JsonTodoc4j.document.page.Page;
import com.mccm.poc.JsonTodoc4j.document.page.PageType;
import com.mccm.poc.JsonTodoc4j.document.paragraph.Paragraph;

import java.util.List;

public class DefaultPage extends Page {
    public DefaultPage( List<Paragraph> paragraphs) {
        super(PageType.DEFAULT_PAGE, paragraphs);
    }
}
