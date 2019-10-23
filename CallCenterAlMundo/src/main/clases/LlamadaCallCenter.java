package main.clases;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class LlamadaCallCenter {

	private String idLlamada;
	
	private static final int DURACION_MINIMA_LLAMADA_EN_SEGUNDOS = 5;
	
	private static final int DURACION_MAXIMA_LLAMADA_EN_SEGUNDOS = 10;
	
	public LlamadaCallCenter() {
		this.idLlamada = new Date().toInstant().toString();
	}
	
	public int getDuracionLlamada() {
		return ThreadLocalRandom.current().nextInt(LlamadaCallCenter.DURACION_MINIMA_LLAMADA_EN_SEGUNDOS, 
														LlamadaCallCenter.DURACION_MAXIMA_LLAMADA_EN_SEGUNDOS);
	}
	
	public String idLlamada() {
		return this.idLlamada;
	}
}
