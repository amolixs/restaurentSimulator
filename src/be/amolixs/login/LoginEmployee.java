package be.amolixs.login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import be.amolixs.crypt.Crypt;
import be.amolixs.menu.MenuEmployee;

/**
 * Classe qui permet de gérer la connexion des employés
 * @author amolixs
 * @version 1.0
 */

public class LoginEmployee {
	/**
	 * Object de type MenuEmployee
	 * @author amolixs
	 */
	private MenuEmployee menuEmployee;
	
	/**
	 * Constructeur par default
	 * @author amolixs
	 */
	public LoginEmployee() {
		this.menuEmployee = new MenuEmployee();
	}
	
	/**
	 * Méthode qui permet de logé l'émployé
	 * @author amolixs
	 */
	public void printLoginPage() {
		String username;
		String password;
		Scanner sc  = new Scanner(System.in);
		System.out.print("[*] Entrez le username : ");
		username = sc.nextLine();
		System.out.print("[*] Entrez le mot de passe : ");
		password = sc.nextLine();
		try {
			String hash = Crypt.cryptMd5(password);
			try {
				String hashFile = retrievePassInThoTheFilePass();
				if (verifPassword(hash, hashFile) && username.equals("admin")) {
					Process clear = Runtime.getRuntime().exec("clear");
					menuEmployee.print();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Méthode qui permet de vérifier le password
	 * @param passwordInput
	 * 			Mot de passe entré par l'employé(mot de passe à vérifer)
	 * @param passwordFile
	 * 			Mot de passe contenue de le fichier Pass
	 * @return true si password correct else
	 */
	public boolean verifPassword(String passwordInput, String passwordFile) {
		if (passwordInput.equals(passwordFile)) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Méthode qui permet de récupérer le mot de passe contennu dans le fichier Pass
	 * @return
	 * 		Mot de passe crypté récupérer
	 * @throws IOException 
	 */
	public String retrievePassInThoTheFilePass() throws IOException {
		File file = new File("/home/amolixs/eclipse-workspace/restaurentSimulator/src/file/Pass");
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		String line = reader.readLine();
		reader.close();
		return line;
	}
}
