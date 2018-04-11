package co.com.prueba.cargamasiva.definitions.factory.service;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import co.com.prueba.cargamasiva.definitions.factory.AdministradorService;
import co.com.prueba.cargamasiva.definitions.service.ArchivoRemote;
import co.com.prueba.cargamasiva.definitions.service.CampaniaRemote;
import co.com.prueba.cargamasiva.dto.configuracion.ServicePropertiesDto;

/**
 * 
 * @author Leonardo Cruz
 *
 */
public class ServicesFactory {

	// Services provider

	@Inject
	private ServicesProviderFactory servicesProvider;

	private ServicePropertiesDto buildServicesPropertiesDTO(ServiciosEnum serviciosEnum) {
		return new ServicePropertiesDto(serviciosEnum.getLocalBusinessName(), serviciosEnum.getRemoteClazz(),
				serviciosEnum.getBeanName(), serviciosEnum.getAppName(), ServiciosEnum.MODULE_NAME);
	}

	@Produces
	@AdministradorService
	public CampaniaRemote produceCacheBoundary() {
		return servicesProvider.doLookup(CampaniaRemote.class,
				buildServicesPropertiesDTO(ServiciosEnum.CAMPANIA_BOUNDARY));
	}
	
	@Produces
	@AdministradorService
	public ArchivoRemote produceArchivoBoundary() {
		return servicesProvider.doLookup(ArchivoRemote.class,
				buildServicesPropertiesDTO(ServiciosEnum.ARCHIVO_BOUNDARY));
	}	

	public enum ServiciosEnum {

		ARCHIVO_BOUNDARY(ArchivoRemote.class, "ArchivoBoundary"),
		CAMPANIA_BOUNDARY(CampaniaRemote.class, "CampaniaBoundary");
		

		static String MODULE_NAME = "administrador-ejb-1.0-SNAPSHOT";

		// Estructura del enum
		private final String localBusinessName;
		private final Class remoteClazz;
		private final String beanName;

		ServiciosEnum(Class remoteClazz, String beanName) {
			this.localBusinessName = "";
			this.remoteClazz = remoteClazz;
			this.beanName = beanName;
		}

		public String getLocalBusinessName() {
			return localBusinessName;
		}

		public Class getRemoteClazz() {
			return remoteClazz;
		}

		public String getBeanName() {
			return beanName;
		}

		public String getAppName() {
			return "administrador-ear-1.0-SNAPSHOT";
		}
	}

}
