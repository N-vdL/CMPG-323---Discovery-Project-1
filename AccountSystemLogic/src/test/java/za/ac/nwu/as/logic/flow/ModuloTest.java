package za.ac.nwu.as.logic.flow;

import flow.FetchAccountTypeFlowImpl;
import flow.Modulo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModuloTest
{
    private Modulo mod;

    @Before
    public void setUp() throws Exception
    {
        mod = new Modulo();
    }

    @Test
    public void testMod()
    {
        Integer result = mod.doMod(9, 5);
        assertNotNull("This should not equal null.", result);
        assertEquals("This should be equal to 4.", 4, result.intValue());
    }

    @Test
    public void testModByZero()
    {
        try
        {
            mod.doMod(9, 0);
            fail("It should throw an exception.");
        }

        catch (Exception ex)
        {
            assertEquals("There is an error present!", ex.getMessage());
            assertTrue("Error Message is not as expected.", ex.getMessage().equalsIgnoreCase("Error is being thrown!"));
        }
    }
}
