package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.IProduitDao;
import dao.ProduitDaoImpl;
import model.ProduitModel;

@WebServlet(name = "produit", urlPatterns = {"/produit", "*.produit"})
public class ProduitServlet extends HttpServlet {
	private IProduitDao metier;
	
	@Override
	public void init() throws ServletException {
		metier = new ProduitDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/produit")){
			request.getRequestDispatcher("produit.jsp").forward(request, response);
		}
		else if (path.equals("/chercher.produit")) {
			String motCle = request.getParameter("mc");
			
			ProduitModel model = new ProduitModel();
			model.setMc(motCle);
			model.setProduits(metier.produitsParMC("%" + motCle + "%"));
			
			request.setAttribute("model", model);
			request.getRequestDispatcher("produit.jsp").forward(request, response);
		} else {
			response.sendError(Response.SC_NOT_FOUND);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
