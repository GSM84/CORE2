package Lesson4.MFU;

public enum Tasks {
    PRINT("Печать"), SCAN("Сканирование"), COPY("Копирование");
    private String task;

    Tasks(String _task){
        this.task = _task;
    }

    @Override
    public String toString(){
        return this.task;
    }

}
