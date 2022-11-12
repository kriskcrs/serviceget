package com.example.serviceget;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("service")
@CrossOrigin
public class recibeService {

    Data datos = new Data();

    @PostMapping(path = "/recibe")
    private String recibe(@RequestBody String it) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map data = mapper.readValue(it, Map.class);
        System.out.println("\n"+"Recibiendo de ngnix \n"+"<------------>");
        datos.setIdPlatformOrigin((int) data.get("idPlatformOrigin"));
        datos.setIdCoin((int) data.get("idCoin"));
        datos.setIdPlatformDestiny((int) data.get("idPlatformDestiny"));
        datos.setIdProducto((int) data.get("idProducto"));
        datos.setQuantity((int) data.get("quantity"));
        datos.setMount((Double) data.get("mount"));
        datos.setNameClient((String) data.get("nameClient"));
        datos.setIdClient((int) data.get("idClient"));
        data.forEach((k,v) -> System.out.println((k +": " + v)));
        System.out.println("<------------>");
        return it;
    }

    @GetMapping(path="/ver")
    private Data ver(){
        return  datos;
    }


}
