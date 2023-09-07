package org.metable.citenavix.domain;

public class ArgumentItem extends NameValueItem {
    public ArgumentItem(String name, String value) {
        super(name, new NavigableItem(value));
    }
}
