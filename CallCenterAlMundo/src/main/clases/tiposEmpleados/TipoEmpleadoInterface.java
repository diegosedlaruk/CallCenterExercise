package main.clases.tiposEmpleados;

import main.clases.tiposEmpleados.jerarquiaEmpleados.JerarquiasEmpleadosEnum;

public interface TipoEmpleadoInterface {

	public String recuperarTipoEmpleado();
	
	public JerarquiasEmpleadosEnum recuperarNivelJerarquia();
}
