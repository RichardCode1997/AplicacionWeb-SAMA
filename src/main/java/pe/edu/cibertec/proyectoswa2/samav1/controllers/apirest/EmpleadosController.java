package pe.edu.cibertec.proyectoswa2.samav1.controllers.apirest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.proyectoswa2.samav1.datatranfertobjet.EmpleadoDTO;
import pe.edu.cibertec.proyectoswa2.samav1.dto.EmpleadosDTO;
import pe.edu.cibertec.proyectoswa2.samav1.service.EmpleadoService;
import pe.edu.cibertec.proyectoswa2.samav1.service.apirest.EmpleadosService;

import java.util.List;

@RestController
@RequestMapping("/empleados")
@RequiredArgsConstructor
public class EmpleadosController {

    @Autowired
    private EmpleadosService empleadosService;
    @GetMapping
    public ResponseEntity<List<EmpleadosDTO>> getAll(){
        return new ResponseEntity<>(empleadosService.getEmpleados(), HttpStatus.OK);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void guardarEmpleado(@RequestBody EmpleadosDTO empleadosDTO){
        empleadosService.guardarEmpleado(empleadosDTO);
    }

    @PutMapping("/{ID_Empleado}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modificarEmpleado(@PathVariable("ID_Empleado") Integer ID_Empleado, @RequestBody EmpleadosDTO empleadosDTO){
        empleadosService.modificarEmpleado(ID_Empleado,empleadosDTO);
    }

    @DeleteMapping("/{ID_Empleado}")
    public void  eliminarEmpleado(@PathVariable("ID_Empleado") Integer ID_Empleado){
        empleadosService.eliminarEmpleado(ID_Empleado);
    }
}
