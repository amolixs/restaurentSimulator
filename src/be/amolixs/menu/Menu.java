package be.amolixs.menu;

/**
 * Interface qui contient les méthods pour les menus
 * @version 1.0
 * @author amolixs
 */

public interface Menu {
	/**
	 * Méthod qui permettra d'afficher un menu
	 * @author amolixs
	 */
	void print();
	
	/**
	 * Méthod qui va permettre de récupérer le choix options entré par l'utilisateur
	 * @author amolixs
	 * @return 
	 * 		Choix entré par l'utilisateur
	 */
	int getChoice();
	
	
	void choixManagement(int choix);
	
	/**
	 * Méthod qui permet de lancer le menu
	 * @author amolixs
	 */
	void run();
}
