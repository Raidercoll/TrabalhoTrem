import java.util.ArrayList;

public class GaragemLocomotivas {
    private ArrayList<Locomotiva> locomotivas;

    public GaragemLocomotivas(){
        locomotivas = new ArrayList<>(30);
    }

    public void locomotivaEntra(Locomotiva locomotiva){
        locomotivas.add(locomotiva);
    }

    public Locomotiva locomotivaSai(int id){
        for(int i=0;i<locomotivas.size();i++){
            if (locomotivas.get(i).getId() == id){
                Locomotiva removida = locomotivas.remove(i);
                return removida;
            }
        }
        return null;
    }

    public Locomotiva procurLocomotiva(int id){
        for(int i = 0; i < locomotivas.size(); i ++){
            if(locomotivas.get(i).getId() == id){
                return locomotivas.get(i);
            }
        }
        return null;
    }

    public boolean verificaLocomotiva(int id){
        for(Locomotiva l: locomotivas){
            if(l.getId() == id){
                return true;
            }
        }
        return false;
    }
    
   @Override
    public String toString() {
       String aux = "Garagem de Locomotivas\nEstacionadas: "+locomotivas.size()+"\n";
       for(Locomotiva l : locomotivas){
           aux += l.toString()+"\n";
       }
       return aux;
    }
}
