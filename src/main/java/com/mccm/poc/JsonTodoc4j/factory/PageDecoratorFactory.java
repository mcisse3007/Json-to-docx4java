package com.mccm.poc.JsonTodoc4j.factory;

import com.mccm.poc.JsonTodoc4j.decorators.page.PageDecorator;
import com.mccm.poc.JsonTodoc4j.decorators.page.impl.DefaultPageDecorator;
import com.mccm.poc.JsonTodoc4j.decorators.page.impl.PageDeGardeDecorator;
import com.mccm.poc.JsonTodoc4j.document.page.Page;
import com.mccm.poc.JsonTodoc4j.document.page.impl.DefaultPage;
import com.mccm.poc.JsonTodoc4j.document.page.impl.PageDeGarde;

public class PageDecoratorFactory {

    public static PageDecorator getPageDecorator(Page page){
        if(page == null)  throw new IllegalStateException("Null content");
        switch (page.getType()) {
            case PAGE_DE_GARDE:
                PageDeGarde pageDeGarde = (PageDeGarde) page;
                return new PageDeGardeDecorator(pageDeGarde);
            case DEFAULT_PAGE:
                DefaultPage defaultPage = (DefaultPage) page;
                return new DefaultPageDecorator(defaultPage);
            default:
                throw new IllegalStateException("Unexpected value : " + page.getType());
        }
    }
}
