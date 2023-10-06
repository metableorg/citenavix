package org.metable.citenavix.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class NavixPath {
    private final List<String> pathElements;

    public NavixPath(String path) {
        pathElements = new ArrayList<>();
        parse(path);
    }

    public void forEach(Consumer<? super String> action) {
        pathElements.forEach(element -> action.accept(element));
    }

    public boolean isEmpty() {
        return pathElements.isEmpty();
    }

    private void parse(String path) {
        final String[] tokens = path.strip().split("/");

        for (String token : tokens) {
            if (token.isBlank()) {
                continue;
            }

            pathElements.add(token.strip());
        }
    }
}