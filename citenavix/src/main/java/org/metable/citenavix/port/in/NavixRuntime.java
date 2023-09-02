package org.metable.citenavix.port.in;

public interface NavixRuntime {
    public void assign(String value);

    public void execute();

    public void visit(String itemName);
}
