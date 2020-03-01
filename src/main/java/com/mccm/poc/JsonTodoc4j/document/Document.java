package com.mccm.poc.JsonTodoc4j.document;

import com.mccm.poc.JsonTodoc4j.document.page.Page;

import java.util.List;
/**
 * document extrait en json de la base
 *
 * {
 *     "pages" : [{"type" : "PAGE_DE_GARDE",  },{ "type" : "SUMMARY" },{
 *          "paragraphs":[{
 *               "type" : "HTML",
 *               "html":"<html><body></body></html>"
 *           }],
 *         "type" : "DEFAULT_PAGE"
 *     }
 *    ]
 * }
 * */

public class Document {

    private final String nomDocument;

    private final List<Page> pages;

    public Document(String nomDocument, List<Page> pages) {
        this.nomDocument = nomDocument;
        this.pages = pages;
    }

    public List<Page> getPages() {
        return pages;
    }

    public String getNomDocument() {
        return nomDocument;
    }
}
