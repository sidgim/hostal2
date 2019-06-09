package com.hostal.springboot.app.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * The persistent class for the Reserva database table.
 * 
 */
@Entity
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idReserva;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull
	private Date fechaEntrada;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull
	private Date fechaSalida;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Habitacion_idHabitacion")
	private Habitacion habitacion;

	//bi-directional many-to-one association to Huesped
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Huesped_idHuesped")
	private Huesped huesped;

	//bi-directional many-to-one association to TipoPago
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TipoPago_idTipoPago")
	private TipoPago tipoPago;

	public Reserva() {
	}

	public int getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Date getFechaEntrada() {
		return this.fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Habitacion getHabitacion() {
		return this.habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Huesped getHuesped() {
		return this.huesped;
	}

	public void setHuesped(Huesped huesped) {
		this.huesped = huesped;
	}

	public TipoPago getTipoPago() {
		return this.tipoPago;
	}

	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}

}