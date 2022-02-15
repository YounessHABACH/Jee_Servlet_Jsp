package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CreditMetierImpl;
import metier.ICreditMetier;
import model.CreditModel;

@WebServlet(name = "creditServlet", urlPatterns = {"/credit", "*.credit"})
public class ControllerServlet extends HttpServlet {
	private ICreditMetier iCreditMetier;
	
	@Override
	public void init() throws ServletException {
		iCreditMetier = new CreditMetierImpl();
		System.out.println("Init servlet");
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("creditModel", new CreditModel());
        request.getRequestDispatcher("credit.jsp").forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// read data from request
		double capital = Double.parseDouble(request.getParameter("capital"));
		double taux = Double.parseDouble(request.getParameter("taux"));
		int duree = Integer.parseInt(request.getParameter("duree"));
		// do Validation
		
		// Create model object + do processing
		CreditModel creditModel = new CreditModel();
		creditModel.setCapital(capital);
		creditModel.setDuree(duree);
		creditModel.setTaux(taux);
		creditModel.setMonthlyPart(iCreditMetier.calculerMensualite(capital, taux, duree));
		// store the nodel to request
		request.setAttribute("creditModel", creditModel);
		// forward to jsp file
		request.getRequestDispatcher("credit.jsp").forward(request, response);
	}
}
