package org.metable.citenavix;

import org.junit.After;
import org.junit.Before;
import org.metable.citenavix.driver.CiteNavixDslDriver;
import org.metable.citenavix.driver.DefaultCiteNavixDslDriver;
import org.metable.citenavix.dsl.CiteNavixDsl;

public class CommonTest {

    protected CiteNavixDsl dsl;
    protected CiteNavixDslDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new DefaultCiteNavixDslDriver();
        dsl = new CiteNavixDsl(driver);

        doBeforeEachTest();
    }

    @After
    public void tearDown() throws Exception {
        driver.dispose();

        doAfterEachTest();
    }

    protected void doAfterEachTest() {
    }

    protected void doBeforeEachTest() {
    }
}
