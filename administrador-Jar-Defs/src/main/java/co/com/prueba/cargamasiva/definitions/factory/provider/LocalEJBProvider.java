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
public class LocalEJBProvider implements ServicesProviderFactory {
    @Override
    public <T> T doLookup(Class<T> clazz, ServicePropertiesDto descriptorDTO) {
        return new BeanLocator.GlobalJNDIName()
                .setAppLevel()
                .withModuleName(descriptorDTO.getModuleName())
                .withBeanName(descriptorDTO.getBeanName())
                .withBusinessInterface(descriptorDTO.getLocalBusinessName())
                .locate(clazz);
    }
}
