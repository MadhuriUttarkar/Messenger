package org.madhuri.app.message.handler;

import org.madhuri.app.message.model.StockSymbol;
import org.madhuri.app.message.service.StockSymbolService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/stocks")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StockSymbolHandler{
	
	 private StockSymbolService stockSymbolService = new StockSymbolService();
	 @GET
	 @Path("/{description}")
	 public Response getStockSymbolInfo(@PathParam("description") String description) {
		 
		 try {
	            StockSymbol stockSymbol = stockSymbolService.getStockDescription(description);
	            if (stockSymbol != null) {
	                return Response.ok(stockSymbol).build();
	            } else {
	                return Response.status(Response.Status.NOT_FOUND).build();
	            }
	        } catch (Exception e) {
	            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	        }
	    }
}
