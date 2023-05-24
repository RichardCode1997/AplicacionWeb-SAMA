package pe.edu.cibertec.proyectoswa2.samav1.service.apirest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pe.edu.cibertec.proyectoswa2.samav1.dto.UsuariosDTO;

import java.util.Arrays;
import java.util.List;

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

    public void modificarUsuarios(Integer ID_Usuario, UsuariosDTO usuariosDTO){
        restTemplate.put(basePath + "/usuarios/"+ID_Usuario,usuariosDTO);
    }

    public void eliminarUsuarios(Integer ID_Usuario){
        restTemplate.delete(basePath + "/usuarios/" + ID_Usuario);
    }
}
