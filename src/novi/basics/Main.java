package novi.basics;

import javax.xml.transform.SourceLocator;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;
import java.util.function.DoubleFunction;

public class Main {

    public static void main(String[] args) {
	    // Variabele toevoegen
            int firstDigit;
            int secondDigit;
            int thirdDigit;

            int maximum = 9;

          Random randomizer = new Random();

          //variable random waardes (nummers) geven

          firstDigit = randomizer.nextInt(maximum) + 1;
          secondDigit = randomizer.nextInt(maximum) + 1;
          thirdDigit = randomizer.nextInt(maximum) + 1;

         // De som van de random gegenereerde nummers en het product van de gegenereerde nummers in variable zetten.

        int sumOfDigits = firstDigit + secondDigit + thirdDigit;

        int productOfDigits = firstDigit * secondDigit * thirdDigit;

        // scanner object voor userinput maken

        Scanner in = new Scanner(System.in);

        // keuze om het spel in het Nederlands of in het Engels te spelen

        System.out.println("Typ 0 voor Nederlands. vergeet niet na elke invoer op enter te drukken!");
        System.out.println("Type 1 for English (don't forget to press enter after each input)");

        int engelsOfNederlands = in.nextInt();

        if (engelsOfNederlands == 0) {

            System.out.println("NEDERLANDS");

            //uitleg spel
            System.out.println("Raad welke 3 getallen de som en het product maken");

            System.out.println("De som is: " + sumOfDigits);

            System.out.println("Het product is: " + productOfDigits);

            System.out.println("Succes!");


            // hulp optie
            System.out.println("Wil je een hulpoptie bij vraag 2? toets y of n");
            String hulpOptie = in.next();

            //de while loop tot je de keuze maakt niet door te spelen

            while(true) {
            boolean hasPlayerWon = false;

            // de while loop die net zolang doorgaat tot je wint daarna krijg je de optie of je door wilt spelen.

            while (hasPlayerWon == false) {

                //userinputs


                System.out.println("Voer getal 1 in, maak keuze uit de nummers 1 - 9: ");

                int userInput1 = in.nextInt();


                //hulp voor userinput2 alleen bij 1 speelronde!
                if (hulpOptie.equals("y")) {
                    System.out.println("Uw keuze voor getal nummer 1 is: " + userInput1);
                    System.out.println("U heeft hulp ingeschakeld de eerste 2 getallen hebben samen een som van " + (firstDigit + secondDigit));
                        System.out.println("Het product hiervan is " + (firstDigit * secondDigit) + " voer nu uw keuze in voor getal nummer 2!");
                }
                //geen hulp optie dus else
                else {
                    System.out.println("Voer nu het 2de nummer in");
                }

                //userinputs 2 en 3

                int userInput2 = in.nextInt();
                System.out.println("Uw keuze voor getal nummer 2 is " + userInput2 + " voer nu het 3de nummer in!");

                int userInput3 = in.nextInt();


                // Win conditie toevoegen

                int sumOfTotalInput = userInput1 + userInput2 + userInput3;

                int productOfTotalInput = userInput1 * userInput2 * userInput3;


                System.out.println("De getallen die u heeft gekozen hebben een som van: " + sumOfTotalInput + " en een product van: " + productOfTotalInput);

                // we gaan geen antwoorden voorzeggen dus al speel je meer dan 1 ronde krijg je het antwoord ook niet tot je het goed hebt.

                hasPlayerWon = sumOfTotalInput == sumOfDigits && productOfTotalInput == productOfDigits;

                if (hasPlayerWon) {
                    System.out.println("De computer had ook een som van: " + sumOfDigits + " en een product van: " + productOfDigits);
                    System.out.println("Gefeliciteerd u heeft het spel gewonnen!");
                } else {
                    System.out.println("Helaas u heeft verloren :( probeer het nog eens! (opgeven? kies 3x 0 bij de nummerinvoer)");
                    if (productOfTotalInput == 0) {
                        System.out.println("De computer had een som van: " + sumOfDigits + " en een product van: " + productOfDigits);
                        System.out.println("De juiste getallen waren " + firstDigit + ", " + secondDigit + " en " + thirdDigit);
                    }
                }
            }

            // voeg spelmenu toe

            boolean continuePlaying = true;

            System.out.println("Wil je doorspelen? toets y/n");

            String continuePlayingUserChoice = in.next();

            switch (continuePlayingUserChoice) {
                case "y": {
                    System.out.println("Je hebt ervoor gekozen nog een keer te spelen!");
                    continuePlaying = true;
                    break;
                }
                case "n": {
                    System.out.println("Je hebt ervoor gekozen te stoppen!");
                    continuePlaying = false;
                    break;
                }
                default: {
                    System.out.println("Je hebt geen geldige waarde ingevoerd");
                    break;
                }
            }
            if (continuePlaying == false) {
                break;
            }
        }

                System.out.println("Het spel is afgelopen");

        }
            else if (engelsOfNederlands == 1) {
            System.out.println("ENGLISH");

            System.out.println("Guess which 3 numbers make the total sum and total product!");

            System.out.println("The Sum is: " + sumOfDigits);

            System.out.println("The product is: " + productOfDigits);

            System.out.println("Good luck!");

            System.out.println("How many times do you want to play this game? (be aware with more then 1 you will not get an additional help option)");
            int timesPlaying = in.nextInt();

            for (int i = 0; i < timesPlaying; i++) {
                System.out.println("Fill in your first number between from 1 - 9: ");
                int userInput1 = in.nextInt();


                if (timesPlaying < 2) {
                System.out.println("Your choice for number 1 is: " + userInput1 + "! Do you want help fill in: YES if not then fill in NO.");
                String hulp = in.next();
                if (hulp.equals("YES")) {
                    System.out.println("You've asked for help! The first two numbers have a sum of " + (firstDigit + secondDigit));
                    System.out.println("The product of this is " + (firstDigit * secondDigit) + " now fill in the second number!");
                } else if (hulp.equals("NO")) {
                    System.out.println("Now fill in the second number");
                } }
                else {

                    System.out.println("Your choice for the first number is " + userInput1 + " fill in the second number!");
                }

                int userInput2 = in.nextInt();

                System.out.println("Your choice for the second number is " + userInput2 + " fill in the third number!");

                int userInput3 = in.nextInt();


                // Win conditie toevoegen

                int sumOfTotalInput = userInput1 + userInput2 + userInput3;

                int productOfTotalInput = userInput1 * userInput2 * userInput3;


                System.out.println("The numbers that you've chosen have a sum of " + sumOfTotalInput + " and a product of: " + productOfTotalInput);


                if (sumOfTotalInput == sumOfDigits && productOfTotalInput == productOfDigits) {
                    if (timesPlaying < 2) {
                        System.out.println("The computer also had a sum of: " + sumOfDigits + " and a product of: " + productOfDigits);
                    }
                        System.out.println("CONGRATULATIONS YOU'VE WON!");

                } else {
                    System.out.println("Unfortunatly you've lost the game :( try again!");
                    if (timesPlaying < 2) {
                        System.out.println("The computer had a sum of: " + sumOfDigits + " and a product of: " + productOfDigits);
                        System.out.println("The right numbers were " + firstDigit + ", " + secondDigit + " and " + thirdDigit);
                    }
                }
            }
        }

}



        // Meerdere rondes spelen


        // Menu toevoegen

    }

