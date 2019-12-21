package Lesson1.Task1;

import java.util.ArrayList;

public class ElementReplace<T> {
    private T[] elements;

    public ElementReplace(T... _elements){
        this.elements = _elements;
    }
    public static void main(String[] args) {
        ElementReplace<Integer> arr = new ElementReplace<>(1,2,3,4,5,6,7,8,9,0);
        System.out.println("Print array");
        arr.print();

        arr.replacePositions( 1,8);
        System.out.println("Print replaced array");
        arr.print();

        ArrayList<Integer> list = arr.transformToArrayList();
        System.out.println("Print ArrayList");
        for (Integer e : list) {
            System.out.print(e + " ");
        }
    }

    void replacePositions( int _firstElemPos, int _secondElemPos){
        T firstElement = this.elements[_firstElemPos];
        T secondElement = this.elements[_secondElemPos];

        this.elements[_firstElemPos] = secondElement;
        this.elements[_secondElemPos] = firstElement;

    }

    void print(){
        for (int i = 0; i < this.elements.length; i++) {
            System.out.print(this.elements[i] + " ");
        }
        System.out.println();
    }

    ArrayList<T> transformToArrayList(){
        ArrayList<T> arrList = new ArrayList<>();
        for (int i = 0; i < this.elements.length; i++) {
            arrList.add(this.elements[i]);
        }

        return arrList;
    }
}
