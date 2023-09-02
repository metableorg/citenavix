package org.metable.citenavix.driver;

import java.util.Arrays;

import org.metable.citenavix.port.out.ResultPort;
import org.metable.citenavix.service.CiteNavixRuntime;

public class DefaultCiteNavixDslDriver implements CiteNavixDslDriver {

    private static class ResultView implements ResultPort {

        private String path;
        private String[] listedItems;

        public String getPath() {
            return path;
        }

        @Override
        public void list(String... items) {
            listedItems = Arrays.copyOf(items, items.length);
        }

        public boolean listsItem(String targetItem) {
            for (String item : listedItems) {
                if (item.equals(targetItem)) {
                    return true;
                }
            }

            return false;
        }

        @Override
        public void path(String path) {
            this.path = path;
        }

        @Override
        public void clear() {
            listedItems = new String[0];
        }
    }

    private ResultView resultView;
    private CiteNavixRuntime runtime;

    public DefaultCiteNavixDslDriver() {
    }

    @Override
    public void dispose() {
    }

    @Override
    public void loginUser(String username, String password) {
    }

    @Override
    public void newCiteNavix() {
        resultView = new ResultView();
        runtime = new CiteNavixRuntime(resultView);
    }

    @Override
    public boolean pathIs(String path) {
        return resultView.getPath().equals(path);
    }

    @Override
    public boolean resultContains(String item) {
        return resultView.listsItem(item);
    }

    @Override
    public void visit(String itemName) {
        runtime.visit(itemName);
    }

    @Override
    public void listItems() {
        runtime.list();
    }
}