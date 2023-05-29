package pe.edu.cibertec.proyectoswa2.samav1.controllers.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.proyectoswa2.samav1.dto.HorariosDTO;
import pe.edu.cibertec.proyectoswa2.samav1.dto.UsuariosDTO;
import pe.edu.cibertec.proyectoswa2.samav1.service.apirest.HorariosService;
import pe.edu.cibertec.proyectoswa2.samav1.service.apirest.UsuariosService;

import java.util.List;

@RestController
@RequestMapping("/horarios")
public class HorariosController {
    @Autowired
    private HorariosService horariosService;
    @GetMapping
    public ResponseEntity<List<HorariosDTO>> getAll(){
        return new ResponseEntity<>(horariosService.getHorarios(), HttpStatus.OK);
    }
    @GetMapping("/{ID_Horario}")
    public ResponseEntity<HorariosDTO> obtenerUsuarioPorId(@PathVariable int ID_Horario) {
        HorariosDTO horariosDTO = horariosService.obtenerHorarioPorId(ID_Horario);
        return new ResponseEntity<>(horariosDTO, HttpStatus.OK);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void guardarUsuarios(@RequestBody HorariosDTO horariosDTO){
        horariosService.guardarHorarios(horariosDTO);
    }

    @PutMapping("/{ID_Usuario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modificarUsuarios(@PathVariable("ID_Horario") Integer ID_Horario, @RequestBody HorariosDTO horariosDTO){
        horariosService.modificarHorarios(ID_Horario,horariosDTO);
    }

    @DeleteMapping("/{ID_Usuario}")
    public void  eliminarUsuarios(@PathVariable("ID_Usuario") Integer ID_Usuario){
        horariosService.eliminarHorarios(ID_Usuario);
    }
}
