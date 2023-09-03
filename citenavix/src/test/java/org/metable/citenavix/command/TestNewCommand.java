package org.metable.citenavix.command;

import org.junit.Assert;
import org.junit.Test;
import org.metable.citenavix.CommonTest;

public class TestNewCommand extends CommonTest {

    @Test
    public void test_should_create_new_folder_when_new_command_is_executed() {
        // citenavix/new/type="folder" name="f1" !

        // Given
        dsl.newCiteNavix();
        // And
        dsl.visit("path: ./new/type");
        // And
        dsl.assign("value: folder");
        // And
        dsl.visit("path: ../name");
        // And
        dsl.assign("value: f1");
        // And
        dsl.visit("path: ..");
       
        // When
        dsl.execute();

        // Then
        dsl.visit("path: citenavix/f1");
        Assert.assertTrue(dsl.pathIs("path: citenavix/f1"));
    }
}
