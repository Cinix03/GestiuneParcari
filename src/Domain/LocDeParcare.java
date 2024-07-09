package Domain;

public class LocDeParcare {
    private int id;
    private boolean free;

    public LocDeParcare(int id, boolean free) {
        this.id = id;
        this.free = free;
    }
    public int getId() {return id;}
    public boolean isFree() {return free;}
    public void setState(boolean occupied) {this.free = occupied;}
}
