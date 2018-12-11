package com.api.mileniocloud.entity;

public class Colegio {
	
	private int codigo_id;  
    private int nit;
	private String nombre;
	private int codigo_colegio;
	private int codigo_dane;
	private String direccion;
	private String telefono;
	private String fini_fiscal;
	private String ffin_fiscal;
	private String ubicacion_geo;
	private String foto;
	
	
	public int getCodigo_id() {
		return codigo_id;
	}
	public void setCodigo_id(int codigo_id) {
		this.codigo_id = codigo_id;
	}
	public int getNit() {
		return nit;
	}
	public void setNit(int nit) {
		this.nit = nit;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCodigo_colegio() {
		return codigo_colegio;
	}
	public void setCodigo_colegio(int codigo_colegio) {
		this.codigo_colegio = codigo_colegio;
	}
	public int getCodigo_dane() {
		return codigo_dane;
	}
	public void setCodigo_dane(int codigo_dane) {
		this.codigo_dane = codigo_dane;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getFini_fiscal() {
		return fini_fiscal;
	}
	public void setFini_fiscal(String fini_fiscal) {
		this.fini_fiscal = fini_fiscal;
	}
	public String getFfin_fiscal() {
		return ffin_fiscal;
	}
	public void setFfin_fiscal(String ffin_fiscal) {
		this.ffin_fiscal = ffin_fiscal;
	}
	public String getUbicacion_geo() {
		return ubicacion_geo;
	}
	public void setUbicacion_geo(String ubicacion_geo) {
		this.ubicacion_geo = ubicacion_geo;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
}

