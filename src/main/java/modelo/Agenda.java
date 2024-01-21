package modelo;

public class Agenda {

	private int id;
    private int idMascota;
    private String rutDueno;
    private String nombreMascota;
    private String hora;
    private String fecha;
    
    public Agenda() {
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}

	public String getRutDueno() {
		return rutDueno;
	}

	public void setRutDueno(String rutDueno) {
		this.rutDueno = rutDueno;
	}

	public String getNombreMascota() {
		return nombreMascota;
	}

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
        
}
