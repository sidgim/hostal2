package com.hostal.springboot.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


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
	private Date fechaEntrada;

	@Temporal(TemporalType.DATE)
	private Date fechaSalida;

	//bi-directional many-to-one association to TipoPago
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TipoPago_idTipoPago")
	private TipoPago tipoPago;

	//bi-directional many-to-one association to ReservaHuesped
	@OneToMany(mappedBy="reserva" , cascade = CascadeType.ALL)
	private List<ReservaHuesped> reservaHuespeds;

	//bi-directional many-to-one association to ReservaHabitacion
	@OneToMany(mappedBy="reserva" , cascade = CascadeType.ALL)
	private List<ReservaHabitacion> reservaHabitacions;

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

	public TipoPago getTipoPago() {
		return this.tipoPago;
	}

	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}

	public List<ReservaHuesped> getReservaHuespeds() {
		return this.reservaHuespeds;
	}

	public void setReservaHuespeds(List<ReservaHuesped> reservaHuespeds) {
		this.reservaHuespeds = reservaHuespeds;
	}

	public ReservaHuesped addReservaHuesped(ReservaHuesped reservaHuesped) {
		getReservaHuespeds().add(reservaHuesped);
		reservaHuesped.setReserva(this);

		return reservaHuesped;
	}

	public ReservaHuesped removeReservaHuesped(ReservaHuesped reservaHuesped) {
		getReservaHuespeds().remove(reservaHuesped);
		reservaHuesped.setReserva(null);

		return reservaHuesped;
	}

	public List<ReservaHabitacion> getReservaHabitacions() {
		return this.reservaHabitacions;
	}

	public void setReservaHabitacions(List<ReservaHabitacion> reservaHabitacions) {
		this.reservaHabitacions = reservaHabitacions;
	}

	public ReservaHabitacion addReservaHabitacion(ReservaHabitacion reservaHabitacion) {
		getReservaHabitacions().add(reservaHabitacion);
		reservaHabitacion.setReserva(this);

		return reservaHabitacion;
	}

	public ReservaHabitacion removeReservaHabitacion(ReservaHabitacion reservaHabitacion) {
		getReservaHabitacions().remove(reservaHabitacion);
		reservaHabitacion.setReserva(null);

		return reservaHabitacion;
	}

}