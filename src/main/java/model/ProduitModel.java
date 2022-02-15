package model;

import java.util.List;

import entities.Produit;

public class ProduitModel {
	private String mc;
	private List<Produit> produits;
	
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	
}
