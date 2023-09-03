package org.metable.citenavix.domain;

public class NewCommand extends NavigableItem {

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

                    getParent().addItem(new NavigableItem(getParent(), nameArg.getValue()));
                }
            }

        }
    }

    public NewCommand(Navigable parent) {
        super(parent, "new");
        items.add(new TypeArgument(this));
    }
}
