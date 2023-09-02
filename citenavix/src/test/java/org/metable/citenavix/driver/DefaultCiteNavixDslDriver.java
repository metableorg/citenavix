package org.metable.citenavix.driver;

import java.util.ArrayList;
import java.util.List;

import org.metable.citenavix.domain.Navigable;
import org.metable.citenavix.domain.SystemRoot;
import org.metable.citenavix.port.out.ResultPort;

public class DefaultCiteNavixDslDriver implements CiteNavixDslDriver {

    private static class ResultView implements ResultPort {
        private final List<String> resultItems = new ArrayList<>();

        @Override
        public void giveResult(List<Navigable> navigables) {
            navigables.forEach(n -> resultItems.add(n.getName()));
        }

        public boolean contains(String targetItem) {
            for (String item : this.resultItems) {
                if (item.equals(targetItem)) {
                    return true;
                }
            }

            return false;
        }

    }

    private Navigable current;

    private final ResultView resultView;

    public DefaultCiteNavixDslDriver() {
        resultView = new ResultView();
    }

    @Override
    public void dispose() {
    }

    @Override
    public void loginUser(String username, String password) {
    }

    @Override
    public void rootLevel() {
        current = new SystemRoot();
    }

    @Override
    public boolean resultContains(String item) {
        return resultView.contains(item);
    }

    @Override
    public void listAction() {
        resultView.giveResult(current.getActions());
    }
}