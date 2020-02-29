package com.mccm.poc.JsonTodoc4j.decorators;

import com.mccm.poc.JsonTodoc4j.document.content.ContentType;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

public interface JsonToDocx4JDecorator {

     void decorate(MainDocumentPart mainDocumentPart);


}
