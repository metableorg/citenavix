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

    public void rootLevel() {
        driver.rootLevel();
    }

    public boolean resultContains(String... args) {
        final Parameters params = new Parameters(args);
        final String item = params.Optional("item", "");
        
        return driver.resultContains(item);
    }

    public void listAction() {
        driver.listAction();
    }

}
