package pe.edu.cibertec.proyectoswa2.samav1.dto;

import lombok.Data;

@Data
public class AsistenciasDTO {

    private int idAsistencia;
    private EmpleadosDTO empleado;
    private String fecha;
    private String horaEntrada;
    private String horaSalida;
}
