package BITGym.modelo;

import java.util.Date;

public class Factura {
	
	private int nroFactura;
	private int dniSocio;
	private Date fechaFactura;
	private float monto;
	private String detalle;
	
	
	public Factura(int nroFactura, int dniSocio, Date fechaFactura, float monto, String detalle) {
		super();
		this.nroFactura = nroFactura;
		this.dniSocio = dniSocio;
		this.fechaFactura = fechaFactura;
		this.monto = monto;
		this.detalle = detalle;
	}
	
	
	public int getNroFactura() {
		return nroFactura;
	}
	public void setNroFactura(int nroFactura) {
		this.nroFactura = nroFactura;
	}
	public int getDniSocio() {
		return dniSocio;
	}
	public void setDniSocio(int dniSocio) {
		this.dniSocio = dniSocio;
	}
	public Date getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	
	
}
