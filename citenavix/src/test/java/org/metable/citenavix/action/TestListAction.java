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
        dsl.visit("path: citenavix/AI Research");

        // When
        dsl.listItems();

        // Then
        Assert.assertTrue(dsl.resultContains("item: tags: [Artificial Intelligence, Research]"));
        Assert.assertTrue(dsl.resultContains("item: Machine Learning [sub-project]"));
        Assert.assertTrue(dsl.resultContains("item: Natural Language Processing [sub-project]"));
    }

    @Test
    public void test_should_show_command_arguments() {
        // Given
        dsl.newCiteNavix();
        // And
        dsl.visit("path: citenavix/AI Research/Natural Language Processing");

        // When
        dsl.listItems();

        // Then
        Assert.assertTrue(dsl.resultContains("item: new: (type: Book Citation, author: Sam Brown, year: 2017)"));
    }
}
