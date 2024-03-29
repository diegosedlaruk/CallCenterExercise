package main.clases;

import main.clases.tiposEmpleados.TipoEmpleado;

public abstract class Empleado {

	private String nombre;

	private String apellido;

	private String dni;

	private String identificadorEmpleado;

	private TipoEmpleado tipo;

	private boolean atendiendoLlamada = false;

	private String idLlamada = null;
	
	private int cantidadLlamadosAtendidos = 0;
	
	public Empleado(String nombre, String apellido, String dni, String identificadorEmpleado, TipoEmpleado tipo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.identificadorEmpleado = identificadorEmpleado;
		this.tipo = tipo;
	}

	public boolean puedeAtenderLLamada() {
		return !atendiendoLlamada;
	}

	public void atenderLlamada(LlamadaCallCenter llamada) {

		//El usuario
		this.atendiendoLlamada = true;

		this.idLlamada = llamada.idLlamada();
		
		//Atendemos la llamada.
		this.atendiendoLlamada(llamada.getDuracionLlamada());
		
		this.idLlamada = null;
		
		this.atendiendoLlamada = false;
	}

	private void atendiendoLlamada(int duracionLlamada) {
				
		try {
			Thread.sleep(duracionLlamada * 1000);
		} catch (InterruptedException e) {
			//Cualquier error que haya en la comunicación, el empleado debe cortar para no dejar la línea ocupada.
			this.atendiendoLlamada = false;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDni() {
		return dni;
	}

	public String getIdentificadorEmpleado() {
		return identificadorEmpleado;
	}

	public TipoEmpleado getTipo() {
		return tipo;
	}

	public int getCantidadLlamadosAtendidos() {
		return cantidadLlamadosAtendidos;
	}

	public void setCantidadLlamadosAtendidos(int cantidadLlamadosAtendidos) {
		this.cantidadLlamadosAtendidos = cantidadLlamadosAtendidos;
	}
	
	public boolean atendiendoLlamada() {
		return this.atendiendoLlamada;
	}

	public String getIdLlamada() {
		return idLlamada;
	}
}
