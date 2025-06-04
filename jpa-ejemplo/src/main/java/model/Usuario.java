package model;

import java.time.LocalDate;


import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "tb_usuarios")
@DynamicInsert

public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_usua")
	private int codigo;
	
	@Column(name = "nom_usua", nullable = false)
	private String nombres;

	@Column(name = "ape_usua", nullable = false)
	private String apellidos;

	@Column(name = "user_usua", nullable = false)
	private String usuario;

	@Column(name = "pswd_usua", nullable = false)
	private String password;

	@Column(name = "fnac_usua")
	private LocalDate fechaNac;

	@Column(name = "idtipo", columnDefinition = "INT NOT NULL DEFAULT 2") // valor por defecto
	private Integer idTipo; 

	@Column(name = "est_usua", columnDefinition = "BIT NOT NULL DEFAULT 1") // valor por defecto
	private Boolean estado;
	
	  // Getters y Setters

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
}
