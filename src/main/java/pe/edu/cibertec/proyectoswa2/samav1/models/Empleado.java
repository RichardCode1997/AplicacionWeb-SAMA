package pe.edu.cibertec.proyectoswa2.samav1.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {

    private int id;
    private String nombre;
    private String apellido;
    private String passw;
    private String email;
    private Date fecha_nacimiento;
    private String telefono;
    private int id_rol;
    private int id_departamento;
    private int id_horario;
}
