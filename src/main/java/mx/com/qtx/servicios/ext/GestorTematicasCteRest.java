package mx.com.qtx.servicios.ext;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.qtx.web.IGestorTematicas;

@Service
public class GestorTematicasCteRest implements IGestorTematicas{
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String URI_TXP = "http://localhost:8081/tematicas/{numPersona}";
	
	public Map<String,Integer> getMapTematicas(int numPersona){
		Map<String,Integer> mapTematicas = new TreeMap<>();
		TematicaDTO[] arrTematicas = restTemplate.getForObject(URI_TXP, TematicaDTO[].class, numPersona);
		Arrays.asList(arrTematicas)
		      .forEach( t -> mapTematicas.put(t.getNombre(),t.getIdTematica()));
		return mapTematicas;
	}

}
