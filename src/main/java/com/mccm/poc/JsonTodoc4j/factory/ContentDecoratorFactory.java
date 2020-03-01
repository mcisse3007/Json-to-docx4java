package com.mccm.poc.JsonTodoc4j.factory;

import com.mccm.poc.JsonTodoc4j.decorators.content.ContentDecorator;
import com.mccm.poc.JsonTodoc4j.decorators.content.impl.HtmlDecorator;
import com.mccm.poc.JsonTodoc4j.decorators.content.impl.ImageDecorator;
import com.mccm.poc.JsonTodoc4j.decorators.content.impl.TableDecorator;
import com.mccm.poc.JsonTodoc4j.decorators.content.impl.TextDecorator;
import com.mccm.poc.JsonTodoc4j.document.content.Content;
import com.mccm.poc.JsonTodoc4j.document.content.impl.Html;
import com.mccm.poc.JsonTodoc4j.document.content.impl.Image;
import com.mccm.poc.JsonTodoc4j.document.content.impl.Table;
import com.mccm.poc.JsonTodoc4j.document.content.impl.Text;

public class ContentDecoratorFactory {

    public static ContentDecorator getContentDecorator(Content content){
        if(content == null)  throw new IllegalStateException("Null content");
        switch (content.getType()) {
            case TEXT:
                Text text = (Text) content;
                return new TextDecorator(text);
            case IMAGE:
                Image image = (Image)content;
                return new ImageDecorator(image);
            case HTML:
                Html html = (Html)content;
                return new HtmlDecorator(html);
            case TABLE:
                Table table = (Table)content;
                return new TableDecorator(table);
            default:
                throw new IllegalStateException("Unexpected value : " + content.getType());
        }
    }
}
