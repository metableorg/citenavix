package org.metable.citenavix.domain;

import java.util.StringJoiner;

public class ListItem extends ObjectItem {

    public ListItem(String name) {
        super(name, "list");
    }

    @Override
    public String getLabel() {
        final StringJoiner joiner = new StringJoiner(", ");

        for (Navigable item : getItems()) {
            joiner.add(item.getLabel());
        }

        return getName() + ": [" + joiner.toString() + "]";
    }
}
