package pe.edu.cibertec.proyectoswa2.samav1.dto;


import lombok.Data;

@Data
public class EmpleadosDTO {

    private int idEmpleado;
    private UsuariosDTO usuario;
    private HorariosDTO horario;
    private DepartamentosDTO departamento;

}
