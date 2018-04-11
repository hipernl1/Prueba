package co.com.prueba.cargamasiva.model.boundary.maestro;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import co.com.prueba.cargamasiva.definitions.service.CampaniaRemote;
import co.com.prueba.cargamasiva.dto.maestros.CampaniaDto;
import co.com.prueba.cargamasiva.model.control.maestro.CampaniaControl;

@Stateless
@Remote(CampaniaRemote.class)
public class CampaniaBoundary implements CampaniaRemote{
	
	@Inject	
    private CampaniaControl campaniaControl;
	

	@Override
	public CampaniaDto consultarUltimaCampania() {
		return campaniaControl.consultarUltimaCampania();
	}

}
