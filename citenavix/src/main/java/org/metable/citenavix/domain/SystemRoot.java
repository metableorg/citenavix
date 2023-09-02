package org.metable.citenavix.domain;

import java.util.Arrays;
import java.util.List;

public class SystemRoot extends NavigableItem {

    public SystemRoot() {
        super("root");
    }

    @Override
    public List<Navigable> getActions() {
        return Arrays.asList((Navigable) new Action("new"));
    }
}
