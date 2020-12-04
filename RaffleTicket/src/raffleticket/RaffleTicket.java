
package raffleticket;

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
public class RaffleTicket {
        public static String name;
        public static ArrayList<Integer> usersTickets = new ArrayList<>();
    public static Random rand = new Random();
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        System.out.println("Welcome to the raffle.");
        System.out.println("Would you like to buy a ticket or check one? \n 1: Buy \n 2: Check \n 3: Quit");
        
        mainMenu();
    }
    
    public static void mainMenu(){
        
        
        try {
            int menuChoice = Integer.parseInt(input.readLine());
            switch (menuChoice){
                case(1):
                    TicketOrder();
                    break;
                case(2):
                    checkTickets();
                    break;
                case(3):
                    Quit();
                    break;
                default:
                    System.out.println("Not a valid choice");
                    break;
            }
        } catch (Exception e) {
            System.out.println("There was an error.   " + e);
        }
    }
    
    public static void Quit(){
        System.out.println("Thanks for coming to the raffle.");  
    }
    public static void TicketOrder(){
        try {
        System.out.println("How many tickets would you like to buy");
        int numOfTickets = Integer.parseInt(input.readLine());
        System.out.println("What is your name?");
        name = input.readLine();
        
        for (int i=0;i<numOfTickets;i++){
            usersTickets.add(rand.nextInt(100)+1);
        }
        Iterator myIteration = usersTickets.iterator();
        while (myIteration.hasNext()){
            System.out.println(myIteration.next());
        }
        } catch (Exception e) {
            System.out.println("There was an error. " + e);
        }
        System.out.println("Would you like to \n 1: Buy more tickets \n 2: Check to see if you one \n 3: Quit");
        mainMenu();
    }
    
    public static void checkTickets(){
        try{
        System.out.println("Please enter the name you registered the tickets under.");
        if(name.equalsIgnoreCase(input.readLine())){
            System.out.println("Which ticket would you like to check.");
            int checkTicket = Integer.parseInt(input.readLine());
            if(usersTickets.contains(checkTicket)){
                for(int i = 1; i <= checkTicket / 2; i++) {
    if (checkTicket % (i+1) != 0) {
        System.out.println("Congrats the ticket number " + checkTicket + " has won.");  
        System.out.println("Would you like to \n 1: Buy more tickets \n 2: Check to see if you one \n 3: Quit");
        mainMenu();
    }else{
        System.out.println("Sorry you didnt win. Would you like to \n 1: Buy more tickets \n 2: Check to see if you one \n 3: Quit");
        mainMenu();
    }
}
            }else{
                System.out.println("You dont own that ticket.You will be returned to the menu.");
                System.out.println("Would you like to \n 1: Buy more tickets \n 2: Check to see if you one \n 3: Quit");
            }
        }else{
            System.out.println("Sorry, the name doesn't match. You will be returned to the menu.");
            System.out.println("Would you like to \n 1: Buy more tickets \n 2: Check to see if you one \n 3: Quit");
            mainMenu();
            
        }
        }catch(Exception e){
                System.out.println("There was an error. " + e);
                }
        }
        
        
    }
    

