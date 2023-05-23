package pe.edu.cibertec.proyectoswa2.samav1.dto;

import lombok.Data;
@Data
public class TardanzasDTO {

    private int idTardanza;

    private EmpleadosDTO empleado;

    private String fecha;

    private String horaTardanza;
}
