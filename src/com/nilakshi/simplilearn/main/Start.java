package com.nilakshi.simplilearn.main;

import java.util.Scanner;
import java.util.logging.Logger;

import com.nilakshi.simplilearn.filemanager.FileManager;

public class Start {
	
	private static Logger logger = Logger.getLogger(Start.class.getName());

	public static void main(String[] args) {
		System.out.println("**************************************************************");
		System.out.println("******************** Welcome to EXPLORER *********************");
		System.out.println("*********************** Version: 1.0 *************************");
		System.out.println("***************** Created By: NILAKSHI PATIL *****************");
		System.out.println("**************************************************************");
		System.out.println();

		Scanner sc = new Scanner(System.in);

main_menu:	while(true) {
			System.out.println("SELECT from following option:");
			System.out.println("[1]\t List files");
			System.out.println("[2]\t File Menu");
			System.out.println("[3]\t Close the Application");
			int choice = sc.nextInt();

			switch(choice) {
			case 1: System.out.println("Listing files:");
					//TODO: Add logic to list files
					new FileManager();
					break;

			case 2: //TODO: File IO operation
					System.out.println("FILE MENU Options:");
					System.out.println("[1]\t Add file");
					System.out.println("[2]\t Delete file");
					System.out.println("[3]\t Search file");
					System.out.println("[4]\t Main Menu");
					int menu = sc.nextInt();
					
					String file;
file_menu:			switch(menu) {
						case 1: // TODO add a file
								System.out.println("Enter file name to be added");
								file=sc.next();
								break;
								
						case 2: // TODO delete a file
								System.out.println("Enter file name to be deleted");
								file=sc.next();
								break;
								
						case 3: // TODO search a file
								System.out.println("Enter file name to be searched");
								file=sc.next();
								break;
								
						case 4: // Back to main menu
								continue main_menu;
								
						default: System.out.println("Invalid Choice");
			
					}
					break;

			case 3: System.out.println("Are you sure you want to close the application [yes/no]:");
					String option = sc.next();

					if(option.equals("yes")) {
						System.out.println("Application Closed");
						System.exit(0);
					}
					break;
			
			default: System.out.println("Invalid option selected. Please, reselect");
					break;

			}
			
			System.out.println();

		}

	}
}
