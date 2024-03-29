package main.clases.tiposEmpleados;

import main.clases.Empleado;
import main.clases.tiposEmpleados.jerarquiaEmpleados.JerarquiasEmpleadosEnum;

public class Operador extends Empleado {

	private static final TipoEmpleado TIPO_EMPLEADO_OPERADOR = new TipoEmpleado("Operador", JerarquiasEmpleadosEnum.OPERADOR);
	
	public Operador(String nombre, String apellido, String dni, String identificadorEpleado) {

		super(nombre, apellido, dni, identificadorEpleado, Operador.TIPO_EMPLEADO_OPERADOR);
	}
}
