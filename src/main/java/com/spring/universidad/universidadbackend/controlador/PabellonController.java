package com.spring.universidad.universidadbackend.controlador;

import com.spring.universidad.universidadbackend.exception.BadRequestException;
import com.spring.universidad.universidadbackend.modelo.entidades.Pabellon;
import com.spring.universidad.universidadbackend.servicios.contratos.PabellonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pabellones")
public class PabellonController extends GenericController<Pabellon, PabellonDAO>{

    @Autowired
    public PabellonController(PabellonDAO service) {
        super(service);
        nombreEntidad= "Pabellon";
    }

    @GetMapping("/nombrePabellon")
    public ResponseEntity<?> findPabellonByNombreIgnoreCase(@RequestParam String nombrePabellon){
        Map<String, Object> message = new HashMap<>();
        List<Pabellon> pabellones = (List<Pabellon>) service.findPabellonByNombre(nombrePabellon);
        if (pabellones.isEmpty()) {
            //throw new BadRequestException(String.format("no existen pabellones con el nombre %s", nombrePabellon));
            message.put("succes", Boolean.FALSE);
            message.put("message", String.format("no existe ningun pabellon con nombre: %s", nombrePabellon));
            return ResponseEntity.badRequest().body(message);
        }
        message.put("succes", Boolean.TRUE);
        message.put("datos", pabellones);
        return ResponseEntity.ok(message);
    }

}
