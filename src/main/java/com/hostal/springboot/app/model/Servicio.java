package com.hostal.springboot.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Servicio database table.
 * 
 */
@Entity
@NamedQuery(name="Servicio.findAll", query="SELECT s FROM Servicio s")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idServicio;

	private String nombre;

	private String precio;

	//bi-directional many-to-one association to ServicioHabitacion
	@OneToMany(mappedBy="servicio",cascade = CascadeType.ALL)
	private List<ServicioHabitacion> servicioHabitacions;

	public Servicio() {
	}

	public int getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return this.precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public List<ServicioHabitacion> getServicioHabitacions() {
		return this.servicioHabitacions;
	}

	public void setServicioHabitacions(List<ServicioHabitacion> servicioHabitacions) {
		this.servicioHabitacions = servicioHabitacions;
	}

	public ServicioHabitacion addServicioHabitacion(ServicioHabitacion servicioHabitacion) {
		getServicioHabitacions().add(servicioHabitacion);
		servicioHabitacion.setServicio(this);

		return servicioHabitacion;
	}

	public ServicioHabitacion removeServicioHabitacion(ServicioHabitacion servicioHabitacion) {
		getServicioHabitacions().remove(servicioHabitacion);
		servicioHabitacion.setServicio(null);

		return servicioHabitacion;
	}

}