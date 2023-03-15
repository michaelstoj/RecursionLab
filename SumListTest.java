
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hansen
 */
public class SumListTest {
    ArrayList reallySimple;
    ArrayList simple;
    ArrayList aLittleComplex;
    ArrayList reallyComplex;
    public SumListTest() {
        reallySimple = new ArrayList();
        reallySimple.add(1);

        simple = new ArrayList();
        for (int i=1; i<= 100; i++)
            simple.add(i);

        aLittleComplex = (ArrayList) simple.clone();
        aLittleComplex.add(simple.clone());
        aLittleComplex.add(0, simple.clone());

        reallyComplex = (ArrayList) aLittleComplex.clone();
        reallyComplex.add(1, aLittleComplex.clone());
        ArrayList temp = (ArrayList) reallyComplex.clone();
        reallyComplex.add(5, temp);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of sumList method, of class SumList.
     */
    @Test
    public void testSumList1() {
        System.out.println("sumList");
        ArrayList arr = reallySimple;
        int expResult = 1;
        int result = SumList.sumList(arr);
        assertEquals(expResult, result);
    }

    /**
     * Test of sumList method, of class SumList.
     */
    @Test
    public void testSumList2() {
        System.out.println("sumList");
        ArrayList arr = simple;
        int expResult = 5050;
        int result = SumList.sumList(arr);
        assertEquals(expResult, result);
    }

    /**
     * Test of sumList method, of class SumList.
     */
    @Test
    public void testSumList3() {
        System.out.println("sumList");
        ArrayList arr = aLittleComplex;
        int expResult = 15150;
        int result = SumList.sumList(arr);
        assertEquals(expResult, result);
    }

    /**
     * Test of sumList method, of class SumList.
     */
    @Test
    public void testSumList4() {
        System.out.println("sumList");
        ArrayList arr = reallyComplex;
        int expResult = 60600;
        int result = SumList.sumList(arr);
        assertEquals(expResult, result);
    }
}