package co.com.prueba.cargamasiva.definitions.service;

import javax.ejb.Remote;

import co.com.prueba.cargamasiva.dto.maestros.CampaniaDto;
import co.com.prueba.cargamasiva.dto.transaccion.ArchivoDto;


@Remote
public interface ArchivoRemote {
	/**
	 * Almacena un archivo en la bd
	 * @param archivoDto
	 */
	public void guardarArchivo(ArchivoDto archivoDto);
	
	/**
	 * Consulta la ultima campaña
	 * @return
	 */
	public CampaniaDto consultarUltimaCampania();
	


}
