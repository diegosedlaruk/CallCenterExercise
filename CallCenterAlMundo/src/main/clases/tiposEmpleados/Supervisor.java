package main.clases.tiposEmpleados;

import main.clases.Empleado;
import main.clases.tiposEmpleados.jerarquiaEmpleados.JerarquiasEmpleadosEnum;

public class Supervisor extends Empleado {

	private static final TipoEmpleado TIPO_EMPLEADO_SUPERVISOR = new TipoEmpleado("Supervisor", JerarquiasEmpleadosEnum.SUPERVISOR);
	
	public Supervisor(String nombre, String apellido, String dni, String identificadorEpleado) {
		super(nombre, apellido, dni, identificadorEpleado, Supervisor.TIPO_EMPLEADO_SUPERVISOR);
	}
}
