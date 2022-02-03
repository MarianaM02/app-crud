package org.adaitw.app_crud.model;

public class Venta {
	private int id;
	private Articulo articulo;
    private String cliente;
    private double cantidad;
    
	public Venta(int id, Articulo articulo, String cliente, double cantidad) {
		super();
		this.id = id;
		this.setArticulo(articulo);
		this.cliente = cliente;
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

}
