package org.metable.citenavix.domain;

import java.util.List;

public interface Navigable {

    public Navigable addItem(Navigable item);

    public void assign(String value);

    public void execute();

    public String getIdentifier();

    public List<Navigable> getItems();

    public String getLabel();

    public Navigable getParent();

    public String getPath();

    public void removeAllItems();
}
