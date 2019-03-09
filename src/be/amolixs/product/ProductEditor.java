package be.amolixs.product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Classe qui permet de gérer les produits
 * @version 1.0
 * @author amolixs
 */
public class ProductEditor {
	/**
	 * Object json
	 * @author amolixs
	 */
	private JSONObject productJson;
	
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
		this.productJson = new JSONObject();
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
	public void create(String name, int price, boolean isDrinked) {
		product.setName(name);
		product.setPrice(price);
		product.setDrinked(isDrinked);
		saveProduct(name, price, isDrinked);
		System.out.println("[+] Produit créer et sauvegardé !");
	}
	
	/**
	 * Méthode qui permet de save notre produit dans un fichier json
	 * @param name
	 * 		Nom du produit
	 * @param price
	 * 		Prix du produit
	 * @param isDrinked
	 * 		Savoir si le produit est buvable ou non
	 */
	void saveProduct(String name, int price, boolean isDrinked) {
		JSONObject productJson = new JSONObject();
		try {
			productJson.put("name", product.getName());
			productJson.put("price", product.getPrice());
			productJson.put("isDrinked", product.isDrinked());
			try {
				Files.write(Paths.get("json/product.json"), productJson.toString().getBytes(), StandardOpenOption.APPEND);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Méthod qui permet de récupérer les valeurs des object du fichier json
	 * @param jsonArrayStr
	 * 		Le tableau json
	 * @param key
	 * 		La clé a récupérer
	 * @return
	 * 		Une liste contenant les valeurs des clés
	 */
	public List<String> getValuesForGivenKey(String jsonArrayStr, String key) {
	    JSONArray jsonArray = new JSONArray(jsonArrayStr);
	    return IntStream.range(0, jsonArray.length())
	      .mapToObj(index -> ((JSONObject)jsonArray.get(index)).optString(key))
	      .collect(Collectors.toList());
	}
	
	/**
	 * Méthode qui permet de lire tous les produits
	 * @author amolixs
	 * @throws IOException 
	 */
	public void readAll() throws IOException {
		List<String> listNameProduct = getValuesForGivenKey(readFileJson(), "name");
		System.out.println(listNameProduct.toString());
	}
	
	/**
	 * Méthod qui permet de lire le fichier json
	 * @return
	 * 		Le contenu du fichier json
	 * @throws IOException
	 */
	public String readFileJson() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("json/product.json"));
		String json = "";
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = reader.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append("\n");
		        line = reader.readLine();
		    }
		    json = sb.toString();
		} finally {
		    reader.close();
		}
		
		return json;
	}
	
	void update() {
		
	}
	
	void delete() {
	}
}
