package org.metable.citenavix.domain;

public abstract class NavigableItem implements Navigable {

    private final String name;

    public NavigableItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
