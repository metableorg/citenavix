package org.metable.citenavix.command;

import org.junit.Assert;
import org.junit.Test;
import org.metable.citenavix.CommonTest;

public class TestNewFolderCommand extends CommonTest {

    @Test
    public void test_new_folder_should_contain_new_folder_command() {
        // input: citenavix/new/name="AI Research Project"!

        // Given
        dsl.newCiteNavix();
        // And
        dsl.visit("path: ./new/name");
        // And
        dsl.assign("value: AI Research Project");
        // And
        dsl.visit("path: ..");

        // When
        dsl.execute();
        dsl.visit("path: ../AI Research Project");
        dsl.listItems();

        // Then
        Assert.assertTrue(dsl.resultContains("item: new: (name: new folder)"));
    }

    @Test
    public void test_should_create_new_folder_when_new_folder_command_is_executed() {
        // Given
        dsl.newCiteNavix();
        // And
        dsl.visit("path: ./new/name");
        // And
        dsl.assign("value: AI Research Project");
        // And
        dsl.visit("path: ..");

        // When
        dsl.execute();
        dsl.visit("path: ..");
        dsl.listItems();

        // Then
        Assert.assertTrue(dsl.resultContains("item: AI Research Project [folder]"));
        dsl.printTree();
    }
}
