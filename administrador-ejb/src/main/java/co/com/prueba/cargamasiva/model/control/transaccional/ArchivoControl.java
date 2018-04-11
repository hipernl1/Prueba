package co.com.prueba.cargamasiva.model.control.transaccional;

import java.util.Objects;

import javax.enterprise.inject.Default;

import co.com.prueba.cargamasiva.dto.transaccion.ArchivoDto;
import co.com.prueba.cargamasiva.model.control.ControlServiceBean;
import co.com.prueba.cargamasiva.model.entity.transaccional.Archivo;

@Default
public class ArchivoControl  extends ControlServiceBean{	
	public void crearArchivo(ArchivoDto archivoDto){
		Archivo archivo = new Archivo(archivoDto.getNombreArchivoOriginal(),
										archivoDto.getNombreArchivoServidor(),
										archivoDto.getExtension(),
										archivoDto.getPath());
		archivo.setId(archivoDto.getId());
		if(Objects.nonNull(archivo.getId())){
			actualizar(archivo);
		}else{
			crear(archivo);
		}
	}
}
