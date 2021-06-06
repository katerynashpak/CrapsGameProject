/*The order of implementing the methods
  Strt with the last method in this file and move up.
  write one method at a time, test it and move to the next method.
  the explanation for each method is given in the pdf file.
  a lot of code is missing in this file. please read the pdf file about
  the description of each method. implement one method at a time, test it,
   move to the next method
*/
import java.util.*;

public class CrapsGame_Shpak{

//*********************************************************************

    public static void main(String[] args){

        play();

    }

    //********************************************************************

    public static int numOfWins;
    public static int numOfLoses;
    public static int point;
    public static int comeOutRoll;
    public static int numOfPlays;


    public static void play(){

        // Variable all the needed variables
        numOfWins = 0;
        numOfLoses = 0;
        point = 0;
        comeOutRoll = 0;
        numOfPlays = 0;


        boolean nextPlayer = true;
        boolean nextTurn;

        description();

        System.out.println("Let's start playing");


        Scanner keyboard = new Scanner(System.in);


        //while loop to let another user to play

        while (nextPlayer){ //reset the varables for the next player

            nextTurn = true;

            while(nextTurn){ //while loop to let the same user to take another turn

                // Simulate rolling the two dice, with values from 1-6
                Random rand = new Random();

                int dice1 = rand.nextInt(6)+1;
                int dice2 = rand.nextInt(6)+1;

                // generate two random numbers, add them together
                int sum = dice1 + dice2;

                //and store it in comeOutRoll
                System.out.print("\nI am rolling the dice for you. Hit enter to see what you got.");
                comeOutRoll = sum;
                keyboard.nextLine();


                String result = winOrLoss(comeOutRoll);
                //your code to display information to the user, refer to the sample output

                // Check for initial win or loss
                if (result.equals("Win") )
                {
                    //your code
                    numOfWins++;
                }
                else if (result.equals("Loss"))
                {
                    //your code
                    numOfLoses++;
                }
                else
                {
                    //your code
                    String r = keepRolling(comeOutRoll);
                    if(comeOutRoll == point){
                        numOfWins++;

                    }
                    else if(comeOutRoll == 7){
                        numOfLoses++;

                    }
                }

                // ask the user if they want to play another turn
                System.out.print("\nAnother turn [yes/no] ? ");
                String user = keyboard.next();
                //if the answer is no set turn to false

                if(user.equalsIgnoreCase("no")){
                    nextTurn = false;
                    break;
                }

                if(user.equalsIgnoreCase("yes")){
                    //comeOutRoll = sum;
                    keyboard.nextLine();
                }
                else{
                    System.out.print("Invalid input, try yes/no -->");
                    keyboard.next();
                    keyboard.nextLine();
                }
            }

            //your code to display the result of the game

            System.out.println("In the simulation: ");
            System.out.println("You won " + numOfWins + " times.");
            System.out.println("You lost " + numOfLoses + " times.");
            System.out.print("For a win probability of ");
            winProbability(numOfWins, numOfLoses);

            String answer = "";

            //ask the user if another person want to play
            nextTurn = true;
            numOfWins = 0;
            numOfLoses = 0;

            System.out.print("\nStart another game [yes/no] ? ");

            String u = keyboard.next();



            //if the answer is no set playAgain to false
            if(u.equalsIgnoreCase("no")){
                nextPlayer = false;
                System.out.println("Thanks for playing. GoodBye!");
            }
            keyboard.nextLine();

        }
    }

//*********************************************************************
//3. winOrLoss method: in this method you can only have one return statement.

    public static String winOrLoss(int comeOutRoll){

        //if comeOutroll is 7 or 11 return “win”
        //if comeOutRoll is 2, 3, or 12 return the string “Loss”
        //if comeOutRoll is 4, 5, 6, 8, 9, or 10 return the string ”the point”

        if(comeOutRoll == 7 || comeOutRoll == 11){
            System.out.println("\nYou got " + comeOutRoll + ". You won!");

            return "Win";
        }
        else if(comeOutRoll == 2 || comeOutRoll == 3 || comeOutRoll == 12){
            System.out.println("\nYou got " + comeOutRoll + ". You lost!");

            return "Loss";

        }
        else{
            System.out.println("\nYou got " + comeOutRoll + ". No loss, no win, your come out roll is "+ comeOutRoll + ".");


            return "The Point";

        }

    }

    //********************************************************************
    //4
    public static void description(){

        System.out.println("Computer will play a crap game for you. Here are the rules of the game:");
        System.out.println("Two six sided dice is rolled.");
        System.out.println("Come out roll: The first roll of the dice in a craps round.");
        System.out.println("A come out roll of 7 or 11 automatically wins.");
        System.out.println("A come out roll of 2, 3, or 12 automatically loses.");
        System.out.println("A come out roll of 4, 5, 6, 8, 9, or 10 becomes The Point.");
        System.out.println("If the player gets the point they will keep playing by rolling the dice until he/she gets a 7 or the point.");
        System.out.println("If the point is rolled first , then the player wins the bet.");
        System.out.println("If a 7 is rolled first, then the player loses. ");
        System.out.println("****************************************************************************");

    }

    //******************************************************************

    //5.KeepRolling method: you must only use one return statement.
    public static String keepRolling(int point){
        Random rand = new Random();
        int dice1 = rand.nextInt(6)+1;
        int dice2 = rand.nextInt(6)+1;
        int sum = dice1 + dice2;

        //keep rolling the dice until you get thePoint or you get seven.
        while(sum != point && sum != 7){
            dice1 = rand.nextInt(6)+1;
            dice2 = rand.nextInt(6)+1;
            sum = dice1 + dice2;



        }

        //return the string “seven” if you get a seven
        //return the string “thePoint” if you get the point
        System.out.println("\nYou have to keep rolling until getting a 7 or your come out roll. If you get 7 you lose, if you get your come out roll you win.");
        System.out.print("Hit enter to see the result of rolling!");
        Scanner keyboard = new Scanner(System.in);
        String u2 = keyboard.nextLine();

        // ?


        if(sum == point){
            System.out.println("\nYou got "+ point +". You won!");
            numOfWins++; // ?
            return "Point";
        }
        else{
            System.out.println("\nYou got 7. You lost!");
            numOfLoses++; // ?
            return "Seven";
        }


    }

    //********************************************************************

    public static double winProbability(int wins, int loses)
    {
        double probability = (double) wins/(wins+loses);
        System.out.println(probability);
        return probability;
    }


}
