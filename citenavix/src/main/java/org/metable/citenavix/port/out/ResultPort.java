package org.metable.citenavix.port.out;

public interface ResultPort {
    public void clear();

    public void list(String... items);

    public void path(String path);
}
