package org.metable.citenavix.domain;

public class CiteNavix extends NavigableItem {

    private final static String ROOT = "citenavix";

    public CiteNavix() {
        super(ROOT);
        addItem(new NavigableItem("filter"));
        addItem(new NewCommand());
        addItem(new NavigableItem("search"));
    }

    @Override
    public String getPath() {
        return getName();
    }
}
