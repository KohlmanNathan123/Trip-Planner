import java.util.*;
import java.io.*;
class Trip implements Serializable{
	protected double distance;
	protected double totalCost;
	protected TransportMethod vehicle;
	protected Object location;
	protected String tripName;
	protected boolean[] activities;
	protected int[] numTicketsArray;
	protected String locName;
	protected double lodgeCost;
	protected double transportationCost;	
	
	public static void main(String args[]){
		Trip t = new Trip();
	}
	
	public Trip(){
		locationChoice();
		vehicle = new TransportMethod();
		getTransportCost();
		System.out.println("The total cost of your trip is $" + totalCost);
	}

	public void locationChoice(){
		boolean keepGoing = true;
		Scanner obj = new Scanner(System.in);
		while(keepGoing){
			System.out.println("\nWhere would you like to go for this trip? ");
			System.out.println("1) Chicago");
			System.out.println("2) New Orleans");
			System.out.print("Choice: ");
			String choice = obj.nextLine();
			System.out.print("\n");
			if(choice.equals("1")){
				locName = "Chicago";
				Chicago tripLocation = new Chicago();
				totalCost = tripLocation.getCost();
				lodgeCost = tripLocation.getLodgeCost();
				keepGoing = false;
				location = tripLocation;
				System.out.print("Trip name: ");
				tripName = obj.nextLine();
				activities = tripLocation.getActivities();
				numTicketsArray = tripLocation.getTicketsArray();
			}
			else if(choice.equals("2")){
				locName = "New Orleans";
				NewOrleans tripLocation = new NewOrleans();
				totalCost = tripLocation.getCost();
				lodgeCost = tripLocation.getLodgeCost();
				keepGoing = false;
				location = tripLocation;
				System.out.print("Trip name: ");
				tripName = obj.nextLine();
				activities = tripLocation.getActivities();
				numTicketsArray = tripLocation.getTicketsArray();
			}
			else{
				System.out.println("Input not recognized...\n");
			}
		}
	}
	
	public void getTransportCost(){
		//Scanner obj = new Scanner(System.in);
		boolean keepGoing = true;
		while(keepGoing){
			try{
				Scanner obj = new Scanner(System.in);
				System.out.print("\nHow far away is your destination(miles)? ");
				distance = obj.nextDouble();
				double gallonsUsed = distance / vehicle.getMpg();
				gallonsUsed = Math.round(gallonsUsed*100)/100;
				System.out.println("Gallons Used: " + gallonsUsed);
				double transportCost = gallonsUsed*3.50*2;
				transportCost = Math.round(transportCost*100)/100;
				System.out.println("Your price for transportation will be $" + transportCost + "\n");
				transportationCost = transportCost;
				totalCost += transportCost;
				keepGoing = false;
			}catch(Exception e){
				System.out.println("Input not recognized...");
			}
		}
	}

	public void report(){
		System.out.println("\n--------------------------------");
		System.out.println(tripName + " to " + locName);
		System.out.println("Total Cost: $" + totalCost);
		System.out.println("\nCost of Transportation: $" + transportationCost);
		System.out.println("Cost of Lodging: $" + lodgeCost);
		if(locName.equals("Chicago")){
			System.out.println("\nCost of activities:");
			if(activities[0]){
				System.out.println("Grant park: free");
			}
			if(activities[1]){
				System.out.println("Architecture Boat Tour: $" + 40*(numTicketsArray[1]));
			}
			if(activities[2]){
				System.out.println("Field Museum: $" + 27*(numTicketsArray[2]));
			}
			if(activities[3]){
				System.out.println("Museum of Science and Industry: $" + 22*(numTicketsArray[3]));
			}
		}
		else if(locName.equals("New Orleans")){
			System.out.println("\nCost of activities:");
			if(activities[0]){
				System.out.println("New Orleans City Park: free");
			}
			if(activities[1]){
				System.out.println("National WWII Museum: $" + 29.50*(numTicketsArray[1]));
			}
			if(activities[2]){
				System.out.println("Airboat Swamp Tour: $" + 80*(numTicketsArray[2]));
			}
			if(activities[3]){
				System.out.println("French Quarter Ghost Tour: $" + 29*(numTicketsArray[3]));
			}
		}	
		System.out.println("--------------------------------\n");
	}

	public String getName(){
		return(tripName);
	}

	public Object getLocation(){
		return(location);
	}
}
