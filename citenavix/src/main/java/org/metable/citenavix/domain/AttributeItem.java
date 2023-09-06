package org.metable.citenavix.domain;

public class AttributeItem extends NavigableItem {
    private String value;

    public AttributeItem(String name, String value) {
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
