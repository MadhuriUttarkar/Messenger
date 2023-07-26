package org.madhuri.app.message.model;

import jakarta.json.bind.annotation.JsonbProperty;

public class Stock {
	
	@JsonbProperty("c")
	private double c;
	
	@JsonbProperty("d")
	private double d;
	
	@JsonbProperty("dp")
	private double dp;
	
	@JsonbProperty("h")
	private double h;
	
	@JsonbProperty("l")
	private double l;
	
	@JsonbProperty("o")
	private double o;
	
	@JsonbProperty("pc")
	private double pc;
	
	@JsonbProperty("t")
	private double t;
	
	public Stock()
	{
		
	}

	public Stock(double c, double d, double dp, double h, double l, double o, double pc, double t) {
		this.c = c;
		this.d = d;
		this.dp = dp;
		this.h = h;
		this.l = l;
		this.o = o;
		this.pc = pc;
		this.t = t;
	}

	public double getC() {
		return c;
	}

	public double getD() {
		return d;
	}

	public double getDp() {
		return dp;
	}

	public double getH() {
		return h;
	}

	public double getL() {
		return l;
	}

	public double getO() {
		return o;
	}

	public double getPc() {
		return pc;
	}

	public double getT() {
		return t;
	}

	public void setC(double c) {
		this.c = c;
	}

	public void setD(double d) {
		this.d = d;
	}

	public void setDp(double dp) {
		this.dp = dp;
	}

	public void setH(double h) {
		this.h = h;
	}

	public void setL(double l) {
		this.l = l;
	}

	public void setO(double o) {
		this.o = o;
	}

	public void setPc(double pc) {
		this.pc = pc;
	}

	public void setT(double t) {
		this.t = t;
	}	
}
