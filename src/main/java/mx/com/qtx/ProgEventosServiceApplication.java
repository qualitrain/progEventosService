package mx.com.qtx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import mx.com.qtx.messageBroker.EmisorRabbitmq;
import mx.com.qtx.web.IPublicadorNotificaciones;

@SpringBootApplication
public class ProgEventosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgEventosServiceApplication.class, args);
	}
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public IPublicadorNotificaciones getPublicadorNotificaciones(Environment env){
		return EmisorRabbitmq.getEmisorNotificacion(
				env.getProperty("qtx.progEventosService.messageBroker.host", "localhost"),
				env.getProperty("qtx.progEventosService.messageBroker.exchangeEvtos", "exchangeDefault")
				);
	}
}
