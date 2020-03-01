package com.mccm.poc.JsonTodoc4j.decorators.document;

import com.mccm.poc.JsonTodoc4j.decorators.JsonToDocx4JDecorator;
import com.mccm.poc.JsonTodoc4j.decorators.page.impl.DefaultPageDecorator;
import com.mccm.poc.JsonTodoc4j.document.Document;
import com.mccm.poc.JsonTodoc4j.document.page.Page;
import com.mccm.poc.JsonTodoc4j.factory.PageDecoratorFactory;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class DocumentDecorator implements JsonToDocx4JDecorator {

    final Document document;

    Logger logger = LoggerFactory.getLogger(DocumentDecorator.class);

    protected DocumentDecorator(Document document) {
        this.document = document;
    }


    @Override
    public void decorate(WordprocessingMLPackage wordprocessingMLPackage) {
        try {
            List<Page> pages = document.getPages();
            pages
                    .stream()
                    .map(page -> PageDecoratorFactory.getPageDecorator(page))
                    .forEach(decorator -> decorator.decorate(wordprocessingMLPackage));
        } catch (Exception e) {
            logger.error("Document error ---------------");
        }
    }
}
