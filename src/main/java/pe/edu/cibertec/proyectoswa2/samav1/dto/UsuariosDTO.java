package pe.edu.cibertec.proyectoswa2.samav1.dto;

import lombok.Data;


@Data
public class UsuariosDTO {
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String dni;
    private String correo;
    private String contraseña;
    private String direccion;
    private String celular;
    private RolesDTO rol;

    // Constructor, getters, and setters
}
