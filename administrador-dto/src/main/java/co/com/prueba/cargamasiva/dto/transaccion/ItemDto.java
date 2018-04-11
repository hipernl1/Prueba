package co.com.prueba.cargamasiva.dto.transaccion;

import java.io.Serializable;

public class ItemDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1280734046209162586L;
	private String nombres;
	private String apellidos;
	private String telefonos;
	private String direccion;
	private String codigoCampania;
	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}
	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * @return the telefonos
	 */
	public String getTelefonos() {
		return telefonos;
	}
	/**
	 * @param telefonos the telefonos to set
	 */
	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the codigoCampania
	 */
	public String getCodigoCampania() {
		return codigoCampania;
	}
	/**
	 * @param codigoCampania the codigoCampania to set
	 */
	public void setCodigoCampania(String codigoCampania) {
		this.codigoCampania = codigoCampania;
	}
	
	

}
