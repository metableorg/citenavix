package org.metable.citenavix.domain;

import java.util.List;

public interface Navigable {

    public List<Navigable> getItems();

    public String getName();

    public Navigable getParent();

    public String getPath();
    
    public boolean assign(String value);

    public void execute();
    
    public void addItem(Navigable item);

    public void removeAllItems();
}
