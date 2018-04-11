package co.com.prueba.cargamasiva.model.boundary.transaccional;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import co.com.prueba.cargamasiva.definitions.service.ArchivoRemote;
import co.com.prueba.cargamasiva.dto.maestros.CampaniaDto;
import co.com.prueba.cargamasiva.dto.transaccion.ArchivoDto;
import co.com.prueba.cargamasiva.model.control.maestro.CampaniaControl;
import co.com.prueba.cargamasiva.model.control.transaccional.ArchivoControl;


@Stateless
@Remote(ArchivoRemote.class)
public class ArchivoBoundary implements ArchivoRemote{
	
	@Inject	
    private ArchivoControl archivoControl;
	
	@Inject	
    private CampaniaControl campaniaControl;
		
	@Override
	public void guardarArchivo(ArchivoDto archivoDto) {
		archivoControl.crearArchivo(archivoDto);		
	}
	
	@Override
	public CampaniaDto consultarUltimaCampania() {
		return campaniaControl.consultarUltimaCampania();
	}

}
