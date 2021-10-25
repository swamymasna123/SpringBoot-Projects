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

@WebServlet("/all")
public class FetchListProductsServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher rd = null;
		
		//1.create the Service Interface Object and call the method
		IProductService service = new ProductServiceImpl();
		List<Product> list = service.getAllProducts();
		
		//2.send the Response Back to the UI Page
		req.setAttribute("list", list);
		
		//3.Dispatch back to UI Page
		rd = req.getRequestDispatcher("ProductsData.jsp");
		rd.forward(req, resp);
	}
}

