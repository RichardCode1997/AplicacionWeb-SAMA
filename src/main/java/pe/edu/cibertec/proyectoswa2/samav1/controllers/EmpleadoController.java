package pe.edu.cibertec.proyectoswa2.samav1.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.proyectoswa2.samav1.datatranfertobjet.EmpleadoDTO;
import pe.edu.cibertec.proyectoswa2.samav1.service.EmpleadoService;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
@RequiredArgsConstructor
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;
    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> getAll(){
        return new ResponseEntity<>(empleadoService.getEmpleado(), HttpStatus.OK);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveEmpleado(@RequestBody EmpleadoDTO empleado){
        empleadoService.saveEmpleado(empleado);
    }

    @PutMapping("/{id_empleado}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmpleado(@PathVariable("id_empleado") Integer id_empleado, @RequestBody EmpleadoDTO empleado){
        empleadoService.updateEmpleado(id_empleado,empleado);

    }

    @DeleteMapping("/{id_empleado}")
    public void  deleteEmpleado(@PathVariable("id_empleado") Integer id_empleado){
        empleadoService.deleteEmpleado(id_empleado);
    }
}
