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
    public Navigable addItem(Navigable item) {
        checkForUniqeness(item);
        ((NavigableItem) item).parent = this;
        items.add(item);
        return this;
    }

    private void checkForUniqeness(Navigable targetItem) {
        for (Navigable item : items) {
            if (item.getIdentifier().equals(targetItem.getIdentifier())) {
                throw new java.lang.IllegalArgumentException(targetItem.getIdentifier() + " is not unique.");
            }
        }
    }

    @Override
    public void execute() {
    }

    @Override
    public List<Navigable> getItems() {
        return items;
    }

    @Override
    public String getLabel() {
        return getIdentifier();
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
    public void removeAllItems() {
        items.clear();
    }
}
