package com.morsaprogramando.holaSpring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rutas {

    @GetMapping("/saludo")
    String miPrimeraRuta(){
        return "Hola mundo desde Spring Controller :)";
    }

    //------------------ PathParams: ---------------
    //-->Filtrando por ID del libro
    @GetMapping("/libro/{id}")
    String leerLibro(@PathVariable int id){
        return "Leyendo el libro id: " + id;
    }

    //-->Filtrando por ID del libro y Editorial
    @GetMapping("/libro/{id}/editorial/{editorial}")
    String leerLibroEditorial(@PathVariable int id, @PathVariable String editorial){
        return "Leyendo el libro id: " + id + ", editorial: " + editorial;
    }


    //------------------ QueryParams: ---------------
    //-->
    @GetMapping("/libro2/{id}")
    String leerLibro2(@PathVariable int id, @RequestParam String params, @RequestParam String editorial){
        return "Leyendo el libro2 id: " + id + ", params: " + params + ", La editorial es: " + editorial;
    }
}
