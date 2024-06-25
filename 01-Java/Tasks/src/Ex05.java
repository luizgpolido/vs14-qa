import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Insira quantos votos tiveram no munícipio de Santo Andre: ");
        float totalVotos = sc.nextFloat();

        System.out.println("Insira quantos votos brancos tiveram: ");
        float votosBrancos = sc.nextFloat();

        System.out.println("Insira quantos votos nulos tiveram: ");
        float votosNulos = sc.nextFloat();

        System.out.println("Insira quantos votos validos tiveram: ");
        float votosValidos = sc.nextFloat();

        if (totalVotos < (votosNulos + votosBrancos + votosValidos) || totalVotos > (votosNulos + votosBrancos + votosValidos)){ //Validação da quantidade de votos
            System.out.println("Eleição fraudada, quantidade de votos inconsistente.");
            System.exit(0);
        }

        System.out.println("=============================");
        System.out.println("TOTAL DE VOTOS POR CATEGORIA:");
        System.out.printf("VOTOS VÁLIDOS: %.0f, sendo %.2f%% dos votos totais.\n", votosValidos, (votosValidos / totalVotos) * 100);
        System.out.printf("VOTOS BRANCOS: %.0f, sendo %.2f%% dos votos totais.\n", votosBrancos, (votosBrancos / totalVotos) * 100);
        System.out.printf("VOTOS NULOS: %.0f, sendo %.2f%% dos votos totais.\n", votosNulos, (votosNulos / totalVotos) * 100);
        System.out.println("=============================");

    }
}
