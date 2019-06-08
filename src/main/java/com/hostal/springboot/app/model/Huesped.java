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

	//bi-directional many-to-one association to ReservaHuesped
	@OneToMany(mappedBy="huesped" ,cascade = CascadeType.ALL)
	private List<ReservaHuesped> reservaHuespeds;

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

	public List<ReservaHuesped> getReservaHuespeds() {
		return this.reservaHuespeds;
	}

	public void setReservaHuespeds(List<ReservaHuesped> reservaHuespeds) {
		this.reservaHuespeds = reservaHuespeds;
	}

	public ReservaHuesped addReservaHuesped(ReservaHuesped reservaHuesped) {
		getReservaHuespeds().add(reservaHuesped);
		reservaHuesped.setHuesped(this);

		return reservaHuesped;
	}

	public ReservaHuesped removeReservaHuesped(ReservaHuesped reservaHuesped) {
		getReservaHuespeds().remove(reservaHuesped);
		reservaHuesped.setHuesped(null);

		return reservaHuesped;
	}

}