package pe.edu.cibertec.proyectoswa2.samav1.datatranfertobjet;

import lombok.Data;

import java.util.Date;

@Data
public class EmpleadoDTO {
    private Integer id_empleado;
    private Integer fk_personas_id_personat;
    private String telefono_casa_empleado;
    private String email_personal_empleado;
    private String direccion_empleado;
    private String referencia_direccion_empleado;
    private String cod_sistema_pensiones_empleados;
    private Date fecha_ingreso_empleado;
    private Date fecha_cese_empleado;
    private Integer fk_estado_civil_id_estado_civil;
    private Integer fk_distrito_id_distrito;
    private Integer fk_areas_id_areas;
    private Integer fk_cargos_id_cargos;
    private Integer estado_empleado;
    private Integer roles_id_roles;
    private String contrasenia_empleado;
}
