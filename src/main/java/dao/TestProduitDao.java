package dao;

import java.util.Iterator;
import java.util.List;

import entities.Produit;

public class TestProduitDao {
	public static void main(String[] args) {
		IProduitDao dao = new ProduitDaoImpl();
		//Produit p1 = dao.save(new Produit("HP", 4000.50, 5));
		//Produit p2 = dao.save(new Produit("Omen", 12000.50, 5));
		//Produit p3 = dao.save(new Produit("Lenovo", 6000.50, 5));

		//System.out.println(p1);
		//System.out.println(p2);
		//System.out.println(p3);
		
		System.out.println("Chercher");
		List<Produit> produits = dao.produitsParMC("%H%");
		for (Produit p: produits) {
			System.out.println(p);
		}

	}
}
