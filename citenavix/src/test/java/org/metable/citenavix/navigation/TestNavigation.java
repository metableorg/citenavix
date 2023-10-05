package org.metable.citenavix.navigation;

import org.junit.Assert;
import org.junit.Test;
import org.metable.citenavix.CommonTest;

public class TestNavigation extends CommonTest {

    @Test
    public void test_line_separator_should_not_change_path() {
        // Given
        dsl.newCiteNavix();
        dsl.visit("path: /AI Research/Natural Language Processing/Paper 2/author");

        // When
        dsl.visit("path: " + System.lineSeparator());

        // Then
        dsl.listItems();
        Assert.assertTrue(dsl.pathIs("path: /AI Research/Natural Language Processing/Paper 2/author"));
    }

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

        // When
        dsl.listItems();

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
        dsl.listItems();
        Assert.assertTrue(dsl.pathIs("path: /AI Research/Natural Language Processing/Paper 2/author"));
    }

    @Test
    public void test_should_return_path_to_citation_author_name_value_when_subproject_path_is_visited() {
        // Given
        dsl.newCiteNavix();

        // When
        dsl.visit("path: /AI Research/Natural Language Processing/Paper 2/author/Emily Brown");

        // Then
        dsl.listItems();
        Assert.assertTrue(dsl.pathIs("path: /AI Research/Natural Language Processing/Paper 2/author/Emily Brown"));
    }

    @Test
    public void test_should_return_path_to_citation_journal_attribute_when_subproject_relative_path_is_visited() {
        // Given
        dsl.newCiteNavix();
        dsl.visit("path: /AI Research/Natural Language Processing/Paper 2/author");

        // When
        dsl.visit("path: ../journal");
        dsl.listItems();

        // Then
        Assert.assertTrue(dsl.pathIs("path: /AI Research/Natural Language Processing/Paper 2/journal"));
    }

    @Test
    public void test_should_return_path_to_new_result_when_citenavix_new_path_is_visited() {
        // Given
        dsl.newCiteNavix();

        // When
        dsl.visit("path: new");
        dsl.listItems();

        // Then
        Assert.assertTrue(dsl.pathIs("path: /new"));
    }

    @Test
    public void test_should_return_path_to_root_when_path_is_root() {
        // Given
        dsl.newCiteNavix();
        dsl.visit("path: /AI Research/Natural Language Processing/Paper 2/author");

        // When
        dsl.visit("path: /");

        // Then
        dsl.listItems();
        Assert.assertTrue(dsl.pathIs("path: /"));
    }

    @Test
    public void test_should_return_path_to_root_when_relative_path_from_root() {
        // Given
        dsl.newCiteNavix();
        dsl.visit("path: /");

        // When
        dsl.visit("path: ..");

        // Then
        dsl.listItems();
        Assert.assertTrue(dsl.pathIs("path: /"));
    }

    @Test(expected = java.lang.RuntimeException.class)
    public void test_should_throw_exception_when_path_contains_unknown_element() {
        // Given
        dsl.newCiteNavix();

        // When
        dsl.visit("path: /AI Research/Natural Language Processing/unknown element");

        // Then
        // See expected above
    }
}
