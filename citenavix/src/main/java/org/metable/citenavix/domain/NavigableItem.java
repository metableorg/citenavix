package org.metable.citenavix.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class NavigableItem implements Navigable {

    private final List<Navigable> items;

    private Navigable parent;

    public NavigableItem() {
        this.parent = null;
        this.items = new ArrayList<>();
    }

    @Override
    public List<Navigable> getItems() {
        return items;
    }

    @Override
    public Navigable getParent() {
        return parent;
    }

    @Override
    public String getPath() {
        return getParent().getPath() + "/" + getIdentifier();
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
        return getIdentifier();
    }
}
