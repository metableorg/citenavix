package org.metable.citenavix.domain;

public class ObjectItem extends NavigableNameItem {
    private final String type;

    public ObjectItem(String name, String type) {
        super(name);
        this.type = type;
    }

    public String getType() {
        return type;
    }
    
    @Override
    public String getLabel() {
        return getName() + " [" + getType() + "]";
    }
}
