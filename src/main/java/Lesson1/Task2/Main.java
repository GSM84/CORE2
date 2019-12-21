package Lesson1.Task2;

public class Main {
    public static void main(String[] args) {
        Box appleBox = new Box(new Apple(), new Apple(), new Apple());
        Box orangeBox = new Box(new Orange(), new Orange(), new Orange());

        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());
        // сравниваем коробки
        System.out.println(appleBox.compare(orangeBox));
        // создаем пустую коробку  и пересыпаем яблоки
        Box emptyBox = new Box();

        appleBox.sprinkleFruits(emptyBox);

        System.out.println("Empty box " + emptyBox.getWeight());
        System.out.println("Apple box " + appleBox.getWeight());

        // пробуем пересыпать туда же апельсины
        orangeBox.sprinkleFruits(emptyBox);

    }
}
