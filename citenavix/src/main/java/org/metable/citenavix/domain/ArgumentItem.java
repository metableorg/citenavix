package org.metable.citenavix.domain;

public class ArgumentItem extends NavigableItem {
    private String value;

    public ArgumentItem(String name, String value) {
        super(name);
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    @Override
    public String getLabel() {
        return getName() + ": " + getValue();
    }
}
