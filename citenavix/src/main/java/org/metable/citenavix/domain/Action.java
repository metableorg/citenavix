package org.metable.citenavix.domain;

import java.util.List;

public class Action extends NavigableItem {

    public Action(String name) {
        super(name);
    }

    @Override
    public List<Navigable> getActions() {
        return null;
    }
}
