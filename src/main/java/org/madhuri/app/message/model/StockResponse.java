package org.madhuri.app.message.model;

import java.util.List;

import jakarta.json.bind.annotation.JsonbProperty;

public class StockResponse {

	@JsonbProperty("count")
	private long count;
	
	@JsonbProperty("result")
	private List<StockSymbol> result;
	
	
	public StockResponse()
	{
		
	}
	

	public StockResponse(long count, List<StockSymbol> result) {
		super();
		this.count = count;
		this.result = result;
	}

	public long getCount() {
		return count;
	}

	public List<StockSymbol> getResult() {
		return result;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public void setResult(List<StockSymbol> result) {
		this.result = result;
	}
}
