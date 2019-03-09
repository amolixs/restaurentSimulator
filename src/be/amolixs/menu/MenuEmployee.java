package be.amolixs.menu;

import java.io.IOException;
import java.util.Scanner;

import be.amolixs.login.LoginEmployee;
import be.amolixs.product.ProductEditor;

public class MenuEmployee implements Menu {
	private ProductEditor productEditor;
	
	public MenuEmployee() {
		this.productEditor = new ProductEditor();
	}

	public void print() {
		System.out.println("1- Ajouter un produit");
		System.out.println("2- Lire les produit");
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

	public void choiceManagement(int choix) {
		switch (choix) {
			case 1:
				String nameProduct;
				int priceProduct;
				boolean isDrinked;
				Scanner sc = new Scanner(System.in);
				System.out.print("[*] Entrez le nom du produit : ");
				nameProduct = sc.next();
				System.out.print("[*] Entrez prix du produit : ");
				priceProduct = sc.nextInt();
				System.out.print("[*] Boisson true/false : ");
				isDrinked = sc.nextBoolean();
				productEditor.create(nameProduct, priceProduct, isDrinked);
			break;
			
			case 2:
			try {
				productEditor.readAll();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
	
			default:
				
			break;
		}
	}
	
	public void loop() {
		print();
		int choix = getChoice();
		choiceManagement(choix);
	}
}
