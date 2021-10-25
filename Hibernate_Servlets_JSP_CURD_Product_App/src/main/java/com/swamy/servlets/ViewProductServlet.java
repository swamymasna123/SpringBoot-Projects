package com.swamy.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swamy.model.Product;
import com.swamy.service.IProductService;
import com.swamy.service.impl.ProductServiceImpl;

@WebServlet("/view")
public class ViewProductServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = null;

		//1.Read the Id From the Form Page
		String pid = req.getParameter("id");

		//2.Parse the Data If Required
		int id = Integer.parseInt(pid);

		//3.Create the Model class object and set the Data to same object
		Product product = new Product();
		product.setPid(id);

		//4.create the Service Object and Call the method
		IProductService service = new ProductServiceImpl();
		Product prod = service.getOneProduct(id);

		//5.Set the Object Back to UI
		req.setAttribute("ob", prod);

		//6.Dispatch Back to UI Page
		rd = req.getRequestDispatcher("ViewProduct.jsp");
		rd.forward(req, resp);
	}
}
