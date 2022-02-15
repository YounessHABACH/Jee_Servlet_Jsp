package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import designPattern.SingletonConnection;
import entities.Produit;

public class ProduitDaoImpl implements IProduitDao {

	@Override
	public Produit save(Produit p) {
		Connection con = SingletonConnection.getConnection();
		String insertQuery = "INSERT INTO Produit(designation, prix, quantity) VALUES (?, ?, ?);";
		String getMaxID = "SELECT MAX(id) MAXID FROM Produit;";
		try {
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantity());
			
			ps.executeUpdate();
			ps.close();
			
			PreparedStatement ps_ = con.prepareStatement(getMaxID);
			ResultSet result = ps_.executeQuery();
			if(result.next()) {
				p.setId(result.getLong("MAXID"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Produit> produitsParMC(String mc) {
		List<Produit> produits = new ArrayList<>();
		Connection con = SingletonConnection.getConnection();
		String selectQuery = "SELECT id, designation, prix, quantity FROM Produit WHERE designation LIKE ?";
		try {
			PreparedStatement ps = con.prepareStatement(selectQuery);
			ps.setString(1, mc);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Produit p = new Produit();
				p.setId(rs.getLong("id"));
				p.setDesignation(rs.getString("designation"));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantity(rs.getInt("quantity"));
				
				produits.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produits;
	}

	@Override
	public Produit get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit update(Produit p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
}
