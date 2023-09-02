package org.metable.citenavix.domain;

import java.util.ArrayList;
import java.util.List;

public class NavigableItem implements Navigable {

    protected final List<Navigable> items;

    private final String name;

    private final Navigable parent;
    public NavigableItem(Navigable parent, String name) {
        this.parent = parent;
        this.name = name;
        this.items = new ArrayList<>();
    }

    @Override
    public List<Navigable> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    @Override
    public Navigable getParent() {
        return parent;
    }

    @Override
    public String getPath() {
        return getParent().getPath() + "/" + getName();
    }

}
