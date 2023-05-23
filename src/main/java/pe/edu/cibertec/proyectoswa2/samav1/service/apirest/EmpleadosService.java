package pe.edu.cibertec.proyectoswa2.samav1.service.apirest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pe.edu.cibertec.proyectoswa2.samav1.dto.EmpleadosDTO;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadosService {
    @Value("${sping.external.service.base-url}")
    private String basePath;
    private final RestTemplate restTemplate;
    public List<EmpleadosDTO> getEmpleados(){
        EmpleadosDTO[] response = restTemplate.getForObject(basePath + "/empleados", EmpleadosDTO[].class);
        return Arrays.asList(response);
    }

    public void guardarEmpleado (EmpleadosDTO empleado){
        restTemplate.postForObject(basePath + "/empleados",empleado,EmpleadosDTO.class);
    }

    public void modificarEmpleado(Integer ID_Empleado, EmpleadosDTO empleado){
        restTemplate.put(basePath + "/empleados/"+ID_Empleado,empleado);
    }

    public void eliminarEmpleado(Integer ID_Empleado){
        restTemplate.delete(basePath + "/empleados/" + ID_Empleado);
    }
}
