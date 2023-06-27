package pe.edu.cibertec.proyectoswa2.samav1.service.apirest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pe.edu.cibertec.proyectoswa2.samav1.dto.HorariosDTO;
import pe.edu.cibertec.proyectoswa2.samav1.dto.NoticiasDTO;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticiasService {
    @Value("${sping.external.service.base-url}")
    private String basePath;
    private final RestTemplate restTemplate;
    public List<NoticiasDTO> getNoticias(){
        NoticiasDTO[] response = restTemplate.getForObject(basePath + "/noticias", NoticiasDTO[].class);
        return Arrays.asList(response);
    }

    public NoticiasDTO obtenerNoticiaPorId(Integer ID_Noticia){
        NoticiasDTO response = restTemplate.getForObject(basePath + "/noticias/" + ID_Noticia, NoticiasDTO.class);
        return response;
    }

    public void guardarNoticias(NoticiasDTO noticiasDTO){
        restTemplate.postForObject(basePath + "/noticias",noticiasDTO,NoticiasDTO.class);
    }

    public void modificarNoticias(Integer ID_Noticia, NoticiasDTO noticiasDTO){
        restTemplate.put(basePath + "/noticias/"+ID_Noticia,noticiasDTO);
    }

    public void eliminarNoticias(Integer ID_Noticia){
        restTemplate.delete(basePath + "/horarios/" + ID_Noticia);
    }
}
