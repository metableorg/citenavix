package org.metable.citenavix.action;

import org.junit.Assert;
import org.junit.Test;
import org.metable.citenavix.CommonTest;

public class TestListActions extends CommonTest {

	@Test
	public void testShouldListAllRootLevelActions() {
	    // Given the user is at the root level of the system.
	    dsl.rootLevel();
	  
	    // When the user enters the list action.
	    dsl.listAction();
	    
	    // Then all of the root level actions are listed.
	    Assert.assertTrue(dsl.resultContains("item: new"));
	}
}
