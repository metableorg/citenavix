package org.metable.citenavix.domain;

import java.util.StringJoiner;

public class CommandItem extends NavigableNameItem {

    public CommandItem(String name) {
        super(name);
    }

    @Override
    public String getLabel() {
        final StringJoiner joiner = new StringJoiner(", ");

        for (Navigable item : getItems()) {
            joiner.add(item.getLabel());
        }

        return getName() + ": (" + joiner.toString() + ")";

    }
}
