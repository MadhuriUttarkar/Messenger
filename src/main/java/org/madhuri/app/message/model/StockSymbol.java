package org.madhuri.app.message.model;

import jakarta.json.bind.annotation.JsonbProperty;

public class StockSymbol {
	
	@JsonbProperty("description")
	private String description;
	
	@JsonbProperty("displaySymbol")
	private String displaySymbol;
	
	@JsonbProperty("symbol")
	private String symbol;
	
	@JsonbProperty("type")
	private String type;

	public StockSymbol()
	{
		
	}
	
	public StockSymbol(String description, String displaySymbol, String symbol, String type) {
		
		this.description = description;
		this.displaySymbol = displaySymbol;
		this.symbol = symbol;
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public String getDisplaySymbol() {
		return displaySymbol;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getType() {
		return type;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDisplaySymbol(String displaySymbol) {
		this.displaySymbol = displaySymbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public void setType(String type) {
		this.type = type;
	}
}
