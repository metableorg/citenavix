package org.metable.citenavix.port.in;

import org.metable.citenavix.domain.NavixPath;

public interface NavixRuntime {
    public void assign(String value);

    public void execute();

    void list();

    public void visit(NavixPath path);
}
