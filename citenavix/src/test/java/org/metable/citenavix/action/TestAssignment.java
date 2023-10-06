package org.metable.citenavix.action;

import org.junit.Assert;
import org.junit.Test;
import org.metable.citenavix.CommonTest;

public class TestAssignment extends CommonTest {

    @Test
    public void test_should_assign_name_value() {
        // Given
        dsl.newCiteNavix();

        // When
        dsl.visit("path: ./new/name=\"AI Research Project\"");

        // Then
        dsl.printTree();
        dsl.listItems();
        Assert.assertTrue(dsl.resultContains("item: \"AI Research Project\""));
    }

    @Test
    public void test_should_assign_argument_values() {
        // Given
        dsl.newCiteNavix();

        // When
        dsl.visit(
                "path: ./AI Research/Natural Language Processing/new citation/type=\"journal citation\", author=\"John Smith\", year=2021/..");

        // Then
        dsl.listItems();
        Assert.assertTrue(dsl .resultContains("item: type: \"journal citation\""));
        Assert.assertTrue(dsl .resultContains("item: author: \"John Smith\""));
        Assert.assertTrue(dsl .resultContains("item: year: 2021"));
    }

    @Test
    public void test_should_assign_argument_values_one_at_a_time() {
        // Given
        dsl.newCiteNavix();

        // When
        dsl.visit(
                "path: ./AI Research/Natural Language Processing/new citation/type");
        // And
        dsl.visit("path: =\"journal citation\"");
        // And
        dsl.visit("path: ../author");
        // And
        dsl.visit("path: =\"John Smith\"");
        // And
        dsl.visit("path: ../year");
        // And
        dsl.visit("path: =2021/..");

        // Then
        dsl.printTree();
        dsl.listItems();
        Assert.assertTrue(dsl .resultContains("item: type: \"journal citation\""));
        Assert.assertTrue(dsl .resultContains("item: author: \"John Smith\""));
        Assert.assertTrue(dsl .resultContains("item: year: 2021"));
    }
}
