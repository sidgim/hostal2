package com.hostal.springboot.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ReservaHuesped database table.
 * 
 */
@Entity
@NamedQuery(name="ReservaHuesped.findAll", query="SELECT r FROM ReservaHuesped r")
public class ReservaHuesped implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idReservaHuesped;

	@Temporal(TemporalType.DATE)
	private Date fechaReserva;

	//bi-directional many-to-one association to Huesped
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Huesped_run")
	private Huesped huesped;

	//bi-directional many-to-one association to Reserva
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Reserva_idReserva")
	private Reserva reserva;

	public ReservaHuesped() {
	}

	public int getIdReservaHuesped() {
		return this.idReservaHuesped;
	}

	public void setIdReservaHuesped(int idReservaHuesped) {
		this.idReservaHuesped = idReservaHuesped;
	}

	public Date getFechaReserva() {
		return this.fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Huesped getHuesped() {
		return this.huesped;
	}

	public void setHuesped(Huesped huesped) {
		this.huesped = huesped;
	}

	public Reserva getReserva() {
		return this.reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}