package be.amolixs.product;

/**
 * Classe représentant les produits
 * @version 1.0
 * @author amolixs
 */
public class Product {
	/**
	 * Nom du produit
	 * @author amolixs
	 */
	private String name;
	
	/**
	 * Prix du produit
	 * @author amolixs
	 */
	private int price;
	
	/**
	 * Class du produit
	 * @author amolixs
	 */
	enum classProduit {
		LEGUME,
		FRUIT,
		VIANDE
	}
	
	/**
	 * Permet de savoir si le produit est buvable
	 * @author amolixs
	 */
	private boolean isDrinked;
	
	/**
	 * Constructeur par défault
	 * @author amolixs
	 */
	public Product() {
		this.name = "";
		this.price = 0;
		this.isDrinked = false;
	}
	
	/**
	 * Constructeur qui permet d'initalisé le nom du produit
	 * @author amolixs
	 * @param name
	 * 		Nom du produit
	 */
	public Product(String name) {
		this.name = name;
		this.price = 0;
		this.isDrinked = false;
	}
	
	/**
	 * Constructeur qui permet d'initialisé le prix du produit
	 * @author amolixs
	 * @param price
	 * 		Prix du produit
	 */
	public Product(int price) {
		this.name = "";
		this.price = price;
		this.isDrinked = false;
	}
	
	/**
	 * Constructeur qui permet d'initalisé le isDrinked
	 * @author amolixs
	 * @param isDrinked
	 * 		Permet de préciser si le produit est buvable
	 */
	public Product(boolean isDrinked) {
		this.name = "";
		this.price = 0;
		this.isDrinked = isDrinked;
	}
	
	/**
	 * Constructeur qui permet d'initialisé tous les attributs de la classe
	 * @author amolixs
	 * @param name
	 * 		Nom du produit
	 * @param price
	 * 		Prix du produit
	 * @param isDrinked
	 * 		Permet de préciser si le produit est buvable
	 */
	public Product(String name, int price, boolean isDrinked) {
		this.name = name;
		this.price = price;
		this.isDrinked = isDrinked;
	}
	
	/*******************************\
	 * 
	 * 			GUETTEURS
	 * 
	\*******************************/
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public boolean isDrinked() {
		return isDrinked;
	}
	
	/*******************************\
	 * 
	 * 			SETTERS
	 * 
	\*******************************/
	public void setDrinked(boolean isDrinked) {
		this.isDrinked = isDrinked;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
}