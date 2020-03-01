package com.mccm.poc.JsonTodoc4j.decorators;

import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.ObjectFactory;

public interface JsonToDocx4JDecorator {

     void decorate (WordprocessingMLPackage wordprocessingMLPackage) ;

     default ObjectFactory getContextFactory(){
          return Context.getWmlObjectFactory();
     }

}
