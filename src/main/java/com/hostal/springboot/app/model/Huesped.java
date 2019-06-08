package com.hostal.springboot.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Huesped database table.
 * 
 */
@Entity
@NamedQuery(name="Huesped.findAll", query="SELECT h FROM Huesped h")
public class Huesped implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int run;

	private String apellido;

	private String correo;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="huesped",cascade = CascadeType.ALL)
	private List<Reserva> reservas;

	public Huesped() {
	}

	public int getRun() {
		return this.run;
	}

	public void setRun(int run) {
		this.run = run;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setHuesped(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setHuesped(null);

		return reserva;
	}

}