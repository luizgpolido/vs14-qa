import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira um número: ");
        int numero = sc.nextInt();

        System.out.println((numero % 2 == 0) ? "Seu número é par" : "Seu número é impar");
    }
}
