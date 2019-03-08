package be.amolixs.app;

import be.amolixs.menu.MainMenu;

/**
 * Classe qui gere l'application
 * @version 1.0
 * @author amolixs
 */
public class Application {
	/**
	 * Object de type MainMenu
	 * @author amolixs
	 */
	private MainMenu mainMenu;
	
	/**
	 * Constructeur de la classe Application
	 * @author amolixs
	 */
	public Application() {
		init();
	}
	
	/**
	 * Méthod qui permet d'initialisé tous les objects
	 * @author amolixs
	 */
	public void init() {
		this.mainMenu = new MainMenu();
	}
	
	/**
	 * Méthod qui permet de lancer l'application
	 * @author amolixs
	 */
	public void run() {
		printLogo();
		mainMenu.run();
	}
	
	/**
	 * Méthod qui permet d'afficher le logo
	 * @author amolixs
	 */
	public void printLogo() {
		System.out.println("####################################################################################################");
		System.out.println("   _____  ______  _____ _______      _    _ _____  ______ _   _ _______ ");              
		System.out.println("  |  __ \\|  ____|/ ____|__   __|/\\  | |  | |  __ \\|  ____| \\ | |__   __|");              
		System.out.println("  | |__) | |__  | (___    | |  /  \\ | |  | | |__) | |__  |  \\| |  | |   ");              
		System.out.println("  |  _  /|  __|  \\___ \\   | | / /\\ \\| |  | |  _  /|  __| | . ` |  | |   ");              
		System.out.println("  | | \\ \\| |____ ____) |  | |/ ____ \\ |__| | | \\ \\| |____| |\\  |  | |   ");              
		System.out.println("  |_|  \\_\\______|_____/   |_/_/ ___\\_\\____/|_|  \\_\\______|_| \\_| _|_|___ ____  _____ ");  
		System.out.println("                         / ____|_   _|  \\/  | |  | | |        /\\|__   __/ __ \\|  __ \\ ");
		System.out.println("                        | (___   | | | \\  / | |  | | |       /  \\  | | | |  | | |__) |");
		System.out.println("                         \\___ \\  | | | |\\/| | |  | | |      / /\\ \\ | | | |  | |  _  / ");
		System.out.println("                         ____) |_| |_| |  | | |__| | |____ / ____ \\| | | |__| | | \\ \\ ");
		System.out.println("                        |_____/|_____|_|  |_|\\____/|______/_/    \\_\\_|  \\____/|_|  \\_\\ ");                                                                      
		System.out.println("####################################################################################################");
	}
	
	/*******************************\
	 * 
	 * 			GUETTEURS
	 * 
	\*******************************/
	
	public MainMenu getMainMenu() {
		return mainMenu;
	}
	
	/*******************************\
	 * 
	 * 			SETTERS
	 * 
	\*******************************/
	
	public void setMainMenu(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
	}
}
