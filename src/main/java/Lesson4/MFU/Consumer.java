package Lesson4.MFU;

public class Consumer implements Runnable{
    private String name;
    private Tasks  task;
    private MFU    mfu;

    public Consumer(String _name, Tasks _task, MFU _mfu){
        this.name = _name;
        this.task = _task;
        this.mfu  = _mfu;
    }

    @Override
    public String toString(){
        return this.name + " " + task;
    }

    public Tasks getTask() {
        return task;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        mfu.process(this);
    }
}
