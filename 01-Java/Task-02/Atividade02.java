package task02;

import java.util.Arrays;
import java.util.Scanner;

public class Atividade02 {


    public static void main(String[] args) {
        String[] nomeTimesCasa = new String[10];
        String[] nomeTimesVisitantes = new String[10];
        int[] pontuacaoTimesCasa = new int[10];
        int[] pontuacaoTimesVisitantes = new int[10];
        String[] dataJogos = new String[10];
        Scanner leitor = new Scanner(System.in);
        int opcao = 10;


        while (true) {
            System.out.println("Bem-vindo ao sistema de gerenciamento de Tablea de Campeonato de Basquete!\n" +
                    "Digite a opção desejada!!\n" +
                    "1 - Inserir novos jogos:\n" +
                    "2 - Exibir todos os jogos registrados:\n" +
                    "3 - Buscar jogos por time:\n" +
                    "4 - Exibir a classificação dos times:\n" +
                    "0 - Sair\n");

            opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {

                case 0:
                    System.out.println("Sair");
                    return;
                case 1:
                    boolean espacoLivre = false;
                    System.out.println("**Inserir novo jogo:**");

                    System.out.println("Informe o time da casa:");
                    String nomeTime1 = leitor.nextLine();

                    System.out.println("Informe o time visitante: ");
                    String nomeTime2 = leitor.nextLine();

                    System.out.println("Informe a pontuação do time de casa:");
                    int pontucaoTime1 = leitor.nextInt();
                    leitor.nextLine();

                    System.out.println("Informe a pontuação do time visitante:");
                    int pontucaoTime2 = leitor.nextInt();
                    leitor.nextLine();

                    System.out.println("Informe a data do jogo no formato DD/MM/AAAA:");
                    String data = leitor.nextLine();


                    for (int i = 0; i < nomeTimesCasa.length; i++) {
                        if (nomeTimesCasa[i] == null) {
                            nomeTimesCasa[i] = nomeTime1;
                            nomeTimesVisitantes[i] = nomeTime2;
                            pontuacaoTimesCasa[i] = pontucaoTime1;
                            pontuacaoTimesVisitantes[i] = pontucaoTime2;
                            dataJogos[i] = data;

                            espacoLivre = true;
                            break;
                        }
                    }
                    if (!espacoLivre) {
                        System.out.println("Não pode cadastrar mais partidas.");
                    } else {
                        System.out.println("Partidas cadastradas com sucesso!");
                    }
                    break;
                case 2:
                    System.out.println("Exibir todos os jogos registrados:\n");

                    for (int i = 0; i < nomeTimesCasa.length; i++) {
                        if (nomeTimesCasa[i] == null) {
                            System.out.println("Esses são todos os times encontrados!");
                            break;
                        }
                        System.out.println("Time de casa: " + nomeTimesCasa[i] + " time fora de casa: " + nomeTimesVisitantes[i] + " Pontuação do time de casa " +
                                pontuacaoTimesCasa[i] + " Pontuação do time fora de casa " + pontuacaoTimesVisitantes[i] + " data da partida " + dataJogos[i]);
                    }

                    break;
                case 3:
                    System.out.println("Buscar jogos por time:\n");

                    System.out.println("Informe o time da casa para buscar a partida: ");
                    String nome = leitor.nextLine();
                    boolean encontrado = false;

                    for (int i = 0; i < nomeTimesCasa.length; i++) {
                        if (nome.equalsIgnoreCase(nomeTimesCasa[i])) {
                            System.out.println("Nome do time da casa: " + nomeTimesCasa[i] + " Time fora de casa: " + nomeTimesVisitantes[i] +
                                    " Pontuação time da casa: " + pontuacaoTimesCasa[i] + " Pontuação time de visitante " + nomeTimesVisitantes[i] + " Data da partida " + dataJogos[i]);

                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Esse time não foi encontrado!");
                    }
                    break;

                case 4:
                    System.out.println("Exibir a classificação dos times:");


                    int[] pontuacaoGeral = new int[20];
                    String[] timesGeral = new String[20];

                    System.arraycopy(nomeTimesCasa, 0, timesGeral, 0, nomeTimesCasa.length);
                    System.arraycopy(nomeTimesVisitantes, 0, timesGeral, nomeTimesCasa.length, nomeTimesVisitantes.length);
                    System.arraycopy(pontuacaoTimesCasa, 0, pontuacaoGeral, 0, pontuacaoTimesCasa.length);
                    System.arraycopy(pontuacaoTimesVisitantes, 0, pontuacaoGeral, pontuacaoTimesCasa.length, pontuacaoTimesVisitantes.length);

                    int n = nomeTimesCasa.length;
                    boolean swapped;

                    String[] nomesTimesFiltrado = Arrays.stream(timesGeral)
                            .filter(s -> s != null && !s.trim().isEmpty())
                            .toArray(String[]::new);


                    int[] pontuacaoFiltrado = Arrays.stream(pontuacaoGeral)
                            .filter(p -> p != 0)
                            .toArray();

                    for (int i = 0; i < n - 1; i++) {
                        swapped = false;

                        for (int j = 0; j < pontuacaoFiltrado.length - 1 - i; j++) {
                            if (pontuacaoFiltrado[j] < pontuacaoFiltrado[j + 1]) {
                                int temp1 = pontuacaoFiltrado[j];
                                pontuacaoFiltrado[j] = pontuacaoFiltrado[j + 1];
                                pontuacaoFiltrado[j + 1] = temp1;

                                String temp2 = nomesTimesFiltrado[j];
                                nomesTimesFiltrado[j] = nomesTimesFiltrado[j + 1];
                                nomesTimesFiltrado[j + 1] = temp2;
                                swapped = true;
                            }
                        }


                    }

                    System.out.println("\n\nPontuação Geral:");
                    for (int z = 0; z < pontuacaoFiltrado.length; z++) {
                        if (nomesTimesFiltrado[z] == null) {
                            System.out.println("Essas são todas as partidas");
                            break;
                        }
                        System.out.println(pontuacaoFiltrado[z] + " - " + nomesTimesFiltrado[z] );
                        System.out.println();
                    }
                    break;

                default:
                    System.out.println("Opção invalída. Retornando ao menu inicial.");
            }

        }

    }
}

