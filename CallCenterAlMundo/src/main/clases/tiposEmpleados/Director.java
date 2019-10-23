package main.clases.tiposEmpleados;

import main.clases.Empleado;
import main.clases.tiposEmpleados.jerarquiaEmpleados.JerarquiasEmpleadosEnum;

public class Director extends Empleado{

	private static final TipoEmpleado TIPO_EMPLEADO_DIRECTOR = new TipoEmpleado("Director", JerarquiasEmpleadosEnum.DIRECTOR);
	
	public Director(String nombre, String apellido, String dni, String identificadorEpleado) {
		super(nombre, apellido, dni, identificadorEpleado, Director.TIPO_EMPLEADO_DIRECTOR);
	}
}
