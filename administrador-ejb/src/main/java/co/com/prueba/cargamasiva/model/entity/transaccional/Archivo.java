package co.com.prueba.cargamasiva.model.entity.transaccional;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "archivo", schema = "transaccional")
@NamedQueries({
    @NamedQuery(name = "Archivo.findAll", query = "SELECT p FROM Archivo p"),    
})
public class Archivo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;	
	@Size(max = 150)
    @Column(name = "nombre_archivo_original")
	private String nombreArchivoOriginal;
	@Size(max = 250)
    @Column(name = "nombre_archivo_servidor")
	private String nombreArchivoServidor;
	@Size(max = 5)
    @Column(name = "extension")
	private String extension;
	@Size(max = 250)
    @Column(name = "path")
	private String path;
	@Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	
	public Archivo() {}
	
	/**
	 * 
	 * @param id
	 */
	public Archivo(Long id) {
		this.id = id;
	}
	/**
	 * @param nombreArchivoOriginal
	 * @param nombreArchivoServidor
	 * @param extension
	 * @param path
	 */
	public Archivo(String nombreArchivoOriginal, String nombreArchivoServidor, String extension, String path) {
		super();
		this.nombreArchivoOriginal = nombreArchivoOriginal;
		this.nombreArchivoServidor = nombreArchivoServidor;
		this.extension = extension;
		this.path = path;
		this.fechaRegistro = new Date();
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
	 * @return the nombreArchivoOriginal
	 */
	public String getNombreArchivoOriginal() {
		return nombreArchivoOriginal;
	}
	/**
	 * @param nombreArchivoOriginal the nombreArchivoOriginal to set
	 */
	public void setNombreArchivoOriginal(String nombreArchivoOriginal) {
		this.nombreArchivoOriginal = nombreArchivoOriginal;
	}
	/**
	 * @return the nombreArchivoServidor
	 */
	public String getNombreArchivoServidor() {
		return nombreArchivoServidor;
	}
	/**
	 * @param nombreArchivoServidor the nombreArchivoServidor to set
	 */
	public void setNombreArchivoServidor(String nombreArchivoServidor) {
		this.nombreArchivoServidor = nombreArchivoServidor;
	}
	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}
	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	

}
