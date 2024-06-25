import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int escolhaMenu = 0;

        while (escolhaMenu < 9) {
            System.out.println();
            System.out.println("=======================");
            System.out.println("MENU DE OPÇÕES");
            System.out.println("1- Soma");
            System.out.println("2- Subtração");
            System.out.println("3- Multiplicação");
            System.out.println("4- Divisão");
            System.out.println("5- Área círculo");
            System.out.println("6- Área retângulo");
            System.out.println("7- Área triângulo");
            System.out.println("8- Diametro círculo");
            System.out.println("9 - Encerrar programa");
            System.out.println("=======================");
            escolhaMenu = sc.nextInt();
            sc.nextLine(); //consome quebra de linha

            switch (escolhaMenu){
                case 1:
                    System.out.println("Número 1: ");
                    int num1 = sc.nextInt();
                    System.out.println("Número 2: ");
                    int num2 = sc.nextInt();
                    System.out.printf("Soma: %d " , (num1 + num2));
                    break;
                case 2:
                    System.out.println("Número 1: ");
                     num1 = sc.nextInt();
                    System.out.println("Número 2: ");
                     num2 = sc.nextInt();
                    System.out.printf("Subtração: %d " , (num1 - num2));
                    break;
                case 3:
                    System.out.println("Número 1: ");
                    num1 = sc.nextInt();
                    System.out.println("Número 2: ");
                    num2 = sc.nextInt();
                    System.out.printf("Multiplicação: %d " , (num1 * num2));
                    break;
                case 4:
                    System.out.println("Número 1: ");
                    num1 = sc.nextInt();
                    System.out.println("Número 2: ");
                    num2 = sc.nextInt();
                    System.out.printf("Divisão: %d " , (num1 / num2));
                    break;
                case 5:
                    System.out.println("Raio do círculo: ");
                    num1 = sc.nextInt();
                    System.out.printf("Área: %.2f " , (Math.pow(num1 , 2) * 3.14));
                    break;
                case 6:
                    System.out.println("Base do retangulo: ");
                    num1 = sc.nextInt();
                    System.out.println("Altura do retangulo: ");
                    num2 = sc.nextInt();
                    System.out.printf("Área: %d " , (num1 * num2));
                    break;
                case 7:
                    System.out.println("Base do triangulo: ");
                    num1 = sc.nextInt();
                    System.out.println("Altura do triangulo: ");
                    num2 = sc.nextInt();
                    System.out.printf("Área: %d " , ((num1 * num2) / 2));
                    break;
                case 8:
                    System.out.println("Raio do círculo: ");
                    num1 = sc.nextInt();
                    System.out.printf("Diametro: %d " , (num1 * 2));
                    break;
                default:
                    System.out.println("Inválido");
                    break;
            }

        }

    }
}
