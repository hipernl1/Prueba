package co.com.prueba.cargamasiva.facade.transaccional;

import java.io.Serializable;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import co.com.prueba.cargamasiva.definitions.factory.AdministradorService;
import co.com.prueba.cargamasiva.definitions.service.ArchivoRemote;
import co.com.prueba.cargamasiva.definitions.service.CampaniaRemote;
import co.com.prueba.cargamasiva.dto.maestros.CampaniaDto;
import co.com.prueba.cargamasiva.dto.transaccion.ArchivoDto;

@Dependent
public class ArchivoFacade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4511556432999194747L;
	@Inject
	@AdministradorService
	private ArchivoRemote archivoBoundary;


	public void guardarArchivo(ArchivoDto archivoDto) {
		archivoBoundary.guardarArchivo(archivoDto);
	}
	
	public CampaniaDto consultarUltimaCampania() {
		return archivoBoundary.consultarUltimaCampania();
	}
	
	
}
