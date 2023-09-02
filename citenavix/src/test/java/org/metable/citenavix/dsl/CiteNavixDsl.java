package org.metable.citenavix.dsl;

import org.metable.citenavix.driver.CiteNavixDslDriver;

public class CiteNavixDsl {

    private final CiteNavixDslDriver driver;

    public CiteNavixDsl(CiteNavixDslDriver driver) {
        this.driver = driver;
    }

    public void login(String... args) {
        final Parameters params = new Parameters(args);
        final String username = params.Optional("username", "bigfan@gmail.com");
        final String password = params.Optional("password", "soccer");

        driver.loginUser(username, password);
    }

    public void newCiteNavix() {
        driver.newCiteNavix();
        driver.visit("citenavix");
    }

    public boolean pathIs(String... args) {
        final Parameters params = new Parameters(args);
        final String path = params.Optional("path", "");

        return driver.pathIs(path);
    }

    public boolean resultContains(String... args) {
        final Parameters params = new Parameters(args);
        final String item = params.Optional("item", "");

        return driver.resultContains(item);
    }

    public void listItems() {
        driver.listItems();
    }

    public void visit(String... args) {
        final Parameters params = new Parameters(args);
        final String item = params.Optional("item", "");
        
        driver.visit(item);
    }
}
