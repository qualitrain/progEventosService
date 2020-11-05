package mx.com.qtx.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiEventosController {
	private static Logger bitacora = LoggerFactory.getLogger(ApiEventosController.class); 
	
	@Autowired
	private IGestorTematicas gestorTematicas;
	
	@GetMapping(path = "/eventos/programacion",produces = MediaType.TEXT_PLAIN_VALUE)
	public String getUiProgEventos() {
		bitacora.info("getUiProgEventos()");
		int numPersona = 2;
		Map<String, Integer> tematicas = gestorTematicas.getMapTematicas(numPersona);
		bitacora.info("Temáticas de persona num(" + numPersona
				+ "):" + tematicas.keySet());
		
		return tematicas.keySet().toString();
	}
}
