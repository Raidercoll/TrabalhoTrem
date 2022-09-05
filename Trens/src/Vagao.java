public class Vagao {
    private int id;
    private double capacMax = 100;
    private Trem trem;

    public Vagao(int id){
        this.id = id;
        this.trem = null;
    }

    public int getId(){
        return id;
    }

    public double getCapacMax(){
        return capacMax;
    }

    public Trem getTrem(){
        return trem;
    }

    public void setTrem(Trem trem){
        this.trem = trem;
    }



    @Override
    public String toString() {
        if(trem == null){
            return "Vagao [capacMax=" + capacMax + ", id=" + id + ", trem=" + trem + "]";
        }
        return "Vagao [capacMax=" + capacMax + ", id=" + id + ", Id trem =" + trem.getId() + "]";
    }
}
