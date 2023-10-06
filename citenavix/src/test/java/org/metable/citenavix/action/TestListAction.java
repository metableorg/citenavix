package org.metable.citenavix.action;

import org.junit.Assert;
import org.junit.Test;
import org.metable.citenavix.CommonTest;

public class TestListAction extends CommonTest {

    @Test
    public void test_should_list_project_contents() {
        // Given
        dsl.newCiteNavix();
        // And
        dsl.visit("path: /AI Research");

        // When
        dsl.listItems();

        // Then
        Assert.assertTrue(dsl.resultContains("item: tags: [Artificial Intelligence, Research]"));
        Assert.assertTrue(dsl.resultContains("item: Machine Learning [sub-project]"));
        Assert.assertTrue(dsl.resultContains("item: Natural Language Processing [sub-project]"));
    }

    @Test
    public void test_should_show_command_argument_rollup() {
        // Given
        dsl.newCiteNavix();
        // And
        dsl.visit("path: /AI Research/Natural Language Processing");

        // When
        dsl.listItems();

        // Then
        Assert.assertTrue(dsl.resultContains("item: new citation: (type: Book Citation, author: Sam Brown, year: 2017)"));
    }

    @Test
    public void test_should_show_list_item_rollup() {
        // Given
        dsl.newCiteNavix();
        // And
        dsl.visit("path: /AI Research");

        // When
        dsl.listItems();

        // Then
        Assert.assertTrue(dsl.resultContains("item: tags: [Artificial Intelligence, Research]"));
    }

    @Test
    public void test_should_show_list_items() {
        // Given
        dsl.newCiteNavix();
        // And
        dsl.visit("path: /AI Research/tags");

        // When
        dsl.listItems();

        // Then
        Assert.assertTrue(dsl.resultContains("item: Artificial Intelligence"));
        Assert.assertTrue(dsl.resultContains("item: Research"));
    }
}
