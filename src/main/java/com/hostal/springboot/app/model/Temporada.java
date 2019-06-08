package com.hostal.springboot.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Temporada database table.
 * 
 */
@Entity
@NamedQuery(name="Temporada.findAll", query="SELECT t FROM Temporada t")
public class Temporada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTemporada;

	private String tipo;

	//bi-directional many-to-one association to Habitacion
	@OneToMany(mappedBy="temporada",cascade = CascadeType.ALL)
	private List<Habitacion> habitacions;

	public Temporada() {
	}

	public int getIdTemporada() {
		return this.idTemporada;
	}

	public void setIdTemporada(int idTemporada) {
		this.idTemporada = idTemporada;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Habitacion> getHabitacions() {
		return this.habitacions;
	}

	public void setHabitacions(List<Habitacion> habitacions) {
		this.habitacions = habitacions;
	}

	public Habitacion addHabitacion(Habitacion habitacion) {
		getHabitacions().add(habitacion);
		habitacion.setTemporada(this);

		return habitacion;
	}

	public Habitacion removeHabitacion(Habitacion habitacion) {
		getHabitacions().remove(habitacion);
		habitacion.setTemporada(null);

		return habitacion;
	}

}