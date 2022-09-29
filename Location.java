import java.util.*;
import java.io.*;
abstract class Location implements Serializable{
	String[] stayType = {"HOTEL", "RV", "RENTALHOME", "FAMILYORFRIEND", "VACATIONHOME"};
	protected double cost;
	protected double lodgeCost;
	protected int stayLength;
	protected String type;
	protected boolean[] activities = {false, false, false, false};
	protected int[] numTicketsArray = {0, 0, 0, 0};

	public double getCost(){
		return(cost);
	}
	
	public String getType(){
		return(type);
	}
	
	public boolean[] getActivities(){
		return(activities);
	}

	public int[] getTicketsArray(){
		return(numTicketsArray);
	}

	public double getLodgeCost(){
		return(lodgeCost);
	}

	public void getStayInfo(){
		Scanner obj = new Scanner(System.in);
		boolean keepGoing = true;
		while(keepGoing){
			System.out.println("Where will you be staying? ");
			System.out.print("(Hotel, RV, Rental Home, Family or friend, Vacation Home) ");
			String typeCaps = (obj.nextLine()).toUpperCase();
			typeCaps = typeCaps.replaceAll("\\s", "");
				for(int i = 0; i < stayType.length; i++){
					if(typeCaps.equals(stayType[i])){
						type = typeCaps;
						keepGoing = false;
					}
				}
		}
		if(type.equals("HOTEL")){
			boolean go = true;
			while(go){
				System.out.println("How many stars does the hotel have? ");
				System.out.print("(1, 2, 3, 4, 5) ");
				String stars = obj.nextLine();
				if(stars.equals("1")){
					cost = 60;
					go = false;
				}
				else if(stars.equals("2")){
					cost = 75;
					go = false;
				}
				else if(stars.equals("3")){
					cost = 100;
					go = false;
				}
				else if(stars.equals("4")){
					cost = 125;
					go = false;
				}
				else if(stars.equals("5")){
					cost = 200;
					go = false;
				}
				else{
					System.out.println("Input not recognized... \n");
				}
			}
		}

		else if(type.equals("RV")){
			cost = 0;
		}
		
		else if(type.equals("RENTALHOME")){
			cost = 137;
		}

		else if(type.equals("FAMILYORFRIEND")){
			cost = 0;
		}

		else if(type.equals("VACATIONHOME")){
			cost = 0;
		}
		System.out.println("The average cost for this location is $" + cost + " per night.");
		boolean notDone = true;
		while(notDone){
			try{
				Scanner newObj = new Scanner(System.in);
				System.out.print("How many days will you stay: ");
				stayLength = newObj.nextInt();
				notDone = false;
			}catch(Exception e){
				System.out.println("Input not recognized...\n");
			}
		}
		cost = stayLength * cost;
		lodgeCost = cost;
		System.out.println("Your stay for " + stayLength + " days will cost $" + lodgeCost + "\n");
		
	}
}
