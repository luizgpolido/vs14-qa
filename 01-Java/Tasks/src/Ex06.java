import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira as informações do funcionário.");
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        System.out.println("Salário Mensal: ");
        double salario = sc.nextDouble();
        System.out.println("Número de meses trabalhados: ");
        int mesesTrabalhados = sc.nextInt();
        System.out.printf("O funcionário %s trabalhou por %d meses e recebeu R$%.2f no ano.", nome, mesesTrabalhados, salario * mesesTrabalhados);

    }
}
