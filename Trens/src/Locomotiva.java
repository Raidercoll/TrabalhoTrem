public class Locomotiva{
    private int id;
    private double pesoMax = 6000;
    //6000t
    private int nroMaxVagoes = 50;
    //50 vagoes
    private Trem trem;
    
    public Locomotiva(int id) {
        this.id = id;
        this.trem = null;
    }

    public int getId() {
        return id;
    }

    public double getPesoMax() {
        return pesoMax;
    }

    public int getNroMaxVagoes() {
        return nroMaxVagoes;
    }

    public Trem getTrem() {
        return trem;
    }

    public void setTrem(Trem trem){
        this.trem = trem;
    }

    @Override
    public String toString() {
        if(trem == null){
            return "Locomotiva [id=" + id + ", nroMaxVagoes=" + nroMaxVagoes + ", pesoMax=" + pesoMax + ", trem=" + trem
            + "]";
        }
        return "Locomotiva [id=" + id + ", nroMaxVagoes=" + nroMaxVagoes + ", pesoMax=" + pesoMax + ", trem id=" + trem.getId()
        + "]";
       
    }
}