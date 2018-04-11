package co.com.prueba.cargamasiva.model.control.maestro;

import java.util.List;
import java.util.Objects;

import javax.enterprise.inject.Default;

import co.com.prueba.cargamasiva.dto.maestros.CampaniaDto;
import co.com.prueba.cargamasiva.model.control.ControlServiceBean;
import co.com.prueba.cargamasiva.model.entity.maestros.Campania;


/**
 * 
 * @author Leonardo Cruz 
 *
 */
@Default
public class CampaniaControl extends ControlServiceBean{
	
	
	public void crearCampania(CampaniaDto campaniaDto){
		Campania campania = new Campania();
		campania.setId(campaniaDto.getId());
		campania.setCodigo(campaniaDto.getCodigo());		
		campania.setNombre(campaniaDto.getNombre());
		if(Objects.nonNull(campania.getId())){
			actualizar(campania);
		}else{
			crear(campania);
		}
	}
	
	public void eliminarCampania(CampaniaDto campaniaDto){
		Campania campania = new Campania(campaniaDto.getId());
		eliminar(campania);
	}
	
	@SuppressWarnings("unchecked")
	public CampaniaDto consultarUltimaCampania() {		
		List<CampaniaDto> listCampania = (List<CampaniaDto>) buscarConNamedQuery("Campania.findAllCampania", 1);
		return Objects.nonNull(listCampania) && !listCampania.isEmpty() ? listCampania.get(0) : new CampaniaDto();
	} 
	
	
}
