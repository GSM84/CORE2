package Lesson6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayChecker {
    public int[] getArrayPart(int... _arr){
        if(Arrays.stream(_arr).noneMatch(e -> e == 4))
            throw new RuntimeException("At least one element must be equal 4.");

        List<Integer> list = Arrays.stream(_arr).boxed().collect(Collectors.toList());

        int[] newArr = Arrays.copyOfRange(_arr, list.lastIndexOf(4) + 1, _arr.length);

        return newArr;
    }

    public boolean checkArray(int ... _arr){
        if(Arrays.stream(_arr).noneMatch(e -> e == 4 || e == 1) )
            return false;
        else
            return true;
    }

    public int[] push(int[] _arr){
        return _arr;
    }
}

