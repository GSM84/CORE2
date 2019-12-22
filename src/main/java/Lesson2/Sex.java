package Lesson2;

public enum Sex {
    MALE("MALE"), FEMALE("FEMALE");
    private String sex;
    Sex(String _sex){
        this.sex = _sex;
    }

    public String getSex() {
        return sex;
    }
}
