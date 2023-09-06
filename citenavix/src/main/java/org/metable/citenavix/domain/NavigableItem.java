package org.metable.citenavix.domain;

import java.util.ArrayList;
import java.util.List;

public class NavigableItem implements Navigable {

    private final List<Navigable> items;

    private final String name;

    private Navigable parent;

    public NavigableItem(String name) {
        this.parent = null;
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

    @Override
    public boolean assign(String value) {
        return false;
    }

    @Override
    public void execute() {
    }

    @Override
    public Navigable addItem(Navigable item) {
        ((NavigableItem) item).parent = this;
        items.add(item);
        return this;
    }

    @Override
    public void removeAllItems() {
        items.clear();
    }

    @Override
    public String getLabel() {
        return getName();
    }
}
