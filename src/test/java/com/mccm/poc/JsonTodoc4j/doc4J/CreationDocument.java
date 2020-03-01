package com.mccm.poc.JsonTodoc4j.doc4J;

import com.mccm.poc.JsonTodoc4j.decorators.document.impl.DefaultDocumentDecorator;
import com.mccm.poc.JsonTodoc4j.document.Document;
import com.mccm.poc.JsonTodoc4j.document.content.Content;
import com.mccm.poc.JsonTodoc4j.document.content.impl.Html;
import com.mccm.poc.JsonTodoc4j.document.content.impl.Text;
import com.mccm.poc.JsonTodoc4j.document.page.Page;
import com.mccm.poc.JsonTodoc4j.document.page.impl.DefaultPage;
import com.mccm.poc.JsonTodoc4j.document.page.impl.PageDeGarde;
import com.mccm.poc.JsonTodoc4j.document.paragraph.Paragraph;
import com.mccm.poc.JsonTodoc4j.document.paragraph.impl.DefaultParagraph;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CreationDocument {

    @Test
    public void documentCreationTest() throws Docx4JException {

        // Create the package
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();

        Document document = createDocument();

        DefaultDocumentDecorator decorator = new DefaultDocumentDecorator(document);

        decorator.decorate(wordMLPackage);

        // Save it
        wordMLPackage.save(new java.io.File("/tmp/mccm-the-creator.docx"));
    }

    private Document createDocument() {
        String nomDocument = "Nom du document";
        List<Page> pages = new ArrayList<>();
        List<Paragraph> paragraphs = new ArrayList<>();
        Paragraph paragraph = createParagraph(createContents());
        paragraphs.add(paragraph);
        pages.add(new PageDeGarde());
        pages.add(createPage(paragraphs));

        return new Document(nomDocument, pages);
    }

    private List<Content> createContents() {
        List<Content> contents = new ArrayList<>();
        contents.add(new Html("<html><body><h1> WELCOME TO THIS DEMO</h1><p><strong>Hello World!</strong></p></body></html>"));
        contents.add(new Html("<html>\n" +
                "<body>\n" +
                "\n" +
                "<h2>HTML Image</h2>\n" +
                "<img src=\"img_girl.jpg\" alt=\"Girl in a jacket\" width=\"500\" height=\"600\">\n" +
                "\n" +
                "</body>\n" +
                "</html>"));
        contents.add(new Text("TEXT CONTENT THAT SHbottomAsBytesOULD COME SECOND IN THE PAGE"));
        contents.add(new Text("TEXT CONTENT THAT SHOULD COME THIRD IN THE PAGE"));
        contents.add(new Text("TEXT CONTENT THAT SHOULD COME FOURTH IN THE PAGE"));
        contents.add(new Text("TEXT CONTENT THAT SHOULD COME FIFTH IN THE PAGE"));
        contents.add(new Text("TEXT CONTENT THAT SHOULD COME SIXT IN THE PAGE"));
        return contents;
    }

    private Paragraph createParagraph(List<Content> contents) {
        return new DefaultParagraph(contents);
    }

    private Page createPage(List<Paragraph> paragraphs) {
        return new DefaultPage(paragraphs);
    }
}
