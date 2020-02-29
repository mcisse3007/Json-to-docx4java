package com.mccm.poc.JsonTodoc4j.document.page;

public abstract class Page {
    public final PageType pageType;

    protected Page(PageType pageType) {
        this.pageType = pageType;
    }
}
