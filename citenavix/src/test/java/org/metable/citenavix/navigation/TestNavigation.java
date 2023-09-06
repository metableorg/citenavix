package org.metable.citenavix.navigation;

import org.junit.Assert;
import org.junit.Test;
import org.metable.citenavix.CommonTest;

public class TestNavigation extends CommonTest {

    @Test
    public void test_should_return_citenavix_path_when_citenavix_is_initialized() {
        // Given
        dsl.newCiteNavix();

        // Then
        Assert.assertTrue(dsl.pathIs("path: citenavix"));
    }

    @Test
    public void test_should_list_citenavix_children_when_path_is_citenavix() {
        // Given
        dsl.newCiteNavix();

        // When
        dsl.listItems();

        // Then
        Assert.assertTrue(dsl.resultContains("item: filter"));
        Assert.assertTrue(dsl.resultContains("item: new: (type: )"));
        Assert.assertTrue(dsl.resultContains("item: search"));
    }

    @Test
    public void test_should_return_path_to_new_result_when_citenavix_new_path_is_visited() {
        // Given
        dsl.newCiteNavix();

        // When
        dsl.visit("path: new");

        // Then
        Assert.assertTrue(dsl.pathIs("path: citenavix/new"));
    }

    @Test
    public void test_should_return_path_to_citation_author_attribute_when_subproject_path_is_visited() {
        // Given
        dsl.newCiteNavix();

        // When
        dsl.visit("path: citenavix/AI Research/Natural Language Processing/Paper 2/author");

        // Then
        Assert.assertTrue(dsl.pathIs("path: citenavix/AI Research/Natural Language Processing/Paper 2/author"));
    }

    @Test
    public void test_should_return_path_to_citation_journal_attribute_when_subproject_relative_path_is_visited() {
        // Given
        dsl.newCiteNavix();
        dsl.visit("path: citenavix/AI Research/Natural Language Processing/Paper 2/author");

        // When
        dsl.visit("path: ../journal");

        // Then
        Assert.assertTrue(dsl.pathIs("path: citenavix/AI Research/Natural Language Processing/Paper 2/journal"));
    }
}
