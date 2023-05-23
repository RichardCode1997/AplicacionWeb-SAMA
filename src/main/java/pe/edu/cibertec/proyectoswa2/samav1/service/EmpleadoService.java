package pe.edu.cibertec.proyectoswa2.samav1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pe.edu.cibertec.proyectoswa2.samav1.datatranfertobjet.EmpleadoDTO;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoService {
    @Value("${sping.external.service.base-url}")
    private String basePath;

    private final RestTemplate restTemplate;
    public List<EmpleadoDTO> getEmpleado(){
        EmpleadoDTO[] response = restTemplate.getForObject(basePath + "/empleados", EmpleadoDTO[].class);
        return Arrays.asList(response);
    }

    public void saveEmpleado (EmpleadoDTO empleado){
        restTemplate.postForObject(basePath + "/empleados",empleado,EmpleadoDTO.class);
    }

    public void updateEmpleado(Integer id_empleado, EmpleadoDTO empleado){
        restTemplate.put(basePath + "/empleados/"+id_empleado,empleado);
    }

    public void deleteEmpleado(Integer id_empleado){
        restTemplate.delete(basePath + "/empleados/" + id_empleado);
    }
}
