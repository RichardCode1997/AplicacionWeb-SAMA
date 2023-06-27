package pe.edu.cibertec.proyectoswa2.samav1.controllers.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.proyectoswa2.samav1.dto.HorariosDTO;
import pe.edu.cibertec.proyectoswa2.samav1.dto.NoticiasDTO;
import pe.edu.cibertec.proyectoswa2.samav1.service.apirest.HorariosService;
import pe.edu.cibertec.proyectoswa2.samav1.service.apirest.NoticiasService;

import java.util.List;

@RestController
@RequestMapping("/noticias")
public class NoticiasController {
    @Autowired
    private NoticiasService noticiasService;
    @GetMapping
    public ResponseEntity<List<NoticiasDTO>> getAll(){
        return new ResponseEntity<>(noticiasService.getNoticias(), HttpStatus.OK);
    }
    @GetMapping("/{ID_Horario}")
    public ResponseEntity<NoticiasDTO> obtenerUsuarioPorId(@PathVariable int ID_Noticia) {
        NoticiasDTO noticiasDTO = noticiasService.obtenerNoticiaPorId(ID_Noticia);
        return new ResponseEntity<>(noticiasDTO, HttpStatus.OK);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void guardarUsuarios(@RequestBody NoticiasDTO noticiasDTO){
        noticiasService.guardarNoticias(noticiasDTO);
    }

    @PutMapping("/{ID_Usuario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modificarUsuarios(@PathVariable("ID_Horario") Integer ID_Noticia, @RequestBody NoticiasDTO noticiasDTO){
        noticiasService.modificarNoticias(ID_Noticia,noticiasDTO);
    }

    @DeleteMapping("/{ID_Usuario}")
    public void  eliminarUsuarios(@PathVariable("ID_Usuario") Integer ID_Horario){
        noticiasService.eliminarNoticias(ID_Horario);
    }
}
