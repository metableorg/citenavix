package org.metable.citenavix.domain;

public class NavigableValueItem extends NavigableItem {

    private String value;

    public NavigableValueItem(String value) {
        this.value = value;
    }

    @Override
    public void assign(String value) {
        this.value = value;
    }

    @Override
    public String getIdentifier() {
        return getValue();
    }

    public String getValue() {
        return value;
    }
}
