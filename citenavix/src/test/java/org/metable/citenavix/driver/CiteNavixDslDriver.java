package org.metable.citenavix.driver;

public interface CiteNavixDslDriver {

    void dispose();

    void loginUser(String username, String password);

    void newCiteNavix();

    boolean pathIs(String path);

    boolean resultContains(String item);

    void visit(String itemName);

    void listItems();
}
