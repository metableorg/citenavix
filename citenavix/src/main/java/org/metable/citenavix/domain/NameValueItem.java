package org.metable.citenavix.domain;

public class NameValueItem extends NavigableNameItem {

    public NameValueItem(String name, NavigableValueItem value) {
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

    @Override
    public void assign(String value) {
        getValue().assign(value);
    }

    @Override
    public String getLabel() {
        return getName() + ": " + getValue().getValue();
    }

    public NavigableValueItem getValue() {
        return (NavigableValueItem) getItems().get(0);
    }
}
