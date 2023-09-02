package org.metable.citenavix.service;

import java.util.ArrayList;
import java.util.List;

import org.metable.citenavix.domain.CiteNavix;
import org.metable.citenavix.domain.Navigable;
import org.metable.citenavix.port.in.NavixRuntime;
import org.metable.citenavix.port.out.ResultPort;

public class CiteNavixRuntime implements NavixRuntime {

    private final ResultPort resultPort;
    private final CiteNavix citeNavix;
    private Navigable current;

    public CiteNavixRuntime(ResultPort resultPort) {
        this.resultPort = resultPort;
        this.citeNavix = new CiteNavix();
        this.current = citeNavix;

        resultPort.path(citeNavix.getName());
    }

    @Override
    public void assign(String value) {
    }

    @Override
    public void execute() {
    }

    private void updatePath() {
        resultPort.path(current.getPath());
    }

    @Override
    public void visit(String itemName) {
        for (Navigable item : current.getItems()) {
            if (item.getName().equals(itemName)) {
                current = item;
                break;
            }
        }

        resultPort.clear();
        updatePath();
    }

    public void list() {
        List<String> itemNames = new ArrayList<>();

        for (Navigable item : current.getItems()) {
            itemNames.add(item.getName());
        }

        resultPort.list(itemNames.toArray(new String[itemNames.size()]));
    }
}
