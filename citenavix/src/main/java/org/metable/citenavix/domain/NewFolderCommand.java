package org.metable.citenavix.domain;

public class NewFolderCommand extends CommandItem {

    @Override
    public void execute() {
        ArgumentItem nameArg = (ArgumentItem) getItems().get(0);
        ObjectItem folder = new ObjectItem(nameArg.getValue().getValue(), "folder");
        folder.addItem(new NewFolderCommand());
        getParent().addItem(folder);
    }

    public NewFolderCommand() {
        super("new");
        addItem(new ArgumentItem("name", "new folder"));
    }
}
