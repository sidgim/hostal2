package com.hostal.springboot.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reservaHabitacion database table.
 * 
 */
@Entity
@Table(name="reservaHabitacion")
@NamedQuery(name="ReservaHabitacion.findAll", query="SELECT r FROM ReservaHabitacion r")
public class ReservaHabitacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdReservaHabitacion")
	private int idReservaHabitacion;

	private int estado;

	//bi-directional many-to-one association to Habitacion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Habitacion_idHabitacion")
	private Habitacion habitacion;

	//bi-directional many-to-one association to Reserva
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Reserva_idReserva")
	private Reserva reserva;

	public ReservaHabitacion() {
	}

	public int getIdReservaHabitacion() {
		return this.idReservaHabitacion;
	}

	public void setIdReservaHabitacion(int idReservaHabitacion) {
		this.idReservaHabitacion = idReservaHabitacion;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Habitacion getHabitacion() {
		return this.habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Reserva getReserva() {
		return this.reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}