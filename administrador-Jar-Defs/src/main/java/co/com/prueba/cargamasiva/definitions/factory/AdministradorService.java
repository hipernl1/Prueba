package co.com.prueba.cargamasiva.definitions.factory;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 
 * @author Leonardo Cruz
 *
 */
@Qualifier
@Retention(RUNTIME)
@Target({FIELD, METHOD})
public @interface AdministradorService {
}
