import java.util.ArrayList;

public class Trem {
    private int id;
    // private 
    private ArrayList<Locomotiva> locomotivas;
    private ArrayList<Vagao> vagoes;

    public Trem (int id, Locomotiva locomotiva){
        this.id = id;

        locomotivas = new ArrayList<>();
        vagoes = new ArrayList<>();
        // locomotiva.setTrem(this);
        locomotivas.add(locomotiva);

    }

    public int getId(){
        return id;
    }

    public int getQntLocomotivas(){
        return locomotivas.size();
    }

    public Locomotiva getLocomotiva(int id){
        for(int i = 0; i < locomotivas.size(); i ++){
            if(locomotivas.get(i).getId() == id){
                return locomotivas.get(i);
            }
        }
        return null;
    }

    public int getQntVageoes(){
        return vagoes.size();
    }

    public Vagao getVagao(int id){
        for(int i = 0; i < locomotivas.size(); i ++){
            if(vagoes.get(i).getId() == id){
                return vagoes.get(i);
            }
        }
        return null;
    }

    public int calculaNumeroMaxVagoes(){
        double max = 0;
        double fator = 1.0;
        for(Locomotiva loc : locomotivas){
            
            max += loc.getNroMaxVagoes()*fator;
            fator = fator*0.9;
        }

        return (int) max;
    }

    public double pesoVagoes(){
        double peso = 0.0;
        for (Vagao vag : vagoes ){
            peso += vag.getCapacMax();
        }
        return peso;
    } 

    public double calculaPesoMax(){
        double max = 0.0;
        double aux = 1.0;
        for (Locomotiva loc : locomotivas){
            max += loc.getPesoMax();
            aux = aux*0.9;
        }
        return max;
    }

    public boolean engataLocomotiva(Locomotiva locomotiva){
        if(vagoes.size() >= 1){
            return false;
        }
        locomotivas.add(locomotiva);
        // locomotiva.setTrem(tre);
        return true;
    }

    public boolean engataVagao(Vagao vagao){
        if(locomotivas.size() == calculaNumeroMaxVagoes()){
            return false;
        }

        if(pesoVagoes() >= calculaPesoMax()){
            return false;
        }
        vagoes.add(vagao);
        // vagao.setTrem(this);
        return true;
    }


    public Locomotiva desengataLocomotiva(){
        if(locomotivas.size() <= 1){
            return null;
        }
        Locomotiva aux = locomotivas.remove(locomotivas.size()-1);
        aux.setTrem(null);
        return aux;
    }

    public Locomotiva excluirTrem(){
        if(locomotivas.size() == 0){
            return null;
        }
        Locomotiva aux = locomotivas.remove(locomotivas.size()-1);
        aux.setTrem(null);
        return aux;
    }

    public Vagao desengataVagao(){
        if(vagoes.size() == 0){
            return null;
        }
        Vagao aux = vagoes.remove(vagoes.size()-1);
        aux.setTrem(null);
        return aux;
    }

    public int getTamanhoTrem(){
        int tam = (locomotivas.size())+(vagoes.size());
        return tam;
    }
    
    @Override
    public String toString() {
        return "Trem [id=" + id + ", locomotivas=" + locomotivas + ", vagoes=" + vagoes + "]";
    }
    
}