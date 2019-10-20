import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ArraysMathTest {

    @Parameterized.Parameters
    public static Collection<Object[]> date(){
        return Arrays.asList(new Object[][]{
                {new Integer[]{5, 3}, new Integer[] {1, 2, 3, 4, 5, 3}},
                {new Integer[]{}, new Integer[] {2, 3, 4}},
                {new Integer[] {}, new Integer[] {4}}
        });
    }

    private Integer[] a,b;

    public ArraysMathTest(Integer[] a, Integer[] b) {
        this.a = a;
        this.b = b;
    }

    ArraysMath arraysMath;
    @Before
    public void init(){
        arraysMath = new ArraysMath();
    }

    @Test
    public void returnLast4Test() {
        Assert.assertEquals( a,
            arraysMath.returnLast4(b));
    }

    @Test
    public void returnLast4TestVoidResult() {
        Assert.assertEquals( new Integer[] {},
                arraysMath.returnLast4(new Integer[]{1, 2, 3 , 4, 4}));
    }

    @Test (expected = NullPointerException.class)
    public void returnLast4TestNull() {
                arraysMath.returnLast4(null);
    }

    @Test (expected = RuntimeException.class)
    public void returnLast4TestVoidArray() {
                arraysMath.returnLast4(new Integer[]{});
    }

    @Test
    public void check1and4Test1(){
        Assert.assertTrue(arraysMath.check1and4(new Integer[] {1, 1, 4}));
    }

    @Test
    public void check1and4Test2(){
        Assert.assertFalse(arraysMath.check1and4(new Integer[] {4, 5, 4, -1}));
    }

    @Test
    public void check1and4Test3(){
        Assert.assertFalse(arraysMath.check1and4(new Integer[] {}));
    }

    @Test
    public void check1and4Test4(){
        Assert.assertTrue(arraysMath.check1and4(new Integer[] {4, 3, 2, 2-1}));
    }
}