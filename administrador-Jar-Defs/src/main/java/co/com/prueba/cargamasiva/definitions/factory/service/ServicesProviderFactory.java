package co.com.prueba.cargamasiva.definitions.factory.service;

import co.com.prueba.cargamasiva.dto.configuracion.ServicePropertiesDto;

public interface ServicesProviderFactory {
    <T> T doLookup(final Class<T> clazz, final ServicePropertiesDto servicePropertiesDTO);
}
