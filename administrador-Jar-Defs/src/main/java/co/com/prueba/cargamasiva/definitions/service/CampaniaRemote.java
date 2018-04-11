package co.com.prueba.cargamasiva.definitions.service;

import javax.ejb.Remote;

import co.com.prueba.cargamasiva.dto.maestros.CampaniaDto;

@Remote
public interface CampaniaRemote {
	/**
	 * Consulta la ultima campaña
	 * @return
	 */
	public CampaniaDto consultarUltimaCampania();

}
