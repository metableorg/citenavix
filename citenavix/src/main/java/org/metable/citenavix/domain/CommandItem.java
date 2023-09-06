package org.metable.citenavix.domain;

public class CommandItem extends NavigableItem {

    @Override
    public String getLabel() {
        String args = "";

        for (int i = 0; i < getItems().size() - 1; ++i) {
            final Navigable item = getItems().get(i);
            args += item.getLabel() + ", ";
        }

        if (!getItems().isEmpty()) {
            final Navigable item = getItems().get(getItems().size() - 1);
            args += item.getLabel();
        }

        return getName() + ": (" + args + ")";

    }

    public CommandItem(String name) {
        super(name);
    }
}
