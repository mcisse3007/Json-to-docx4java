package com.mccm.poc.JsonTodoc4j.decorators;

import com.mccm.poc.JsonTodoc4j.decorators.impl.HtmlDecorator;
import com.mccm.poc.JsonTodoc4j.decorators.impl.ImageDecorator;
import com.mccm.poc.JsonTodoc4j.decorators.impl.TableDecorator;
import com.mccm.poc.JsonTodoc4j.decorators.impl.TextDecorator;
import com.mccm.poc.JsonTodoc4j.document.content.Content;
import com.mccm.poc.JsonTodoc4j.document.content.impl.Html;
import com.mccm.poc.JsonTodoc4j.document.content.impl.Image;
import com.mccm.poc.JsonTodoc4j.document.content.impl.Table;
import com.mccm.poc.JsonTodoc4j.document.content.impl.Text;

public class ContentDecoratorFactory {

    public static ContentDecorator getContentDecorator(Content content){

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
                return new TableDecorator((table));
            default:
                throw new IllegalStateException("Unexpected value: " + content.getType());
        }
    }
}
