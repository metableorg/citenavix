package org.metable.citenavix.driver;

import java.util.Arrays;

import org.metable.citenavix.domain.ArgumentItem;
import org.metable.citenavix.domain.AttributeItem;
import org.metable.citenavix.domain.CiteNavix;
import org.metable.citenavix.domain.CommandItem;
import org.metable.citenavix.domain.ListItem;
import org.metable.citenavix.domain.Navigable;
import org.metable.citenavix.domain.NavigableValueItem;
import org.metable.citenavix.domain.ObjectItem;
import org.metable.citenavix.port.out.ResultPort;
import org.metable.citenavix.service.CiteNavixInterpreter;
import org.metable.citenavix.service.CiteNavixRuntime;

public class DefaultCiteNavixDslDriver implements CiteNavixDslDriver {

    private static class ResultView implements ResultPort {

        private String path;
        private String[] listedItems;

        @Override
        public void clear() {
            listedItems = new String[0];
        }

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
        public void printTree(Navigable item) {
            printTree(item, "", true, false);
        }

        private void printTree(Navigable node, String prefix, boolean isTail, boolean includeValues) {

            if ((!includeValues) && (node instanceof NavigableValueItem)) {
                return;
            }

            System.out.println(prefix + (isTail ? "└── " : "├── ") + node.getLabel());

            final int numItems = node.getItems().size();

            for (int i = 0; i < numItems - 1; i++) {
                printTree(node.getItems().get(i), prefix + (isTail ? "    " : "│   "), false, includeValues);
            }
            if (numItems > 0) {
                printTree(node.getItems().get(numItems - 1), prefix + (isTail ? "    " : "│   "), true, includeValues);
            }
        }
    }

    private static void initialize(CiteNavix root) {
        // @formatter:off
        root
            .addItem(new ObjectItem("AI Research", "project")
                 .addItem(new ListItem("tags")
                     .addItem(new NavigableValueItem("Artificial Intelligence"))
                     .addItem(new NavigableValueItem("Research"))
                 )
                .addItem(new ObjectItem("Machine Learning", "sub-project")
                    .addItem(new ListItem("tags")
                        .addItem(new NavigableValueItem("Machine Learning"))
                        .addItem(new NavigableValueItem("AI Algorithms"))
                    )
                    .addItem(new ObjectItem("Paper 1", "journal citation")
                        .addItem(new AttributeItem("tags", "[Deep Learning Neural Networks]"))
                        .addItem(new AttributeItem("author", "John Doe"))
                        .addItem(new AttributeItem("title", "\"Introduction to Deep Learning\""))
                        .addItem(new AttributeItem("journal", "Journal of AI Research"))
                        .addItem(new AttributeItem("year", "2020"))
                    )
                    .addItem(new ObjectItem("Book 1", "book citation")
                        .addItem(new AttributeItem("tags", "[Foundational Texts]"))
                        .addItem(new AttributeItem("author", "Jane Smith"))
                        .addItem(new AttributeItem("title", "\"Machine Learning Basics\""))
                        .addItem(new AttributeItem("publisher", "Acedemic Press"))
                        .addItem(new AttributeItem("year", "2018"))
                    )
                )
                .addItem(new ObjectItem("Natural Language Processing", "sub-project")
                    .addItem(new CommandItem("new")
                        .addItem(new ArgumentItem("type", "Book Citation"))
                        .addItem(new ArgumentItem("author", "Sam Brown"))
                        .addItem(new ArgumentItem("year", "2017"))
                     )
                    .addItem(new AttributeItem("tags", "[NLP, Linguistics]"))
                    .addItem(new ObjectItem("Paper 2", "journal citation")
                        .addItem(new AttributeItem("tags", "[Text Mining, Sentiment Analysis]"))
                        .addItem(new AttributeItem("author", "Emily Brown"))
                        .addItem(new AttributeItem("title", "\"Sentiment Analysis in Social Media\""))
                        .addItem(new AttributeItem("journal", "Journal of NLP"))
                        .addItem(new AttributeItem("year", "2021"))
                    )
                    .addItem(new ObjectItem("Conference Paper 1", "conference citation")
                        .addItem(new AttributeItem("tags", "[Speech Recognition, Real-time Processing]"))
                        .addItem(new AttributeItem("author", "William Green"))
                        .addItem(new AttributeItem("title", "\"Real-time Speach Recognition\""))
                        .addItem(new AttributeItem("conference", "NLP International Conference"))
                        .addItem(new AttributeItem("year", "2019"))
                    )
                )
            );
        // @formatter:on
    }

    private CiteNavix citeNavix;
    private ResultView resultView;

    private CiteNavixRuntime runtime;
    private CiteNavixInterpreter interpreter;

    public DefaultCiteNavixDslDriver() {
    }

    @Override
    public void assign(String value) {
        runtime.assign(value);
    }

    @Override
    public void dispose() {
    }

    @Override
    public void execute() {
        runtime.execute();
    }

    @Override
    public void listItems() {
        runtime.list();
    }

    @Override
    public void loginUser(String username, String password) {
    }

    @Override
    public void newCiteNavix() {
        citeNavix = new CiteNavix();
        initialize(citeNavix);
        resultView = new ResultView();
        runtime = new CiteNavixRuntime(citeNavix, resultView);
        interpreter = new CiteNavixInterpreter(runtime);
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
    public void visit(String path) {
        interpreter.interpret(path);
    }

    @Override
    public void printTree() {
        runtime.printTree();
    }
}