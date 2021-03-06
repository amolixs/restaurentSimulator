package be.amolixs.menu;

import java.util.Scanner;

import be.amolixs.login.LoginEmployee;

/**
 * Classe qui permet de gérer le menu principal
 * @author amolixs
 * @version 1.0
 */

public class MainMenu implements Menu {
	/**
	 * Object de type MenuEmployee
	 * @author amolixs
	 */
	private MenuEmployee menuEmployee;
	
	/**
	 * Object de type LoginEmployee
	 * @author amolixs
	 */
	private LoginEmployee login;
	
	/**
	 * Constructeur par default
	 * @author amolixs
	 */
	public MainMenu() {
		this.menuEmployee = new MenuEmployee();
		this.login = new LoginEmployee();
	}

	public void print() {
		System.out.println("1- Menu employé");
		System.out.println("2- Menu client");
		System.out.println("3- Quit");
		System.out.print("[*] Votre choix : ");
	}

	public int getChoice() {
		Scanner sc = new Scanner(System.in);
		int choixInput;
		choixInput = sc.nextInt();
		return choixInput;
	}

	public void choiceManagement(int choix) {
		switch (choix) {
			case 1:
				login.printLoginPage();
			break;
			
			case 2:
				System.out.println("Comming soun...");
			break;
			
			case 3:
				System.out.println("Merci et à bientot !");
			break;
			
			default:
				System.out.println("Veuillez entrez une option valide");
			break;
		}
	}

	public void loop() {
		int choix = 0;
		do {
			print();
			choix = getChoice();
			choiceManagement(choix);
		}while(choix != 3);
	}
}
