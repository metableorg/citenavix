package org.metable.citenavix.domain;

public class CiteNavix extends ObjectItem {

    private final static String ROOT = "citenavix";

    public CiteNavix() {
        super(ROOT, "");
        addItem(new NewFolderCommand());
    }

    @Override
    public String getPath() {
        return getName();
    }
}
