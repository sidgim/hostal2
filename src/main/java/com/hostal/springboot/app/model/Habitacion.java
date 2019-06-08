package com.hostal.springboot.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Habitacion database table.
 * 
 */
@Entity
@NamedQuery(name="Habitacion.findAll", query="SELECT h FROM Habitacion h")
public class Habitacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idHabitacion;

	private int numero;

	private double precio;

	private String tipo;

	//bi-directional many-to-one association to Temporada
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Temporada_idTemporada")
	private Temporada temporada;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="habitacion",cascade = CascadeType.ALL)
	private List<Reserva> reservas;

	//bi-directional many-to-one association to ServicioHabitacion
	@OneToMany(mappedBy="habitacion",cascade = CascadeType.ALL)
	private List<ServicioHabitacion> servicioHabitacions;

	public Habitacion() {
	}

	public int getIdHabitacion() {
		return this.idHabitacion;
	}

	public void setIdHabitacion(int idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Temporada getTemporada() {
		return this.temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setHabitacion(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setHabitacion(null);

		return reserva;
	}

	public List<ServicioHabitacion> getServicioHabitacions() {
		return this.servicioHabitacions;
	}

	public void setServicioHabitacions(List<ServicioHabitacion> servicioHabitacions) {
		this.servicioHabitacions = servicioHabitacions;
	}

	public ServicioHabitacion addServicioHabitacion(ServicioHabitacion servicioHabitacion) {
		getServicioHabitacions().add(servicioHabitacion);
		servicioHabitacion.setHabitacion(this);

		return servicioHabitacion;
	}

	public ServicioHabitacion removeServicioHabitacion(ServicioHabitacion servicioHabitacion) {
		getServicioHabitacions().remove(servicioHabitacion);
		servicioHabitacion.setHabitacion(null);

		return servicioHabitacion;
	}

}