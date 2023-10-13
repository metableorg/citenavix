package org.metable.citenavix.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.metable.citenavix.domain.NavixPath;
import org.metable.citenavix.port.in.NavixInterpreter;
import org.metable.citenavix.port.in.NavixRuntime;

public class CiteNavixInterpreter implements NavixInterpreter {

    private static final String NAME_VALUE_REGEX = "(\\w+)\\s*=\\s*(\"[^\"]*\"|\\w+|\\d+(?:\\.\\d+)?)(?:,\\s*|$)";

    private final NavixRuntime runtime;
    private final Pattern nameValuePattern;

    public CiteNavixInterpreter(final NavixRuntime runtime) {
        this.runtime = runtime;
        this.nameValuePattern = Pattern.compile(NAME_VALUE_REGEX);
    }

    @Override
    public void interpret(final String text) {
        if (text.strip().equals("/")) {
            runtime.visit("/");
        } else {
            NavixPath path = new NavixPath(text);
            path.forEach(item -> execute(item));
        }
    }

    private void execute(final String item) {
        if (executeAssignment(item)) {
            return;
        }
        
        if (executeCommand(item)) {
            return;
        }

        runtime.visit(item);
    }

    private boolean executeCommand(String item) {
        if (item.equals("!")) {
            runtime.execute();
            return true;
        }

        return false;
    }

    private boolean executeAssignment(final String item) {
        if (item.startsWith("=")) {
            final String value = item.substring(1);
            runtime.assign(value.strip());
            return true;
        }

        final Matcher matcher = nameValuePattern.matcher(item);

        String name = ".";

        while (matcher.find()) {
            name = matcher.group(1);
            final String value = matcher.group(2);

            runtime.visit(name);
            runtime.assign(value);
            runtime.visit("..");
        }

        runtime.visit(name);
        
        final boolean isNameValueMatch = !name.equals(".");

        return isNameValueMatch; 
    }
}