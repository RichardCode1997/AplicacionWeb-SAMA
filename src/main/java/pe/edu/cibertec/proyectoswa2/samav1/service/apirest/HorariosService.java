package pe.edu.cibertec.proyectoswa2.samav1.service.apirest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pe.edu.cibertec.proyectoswa2.samav1.dto.HorariosDTO;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HorariosService {
    @Value("${sping.external.service.base-url}")
    private String basePath;
    private final RestTemplate restTemplate;
    public List<HorariosDTO> getHorarios(){
        HorariosDTO[] response = restTemplate.getForObject(basePath + "/horarios", HorariosDTO[].class);
        return Arrays.asList(response);
    }

    public HorariosDTO obtenerHorarioPorId(Integer ID_Horario){
        HorariosDTO response = restTemplate.getForObject(basePath + "/horarios/" + ID_Horario, HorariosDTO.class);
        return response;
    }

    public void guardarHorarios(HorariosDTO horariosDTO){
        restTemplate.postForObject(basePath + "/horarios",horariosDTO,HorariosDTO.class);
    }

    public void modificarHorarios(Integer ID_Horario, HorariosDTO horariosDTO){
        restTemplate.put(basePath + "/horarios/"+ID_Horario,horariosDTO);
    }

    public void eliminarHorarios(Integer ID_Horario){
        restTemplate.delete(basePath + "/horarios/" + ID_Horario);
    }
}
