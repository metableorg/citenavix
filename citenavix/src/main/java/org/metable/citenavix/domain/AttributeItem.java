package org.metable.citenavix.domain;

public class AttributeItem extends NameValueItem {
    public AttributeItem(String name, String value) {
        super(name, new NavigableValueItem(value));
    }
}
