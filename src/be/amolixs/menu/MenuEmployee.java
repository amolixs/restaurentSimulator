package be.amolixs.menu;

import java.util.Scanner;

import be.amolixs.login.LoginEmployee;

public class MenuEmployee implements Menu {
	
	public MenuEmployee() {
	}

	public void print() {
		System.out.println("1- Ajouter un produit");
		System.out.println("2- Lire un produit");
		System.out.println("3- Mettre un jour un produit");
		System.out.println("4- Supprimer un produit");
		System.out.print("[*] Votre choix : ");
	}

	public int getChoice() {
		Scanner sc = new Scanner(System.in);
		int choixInput;
		choixInput = sc.nextInt();
		return choixInput;
	}

	public void choixManagement(int choix) {
		switch (choix) {
			case 1:
				
			break;
	
			default:
				
			break;
		}
	}

	public void run() {
	}
}
