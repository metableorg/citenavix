package org.metable.citenavix.domain;

public class CiteNavix extends NavigableItem {

    public final static String ROOT = "citenavix";

    public CiteNavix() {
        super(null, ROOT);
        items.add(new NavigableItem(this, "filter"));
        items.add(new NewCommand(this));
        items.add(new NavigableItem(this, "search"));
    }

    @Override
    public String getPath() {
        return getName();
    }
}
