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
	 
	/**
	 * @author amolixs
	 * Méthod qui permet de gérer les choixs d'options des menus
	 */
	void choiceManagement(int choix);
	
	/**
	 * Boucle des menus
	 * @author amolixs
	 */
	void loop();
}
