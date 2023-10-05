package org.metable.citenavix.service;

import org.metable.citenavix.domain.NavixPath;
import org.metable.citenavix.port.in.NavixInterpreter;
import org.metable.citenavix.port.in.NavixRuntime;

public class CiteNavixInterpreter implements NavixInterpreter {

    private final NavixRuntime runtime;

    public CiteNavixInterpreter(NavixRuntime runtime) {
        this.runtime = runtime;
    }

    @Override
    public void interpret(String text) {

        if (text.strip().equals("/")) {
            runtime.visit("/");
        } else {
            NavixPath path = new NavixPath(text);
            path.forEach(item -> execute(item));
        }
    }

    private void execute(String item) {
        runtime.visit(item);
    }
}