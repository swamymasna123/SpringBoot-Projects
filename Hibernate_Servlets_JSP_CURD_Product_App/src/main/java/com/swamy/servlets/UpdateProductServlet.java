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

@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher rd = null;	
		
		//1.read the form data
		String id = req.getParameter("pid");
		String pname = req.getParameter("pname");
		String cost = req.getParameter("pcost");
		String pdesc = req.getParameter("pdesc");
		
		//2.Parse the Data If required
		int pid = Integer.parseInt(id);
		double pcost = Double.parseDouble(cost);
		
		//3.create the Model class object and set the Data to the Object
		Product product = new Product();
		product.setPid(pid);
		product.setPname(pname);
		product.setPcost(pcost);
		product.setPdesc(pdesc);
		
		//4.Create the Service Object and call the Method
		IProductService service = new ProductServiceImpl();
		service.updateProduct(product);
		List<Product> list = service.getAllProducts();
		//5.create the Message and Send to UI
		String message = "Product Data '"+product.getPid()+"' Updated Successfully";
		req.setAttribute("message", message);
		req.setAttribute("list", list);
		
		//6.Dispacth Back to UI Page
		rd = req.getRequestDispatcher("ProductsData.jsp");
		rd.forward(req, resp);
	}
}
