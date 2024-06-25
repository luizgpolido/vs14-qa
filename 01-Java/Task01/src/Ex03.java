import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Insira uma temperatura em graus celsius: ");
        final float celsiusTemperature = sc.nextFloat(); //Constante da temperatura em celsius?

        System.out.printf("%.2f graus celsius equivalem à %.2f graus fahrenheit", celsiusTemperature , (celsiusTemperature * 1.8 + 32));

    }
}
