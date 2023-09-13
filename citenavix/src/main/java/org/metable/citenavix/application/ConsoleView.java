package org.metable.citenavix.application;

import org.metable.citenavix.domain.Navigable;
import org.metable.citenavix.domain.NavigableValueItem;
import org.metable.citenavix.port.out.ResultPort;

public class ConsoleView implements ResultPort {

    @Override
    public void clear() {
    }

    @Override
    public void list(String... items) {
        for (String item : items) {
            System.out.println("    " + item);
        }
    }

    @Override
    public void path(String path) {
        System.out.println(path);
    }

    public void printTree(Navigable item) {
        printTree(item, "", true, false);
    }

    private void printTree(Navigable node, String prefix, boolean isTail, boolean includeValues) {

        if ((!includeValues) && (node instanceof NavigableValueItem)) {
            return;
        }

        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.getLabel());

        final int numItems = node.getItems().size();

        for (int i = 0; i < numItems - 1; i++) {
            printTree(node.getItems().get(i), prefix + (isTail ? "    " : "│   "), false, includeValues);
        }
        if (numItems > 0) {
            printTree(node.getItems().get(numItems - 1), prefix + (isTail ? "    " : "│   "), true, includeValues);
        }
    }

}
