package pe.edu.cibertec.proyectoswa2.samav1.dto;


import lombok.Data;

@Data
public class FaltasDTO {
    private int idFalta;
    private EmpleadosDTO empleado;
    private String fecha;
    private String motivo;
}
