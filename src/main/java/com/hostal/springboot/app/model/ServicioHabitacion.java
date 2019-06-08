package com.hostal.springboot.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ServicioHabitacion database table.
 * 
 */
@Entity
@NamedQuery(name="ServicioHabitacion.findAll", query="SELECT s FROM ServicioHabitacion s")
public class ServicioHabitacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idServicioHabitacion;

	private int numServicios;

	//bi-directional many-to-one association to Habitacion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Habitacion_idHabitacion")
	private Habitacion habitacion;

	//bi-directional many-to-one association to Servicio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Servicio_idServicio")
	private Servicio servicio;

	public ServicioHabitacion() {
	}

	public int getIdServicioHabitacion() {
		return this.idServicioHabitacion;
	}

	public void setIdServicioHabitacion(int idServicioHabitacion) {
		this.idServicioHabitacion = idServicioHabitacion;
	}

	public int getNumServicios() {
		return this.numServicios;
	}

	public void setNumServicios(int numServicios) {
		this.numServicios = numServicios;
	}

	public Habitacion getHabitacion() {
		return this.habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}