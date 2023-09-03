package org.metable.citenavix.domain;

public class NameArgument extends NavigableItem {
    private String value;

    public NameArgument(Navigable parent) {
        super(parent, "name");
        value = "";
    }

    @Override
    public boolean assign(String value) {
        this.value = value;
        return false;
    }

    public String getValue() {
        return value;
    }
}
