import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    GaragemLocomotivas garagemLocomotiva = new GaragemLocomotivas();
    GaragemVagoes garagemVagoes = new GaragemVagoes();

    PatioTrens patio = new PatioTrens();
    Locomotiva um = new Locomotiva(1);
    Locomotiva dois = new Locomotiva(2);
    Locomotiva tres = new Locomotiva(3);
    Locomotiva quatro = new Locomotiva(4);
    Locomotiva cinco = new Locomotiva(5);
    Locomotiva seis = new Locomotiva(6);

    Vagao v1 = new Vagao(1);
    Vagao v2 = new Vagao(2);
    Vagao v3 = new Vagao(3);
    Vagao v4 = new Vagao(4);

    garagemVagoes.vagaoEntra(v1);
    garagemVagoes.vagaoEntra(v2);
    garagemVagoes.vagaoEntra(v3);
    garagemVagoes.vagaoEntra(v4);

    garagemLocomotiva.locomotivaEntra(um);
    garagemLocomotiva.locomotivaEntra(dois);
    garagemLocomotiva.locomotivaEntra(tres);
    garagemLocomotiva.locomotivaEntra(quatro);
    garagemLocomotiva.locomotivaEntra(cinco);
    garagemLocomotiva.locomotivaEntra(seis);

    boolean verificador = true;

    while (verificador) {
      System.out.println("Bem-vindo ao sistemas de trem!");
      System.out.println("1. Criar trem");
      System.out.println("2. Editar trem");
      System.out.println("3. Listar trens");
      System.out.println("4. Desfazer trem");
      System.out.println("5. Sair");
      System.out.println("Por favor, selecione a opção desejada: ");

      int opcao = sc.nextInt();

      switch (opcao) {

        case 1:
          System.out.println("Digite um identificador para o  trem:");
          int identificadorTrem = sc.nextInt();
          System.out.println("\n");

          if (patio.verificaTrem(identificadorTrem) == true) {
            System.out.println("Já existe um trem com esse identificador!!");
            continue;

          }
          System.out.println("Escolha uma das locomotivas abaixo para engatar no Trem: \n");
          System.out.print(garagemLocomotiva.toString());

          System.out.println("Escolha uma Locomotiva: ");
          int identificadorLocomotiva = sc.nextInt();

          Locomotiva auxL1 = garagemLocomotiva.procurLocomotiva(identificadorLocomotiva);
          Trem auxT1 = criaTrem(identificadorTrem, auxL1);
          patio.tremEntra(auxT1);

          
          garagemLocomotiva.procurLocomotiva(identificadorLocomotiva).setTrem(auxT1);
          garagemLocomotiva.locomotivaSai(identificadorLocomotiva);
          System.out.println(patio.toString());

          continue;
        case 2:
          // Inicialmente deve-se indicar o identificador do trem a ser editado. A partir
          // de então ficam liberadas as seguintes operações:
          System.out.println("Patio:\n" + patio.toString());
          System.out.println("Escolha um dos Trens estacionados no patio: ");
          int idTrem = sc.nextInt();

          while (true) {
            System.out.println("Menu de edição de trem.");
            System.out.println("1. Inserir uma locomotiva.");
            System.out.println("2. Inserir um vagão.");
            System.out.println("3. Remover o último elemento do trem.");
            System.out.println("4. Listar locomotivas livres.");
            System.out.println("5. Listar vagões livres.");
            System.out.println("6. Encerrar edição do trem");
            System.out.print("Selecione a opção desejada: ");
            int opcao1 = sc.nextInt();

            switch (opcao1) {
              case 1:
                System.out.println("Garagem das Locomotivas:\n" + garagemLocomotiva.toString());
                System.out.println("Escolha uma das locomotivas: ");
                int idLoc = sc.nextInt();
                Trem auxT4 = patio.procuraTrem(idTrem);
                if(auxT4.getQntVageoes() >= 1){
                  System.out.println("Não é possível inserir uma locomotiva após um vagão!!");
                  continue;
                }
                Locomotiva auxL = garagemLocomotiva.procurLocomotiva(idLoc);
                patio.procuraTrem(idTrem).engataLocomotiva(auxL);

                Trem auxT = patio.procuraTrem(idTrem);
                garagemLocomotiva.procurLocomotiva(idLoc).setTrem(auxT);
                garagemLocomotiva.locomotivaSai(idLoc);
                continue;

              case 2:
                System.out.println("Garagem dos vagoes: \n" + garagemVagoes.toString());
                System.out.println("Escolha um dos vagoes: ");
                int idVag = sc.nextInt();

                Vagao auxV = garagemVagoes.procurVagao(idVag);
                patio.procuraTrem(idTrem).engataVagao(auxV);

                Trem auxT2 = patio.procuraTrem(idTrem);
                garagemVagoes.procurVagao(idVag).setTrem(auxT2);
                garagemVagoes.vagaoSai(idVag);

                continue;

              case 3:
                System.out.println("Deseja remover o ultimo elemento do Trem? ");
                String resp = sc.next();
                String auxStr = resp.toUpperCase();
                Trem auxT3 = patio.procuraTrem(idTrem);
                if(auxStr.equals("SIM")||auxStr.equals("S")){
                  if(auxT3.getQntVageoes() >= 1){
                    patio.procuraTrem(idTrem).desengataVagao();
                    Vagao auxVag = patio.procuraTrem(idTrem).desengataVagao();
                    garagemVagoes.vagaoEntra(auxVag);

                  }else{
                    patio.procuraTrem(idTrem).desengataLocomotiva();
                    Locomotiva auxLocomotiva = patio.procuraTrem(idTrem).desengataLocomotiva();
                    garagemLocomotiva.locomotivaEntra(auxLocomotiva);
                  }
                }
                
                
                continue;

              case 4:
                System.out.println(garagemLocomotiva.toString());
                continue;

              case 5:
                System.out.println(garagemVagoes.toString());
                continue;

              case 6:
                // · Encerrar a edição do trem
                System.out.println("Voltando ao menu principal...");

            }
            break;
          }

        case 3:
          System.out.println(patio.toString());
          continue;

        case 4:
        System.out.println("Digite o identificador do Trem: ");
        int idTrem1 = sc.nextInt();
        System.out.println("Deseja mesmo excluir o Trem?");
        String resp = sc.next();
        String auxStr = resp.toUpperCase();
        Trem auxTrem1 = patio.procuraTrem(idTrem1);
        if(auxStr.equals("SIM")||auxStr.equals("S")){
          for(int i = auxTrem1.getTamanhoTrem(); i >= 1; i -- ){
            if(auxTrem1.getQntVageoes() >= 1){
              Vagao auxVag = patio.procuraTrem(idTrem1).desengataVagao();
              patio.procuraTrem(idTrem1).desengataVagao();
              garagemVagoes.vagaoEntra(auxVag);
            }else{
              Locomotiva auxLocomotiva = patio.procuraTrem(idTrem1).desengataLocomotiva();
              patio.procuraTrem(idTrem1).excluirTrem();
              garagemLocomotiva.locomotivaEntra(auxLocomotiva);
            }
          }
          // patio.tremSai(idTrem1);
        }
          continue;

        case 5:
          // sair...
          System.out.println("Saindo...");

        case 6:
        System.out.println("garagem locomotiva: "+garagemLocomotiva.toString());

        case 7:
        System.out.println("garage, vagoes: "+garagemVagoes.toString());

      }
      break;

    }
  }

  public static Trem criaTrem(int id, Locomotiva locomotiva) {

    Trem trem = new Trem(id, locomotiva);
    return trem;
  }

}