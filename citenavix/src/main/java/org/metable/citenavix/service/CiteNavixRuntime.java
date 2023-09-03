package org.metable.citenavix.service;

import java.nio.file.Path;
import java.nio.file.Paths;
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
        current.assign(value);
    }

    @Override
    public void execute() {
        current.execute();
    }

    private void updatePath() {
        resultPort.path(current.getPath());
    }

    @Override
    public void visit(String itemName) {
        Path path = Paths.get(itemName);
        visitPath(path);
    }

    private void visitItem(String itemName) {
        if (itemName.equals("..")) {
            current = current.getParent();
            if (current == null) {
                current = citeNavix;
            }
        } else if (itemName.equals(CiteNavix.ROOT)) {
            current = citeNavix;
        } else {
            for (Navigable item : current.getItems()) {
                if (item.getName().equals(itemName)) {
                    current = item;
                    break;
                }
            }
        }

        resultPort.clear();

        updatePath();
    }

    @Override
    public void list() {
        List<String> itemNames = new ArrayList<>();

        for (Navigable item : current.getItems()) {
            itemNames.add(item.getName());
        }

        resultPort.list(itemNames.toArray(new String[itemNames.size()]));
    }

    private void visitPath(Path path) {
        path.forEach(item -> visitItem(item.toString()));
    }
}
