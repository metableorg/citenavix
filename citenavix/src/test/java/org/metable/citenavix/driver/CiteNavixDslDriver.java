package org.metable.citenavix.driver;

public interface CiteNavixDslDriver {

    void assign(String value);

    void dispose();

    void execute();

    void listItems();

    void loginUser(String username, String password);

    void newCiteNavix();

    boolean pathIs(String path);

    boolean resultContains(String item);

    void visit(String itemName);
}
