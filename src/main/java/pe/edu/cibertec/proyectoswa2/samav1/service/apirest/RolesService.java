package pe.edu.cibertec.proyectoswa2.samav1.service.apirest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pe.edu.cibertec.proyectoswa2.samav1.dto.RolesDTO;
import pe.edu.cibertec.proyectoswa2.samav1.dto.UsuariosDTO;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RolesService {
    @Value("${sping.external.service.base-url}")
    private String basePath;
    private final RestTemplate restTemplate;
    public List<RolesDTO> getRoles(){
        RolesDTO[] response = restTemplate.getForObject(basePath + "/roles", RolesDTO[].class);
        return Arrays.asList(response);
    }

    public RolesDTO obtenerRolesPorId(Integer ID_Rol){
        RolesDTO response = restTemplate.getForObject(basePath + "/roles/" + ID_Rol, RolesDTO.class);
        return response;
    }

    public void guardarRoles (RolesDTO rolesDTO){
        restTemplate.postForObject(basePath + "/roles",rolesDTO,RolesDTO.class);
    }

    public String modificarRoles(Integer ID_Rol, RolesDTO rolesDTO) {
        RolesDTO rolExistente = obtenerRolesPorId(ID_Rol);
        if (rolExistente == null) {
            throw new NoSuchElementException("El rol con ID " + ID_Rol + " no existe");
        } else {
            // Realizar las modificaciones necesarias en el objeto usuarioExistente utilizando los datos de usuariosDTO
            // ...

            // Enviar la solicitud PUT para actualizar el usuario
            restTemplate.put(basePath + "/roles/" + ID_Rol, rolesDTO);

            // Devolver el mensaje de confirmación
            String mensajeConfirmacion = "El rol con ID " + ID_Rol + " se registró correctamente";
            return mensajeConfirmacion;
        }
    }

    public void eliminarRoles(Integer ID_Rol){
        restTemplate.delete(basePath + "/roles/" + ID_Rol);
    }
}
