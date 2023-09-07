package org.metable.citenavix.domain;

public class NameValueItem extends NavigableItem {
    public NameValueItem(String name, Navigable value) {
        super(name);
        addItem(value);
    }

    @Override
    public Navigable addItem(Navigable item) {
        if (!getItems().isEmpty()) {
            throw new java.lang.IllegalArgumentException(getName() + ": one value only.");
        }

        return super.addItem(item);
    }

    public Navigable getValue() {
        return getItems().get(0);
    }

    @Override
    public String getLabel() {
        return getName() + ": " + getValue().getName();
    }
}
