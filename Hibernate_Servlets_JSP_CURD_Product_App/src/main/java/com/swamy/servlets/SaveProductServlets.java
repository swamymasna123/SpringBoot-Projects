package com.swamy.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swamy.model.Product;
import com.swamy.service.IProductService;
import com.swamy.service.impl.ProductServiceImpl;

@WebServlet("/save")
public class SaveProductServlets extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = null;
		
		//1.Read the Form Data
		String pname = req.getParameter("pname");
		String cost = req.getParameter("pcost");
		String pdesc = req.getParameter("pdesc");
		
		//2.Parse the Data If Required
		double pcost = Double.parseDouble(cost);
		
		//3.Create the Model class Object and set the Data to Same Object
		Product product = new Product();
		product.setPname(pname);
		product.setPcost(pcost);
		product.setPdesc(pdesc);
		
		//4.Create the Service Interface Object and call the Method
		IProductService service = new ProductServiceImpl();
		Integer id = service.saveProduct(product);
		List<Product> list = service.getAllProducts();
		//5.Create the Message and send to UI Page
		String message = "Product Data '"+id+"' Saved Successfully";
		req.setAttribute("message", message);
		req.setAttribute("list", list);
		
		//6.Dispatch Back to Same UI page.
		rd = req.getRequestDispatcher("ProductsData.jsp");
		rd.forward(req, resp);
	}
}

