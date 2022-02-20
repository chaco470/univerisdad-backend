package com.spring.universidad.universidadbackend.controlador;

import com.spring.universidad.universidadbackend.modelo.entidades.Empleado;
import com.spring.universidad.universidadbackend.modelo.entidades.Pabellon;
import com.spring.universidad.universidadbackend.modelo.entidades.Persona;
import com.spring.universidad.universidadbackend.modelo.entidades.numeradores.TipoEmpleado;
import com.spring.universidad.universidadbackend.servicios.contratos.EmpleadoDAO;
import com.spring.universidad.universidadbackend.servicios.contratos.PabellonDAO;
import com.spring.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController extends PersonaController{

    private final PabellonDAO pabellonDAO;

    @Autowired
    public EmpleadoController(@Qualifier("empleadoDAOImpl") PersonaDAO service, PabellonDAO pabellonDAO) {
        super(service);
        this.pabellonDAO = pabellonDAO;
        nombreEntidad = "Empleado";
    }

    @GetMapping("/{tipoEmpleado}")
    public ResponseEntity<?> findEmpleadoByTipoEmpleado(@PathVariable TipoEmpleado tipoEmpleado){
        Map<String, Object> message = new HashMap<>();
        List<Persona> empleados = (List<Persona>) ((EmpleadoDAO) service).findEmpleadoByTipoEmpleado(tipoEmpleado);
        if (empleados.isEmpty()) {
            //throw new BadRequestException("No existe ningun empleado de ese tipo");
            message.put("succes", Boolean.FALSE);
            message.put("message",String.format("No existe ningun empleado de ese tipo"));
            return ResponseEntity.badRequest().body(message);
        }
        message.put("datos", empleados);
        message.put("succes", Boolean.TRUE);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/{idEmpleado}/pabellon/{idPabellon}")
    public ResponseEntity<?> asiganrPabellonAEmpleado(@PathVariable Integer idEmpleado, @PathVariable Integer idPabellon){
        Map<String, Object> message = new HashMap<>();
        Optional<Persona> oEmpleado = service.findById(idEmpleado);
        Optional<Pabellon> oPabellon = pabellonDAO.findById(idPabellon);
        if (!oEmpleado.isPresent() || !oPabellon.isPresent()) {
            //throw new BadRequestException(String.format("el empleado con id %d o el pabellon con id %d no existe", idEmpleado, idPabellon));
            message.put("succes", Boolean.FALSE);
            message.put("message",String.format("El empleado con id: %d o el pabellon con id: %d", idEmpleado, idPabellon));
            return ResponseEntity.badRequest().body(message);
        }
        Persona empleado = oEmpleado.get();
        Pabellon pabellon = oPabellon.get();
        ((Empleado) empleado).setPabellon(pabellon);
        message.put("datos", service.save(empleado));
        message.put("succes", Boolean.TRUE);
        return ResponseEntity.ok(message);
    }
}
