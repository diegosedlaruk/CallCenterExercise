package main.clases;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CallDispatcher extends Thread {
	
	private static final int WAITING_SECONDS = 5;
	
	private static final int MAX_REINTENTOS = 5;
		
	private LlamadaCallCenter llamada;
	
	private List<Empleado> empleados;
	
	public CallDispatcher(LlamadaCallCenter llamada, List<Empleado> empleados) {
		this.llamada = llamada;
		this.empleados = empleados;
	}
		
	public void run() {
			dispatchCall(llamada, empleados);
	}
	
	private void dispatchCall(LlamadaCallCenter llamada, List<Empleado> empleados) {
		
		boolean seAtendioLlamada = false;
		
		int iteracionesMaxima = CallDispatcher.MAX_REINTENTOS;
		
		Empleado empleadoLibre;
		
		int iter = 0;
		
		while(!seAtendioLlamada && iter < iteracionesMaxima) {
			
			empleadoLibre = getEmpleadoLibre(empleados);
			
			if(empleadoLibre != null) {

				seAtendioLlamada = true;
				
				empleadoLibre.atenderLlamada(llamada);	
				
				//Contabilizamos la cantidad de llamados que atiende.
				empleadoLibre.setCantidadLlamadosAtendidos(empleadoLibre.getCantidadLlamadosAtendidos() + 1);
				
			}else {

				try {
					Thread.sleep(WAITING_SECONDS * 1000);
				} catch (InterruptedException e) {
					System.out.println("Hilo: " + getName() +"Ocurrió un error esperando que se desocupe un empleado. Llamada: " + llamada);
				}	
			}
			
			iter ++;
		}
	}
			
	private Empleado getEmpleadoLibre(List<Empleado> empleados) {
		
		Empleado empleadoLibre;

		List<Empleado> empleadosLibres = this.filter(empleado -> empleado.getTipo().esOperador() && empleado.puedeAtenderLLamada(), empleados);
		
		//Si no conseguimos operadores libres, buscamos supervisores libres.
		if(empleadosLibres.isEmpty()) {

			empleadosLibres = this.filter(empleado -> empleado.getTipo().esSupervisor() && empleado.puedeAtenderLLamada(), empleados);

			//Si no conseguimos operadores libres, buscamos supervisores libres.
			if(empleadosLibres.isEmpty()) {
			
				empleadosLibres = this.filter(empleado -> empleado.getTipo().esDirector() && empleado.puedeAtenderLLamada(), empleados);
			}
		}
		
		if(!empleadosLibres.isEmpty()) {
			empleadoLibre = empleadosLibres.get(0);
		}else {
			empleadoLibre = null;
		}
		
		
		return empleadoLibre;
	}
	 
	private List<Empleado> filter(Predicate<Empleado> criteria, List<Empleado> list) {
	        return list.stream().filter(criteria).collect(Collectors.<Empleado>toList());
	}
}
