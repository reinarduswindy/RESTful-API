package com.windyhendra;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/CartService")
public class CartService {
	Cart cart = new Cart();
	
	@GET
	@Path("/cart")
	@Produces(MediaType.APPLICATION_XML)
	public List<Product> getProducts() {
		return cart.getAllProducts();
	}
	
	@GET
	@Path("cart/totalpurchase")
	@Produces(MediaType.APPLICATION_XML)
	public TotalPurchase getTotalPurchase() {
		return cart.getTotalPurchase();
	}
	
	@GET
	@Path("/addproduct/{product-id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response addProduct(@PathParam("product-id") String productId) {
		cart.addProduct(productId);
		return Response.status(200).entity("Berhasil").build();
	}
	
	@GET
	@Path("/addcoupon/{coupon-id}")
	@Produces("text/xml")
	public Response addCoupon(@PathParam("coupon-id") String couponCode) {
		cart.addCoupon(couponCode);
		return Response.status(200).entity("Berhasil").build();
	}
	
	@GET
	@Path("/removeproduct/{product-id}")
	@Produces("text/xml")
	public Response removeProduct(@PathParam("product-id") String productId) {
		cart.removeProduct(productId);
		return Response.status(200).entity("Berhasil").build();
	}
	
	@GET
	@Path("/removecoupon")
	@Produces("text/xml")
	public Response removeCoupon() {
		cart.removeCoupon();
		return Response.status(200).entity("Berhasil").build();
	}
}
