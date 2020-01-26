import Lesson6.ArrayChecker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayCheckerArrPart {
    ArrayChecker ac;
    @Before
    public void init(){
        ac = new ArrayChecker();
    }
    @Test
    public void arrayCheckTest1(){
        Assert.assertArrayEquals(new int[]{5, 6, 7}, ac.getArrayPart(1,2,3,4,5,6,7));
    }
    @Test
    public void arrayCheckTest2(){
        Assert.assertArrayEquals(new int[]{1, 7}, ac.getArrayPart(1, 2, 4, 4, 2, 3, 4, 1, 7));
    }
    @Test
    public void arrayCheckTest3(){
        Assert.assertArrayEquals(new int[]{}, ac.getArrayPart(1,2,3,4));
    }
    @Test(expected = RuntimeException.class)
    public void arrayCheckTest4(){
        Assert.assertArrayEquals(new int[]{}, ac.getArrayPart(1,2,3));
    }

}
