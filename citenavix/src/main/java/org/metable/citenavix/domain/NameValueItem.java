package org.metable.citenavix.domain;

public class NameValueItem extends NavigableNameItem {

    @Override
    public void assign(String value) {
        getValue().assign(value);
    }

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

    public NavigableValueItem getValue() {
        return (NavigableValueItem) getItems().get(0);
    }

    @Override
    public String getLabel() {
        return getName() + ": " + getValue().getValue();
    }
}
