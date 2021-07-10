package com.nilakshi.simplilearn.main;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.nilakshi.simplilearn.filemanager.FileManager;

public class Start {

	private static Logger logger = Logger.getLogger(Start.class.getName());
	private static Scanner sc = null;
	public static void main(String[] args) {
		System.out.println("**************************************************************");
		System.out.println("******************** Welcome to EXPLORER *********************");
		System.out.println("*********************** Version: 1.0 *************************");
		System.out.println("***************** Created By: NILAKSHI PATIL *****************");
		System.out.println("**************************************************************");
		System.out.println();

		sc = new Scanner(System.in);

		try {

			main_menu:	while(true) {
				System.out.println("SELECT from following options:");
				System.out.println("[1]\t List files");
				System.out.println("[2]\t File Menu");
				System.out.println("[3]\t Close the Application");
				int choice = sc.nextInt();

				switch(choice) {
				case 1: System.out.println("Listing files:");
				FileManager.getFileOperation().list().forEach(System.out::println);
				break;

				case 2: //File Menu
					showFileMenu();
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
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	static void showFileMenu() {
		try {
			while(true) {
				System.out.println("FILE MENU Options:");
				System.out.println("[1]\t Add file");
				System.out.println("[2]\t Delete file");
				System.out.println("[3]\t Search file");
				System.out.println("[4]\t Main Menu");
				int menu = sc.nextInt();

				String file;
				switch(menu) {
				case 1: // add a file
					System.out.println("Enter file name to be added");
					file=sc.next();
					boolean result=FileManager.getFileOperation().addFile(file);
					if(result) {
						System.out.println("File successfully created.");
					}else {
						System.out.println("File already exists.");
					}
					break;

				case 2: // delete a file
					System.out.println("Enter file name to be deleted");
					file=sc.next();
					boolean result1 = FileManager.getFileOperation().deleteFile(file);
					
					if(result1) {
						System.out.println("File successfully deleted.");
					}else {
						System.out.println("File not found.");
					}
					
					break;

				case 3: // case sensitive
					System.out.println("Enter file name to be searched");
					file=sc.next();
					boolean status=FileManager.getFileOperation().searchFile(file);
					if(status) {
						System.out.println("File is present");
					}else {
						System.out.println("File not found.");
					}
					break;

				case 4: // Back to main menu
					return;

				default: System.out.println("Invalid Choice");

				}
				System.out.println();
			}
		}catch (Exception e) {
			e.printStackTrace();
			// handle InputMismatchException
		}
	}
}
