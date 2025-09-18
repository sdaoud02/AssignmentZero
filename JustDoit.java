package app;
import java.io.File;
//import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class JustDoit {

	static ArrayList<String> filePath = new ArrayList<String>(); 
	final int ARRAY_SIZE = 19;
	//final String filePath = "res//dataset-10.txt";
	static Scanner input = new Scanner(System.in);



	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
			// create a switch case that reads the dataset and if the case is "secondary school(high school diploma)" or other education return the appropriate score
			// find a way to read the item right after the education and based on what it says return a score based on the scoring criteria again with a switch case
		//System.out.println("Enter your name: ");
		//String name = input.next();
		//System.out.println("Hello " + name);
		
		File filePath = new File("res/dataset-10.txt");
		Scanner inputFile = new Scanner(filePath);
			// Read a line from the file
			
			//Put file into array list and read everything on each line as 0-10
		File file = new File("res/dataset-10.txt");
		String word = inputFile.nextLine();
		//System.out.println(word);
		

			
		boolean test = true;
			//reads first line from text file, put these items into an arraylist and then 
		//String word = inputFile.nextLine();
			//System.out.println(word);
		/*switch (word) {
			case "Two or more certificates, diplomas, or degrees":
				System.out.println("You have 22 points");
				break;
		}*/
			//prompt();
			
			do{
				prompt();
				String str = inputFile.nextLine();

				switch (str) {
					case "Secondary school (high school diploma)":
						//int points = 5;
						System.out.println("You have 5 points");
						break;
					case "One-year degree, diploma or certificate":
						//int pointss = 15;
						System.out.println("You have 15 points");
						break;
					case "Two-year degree, diploma or certificate":
						int pointsss = 19;
						break;
					case "Bachelor's degree or other programs (three or more years)":
						int pointssss = 21;
						break;
					case "Two or more certificates, diplomas, or degrees":
						System.out.println("You have 22 points");
						//int pointsssss = 22;
						break;
					case "Professional degree needed to practice in a licensed profession":
						int pointssssss = 23;
						break;
					case "University degree at the Master's level":
						int pointsssssss = 23;
						break;
					case "University degree at the Doctoral (PhD) level":
						int pointssssssss = 25;
						break;
					default:
						System.out.println("Enter a valid option");
						break;
				}
			} while (test == true);
			
			/*input.close();
			inputFile.close();*/
		}
		
		public static void prompt() {
			System.out.println("Please provide the name of the input file (to be located in data/input): ");
			String inFil = input.nextLine();
			System.out.println("Please provide the name of the output file (to be placed in data/input/): ");
			String outFil = input.nextLine();
		}
		public static void pointsAge() {
			int points = 0;
			
		}
		public static void pointsWork(){
			
		}
		public static void qualified() {
			
		}
		
			
	

}
