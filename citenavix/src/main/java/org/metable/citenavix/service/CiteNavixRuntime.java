package org.metable.citenavix.service;

import java.util.ArrayList;
import java.util.List;

import org.metable.citenavix.domain.Navigable;
import org.metable.citenavix.domain.ObjectItem;
import org.metable.citenavix.port.in.NavixRuntime;
import org.metable.citenavix.port.out.ResultPort;

public class CiteNavixRuntime implements NavixRuntime {

    private final ResultPort resultPort;
    private final ObjectItem root;
    private Navigable current;

    public CiteNavixRuntime(ObjectItem root, ResultPort resultPort) {
        this.resultPort = resultPort;
        this.root = root;
        this.current = root;

        resultPort.path(root.getName());
    }

    @Override
    public void assign(String value) {
        current.assign(value);
    }

    @Override
    public void execute() {
        current.execute();
    }

    @Override
    public void list() {
        resultPort.clear();
        updatePath();

        List<String> itemLabels = new ArrayList<>();

        for (Navigable item : current.getItems()) {
            itemLabels.add(item.getLabel());
        }

        resultPort.list(itemLabels.toArray(new String[itemLabels.size()]));
    }

    private void updatePath() {
        final String path = current.getPath();
        resultPort.path(path.isEmpty() ? "/" : path);
    }

    @Override
    public void visit(String item) {

        if (item.equals("/")) {
            current = root;
            return;
        }

        if (item.equals(".")) {
            return;
        }

        if (item.equals("..")) {
            current = current.getParent();

            if (current == null) {
                current = root;
            }

            return;
        }

        Navigable newCurrent = null;

        for (Navigable navigable : current.getItems()) {
            if (navigable.getIdentifier().equals(item)) {
                newCurrent = navigable;
                break;
            }
        }

        if (newCurrent == null) {
            throw new java.lang.RuntimeException("Unknown path element: " + item);
        }

        current = newCurrent;
    }

    public void printTree() {
        resultPort.printTree(current);
    }
}
