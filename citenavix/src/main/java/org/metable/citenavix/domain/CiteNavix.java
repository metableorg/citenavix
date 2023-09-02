package org.metable.citenavix.domain;

public class CiteNavix extends NavigableItem {

    public CiteNavix() {
        super(null, "citenavix");
        items.add(new NavigableItem(this, "filter"));
        items.add(new NavigableItem(this, "new"));
        items.add(new NavigableItem(this, "search"));
    }

    @Override
    public String getPath() {
        return getName();
    }
}
