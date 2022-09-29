import java.util.*;
import java.io.*;
public class Main{
	ArrayList<User> userList = new ArrayList<User>();
	User currUser;	

	public static void main(String[] args){
		Main m = new Main();
		m.loadAccounts();
		m.mainMenu();
		m.saveAccounts();
	}
	
	public void mainMenu(){
		Scanner obj = new Scanner(System.in);
		boolean keepGoing = true;
		while(keepGoing){
			System.out.println("1) Login ");
			System.out.println("2) Create new user ");
			System.out.println("0) Exit ");
			System.out.print("Choice: ");
			String choice = obj.nextLine();
			System.out.print("\n");
			if(choice.equals("1")){
				login();
			}
			else if(choice.equals("2")){
				createUser();
				currUser.userMenu();
			}
			else if(choice.equals("0")){
				keepGoing = false;
			}
			else{
				System.out.println("Input not recognized...\n");
			}
		}
	}
	
	public void login(){
		Scanner obj = new Scanner(System.in);
		System.out.print("Enter username: ");
		String username = obj.nextLine();
		System.out.print("Enter password: ");
		String password = obj.nextLine();
		System.out.print("\n");
		for(int i = 0; i < userList.size(); i++){
			boolean isUsername = ((userList.get(i)).getUsername()).equals(username);
			boolean isPassword = ((userList.get(i)).getPassword()).equals(password);
			if(isUsername && isPassword){
				currUser = userList.get(i);
				currUser.userMenu();
			}
		}
	}

	public void createUser(){	
		Scanner obj = new Scanner(System.in);
		System.out.print("Create username: ");
		String username = obj.nextLine();
		System.out.print("Create password: ");
		String password = obj.nextLine();
		System.out.print("\n");
		userList.add(new User(username, password));
		currUser = userList.get(userList.size() - 1);
	}
	
	public void saveAccounts(){
  		try{
			FileOutputStream fo = new FileOutputStream("userList.dat");
			ObjectOutputStream objectOut = new ObjectOutputStream(fo);
			objectOut.writeObject(userList);		
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
  	}//end saveAccounts

	public void loadAccounts(){
		try{
			FileInputStream fIn = new FileInputStream("userList.dat");
			ObjectInputStream objectIn = new ObjectInputStream(fIn);
			userList = (ArrayList<User>)objectIn.readObject();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
  	}//end loadAccounts
	
}
