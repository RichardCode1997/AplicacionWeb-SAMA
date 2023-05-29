package pe.edu.cibertec.proyectoswa2.samav1.controllers.apirest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.proyectoswa2.samav1.dto.RolesDTO;
import pe.edu.cibertec.proyectoswa2.samav1.dto.UsuariosDTO;
import pe.edu.cibertec.proyectoswa2.samav1.service.apirest.RolesService;
import pe.edu.cibertec.proyectoswa2.samav1.service.apirest.UsuariosService;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RolesController {
    @Autowired
    private RolesService rolesService;
    @GetMapping
    public ResponseEntity<List<RolesDTO>> getAll(){
        return new ResponseEntity<>(rolesService.getRoles(), HttpStatus.OK);
    }
    @GetMapping("/{ID_Rol}")
    public ResponseEntity<RolesDTO> obtenerRolPorId(@PathVariable int ID_Rol) {
        RolesDTO rolesDTO = rolesService.obtenerRolesPorId(ID_Rol);
        return new ResponseEntity<>(rolesDTO, HttpStatus.OK);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void guardarRol(@RequestBody RolesDTO rolesDTO){
        rolesService.guardarRoles(rolesDTO);
    }

    @PutMapping("/{ID_Rol}")
    public ResponseEntity<String> modificarRol(@PathVariable("ID_Usuario") Integer ID_Rol, @RequestBody RolesDTO rolesDTO){
        String mensajeConfirmacion = rolesService.modificarRoles(ID_Rol, rolesDTO);
        return ResponseEntity.status(HttpStatus.OK).body(mensajeConfirmacion);
    }

    @DeleteMapping("/{ID_Rol}")
    public void  eliminarRol(@PathVariable("ID_Rol") Integer ID_Rol){
        rolesService.eliminarRoles(ID_Rol);
    }
}
