package Domain;

public class LocDeParcare {
    private int id;
    private boolean occupied;

    public LocDeParcare(int id, boolean occupied) {
        this.id = id;
        this.occupied = occupied;
    }
    public int getId() {return id;}
    public boolean isOccupied() {return occupied;}
    public void setOccupied(boolean occupied) {this.occupied = occupied;}
}
