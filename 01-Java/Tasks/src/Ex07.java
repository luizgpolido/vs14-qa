import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos alunos há na sala?");
        int quantidadeAlunos = sc.nextInt();
        sc.nextLine(); // consome linha

        String[] nomes = new String[quantidadeAlunos];
        float[][] notas = new float[quantidadeAlunos][3];
        float notaSomadas = 0;


        for (int i = 0; i < quantidadeAlunos; i++) {
            System.out.print("Nome do aluno: ");
            nomes[i] = sc.nextLine();

            for (int j = 0; j < 3; j++) {
                System.out.printf("Digite a nota %d do aluno: ", (j + 1));
                notas[i][j] = sc.nextFloat();
            }
            sc.nextLine(); // consome linha
        }

        for (int i = 0; i < quantidadeAlunos; i++) {
            System.out.println("Nome: " + nomes[i]);

            for (int j = 0; j < 3; j++) {
                float notaAtual = notas[i][j];
                notaSomadas += notaAtual;
            }
            System.out.printf("Média: %.2f\n", notaSomadas/3);
            notaSomadas = 0;
        }

    }
}
