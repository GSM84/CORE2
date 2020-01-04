package Lesson3.Animal;

import java.io.Serializable;

public class Cat implements Serializable {
    private String name;
    private float weight;
    private String color;
    private int age;

    public Cat(String _name, String _color, float _weight, int _age) {
        this.name = _name;
        this.color = _color;
        this.weight = _weight;
        this.age = _age;
    }

    @Override
    public String toString() {
        return "Кот " + this.name + ", цвет " + this.color + ", вес " + this.weight + " килограмма, возраст " + this.age + " лет.";

    }
}