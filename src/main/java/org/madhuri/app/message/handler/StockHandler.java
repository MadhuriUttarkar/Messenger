package org.madhuri.app.message.handler;

import org.madhuri.app.message.model.Stock;
import org.madhuri.app.message.service.StockService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
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
                return Response.ok(stock).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}

