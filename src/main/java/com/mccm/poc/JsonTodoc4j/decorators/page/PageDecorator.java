package com.mccm.poc.JsonTodoc4j.decorators.page;

import com.mccm.poc.JsonTodoc4j.decorators.JsonToDocx4JDecorator;
import com.mccm.poc.JsonTodoc4j.document.page.Page;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.Br;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.P;
import org.docx4j.wml.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PageDecorator implements JsonToDocx4JDecorator {

    Logger logger = LoggerFactory.getLogger(PageDecorator.class);

    final Page page;

    protected PageDecorator(Page page) {
        this.page = page;
    }

    protected Page getPage(){
        return this.page;
    }

    @Override
    public void decorate(WordprocessingMLPackage wordprocessingMLPackage) {
        try {
            wordprocessingMLPackage.getMainDocumentPart().addObject(createPageBreak());
        } catch (Exception e) {
            logger.error("PAGE EXCEPTION----------------", e);
        }
    }

    private P createPageBreak() {
        ObjectFactory wmlObjectFactory = getContextFactory();
        P p = wmlObjectFactory.createP();
        R r = wmlObjectFactory.createR();
        p.getContent().add(r);
        Br br = wmlObjectFactory.createBr();
        r.getContent().add(br);
        br.setType(org.docx4j.wml.STBrType.PAGE);
        return  p;
    }
}
