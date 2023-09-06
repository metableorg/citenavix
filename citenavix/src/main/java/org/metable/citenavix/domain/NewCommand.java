package org.metable.citenavix.domain;

public class NewCommand extends NavigableItem {

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

    @Override
    public void execute() {
        TypeArgument typeArg = null;

        for (Navigable item : getItems()) {
            if (item instanceof TypeArgument) {
                typeArg = (TypeArgument) item;
            }
        }

        if (typeArg == null) {
            return;
        }

        if (typeArg.getValue().equals("folder")) {
            NameArgument nameArg = null;

            for (Navigable item : getItems()) {
                if (item instanceof NameArgument) {
                    nameArg = (NameArgument) item;

                    getParent().addItem(new NavigableItem(nameArg.getValue()));
                }
            }

        }
    }

    public NewCommand() {
        super("new");
        addItem(new TypeArgument());
    }
}
