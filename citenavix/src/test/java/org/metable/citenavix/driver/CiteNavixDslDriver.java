package org.metable.citenavix.driver;

public interface CiteNavixDslDriver {

    void dispose();

    void loginUser(String username, String password);

    void rootLevel();

    boolean resultContains(String item);

    void listAction();
}
