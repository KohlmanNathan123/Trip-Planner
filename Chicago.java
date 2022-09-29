import java.util.*;
class Chicago extends Location{
	public static void main(String[] args){
		Chicago c = new Chicago();
		System.out.println(c.getCost());
	}
	
	public Chicago(){
		getStayInfo();
		recommendations();
	}

	public void recommendations(){
		Scanner obj = new Scanner(System.in);
		Scanner tickets = new Scanner(System.in);
		boolean keepGoing = true;
		while(keepGoing){
			System.out.println("1) free: Grant Park ");
			System.out.println("2) $40 per ticket: Architecture Boat Tour ");
			System.out.println("3) $27 per ticket: Field Museum ");
			System.out.println("4) $22 per ticket: Museum of Science and Industry ");
			System.out.println("0) Stop Adding ");
			System.out.println("Select number of any attraction you would like to add. ");
			System.out.print("Choice: ");
			String input = obj.nextLine();


			if(input.equals("1")){
				System.out.println("Current price of trip is now $" + cost + "\n");
				activities[0] = true;
			}
			else if(input.equals("2")){	
				boolean go1 = true;
				while(go1){
					try{
						Scanner tickets1 = new Scanner(System.in);
						System.out.print("How many tickets would you like: ");
						int numTickets = tickets1.nextInt();
						cost += (40 * (numTickets));
						System.out.println("Current price is now $" + cost + "\n");
						activities[1] = true;
						numTicketsArray[1] = numTickets;
						go1 = false;
					}catch(Exception e){
						System.out.println("Input not recognized...\n");
					}
				}
			}

			else if(input.equals("3")){
				boolean go2 = true;
				while(go2){
					try{
						Scanner tickets2 = new Scanner(System.in);
						System.out.print("How many tickets would you like: ");
						int numTickets = tickets2.nextInt();
						cost += (27 * (numTickets));
						System.out.println("Current price is now $" + cost + "\n");
						activities[2] = true;
						numTicketsArray[2] = numTickets;
						go2 = false;
					}catch(Exception e){
						System.out.println("Input not recognized...\n");
					}
				}
			}

			else if(input.equals("4")){
				boolean go3 = true;
				while(go3){
					try{
						Scanner tickets3 = new Scanner(System.in);
						System.out.print("How many tickets would you like: ");
						int numTickets = tickets3.nextInt();
						cost += (22 * (numTickets));
						System.out.println("Current price is now $" + cost + "\n");
						activities[3] = true;
						numTicketsArray[3] = numTickets;
						go3 = false;
					}catch(Exception e){
						System.out.println("Input not recognized...\n");
					}
				}
			}

			else if(input.equals("0")){
				System.out.print("\n");
				keepGoing = false;
			}
			else{
				System.out.println("Input not recognized...\n");
			}
		}
	}	
}
