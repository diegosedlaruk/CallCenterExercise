package main.clases.tiposEmpleados;

import main.clases.tiposEmpleados.jerarquiaEmpleados.JerarquiasEmpleadosEnum;

public class TipoEmpleado implements TipoEmpleadoInterface {

	private String tipo;
	
	private JerarquiasEmpleadosEnum nivelJerarquia;
	
	public TipoEmpleado(String tipoEmpleado, JerarquiasEmpleadosEnum nivelJerarquia) {
		this.tipo = tipoEmpleado;
		this.nivelJerarquia = nivelJerarquia;
	}
	
	@Override
	public String recuperarTipoEmpleado() {
		return this.tipo;
	}

	@Override
	public JerarquiasEmpleadosEnum recuperarNivelJerarquia() {
		return this.nivelJerarquia;
	}
	
	public boolean esOperador() {
		return nivelJerarquia.equals(JerarquiasEmpleadosEnum.OPERADOR);
	}
	
	public boolean esSupervisor() {
		return nivelJerarquia.equals(JerarquiasEmpleadosEnum.SUPERVISOR);
	}
	
	public boolean esDirector() {
		return nivelJerarquia.equals(JerarquiasEmpleadosEnum.DIRECTOR);
	}
}
