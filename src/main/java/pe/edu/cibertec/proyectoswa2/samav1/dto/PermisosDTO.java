package pe.edu.cibertec.proyectoswa2.samav1.dto;

import lombok.Data;
@Data
public class PermisosDTO {
    private int idPermiso;

    private EmpleadosDTO empleado;

    private String fechaInicio;

    private String fechaFin;

    private String motivo;

    private String estado;
}
