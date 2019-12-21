package Lesson1.Task2;

public abstract class Fruits {
    private String name;
    private float weight;

    public Fruits(String _name, float _weight) {
        this.name   = _name;
        this.weight = _weight;
    }

    public float getWeight() {
        return this.weight;
    }
}
