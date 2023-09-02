package org.metable.citenavix.port.out;

import java.util.List;

import org.metable.citenavix.domain.Navigable;

public interface ResultPort {
    
    public void giveResult(List<Navigable> navigables);
}
