package org.metable.citenavix.domain;

import java.util.StringJoiner;

public class CommandItem extends NavigableNameItem {

    @Override
    public String getLabel() {
        final StringJoiner joiner = new StringJoiner(", ");

        for (Navigable item : getItems()) {
            joiner.add(item.getLabel());
        }

        return getName() + ": (" + joiner.toString() + ")";

    }

    public CommandItem(String name) {
        super(name);
    }
}
