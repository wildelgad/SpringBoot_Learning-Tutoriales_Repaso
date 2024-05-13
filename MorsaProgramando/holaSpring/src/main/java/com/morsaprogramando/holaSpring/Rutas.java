package com.morsaprogramando.holaSpring;

import com.morsaprogramando.holaSpring.models.Libro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Rutas {

    private Logger logger = LoggerFactory.getLogger(Rutas.class);

    @GetMapping("/saludo")
    String miPrimeraRuta(){
        return "Hola mundo desde Spring Controller :)";
    }

    //============================================= PathParams: =============================================
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


    //============================================= QueryParams: =============================================
    //Permite colocar en la petición por Postman varios parámetros a pesar de que no se usen
    //pero si es indispensable que lleven los establecidos como @RequestParam
    @GetMapping("/libro2/{id}")
    String leerLibro2(@PathVariable int id, @RequestParam String params, @RequestParam String editorial){
        return "Leyendo el libro2 con id: " + id + ", params: " + params + ", La editorial es: " + editorial;
    }

    //============================================= BodyParams: =============================================
    //Aquí nos permite usar el método PostRequest
    //En los PostRequest normalmente no se envía la información en la URL, ni cómo QueryParams ni como PathParams
    //La información entonces se envía en el Body, generalmente llevan un JSON

    //-->Ejemplo usando un tipo genérico sobre un JSON
    @PostMapping("/guadarLibro")
    String guardarLibro(@RequestBody Map<String, Object> libro){
        libro.keySet().forEach(llave -> {
            logger.debug("llave {} valor{} ", llave, libro.get(llave));
        });
        return "libro guardado";
    }

    //-->Ejemplo: Ahora exigiendo que eso sea un libro
    @PostMapping("/guadarLibro2")
    String guardarLibro2(@RequestBody Libro libro){
        logger.debug("llave {} valor {}", libro.nombre, libro.editorial);
        return "libro guardado";
    }

    //============================================= Http Status: =============================================
    @GetMapping("/saludar01")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    String miSegundaRutaConStatus01(){
        return "Aprendiendo statuses http en spring Boot";
    }

    @GetMapping("/saludar02")
    @ResponseStatus(value = HttpStatus.MOVED_PERMANENTLY, reason = "Fue movida a la versión 2 de la API")
    String miSegundaRutaConStatus02(){
        return "Aprendiendo statuses http en spring Boot";
    }

    //prueba--
}
