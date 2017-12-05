//Naimen Zhen Liang	
//440017998

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//public class CoffeeBot is a program that allows the user process their purchase
//of coffee shots and coffee cups. It allows the user to input their orders and advices
//the user the supply of coffee. At the end of the program, it summarises the sale and
//calculates the cost of the purchase.
public class CoffeeBot {


    //Creates int array that contains the correct denominations
	private static int[] Denominations = new int[] {5 , 10 , 20 , 50};

	private static boolean IsValidDenomination(int denomination)
	{
		boolean dollar = false; 
		// for loop breaks if the payment user input is within the denominations 
		for(int i = 0 ; i < Denominations.length ; i++)
		{
			if(denomination % Denominations[i] == 0)
			{
				dollar = true;
				break;
			}
		}
		return dollar;
	}
	
	public static void main (String[] args){

		Scanner input = new Scanner(System.in);
		int oc;
		int os;

		String name, ConfirmOrder;

		double CupPrice = 2.0;
		double ShotPrice = 1.0;
        
        //COMMAND LINE ARGUMENTS:
        //The following detects if the amount of arguments are valid, if it's more than two or less 
        //then it terminates the program
		if (args.length < 1){
					System.out.println("No arguments. System terminating.");
					System.exit(0);

				}else if (args.length == 1){
					System.out.println("Not enough arguments. System terminating.");
					System.exit(0);

				}else if (args.length > 2){
					System.out.println("Too many arguments. System terminating.");
					System.exit(0);
				}
        
        //Here we turn the arguments into integers
	    //c is the supply of coffee cups and s is the supply of coffee shots
		int c = Integer.parseInt(args[0]);
		int s = Integer.parseInt(args[1]);


		// Detect if Coffee Supply is valid
        //GREETING THE USER:
		if(c < 0 && s > 0) { 
				    System.out.println("Negative supply of coffee cups. System terminating.");
				    System.exit(0);

		        }else if (c > 0 && s < 0 ){
		            System.out.println("Negative supply of coffee shots. System terminating.");
		            System.exit(0);

		        }else if (c < 0 && s < 0){
				    System.out.println("Negative supply chain. System terminating.");
				    System.exit(0);

		        }else{
				    System.out.print("Hello, what's your name? ");
		        }

		   name = input.next();

		   System.out.print("Would you like to order some coffee, " + name + "? (y/n) "); 
		   ConfirmOrder = input.next();
		 
            //The while loop breaks if the user input is y or n
		while (true){
		   	if (ConfirmOrder.equals("y")){
		   		    System.out.println("Great! Let's get started."+"\n");
		            break;

		     	}else if (ConfirmOrder.equals("n")) {
		   		    System.out.println("Come back next time, " + name +".");
		   		    System.exit(0);
		   		    break;

		   	    }else {
		   		    System.out.println("Invalid response. Try Again. ");
		   		    ConfirmOrder = input.next();
		            continue;
		     }   
		}

        //ORDER SELECTION:
		System.out.println("Order selection\n---------------\n");
        
        //prints out the supply of coffee cups and shots following by their prices eac
        // statements (c == 1) and (s == 1) prints out singular amounts 

		if(c == 1){
			    System.out.println("There is " + c + " coffee cup in stock and each costs $" + String.format("%.2f", CupPrice) +".");
		    }else{
			    System.out.println("There are " + c + " coffee cups in stock and each costs $" + String.format("%.2f", CupPrice) +".");
		    }
		    if (s == 1){
			    System.out.println("There is " + s + " coffee shot in stock and each costs $" + String.format("%.2f", ShotPrice) +"."+"\n");
	        }else{
			    System.out.println("There are " + s + " coffee shots in stock and each costs $" + String.format("%.2f", ShotPrice) +"."+"\n");
		}

        //CHOOSING THE NUMBER OF CUPS:
		System.out.print("How many cups of coffee would you like? ");
        oc = input.nextInt();
        

        //Checks if the integer inputed is valid
        if (oc == 0){
			    System.out.println("No cups, no coffee. Goodbye.");
			    System.exit(0);
		    }else if (oc < 0){
			    System.out.println("Does not compute. System terminating.");
			    System.exit(0);
		    }else if (oc > c){
		    	System.out.println("Not enough stock. Come back later.");
			    System.exit(0);
		    }else{
			    System.out.println();
		}

        //CHOOSING THE NUMBER OF COFFEE SHOTS IN EACH CUP:
        //Here, it creates an array that stores the amount of cooffee shots in each cup
        //Hence the size of it is the number of order of cups
		int SiC []= new int [oc];

		for (int i = 0; (i + 1) <= oc; i++){
		
		    System.out.print("How many coffee shots in cup " + (i+1) + "? ");
            SiC [i] = input.nextInt();

		    if ( SiC [i] < 0 ){
		            System.out.println("Does not compute. Try again.");
			        i--;
			        continue;
		       }else if (SiC[i] > s && s == 1){
			        System.out.println("There is only " + s + " coffee shot left. Try again."); //single
			        i--;
			        continue;
		        }else if (SiC[i] > s && !(s == 1) ){
			        System.out.println("There are only " + s + " coffee shots left. Try again.");//plural
			        i--;
			        continue;
		        }else{
			        //subtracts the amount of shots in stock by the amount ordered
			        s = s - SiC[i];
		    }
		}
        
        //ORDER SUMMARY:
		System.out.println("\nOrder summary\n-------------\n");

        for (int i = 0; i < oc ; i++){

		    double CostofCoffee = CupPrice + (ShotPrice * SiC[i]);
		    if (SiC[i] == 1){ //single 		    	    
		            System.out.println("Cup " + (i+1) + " has " + SiC[i] + " shot and will cost $" + String.format("%.2f", CostofCoffee));
		        }else{ //plural		    	    
		            System.out.println("Cup " + (i+1) + " has " + SiC[i] + " shots and will cost $" + String.format("%.2f", CostofCoffee));
		    }
		}

		System.out.print("\n" + oc);

		if (oc == 1){
		        System.out.print(" coffee to purchase."); //single
		    }else{
		        System.out.print(" coffees to purchase.");//plural
		}

		int SumofShots = 0; 
		for ( int i : SiC){
		    SumofShots += i ;
		    //sums up all the amount of shots in the array
		}
		
		//Declare doubles for calculation
		double AllShots = SumofShots;
		double OrderofCups = oc;
		double TotalCost = (OrderofCups * CupPrice) + (AllShots * ShotPrice);
		System.out.print("\nPurchase price is $"+String.format("%.2f", TotalCost)+"\nProceed to payment? (y/n) ");
		String ProceedtoPay = input.next();

        //Confirm payment and detect if invalid input
		while (true){
		   	if (ProceedtoPay.equals("y")){
		            break;
		   	    }else if (ProceedtoPay.equals("n")) {
		   		    System.out.println("Come back next time, " + name +".");
		   		    System.exit(0);
		   		    break;
		   	    }else {
		   		    System.out.println("Invalid response. Try Again.");
		   		    ProceedtoPay = input.next();
		            continue;
		    }
		}  
        
        //PAYMENT PROCESS:
		System.out.println("\nOrder payment\n-------------\n");
        System.out.print("$" + String.format("%.2f", TotalCost) + " remains to be paid. Enter coin or note: ");
		double Pay = 0;
		String Payment = input.next();
		System.out.println();
		double TotalPay = 0;
		
		//Check Validity
		while(true){
			char sign = Payment.charAt(0);
			String realPayment = Payment.substring(1);			
			int integerPlaces = Payment.indexOf('.');
			boolean IsValidMoney = false;
			
			if(integerPlaces == -1){
				    IsValidMoney = false; // means no decimal found
			    }else{

				    int decimalPlaces = Payment.length() - integerPlaces - 1;
				    if(decimalPlaces  == 2){
				
					        IsValidMoney = true;
					        // here we will check digits after decimal must be from 
					        // 50, 20, 10, 05 and its denominations only
					        String FractionPart =  Payment.substring(Payment.indexOf ( "." ) + 1);
					        IsValidMoney = IsValidDenomination(Integer.parseInt(FractionPart));
					
				        }else{

					        IsValidMoney = false;
			        }
			}
			
			if(IsValidMoney){
		
				Pay = Double.parseDouble(realPayment);
                //Since $0.05 is the smallest amount in the currency
                //all denominations %0.05==0
                //if valid currency input %0.05==0 then it's valid
				double ValidMoney = Pay % 0.05;
				
				if(ValidMoney <= 0){
				    IsValidMoney = false;
				}
				
			}

            //Requires user to re-enter if payment did not contain $ and is not a valid denomination
		    if(sign != '$' || !IsValidMoney){
		        System.out.println("Invalid coin or note. Try again.");
		        System.out.print("$" + String.format("%.2f", TotalCost) + " remains to be paid. Enter coin or note: ");
		        Payment = input.next();
		        continue;
		    }
       
            TotalPay += Pay;//sums up the total of money paid 
		
		     if (Pay < TotalCost) {

			        TotalCost = TotalCost - Pay;
			        System.out.print("$" + String.format("%.2f", TotalCost) + " remains to be paid. Enter coin or note: ");
			        Payment = input.next();
			        continue;
		        }else if(TotalCost == Pay){
		    	    System.out.println("You gave $" + String.format("%.2f", TotalPay)+"\nPerfect! No change given.");
			        return;
		        }else if (Pay > TotalCost) {
			        System.out.println("You gave $" + String.format("%.2f", TotalPay) + "\nYour change:");
			        TotalCost = (OrderofCups * CupPrice) + (AllShots * ShotPrice);
			        break;
			
		    }
		}

        //REFUNDING CHANGE:
        double Change = TotalPay - TotalCost;
        Change = (double)Math.round(Change*100)/100; //rounds to 2 decimal places
		double Division = 0;

		while(true){
			if (Change >= 100){
				    Division = Change/100;//calculates roughly how many of this denomination the total payment has
				    int Multiplier = (int) Division;//turns the rough number into integer
				    System.out.println(Multiplier + " x $100.00");
				    Change -= Multiplier * 100;//retruns the rest of change after substrating this denomination
			   	    continue;
			    }else if (Change >= 50) {
				    Division = Change/50;
				    int Multiplier = (int) Division;
				    System.out.println(Multiplier + " x $50.00");
				    Change -= Multiplier * 50;
				    continue;
		        }else if (Change >= 20) {
		    	    Division = Change/20;
				    int Multiplier = (int) Division;
				    System.out.println(Multiplier + " x $20.00");
				    Change -= Multiplier * 20;
				    continue;
		        }else if (Change >= 10){
		    	    Division = Change/10;
				    int Multiplier = (int) Division;
				    System.out.println(Multiplier + " x $10.00");
				    Change -= Multiplier*10;
		        }else if (Change >= 5){
		    	    Division = Change/5;
				    int Multiplier = (int) Division;
				    System.out.println(Multiplier + " x $5.00");
				    Change -= Multiplier * 5;
		        }else if (Change >= 2) {
		    	    Division = Change/2;
				    int Multiplier = (int) Division;
				    System.out.println(Multiplier + " x $2.00");
				    Change -= Multiplier * 2;
		        }else if (Change >= 1) {
		    	    Division = Change/1;
				    int Multiplier = (int) Division;
				    System.out.println(Multiplier + " x $1.00");
				    Change -= Multiplier * 1;
		        }else if (Change >= 0.5) {
		    	    Division = Change/0.5;
				    int Multiplier = (int) Division;
				    System.out.println(Multiplier + " x $0.50");
				    Change -= Multiplier * 0.5;
		        }else if (Change>=0.2) {
		    	    Division = Change/0.2;
				    int Multiplier = (int) Division;
				    System.out.println(Multiplier + " x $0.20");
				    Change -= Multiplier * 0.2;
		    	}else if (Change >= 0.1) {
		    	    Division = Change/0.1;
				    int Multiplier = (int) Division;
				    System.out.println(Multiplier + " x $0.10");
				    Change -= Multiplier * 0.1;
		        }else if (Change >= 0.05) {
		    	    Division = Change/0.05;
				    int Multiplier = (int) Division;
				    System.out.println(Multiplier + " x $0.05"); 
				    break;
		        }else if (Change == 0) {
		    	    break;
		    }

		}
        System.out.println("\nThank you, " + name + "." + "\nSee you next time.");
	}

}

