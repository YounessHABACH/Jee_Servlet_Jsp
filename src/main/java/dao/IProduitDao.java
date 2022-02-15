package dao;

import java.util.List;

import entities.Produit;

public interface IProduitDao {
	public Produit save(Produit p);
	public List<Produit> produitsParMC(String mc);
	public Produit get(Long id);
	public Produit update(Produit p);
	public void delete(Long id);
}
