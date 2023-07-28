package org.madhuri.app.message.handler;

import java.util.List;
import org.madhuri.app.message.model.Stock;
import org.madhuri.app.message.model.StockSymbol;
import org.madhuri.app.message.model.StockResponse;
import org.madhuri.app.message.service.StockService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/stocks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class StockHandler {
	
	private StockService stockService = new StockService();

    @GET
    @Path("/{symbol}")
    public Response getStockInfo(@PathParam("symbol") String symbol) {
        try {
            Stock stock = stockService.getStockData(symbol);
            if (stock != null) {
            	System.out.println("stock processed");
                return Response.ok(stock).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GET
    @Path("/search")
    public Response searchStocks(@QueryParam("q") String query) {
        try {
            if (query == null || query.trim().isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST)
                               .entity("Query parameter 'q' cannot be empty.")
                               .build();
            }

            StockResponse stockResponse = stockService.searchSymbols(query);
            List<StockSymbol> stocks = stockResponse.getResult(); 

            if (stocks != null && !stocks.isEmpty()) { 
                return Response.ok(stocks).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}

