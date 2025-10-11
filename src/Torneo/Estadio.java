package Torneo;

public class Estadio {
	
	private String nombre;
	private int capacidad;
	private String direccion;
	
	//Constructor
	
	public Estadio(String nombre,int capacidad,String direccion) {
		
		this.nombre=nombre;
		this.capacidad=capacidad;
		this.direccion=direccion;
	}
	
	//Getters y setters
	
	public String getNombre(){
		return nombre;
	}
	public int getCapacidad(){
		return capacidad;
	}
	public String getDireccion(){
		return direccion;
	}
	
	
	public void setNombre(String nombre){
		
		this.nombre=nombre;
		
	}
	public void setCapacidad(int capacidad){
		this.capacidad=capacidad;
	}
	public void setDireccion(String direccion){
		this.direccion=direccion;
	}
	
	
	
	//agregar equals
	
	@Override
	public String toString() {
		return "\nEstadio [nombre=" + nombre + ", capacidad=" + capacidad + ", direccion=" + direccion + "]";
	}

	public boolean equals(Estadio estadio) {
		return this.nombre == estadio.getNombre();
	}

}
