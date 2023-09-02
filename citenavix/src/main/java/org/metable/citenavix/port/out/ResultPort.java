package org.metable.citenavix.port.out;

public interface ResultPort {
    public void list(String... items);

    public void path(String path);

    public void clear();
}
