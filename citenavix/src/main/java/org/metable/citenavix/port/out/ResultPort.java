package org.metable.citenavix.port.out;

import org.metable.citenavix.domain.Navigable;

public interface ResultPort {
    public void clear();

    public void list(String... items);

    public void path(String path);
    
    public void printTree(Navigable item);
}
