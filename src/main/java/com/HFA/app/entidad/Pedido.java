package com.HFA.app.entidad;
// Generated 25 ene 2022 14:09:33 by Hibernate Tools 5.5.7.Final

/**
 * Pedido generated by hbm2java
 */
public class Pedido implements java.io.Serializable {

	private Integer idPedido;
	private Cliente cliente;
	private Droga droga;
	private Proveedor proveedor;
	private Long cantidad;
	private Long precio;

	public Pedido() {
	}

	public Pedido(Cliente cliente, Droga droga, Proveedor proveedor, Long cantidad, Long precio) {
		this.cliente = cliente;
		this.droga = droga;
		this.proveedor = proveedor;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public Integer getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Droga getDroga() {
		return this.droga;
	}

	public void setDroga(Droga droga) {
		this.droga = droga;
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Long getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public Long getPrecio() {
		return this.precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}

}
