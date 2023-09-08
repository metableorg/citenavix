package org.metable.citenavix.domain;

public class CiteNavix extends ObjectItem {

    public CiteNavix() {
        super("", "");
        addItem(new NewFolderCommand());
    }

    @Override
    public String getPath() {
        return getName();
    }
}
