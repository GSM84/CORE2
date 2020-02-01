package Lesson8;

import java.util.ArrayList;
import java.util.List;

public class Company {
    int id;
    int parentId;
    List<Company> childList;

    public Company(int _id, int _parentId) {
        this.id = _id;
        this.parentId = _parentId;
        this.childList = new ArrayList<>();
    }

    public void printCompany(){
        int level = 1;
        System.out.println("Level " + level + " branch is\r\n  Company.id = " + this.id);
        printTree(this.childList, ++level);
    }

    private void printTree(List<Company> _companyes, int _level){
        if (_companyes.size() > 0 ){
            System.out.println("\tLevel "+ _level + " branch is");
            final int  lvl = ++_level;
            _companyes.stream().forEach(e -> {
                System.out.println("\t   Company.id "+ e.id);
                printTree(e.childList, lvl);}
            );
        }
    }
}
