import java.util.ArrayList;

public class PatioTrens {
    private ArrayList<Trem> trens;

    public PatioTrens(){
        trens = new ArrayList<>(20);
    }

    public void tremEntra(Trem trem){
        trens.add(trem);
    }

    public Trem tremSai(int id){
        for(int i = 0; i < trens.size(); i ++){
            if(trens.get(i).getId() == id){
                Trem removido = trens.remove(i);
                return removido;
            }
        }
        return null;
    }

    public boolean verificaTrem(int id){
        for(Trem t : trens){
            if(t.getId() == id){
                return true;
            }
        }
        return false;
    }

    public Trem procuraTrem(int idTrem){
        for (Trem t : trens) {
            if(t.getId() == idTrem){
                return t;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String aux = "Patio dos Trens\nEstacionados: " + trens.size() + "\n";
        for(Trem t : trens){
            aux += t.toString()+"\n";
        }
        return aux;
    }
}
