package com.mccm.poc.JsonTodoc4j.document;

import com.mccm.poc.JsonTodoc4j.document.page.Page;

import java.util.List;





/**
 * document extrait en json de la base
 *
 * {
 * ---------------------------------------------------PAGE-------------------------------------
 *     "pages" : [{
 *     -----------------------------------------------PARAGRAPH-----------------------------------
 *         "paragraphs":[{
 *         -------------------------------------------CONTENT--------------------------------------
 *             "type" : "TABLE",
 *             "content" : [{
 *             **********************************SUMMARY*********************************
 *                 "titre" : "sommaire",
 *                 "numeroDePage": 1,
 *             }]
 *         }],
 *         "type" : "SUMMARY"
 *     },{}]
 * }
 * */


public class Document {

    private String nomDocument;

    private List<Page> pages;

}
