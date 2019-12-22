package Lesson1.Task2;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruits> {
    private ArrayList<T> fruits = new ArrayList<>();

    public Box(T... _fruits) {
            for (int i = 0; i < _fruits.length; i++) {
                this.fruits.add(_fruits[i]);
            }
    }

    public float getWeight(){
        float boxWeight = 0;
        for (int i = 0; i < fruits.size(); i++) {
            boxWeight += fruits.get(i).getWeight();
        }
        return boxWeight;
    }

    public boolean compare(Box<?> _box){
        return (this.getWeight() == _box.getWeight())?true:false;
    }

    public void sprinkleFruits(Box<T> _box){
        if (_box.fruits.size() != 0){
            if(!_box.fruits.get(0).getClass().equals(this.fruits.get(0).getClass()))
                System.err.println("В коробке уже лежат другие фрукты");
                return;
        }

        _box.fruits.addAll(this.fruits);
        this.fruits.clear();
    }

}
