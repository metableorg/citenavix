package org.metable.citenavix.driver;

import java.util.Arrays;

import org.metable.citenavix.domain.ArgumentItem;
import org.metable.citenavix.domain.AttributeItem;
import org.metable.citenavix.domain.CiteNavix;
import org.metable.citenavix.domain.CommandItem;
import org.metable.citenavix.domain.ListItem;
import org.metable.citenavix.domain.NavigableItem;
import org.metable.citenavix.domain.ObjectItem;
import org.metable.citenavix.port.out.ResultPort;
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
    }

    private static void initialize(CiteNavix root) {
        // @formatter:off
        root
            .addItem(new ObjectItem("AI Research", "project")
                 .addItem(new ListItem("tags")
                     .addItem(new NavigableItem("Artificial Intelligence"))
                     .addItem(new NavigableItem("Research"))
                 )
                .addItem(new ObjectItem("Machine Learning", "sub-project")
                    .addItem(new ListItem("tags")
                        .addItem(new NavigableItem("Machine Learning"))
                        .addItem(new NavigableItem("AI Algorithms"))
                    )
                    .addItem(new ObjectItem("Paper 1", "journal citation")
                        .addItem(new AttributeItem("tags", new NavigableItem("[Deep Learning Neural Networks]")))
                        .addItem(new AttributeItem("author", new NavigableItem("John Doe")))
                        .addItem(new AttributeItem("title", new NavigableItem("\"Introduction to Deep Learning\"")))
                        .addItem(new AttributeItem("journal", new NavigableItem("Journal of AI Research")))
                        .addItem(new AttributeItem("year", new NavigableItem("2020")))
                    )
                    .addItem(new ObjectItem("Book 1", "book citation")
                        .addItem(new AttributeItem("tags", new NavigableItem("[Foundational Texts]")))
                        .addItem(new AttributeItem("author", new NavigableItem("Jane Smith")))
                        .addItem(new AttributeItem("title", new NavigableItem("\"Machine Learning Basics\"")))
                        .addItem(new AttributeItem("publisher", new NavigableItem("Acedemic Press")))
                        .addItem(new AttributeItem("year", new NavigableItem("2018")))
                    )
                )
                .addItem(new ObjectItem("Natural Language Processing", "sub-project")
                    .addItem(new CommandItem("new")
                        .addItem(new ArgumentItem("type", "Book Citation"))
                        .addItem(new ArgumentItem("author", "Sam Brown"))
                        .addItem(new ArgumentItem("year", "2017"))
                     )
                    .addItem(new AttributeItem("tags", new NavigableItem("[NLP, Linguistics]")))
                    .addItem(new ObjectItem("Paper 2", "journal citation")
                        .addItem(new AttributeItem("tags", new NavigableItem("[Text Mining, Sentiment Analysis]")))
                        .addItem(new AttributeItem("author", new NavigableItem("Emily Brown")))
                        .addItem(new AttributeItem("title", new NavigableItem("\"Sentiment Analysis in Social Media\"")))
                        .addItem(new AttributeItem("journal", new NavigableItem("Journal of NLP")))
                        .addItem(new AttributeItem("year", new NavigableItem("2021")))
                    )
                    .addItem(new ObjectItem("Conference Paper 1", "conference citation")
                        .addItem(new AttributeItem("tags", new NavigableItem("[Speech Recognition, Real-time Processing]")))
                        .addItem(new AttributeItem("author", new NavigableItem("William Green")))
                        .addItem(new AttributeItem("title", new NavigableItem("\"Real-time Speach Recognition\"")))
                        .addItem(new AttributeItem("conference", new NavigableItem("NLP International Conference")))
                        .addItem(new AttributeItem("year", new NavigableItem("2019")))
                    )
                )
            );
        // @formatter:on
    }

    private CiteNavix citeNavix;
    private ResultView resultView;

    private CiteNavixRuntime runtime;

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
}