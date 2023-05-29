package pe.edu.cibertec.proyectoswa2.samav1.controllers.apirest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.proyectoswa2.samav1.dto.EmpleadosDTO;
import pe.edu.cibertec.proyectoswa2.samav1.dto.UsuariosDTO;
import pe.edu.cibertec.proyectoswa2.samav1.service.apirest.EmpleadosService;
import pe.edu.cibertec.proyectoswa2.samav1.service.apirest.UsuariosService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuariosController {
    @Autowired
    private UsuariosService usuariosService;
    @GetMapping
    public ResponseEntity<List<UsuariosDTO>> getAll(){
        return new ResponseEntity<>(usuariosService.getUsuarios(), HttpStatus.OK);
    }
    @GetMapping("/{ID_Usuario}")
    public ResponseEntity<UsuariosDTO> obtenerUsuarioPorId(@PathVariable int ID_Usuario) {
        UsuariosDTO usuariosDTO = usuariosService.obtenerUsuarioPorId(ID_Usuario);
        return new ResponseEntity<>(usuariosDTO, HttpStatus.OK);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void guardarUsuarios(@RequestBody UsuariosDTO usuariosDTO){
        usuariosService.guardarUsuarios(usuariosDTO);
    }

    @PutMapping("/{ID_Usuario}")
    public ResponseEntity<String> modificarUsuarios(@PathVariable("ID_Usuario") Integer ID_Usuario, @RequestBody UsuariosDTO usuariosDTO){
        String mensajeConfirmacion = usuariosService.modificarUsuarios(ID_Usuario, usuariosDTO);
        return ResponseEntity.status(HttpStatus.OK).body(mensajeConfirmacion);
    }

    @DeleteMapping("/{ID_Usuario}")
    public void  eliminarUsuarios(@PathVariable("ID_Usuario") Integer ID_Usuario){
        usuariosService.eliminarUsuarios(ID_Usuario);
    }
}
