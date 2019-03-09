package be.amolixs.password;

import java.io.Console;
import java.util.Scanner;

/**
 * Classe qui contient les méthods pour la gestion des mot de passe
 * @author amolixs
 */
public class Password {
	/**
	 * La requete demandé pour entrez le mot de passe
	 * @author amolixs
	 */
	private String query;
	
	/**
	 * Constructeur par défault
	 * @author amolixs
	 */
	public Password() {
		this.query = "";
	}
	
	/**
	 * Constructeur qui permet d'initalisé la query
	 * @author amolixs
	 * @param query
	 */
	public Password(String query) {
		this.query = query;
	}
	
	/**
	 * Méthod qui permet de faire entrée un mot de passe de manère caché
	 * @author amolixs
	 * @return 
	 * 		Password enter
	 */
	public String inputPassword() {
		Scanner sc = new Scanner(System.in);
		String passwordString;
        Console console = System.console();
        if (console == null) {
        	System.out.print("[*] Entrez votre mot de passe : ");
        	passwordString = sc.next();
        }else {
            console.printf("[*] Entrez votre mot de passe : ");
            char[] passwordChars = console.readPassword();
            passwordString = new String(passwordChars);
        }
        return passwordString;
	}
}
