import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira o horário do início do jogo : ");
        System.out.println("Horas: ");
        int horasInicial = sc.nextInt();
        System.out.println("Minutos: ");
        int minutosInicial = sc.nextInt();

        System.out.println("Insira o horário do final do jogo : ");
        System.out.println("Horas: ");
        int horasFinal = sc.nextInt();
        System.out.println("Minutos: ");
        int minutosFinal = sc.nextInt();

        calcularTempo(horasInicial, minutosInicial, horasFinal, minutosFinal);

    }

    public static void calcularTempo(int horasInicial, int minutosInicial, int horasFinal, int minutosFinal) {

        int minutosTotaisInicial = (horasInicial * 60) + minutosInicial;
        int minutosTotaisFinal = (horasFinal * 60) + minutosFinal;

        int minutosTotais = 0;

        if (minutosTotaisInicial > minutosTotaisFinal){
            minutosTotais = minutosTotaisInicial - minutosTotaisFinal;
        } else {
            minutosTotais = minutosTotaisFinal - minutosTotaisInicial;
        }


        System.out.printf("A partida durou: %d horas e %d minutos", minutosTotais / 60 , minutosTotais % 60);

    }
}
