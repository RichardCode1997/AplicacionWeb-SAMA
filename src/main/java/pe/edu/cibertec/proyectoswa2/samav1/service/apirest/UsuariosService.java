package pe.edu.cibertec.proyectoswa2.samav1.service.apirest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pe.edu.cibertec.proyectoswa2.samav1.dto.UsuariosDTO;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UsuariosService {
    @Value("${sping.external.service.base-url}")
    private String basePath;
    private final RestTemplate restTemplate;
    public List<UsuariosDTO> getUsuarios(){
        UsuariosDTO[] response = restTemplate.getForObject(basePath + "/usuarios", UsuariosDTO[].class);
        return Arrays.asList(response);
    }

    public UsuariosDTO obtenerUsuarioPorId(Integer ID_Usuario){
        UsuariosDTO response = restTemplate.getForObject(basePath + "/usuarios/" + ID_Usuario, UsuariosDTO.class);
        return response;
    }

    public void guardarUsuarios (UsuariosDTO usuariosDTO){
        restTemplate.postForObject(basePath + "/usuarios",usuariosDTO,UsuariosDTO.class);
    }

    public String modificarUsuarios(Integer ID_Usuario, UsuariosDTO usuariosDTO) {
        UsuariosDTO usuarioExistente = obtenerUsuarioPorId(ID_Usuario);
        if (usuarioExistente == null) {
            throw new NoSuchElementException("El usuario con ID " + ID_Usuario + " no existe");
        } else {
            // Realizar las modificaciones necesarias en el objeto usuarioExistente utilizando los datos de usuariosDTO
            // ...

            // Enviar la solicitud PUT para actualizar el usuario
            restTemplate.put(basePath + "/usuarios/" + ID_Usuario, usuariosDTO);

            // Devolver el mensaje de confirmación
            String mensajeConfirmacion = "El usuario con ID " + ID_Usuario + " se registró correctamente";
            return mensajeConfirmacion;
        }
    }



    public void eliminarUsuarios(Integer ID_Usuario){
        restTemplate.delete(basePath + "/usuarios/" + ID_Usuario);
    }
}
