import java.util.*;
import java.io.*;
class TransportMethod implements Serializable{
	//enumeration of types of vehicles supported
	String[] transportType = {"SEDAN", "SUV", "TRUCK", "RV"};
	protected double mileage;
	protected String type;

	public static void main(String[] args){
		TransportMethod tm = new TransportMethod();
	}

	//constructor calls getVehicleInfo to get values for
	//vehicle type and mileage
	public TransportMethod(){
		getVehicleInfo();
	}

	public double getMpg(){
		return mileage;
	}
	public void getVehicleInfo(){
		Scanner obj = new Scanner(System.in);
		boolean keepGoing = true;
		while(keepGoing){
			System.out.println("What type of vehicle will you be taking? ");
			System.out.print("(Sedan, SUV, Truck, RV): ");
			String typeCaps = (obj.nextLine()).toUpperCase();
			for(int i = 0; i < transportType.length; i++){
				if(typeCaps.equals(transportType[i])){
					this.type = typeCaps;
					keepGoing = false;
					System.out.println("Type Selected: " + type);
				}
			}
		}

		String typeString = String.valueOf(type);
		if(typeString.equals("SEDAN")){
			this.mileage = 24.2;
		}
		else if(typeString.equals("SUV")){
			this.mileage = 20;
		}
		else if(typeString.equals("TRUCK")){
			this.mileage = 16;
		}
		else if(typeString.equals("RV")){
			this.mileage = 8;
		}
		System.out.println("Avereage mileage for type: " + mileage);
	}
}
