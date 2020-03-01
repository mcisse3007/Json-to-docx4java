package com.mccm.poc.JsonTodoc4j.decorators.page.impl;

import com.mccm.poc.JsonTodoc4j.decorators.page.PageDecorator;
import com.mccm.poc.JsonTodoc4j.document.page.Page;
import com.mccm.poc.JsonTodoc4j.document.paragraph.Paragraph;
import com.mccm.poc.JsonTodoc4j.factory.ContentDecoratorFactory;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DefaultPageDecorator extends PageDecorator {

    public DefaultPageDecorator(Page page) {
        super(page);
    }

    Logger logger = LoggerFactory.getLogger(DefaultPageDecorator.class);

    @Override
    public void decorate(WordprocessingMLPackage wordprocessingMLPackage) {
        try {
            List<Paragraph> paragraphs = getPage().getParagraphs();
            for (Paragraph paragraph: paragraphs) {
                paragraph.getContents()
                        .stream()
                        .map(ContentDecoratorFactory::getContentDecorator)
                        .forEach(decorator -> decorator.decorate(wordprocessingMLPackage));
            }
            super.decorate(wordprocessingMLPackage);
        } catch (Exception e) {
            logger.error("PAGE EXCEPTION----------------", e);
        }
    }
}
