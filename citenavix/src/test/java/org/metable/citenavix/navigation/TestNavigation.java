package org.metable.citenavix.navigation;

import org.junit.Assert;
import org.junit.Test;
import org.metable.citenavix.CommonTest;

public class TestNavigation extends CommonTest {

    @Test
    public void test_should_list_citenavix_children_when_path_is_citenavix() {
        // Given
        dsl.newCiteNavix();

        // When
        dsl.listItems();

        // Then
        Assert.assertTrue(dsl.resultContains("item: new: (name: new folder)"));
    }

    @Test
    public void test_should_return_citenavix_path_when_citenavix_is_initialized() {
        // Given
        dsl.newCiteNavix();

        // Then
        Assert.assertTrue(dsl.pathIs("path: /"));
    }

    @Test
    public void test_should_return_path_to_citation_author_attribute_when_subproject_path_is_visited() {
        // Given
        dsl.newCiteNavix();

        // When
        dsl.visit("path: /AI Research/Natural Language Processing/Paper 2/author");

        // Then
        Assert.assertTrue(dsl.pathIs("path: /AI Research/Natural Language Processing/Paper 2/author"));
    }

    public void test_should_return_path_to_citation_author_name_value_when_subproject_path_is_visited() {
        // Given
        dsl.newCiteNavix();

        // When
        dsl.visit("path: /AI Research/Natural Language Processing/Paper 2/author/Emily Brown");

        // Then
        Assert.assertTrue(dsl.pathIs("path: /AI Research/Natural Language Processing/Paper 2/author/Emily Brown"));
    }

    @Test
    public void test_should_return_path_to_citation_journal_attribute_when_subproject_relative_path_is_visited() {
        // Given
        dsl.newCiteNavix();
        dsl.visit("path: /AI Research/Natural Language Processing/Paper 2/author");

        // When
        dsl.visit("path: ../journal");

        // Then
        Assert.assertTrue(dsl.pathIs("path: /AI Research/Natural Language Processing/Paper 2/journal"));
    }

    @Test
    public void test_should_return_path_to_new_result_when_citenavix_new_path_is_visited() {
        // Given
        dsl.newCiteNavix();

        // When
        dsl.visit("path: new");

        // Then
        Assert.assertTrue(dsl.pathIs("path: /new"));
    }

    @Test
    public void test_should_return_to_root_when_path_is_root() {
        // Given
        dsl.newCiteNavix();
        dsl.visit("path: /AI Research/Natural Language Processing/Paper 2/author");

        // When
        dsl.visit("path: /");

        // Then
        Assert.assertTrue(dsl.pathIs("path: /"));
    }
}
