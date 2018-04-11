package co.com.prueba.cargamasiva.definitions.factory.provider;

import javax.enterprise.inject.Alternative;

import co.com.prueba.cargamasiva.definitions.factory.BeanLocator;
import co.com.prueba.cargamasiva.definitions.factory.service.ServicesProviderFactory;
import co.com.prueba.cargamasiva.dto.configuracion.ServicePropertiesDto;

/**
 * 
 * @author Leonardo Cruz
 *
 */
@Alternative
public class RemoteEJBProvider implements ServicesProviderFactory {
    @Override
    public <T> T doLookup(Class<T> clazz, ServicePropertiesDto descriptorDTO) {
        return new BeanLocator.GlobalJNDIName()
                .withAppName(descriptorDTO.getAppName())
                .withModuleName(descriptorDTO.getModuleName())
                .withBeanName(descriptorDTO.getBeanName())
                .withBusinessInterface(descriptorDTO.getRemoteClazz())
                .locate(clazz);
    }
}
