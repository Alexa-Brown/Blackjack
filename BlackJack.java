import java.util.Random;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {

        Scanner lulu = new Scanner(System.in);
        Random rand = new Random();
        int playerScore = 0;
        int dealerScore = 0;
        char userLetter = 'h';
        char userPlayAgain = 'y';
        int d = 0;
        int p = 0;

        System.out.println("Black Jack Table");
        System.out.println();

        while (userPlayAgain == 'y') {

            dealerScore = 0;
            playerScore = 0;

            System.out.println("Player's turn");

            while ((playerScore < 21) && (userLetter == 'h')) {
                int value = rand.nextInt(11) + 1;
                System.out.print("card: " + value + " ");
                playerScore = playerScore + value;
                System.out.println("Current score: " + playerScore);
                if (playerScore < 21) {
                    System.out.println("(h) hit me again! (d) I'm done : ");
                    userLetter = lulu.next().charAt(0);
                    }
                else if (playerScore > 21) {
                    System.out.println("Sorry, you got over 21.");
                    break;
                     }
            }

            System.out.println("Player's final score is " + playerScore);

            System.out.println();
            System.out.println("Dealer's turn");

            while ((dealerScore <= 17)) {
                int value = rand.nextInt(11) + 1;
                System.out.print("card: " + value + " ");
                dealerScore = dealerScore + value;
                System.out.println("Current score: " + dealerScore);
                if (dealerScore < 21) {
                    continue;
                } else if (dealerScore > 21) {
                    System.out.println("Dealer got over 21.");
                    break;
                }
            }
            System.out.println("Dealer's final score is " + dealerScore);
            System.out.println();

            if (playerScore <= 21) {
                if (dealerScore <= 21){
                    System.out.println("Player won!");
                    p = p + 1;
                }
                else if (playerScore > dealerScore){
                    System.out.println("Player won!");
                    p = p + 1;
                }
            }
           else if ((dealerScore <= 21) && (dealerScore > 17)) {
                if (playerScore > 21) {
                    System.out.println("Dealer won!");
                    d = d + 1;
                     }
                else if (dealerScore > playerScore) {
                    System.out.println("Dealer won!");
                    d = d + 1;
                     }
                else if ((playerScore > 21) && (dealerScore < 21)){
                    System.out.println("Dealer won!");
                    d = d + 1;
                    }
                }
            else if ((playerScore > 21) && (dealerScore > 21)){
                System.out.println("Sorry, you both loose.");
            }
            else {
                System.out.println("Tie!");
                }

                System.out.println();

                System.out.println("Play again? (y/n): ");
                userPlayAgain = lulu.next().charAt(0);
                System.out.println();

                if (userPlayAgain == 'n') {
                    System.out.println("Player won " + p + " times.");
                    System.out.println("Dealer won " + d + " times.");
                }
            }

        }
    }
