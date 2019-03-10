package be.amolixs.product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
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
		JSONObject product = new JSONObject();
		String textJSon;
		product.put("name", name);
		product.put("price", price);
		product.put("isDrinked", isDrinked);
		textJSon = product.toString() + ",";
		try {
			Files.write(Paths.get("json/temp.json"), textJSon.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Méthode qui permet d'écrire le fichier json de suavegarde pour les produits
	 * @author amolixs
	 * @throws IOException 
	 */
	String writeJsonFileSave() throws IOException {
		File file = new File("json/temp.json");
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		String line;
		String textJsonTemp = "";
		while ((line=reader.readLine())!=null) {
			textJsonTemp += line;
		}
		reader.close();
		return textJsonTemp;
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
	 * Méthod qui permet d'écrire le fichier json de sauvegarde final
	 * @throws IOException
	 * 			Exception pour l'ouverture du fichier
	 */
	public void writeJsonFile() throws IOException {
		String textJsonTemp = writeJsonFileSave();
		File file = new File("json/product.json");
		FileWriter writer = new FileWriter(file);
		writer.write("[");
		writer.write(textJsonTemp);
		writer.write("]");
		writer.flush();
		writer.close();
	}
	
	/**
	 * Méthode qui permet de lire tous les produits
	 * @author amolixs
	 * @throws IOException 
	 */
	public void readAll() throws IOException {
		writeJsonFile();
		List<String> listNameProduct = getValuesForGivenKey(readFileJson(), "name");
		List<String> listPriceProduct = getValuesForGivenKey(readFileJson(), "price");
		List<String> listIsDrinkedProduct = getValuesForGivenKey(readFileJson(), "isDrinked");
		printAllName(listNameProduct);
		printAllPrice(listPriceProduct);
		printAllIsDrinked(listIsDrinkedProduct);
	}
	
	/**
	 * Méthode qui permet d'affiché la liste des noms des produits
	 * @author amolixs
	 * @param listName
	 * 		Liste contenant les noms des produits à affiché
	 */
	public void printAllName(List<String> listName) {
		System.out.println("=======================NAME=======================");
		for (String nameProduct : listName) {
			System.out.println(nameProduct);
		}
		System.out.println("==================================================");
	}
	
	/**
	 * Méthode qui permet d'affiché la liste des prix des produits
	 * @author amolixs
	 * @param listPrice
	 * 		Liste contenant le prix de tous les produits
	 */
	public void printAllPrice(List<String> listPrice) {
		System.out.println("=======================PRIX=======================");
		for (String nameProduct : listPrice) {
			System.out.println(nameProduct);
		}
		System.out.println("==================================================");
	}
	
	/**
	 * Méthode qui permet d'affiché si le produit est buvable ou non
	 * @author amolixs
	 * @param listIsDrinked
	 * 		Liste contenant des false/true représentant si le produit est buvable
	 * 		ou non
	 */
	public void printAllIsDrinked(List<String> listIsDrinked) {
		System.out.println("=======================BOISSON=======================");
		for (String isDrinked : listIsDrinked) {
			if (isDrinked.equals("true")) 
				System.out.println("Boisson");
			else
				System.out.println("Pas boisson");
		}
		System.out.println("==================================================");
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
