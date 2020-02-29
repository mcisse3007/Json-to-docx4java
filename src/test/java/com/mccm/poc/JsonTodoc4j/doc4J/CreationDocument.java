package com.mccm.poc.JsonTodoc4j.doc4J;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.junit.jupiter.api.Test;

public class CreationDocument {

    @Test
    public void createDocument() throws Docx4JException {
        // Create the package
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();


        MainDocumentPart mainDocumentPart = wordMLPackage.getMainDocumentPart();



        // Add styled paragraph if text
        mainDocumentPart.addStyledParagraphOfText("style1", "Hello world");


        //mainDocumentPart.

        // Save it
        wordMLPackage.save(new java.io.File("mccm-the-creator.docx") );
    }
}
