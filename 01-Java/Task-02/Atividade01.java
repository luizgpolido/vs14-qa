package task02;

import java.util.Scanner;

public class Atividade01 {



    public static void main(String[] args) {
        String[] nomePets = new String[10];
        String[] tipoPets = new String[10];
        Scanner leitor = new Scanner(System.in);
        int opcao = 10;
        boolean espacoLivre = false;


        while(true) {
            System.out.println("Bem-vindo ao sistema de gerenciamento de pets!\n" +
                    "Digite a opção desejada!!\n"+
                    "1 - Inserir novo Pet\n"+
                    "2 - Exibir todos os Pets\n"+
                    "3 - Buscar pet pelo nome\n"+
                    "0 - Sair");

            opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao){

                case 0:
                    System.out.println("Sair");
                    return;
                case 1:
                    System.out.println("**Cadastrar novo Pet**");
                    System.out.println("Informe o nome do Pet:");
                    String nome = leitor.nextLine();

                    System.out.println("Informe o tipo do Pet:");
                    String tipo = leitor.nextLine();


                    for (int i = 0; i < nomePets.length; i++) {
                        if (nomePets[i] == null){
                            nomePets[i] = nome;
                            tipoPets[i] = tipo;
                            espacoLivre = true;
                            break;
                        }
                    }
                    if(!espacoLivre){
                        System.out.println("A clínica não pode receber mais pacientes.");
                    }else {
                        System.out.println("Pet cadastrado com sucesso!");
                    }

                    break;
                case 2:
                    System.out.println("**Exibir todos os Pets**\n");

                    for (int i = 0; i < nomePets.length; i++) {
                        if (nomePets[i] == null){
                            System.out.println("Esses são todos os pacientes cadastradoos!");
                            break;
                        }
                        System.out.println("Nome do pet: " + nomePets[i] + " tipo do pet: " + tipoPets[i]);
                    }

                    break;
                case 3:
                    System.out.println("**Buscar pelo nome do Pet**\n");
                    System.out.println("Informe o nome do pet que deseja pesquisar: ");
                    nome = leitor.nextLine();
                    boolean encontrado = false;

                    for (int i =0; i < nomePets.length; i++){
                        if(nome.equalsIgnoreCase(nomePets[i])){
                            System.out.println("Nome do pet: " + nomePets[i] + " tipo do pet: " + tipoPets[i]);
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado){
                        System.out.println("Esse pet não está cadastrado!");
                    }

                    break;
                default:
                    System.out.println("Opção invalída. Retornando ao menu inicial.");
                    continue;
            }

        }

    }

}
