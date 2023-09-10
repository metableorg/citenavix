package org.metable.citenavix.domain;

public class CiteNavix extends ObjectItem {

    @Override
    public String getLabel() {
        return "CiteNavix"; 
    }

    public CiteNavix() {
        super("", "");
        addItem(new NewFolderCommand());
    }

    @Override
    public String getPath() {
        return getName();
    }
}
