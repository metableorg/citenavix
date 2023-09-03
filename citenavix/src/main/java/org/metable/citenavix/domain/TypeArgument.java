package org.metable.citenavix.domain;

public class TypeArgument extends NavigableItem {
    private String value;

    public TypeArgument(Navigable parent) {
        super(parent, "type");
        value = "";
    }

    @Override
    public boolean assign(String value) {
        this.value = value;

        if (this.value.equals("folder")) {
            getParent().removeAllItems();
            getParent().addItem(this);
            getParent().addItem(new NameArgument(getParent()));
            return true;
        }

        return false;
    }

    public String getValue() {
        return value;
    }
}
