package Lesson8;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Company> initial = new ArrayList();

        initial.add(new Company(1,0));
        initial.add(new Company(2,0));
        initial.add(new Company(3,1));
        initial.add(new Company(4,3));
        initial.add(new Company(5,4));
        initial.add(new Company(6,0));
        initial.add(new Company(7,4));
        initial.add(new Company(8,2));

        initial.stream().filter(e -> e.parentId == 0).forEach(e -> processFlatList(initial, e));

        System.out.println("-------------------------------------------");

        initial.stream().filter(e -> e.parentId == 0).forEach(e -> e.printCompany());

    }

    public static void processFlatList(List<Company> _companyList, Company _prior){
        if(_companyList.stream().anyMatch(e -> e.parentId == _prior.id)){
            // для каждого дочернего элемента вызываем проверку
            _companyList.stream().filter(e -> e.parentId == _prior.id).forEach(
                    e -> {
                        System.out.println("Parent "+_prior.id + " child " + e.id);
                        processFlatList(_companyList, e);
                        _prior.childList.add(e);

                    }
            );
        }else{
            System.out.println("No children for element "+ _prior.id);
        }
    }
}
