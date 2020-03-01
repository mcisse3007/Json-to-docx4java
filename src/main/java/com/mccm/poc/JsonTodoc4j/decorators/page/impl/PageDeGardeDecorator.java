package com.mccm.poc.JsonTodoc4j.decorators.page.impl;

import com.mccm.poc.JsonTodoc4j.decorators.page.PageDecorator;
import com.mccm.poc.JsonTodoc4j.document.page.impl.PageDeGarde;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.relationships.Namespaces;
import org.docx4j.relationships.Relationship;
import org.docx4j.relationships.Relationships;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PageDeGardeDecorator extends PageDecorator {

    private Logger logger = LoggerFactory.getLogger(PageDeGardeDecorator.class);

    private static final List<String> MERGED_REL = Arrays.asList(Namespaces.IMAGE,Namespaces.SETTINGS);


    public PageDeGardeDecorator(PageDeGarde page) {
        super(page);
    }

    @Override
    public void decorate(WordprocessingMLPackage wordprocessingMLPackage) {
        WordprocessingMLPackage pdgMlPackage;
        try {
            pdgMlPackage = WordprocessingMLPackage.load(new File("/tmp/Document.docx"));

            Relationships rela = pdgMlPackage.getRelationshipsPart().getRelationships();
            for ( Relationship r : rela.getRelationship() ) {
                if(addRelationShip(r)){
                    wordprocessingMLPackage.getRelationshipsPart().addRelationship((r));
                }
            }
            pdgMlPackage.getMainDocumentPart().getContent().stream().forEach(o -> {
                wordprocessingMLPackage.getMainDocumentPart().addObject(o);
            });

            super.decorate(wordprocessingMLPackage);
        } catch (Exception e) {
            logger.error("PAGE ERR _________",e);
        }
    }

    private boolean addRelationShip(Relationship r) {
       return MERGED_REL.contains(r.getType());
    }
}
