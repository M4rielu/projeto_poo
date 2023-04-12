import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean jogarNovamente = true;

        System.out.println("Pedra, Papel, Tesoura.");
        System.out.println("0 - Pedra | 1 - Papel | 2 - Tesoura.");

        while (jogarNovamente) {
            System.out.print("Escolha um Número: ");
            int jogador = sc.nextInt();

            int computador = randint(0, 2);

            System.out.println("Você Escolheu: " + jogadaToString(jogador));
            System.out.println("O Computador Escolheu: " + jogadaToString(computador));

            String resultado = determinarVencedor(jogador, computador);
            System.out.println(resultado);

            System.out.print("Deseja Jogar Novamente? (Sim-Não): ");
            String jogarNovamenteStr = sc.next();
            jogarNovamente = jogarNovamenteStr.equalsIgnoreCase("Sim");

        }
        sc.close();
    }

    public static int randint(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt(max - min + 1) + min;
        return randomNum;
    }

    public static String jogadaToString(int jogada) {
        switch (jogada) {
            case 0:
                return "Pedra";
            case 1:
                return "Papel";
            case 2:
                return "Tesoura";
            default:
                return "Jogada Inválida";
        }
    }

    public static String determinarVencedor(int jogador, int computador) {
        if (jogador == computador) {
            return "Empate!";
        } else if ((jogador == 0 && computador == 2) || (jogador == 1 && computador == 0)
                || (jogador == 2 && computador == 1)) {
            return "Você Ganhou";
        } else {
            return "Você Perdeu!";
        }
    }
}
