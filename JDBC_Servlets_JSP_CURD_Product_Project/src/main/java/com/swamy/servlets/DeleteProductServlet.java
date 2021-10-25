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

@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher rd = null;

		//1.Read the ID From the Form Page
		String pid = req.getParameter("id");
		
		//2.Parse the Data If Required
		int id = Integer.parseInt(pid);
		
		//3.create the Model class object and set the id to same object
		Product product = new Product();
		product.setPid(id);
		
		//4.Create the Service Interface Object and Call the Method
		IProductService service = new ProductServiceImpl();
		boolean flag = service.deleteProduct(id);
		List<Product> list = service.getAllProducts();
		req.setAttribute("list", list);
		//5.Create the message and send to UI Page
		String message = "Product Data '"+product.getPid()+"' Deleted Successfully";
		req.setAttribute("message", message);
		
		//6.Dispatch to Back to the UI Page
		rd = req.getRequestDispatcher("ProductsData.jsp");
		rd.forward(req, resp);
	}
}






