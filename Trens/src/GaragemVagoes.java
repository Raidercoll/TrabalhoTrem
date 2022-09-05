import java.util.ArrayList;

public class GaragemVagoes {
    private ArrayList<Vagao> vagoes;

    public GaragemVagoes(){
        vagoes = new ArrayList<>(2000);
    }

    public void vagaoEntra(Vagao vagao){
        vagoes.add(vagao);
    }

    public Vagao vagaoSai(int id){
        for(int i = 0;i < vagoes.size(); i ++ ){
            if (vagoes.get(i).getId() == id){
                Vagao removido = vagoes.remove(i);
                return removido;
            }
        }
        return null;
    }

    public Vagao procurVagao(int id){
        for(int i = 0; i < vagoes.size(); i ++){
            if(vagoes.get(i).getId() == id){
                return vagoes.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String aux = "Garagem de Vagoes\nEstacionados: "+vagoes.size()+"\n";
        for(Vagao v : vagoes){
            aux += v.toString()+"\n";
        }
        return aux;
    }
}
