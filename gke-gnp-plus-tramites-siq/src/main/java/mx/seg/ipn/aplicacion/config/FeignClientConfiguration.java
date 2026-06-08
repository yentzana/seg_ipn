package mx.seg.ipn.aplicacion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
/**
 * Configuracion para Basic Authentication.
 */
@Configuration
public class FeignClientConfiguration {
    /**
     * Variable de entorno para el usuario.
     */
    @Value("${gnp.tramites.siq.username}")
    private String userName;
    /**
     * Variable de entorno para la contraseña.
     */
    @Value("${gnp.tramites.siq.password}")
    private String password;

    /**
     * Metodo para crear la autenticacion basica del usuario.
     * @return BasicAuthRequestInterceptor autenticacion basica.
     */
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(userName, password);
    }


}
