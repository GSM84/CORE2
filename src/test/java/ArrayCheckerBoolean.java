import Lesson6.ArrayChecker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayCheckerBoolean {
    ArrayChecker ac;
    @Before
    public void init(){
        ac = new ArrayChecker();
    }
    @Test
    public void arrayCheckTest1(){
        // both values presented
        Assert.assertTrue(ac.checkArray(1,2,3,4,5));
    }
    @Test
    public void arrayCheckTest2(){
        // only 1 presented
        Assert.assertTrue(ac.checkArray(1,2,3,5,6));
    }
    @Test
    public void arrayCheckTest3(){
        // only 4 presented
        Assert.assertTrue(ac.checkArray(2,3,4,5,6));
    }
    @Test
    public void arrayCheckTest4(){
        // neither 1/4 was not presented
        Assert.assertFalse(ac.checkArray(2,3,5,6,7));
    }
}
