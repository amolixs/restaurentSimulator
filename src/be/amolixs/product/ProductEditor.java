package be.amolixs.product;

/**
 * Classe qui permet de gérer les produits
 * @version 1.0
 * @author amolixs
 */
public class ProductEditor {
	/**
	 * Object de type Product représentant le produit
	 * @author amolixs
	 */
	private Product product;
	
	/**
	 * Constructeur de la classe Product
	 * @author amolixs
	 */
	public ProductEditor() {
		this.product = new Product();
	}
	
	/**
	 * Méthode qui permet de créer un produit
	 * @author amolixs
	 * @param name
	 * 		Nom du produit à créer
	 * @param price
	 * 		Prix du produit à créer
	 * @param isDrinked
	 * 		Si le produit est buvable ou non
	 */
	void create(String name, int price, boolean isDrinked) {
		product.setName(name);
		product.setPrice(price);
		product.setDrinked(isDrinked);
	}
	
	void read() {
		
	}
	
	void readAll() {
		
	}
	
	void update() {
		
	}
	
	void delete() {
	}
}
