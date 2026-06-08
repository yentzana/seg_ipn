package mx.seg.ipn.aplicacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Application {

    /**
     * Método principal de la aplicación.
     *
     * @param args argumentos de la aplicación.
     */
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
