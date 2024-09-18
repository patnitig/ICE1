/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardtrick;
import java.util.Random;
import java.util.Scanner;
/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author Nagma, Modified by Nitignakumari Patel (991755501)
 */
public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];
        Random random = new Random();
        
        for (int i=0; i<magicHand.length; i++)
        {
            //c.setValue(insert call to random number generator here)
            //c.setSuit(Card.SUITS[insert call to random number between 0-3 here])
            int randomValue = random.nextInt(13)+1;
            String randomSuit = Card.SUITS[random.nextInt(4)];
            magicHand[i] = new Card(randomValue, randomSuit);
            System.out.println("Card" + (i+1)+": " +magicHand[i]);
            
        }
        
        //insert code to ask the user for Card value and suit, create their card
        // and search magicHand here
        //Then report the result here
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pick a card number (1-13): ");
        int userValue = scanner.nextInt();
        System.out.print("Pick a suit (Hearts, Diamonds, Spades, Clubs): ");
        String userSuit = scanner.next();

        Card userCard = new Card(userValue, userSuit);

        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Your card is in the magic hand!");
        } else {
            System.out.println("Your card is not in the magic hand.");
        }

        Card luckyCard = new Card(7, "Hearts"); 

        boolean luckyFound = false;
        for (Card card : magicHand) {
            if (card.getValue() == luckyCard.getValue() && card.getSuit().equalsIgnoreCase(luckyCard.getSuit())) {
                luckyFound = true;
                break;
            }
        }

        if (luckyFound) {
            System.out.println("You found the lucky card: " + luckyCard + "!");
        } else {
            System.out.println("The lucky card is not in the magic hand.");
        }
    }
    
}