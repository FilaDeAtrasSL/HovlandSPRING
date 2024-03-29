package com.HFA.app.entidad;
// Generated 6 feb 2022 13:08:19 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Proveedor generated by hbm2java
 */
@Entity
@Table(name = "proveedor", catalog = "heroku_5c8a2da75f0eb42")
public class Proveedor implements java.io.Serializable {

	private Integer id;
	private String nombre;
	private String localidad;
	private Set<Droga> drogas = new HashSet<Droga>(0);
	private Set<Pedido> pedidos = new HashSet<Pedido>(0);
	private Set<Droga> drogas_1 = new HashSet<Droga>(0);

	public Proveedor() {
	}

	public Proveedor(String nombre, String localidad, Set<Droga> drogas, Set<Pedido> pedidos, Set<Droga> drogas_1) {
		this.nombre = nombre;
		this.localidad = localidad;
		this.drogas = drogas;
		this.pedidos = pedidos;
		this.drogas_1 = drogas_1;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nombre", length = 20)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "localidad", length = 20)
	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proveedor")
	public Set<Droga> getDrogas() {
		return this.drogas;
	}

	public void setDrogas(Set<Droga> drogas) {
		this.drogas = drogas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proveedor")
	public Set<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "droga_has_proveedor", catalog = "heroku_5c8a2da75f0eb42", joinColumns = {
			@JoinColumn(name = "proveedor_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "droga_id", nullable = false, updatable = false) })
	public Set<Droga> getDrogas_1() {
		return this.drogas_1;
	}

	public void setDrogas_1(Set<Droga> drogas_1) {
		this.drogas_1 = drogas_1;
	}

}
