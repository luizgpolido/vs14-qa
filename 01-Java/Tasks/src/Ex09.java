import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] palavrasIngles = {"Dog", "City", "Feliz", "Sad"};
        String[] palavrasPortugues = {"Cachorro", "Cidade", "Feliz", "Triste"};


        int escolhaMenu = 0;

        while (escolhaMenu != 1) {
            boolean traduzido = false;

            System.out.println("Qual palavra deseja traduzir: ");
            String palavra = sc.nextLine();

            for (int i = 0; i < palavrasIngles.length; i++) {
                if (palavra.equalsIgnoreCase(palavrasIngles[i])){
                    System.out.println("Tradução: " + palavrasPortugues[i]);
                    traduzido = true;
                    break;
                }
            }

            for (int i = 0; i < palavrasPortugues.length; i++) {
                if (palavra.equalsIgnoreCase(palavrasPortugues[i])){
                    System.out.println("Tradução: " + palavrasIngles[i]);
                    traduzido = true;
                    break;
                }
            }

            if (!traduzido){
                System.out.println("Idioma inválido.");
            }

            System.out.println("=======================");
            System.out.println("Digite 1 para encerrar, ou outro número para continuar.");
            System.out.println("=======================");
            escolhaMenu = sc.nextInt();
            sc.nextLine(); //consome quebra de linha
        }
    }
}
