package org.metable.citenavix.domain;

public class NavigableNameItem extends NavigableItem {

    private String name;

    NavigableNameItem(String name) {
        this.name = name;
    }

    @Override
    public void assign(String value) {
        name = value;
    }

    @Override
    public String getIdentifier() {
        return getName();
    }

    public String getName() {
        return name;
    }
}
