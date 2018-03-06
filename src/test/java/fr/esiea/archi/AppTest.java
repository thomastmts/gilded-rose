package fr.esiea.archi;
import org.junit.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    App App;
    String[] a = {"lol2","lol"};
    public AppTest(String testName)
    {
        super(testName);
    }

    @Test
    public void testApp()
    {
        App.main(a);
        assertTrue(true);
    }
}
