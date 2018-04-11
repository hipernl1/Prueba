package co.com.prueba.cargamasiva.dto.transaccion;

import java.io.Serializable;
import java.util.Objects;

/**
 * 
 * @author leonardo
 *
 */
public class ArchivoDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6149201636367320019L;
	
	private Long id;
	private String nombreArchivoOriginal;
	private String nombreArchivoServidor;
	private String extension;
	private String path;
	/**
	 * @param id
	 * @param nombreArchivoOriginal
	 * @param nombreArchivoServidor
	 * @param extension
	 * @param path
	 */
	public ArchivoDto(Long id, String nombreArchivoOriginal, String nombreArchivoServidor, String extension,
			String path) {
		super();
		this.id = id;
		this.nombreArchivoOriginal = nombreArchivoOriginal;
		this.nombreArchivoServidor = nombreArchivoServidor;
		this.extension = extension;
		this.path = path;
	}
	
	
	/**
	 * @param nombreArchivoOriginal
	 * @param nombreArchivoServidor
	 * @param extension
	 * @param path
	 */
	public ArchivoDto(String nombreArchivoOriginal, String nombreArchivoServidor, String extension, String path) {
		super();
		this.nombreArchivoOriginal = nombreArchivoOriginal;
		this.nombreArchivoServidor = nombreArchivoServidor;
		this.extension = extension;
		this.path = path;
	}

	/**
	 * 
	 * @param id
	 * @param nombreArchivoOriginal
	 */
	public ArchivoDto(Long id, String nombreArchivoOriginal) {
		super();
		this.id = id;
		this.nombreArchivoOriginal = nombreArchivoOriginal;		
	}

	/**
	 * 
	 * @param id
	 * @param nombreArchivoOriginal
	 * @param path
	 * @param nombreArchivoServidor
	 */
	public ArchivoDto(Long id, String nombreArchivoOriginal, String path, String nombreArchivoServidor) {
		super();
		this.id = id;
		this.nombreArchivoOriginal = nombreArchivoOriginal;		
		this.path = path;
		this.nombreArchivoServidor = nombreArchivoServidor;
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
		if(Objects.nonNull(nombreArchivoOriginal)) {
			nombreArchivoOriginal = nombreArchivoOriginal.trim();
		}
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
	
	

}
