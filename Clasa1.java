package Model;

public class Clasa1 implements Identifiable<Integer> {

    private int id;
    static int idgenerat = 0;

    public Clasa1(){
        id = getNewID();
    }

    @Override
    public Integer getID() {
        return id;
    }

    @Override
    public void setID(Integer id) {
        this.id = id;

    }

    public int getNewID(){
        idgenerat++;
        return idgenerat;
    }
}
