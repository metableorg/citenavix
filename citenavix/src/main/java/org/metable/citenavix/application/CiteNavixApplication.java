package org.metable.citenavix.application;

import java.util.Scanner;

import org.metable.citenavix.domain.CiteNavix;
import org.metable.citenavix.port.in.NavixInterpreter;
import org.metable.citenavix.port.in.NavixRuntime;
import org.metable.citenavix.service.CiteNavixInterpreter;
import org.metable.citenavix.service.CiteNavixRuntime;

public class CiteNavixApplication {

    public static void main(String[] args) {
        CiteNavix citeNavix = new CiteNavix();
        ConsoleView view = new ConsoleView();
        NavixRuntime runtime = new CiteNavixRuntime(citeNavix, view);
        NavixInterpreter interpreter = new CiteNavixInterpreter(runtime);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            runtime.list();

            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Exiting...");
                break;
            }

            try {
                if ("!".equals(input)) {
                    runtime.execute();
                } else if ("tree".equals(input)) {
                    view.printTree(citeNavix);
                } else if (input.startsWith("=")) {
                    String[] value = input.split("=");
                    runtime.assign(value[1]);
                } else {
                    interpreter.interpret(input);
                }
            } catch (java.lang.RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }

}
