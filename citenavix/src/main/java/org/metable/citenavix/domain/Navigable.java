package org.metable.citenavix.domain;

import java.util.List;

public interface Navigable {

    public List<Navigable> getActions();

    public String getName();
}
