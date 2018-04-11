package co.com.prueba.cargamasiva.dto.maestros;

import java.io.Serializable;
import java.util.Date;

public class CampaniaDto implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8800314536173028992L;
	private Long id;
    private String codigo;
    private String nombre;
    private Date fechaInsert;
    
    public CampaniaDto() {}
    
	/**
	 * @param id
	 * @param codigo
	 * @param nombre
	 * @param fechaInsert
	 */
	public CampaniaDto(Long id, String codigo, String nombre, Date fechaInsert) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaInsert = fechaInsert;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the fechaInsert
	 */
	public Date getFechaInsert() {
		return fechaInsert;
	}
	/**
	 * @param fechaInsert the fechaInsert to set
	 */
	public void setFechaInsert(Date fechaInsert) {
		this.fechaInsert = fechaInsert;
	}
    
    

}
