package com.kellyprojects.ob_hibernate_project.controller;

import com.kellyprojects.ob_hibernate_project.dao.UserDAO;
import com.kellyprojects.ob_hibernate_project.entities.User;
import com.kellyprojects.ob_hibernate_project.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
* Estos controladores devuelven y reciben objetos json. No carga vistas en html.
* En estos controladores vamos a crear los métodos para hacer GET, PUT, DELETE, POST, etc.
* */

/**
 * TODO - crear servicio
 * Método actualizar
 * Pruebas de guardado cuando hay asociaciones
 *  -La asociación billingIngo se gurada desde aquí
 *  - La asociación tasks se guarda desde el controlador Task
 * */
@RestController//Indica que esta clase es un controlador REST y todos los métodos dentro de esta clase devolverán datos directamente en el cuerpo de la respuesta (generalmente en formato JSON).
public class UserController {

    private UserRepository userRepository;
    private UserDAO userDAO;
    public UserController(UserRepository userRepository, UserDAO userDAO){
        this.userRepository=userRepository;
        this.userDAO=userDAO;
    }

    @GetMapping("/api/users")//Anotaciones de spring que se utiliza para manejar solicitudes HTTP de tipo Get. ("/pi/user"), define el endpoint al cual se le puede hacer la solicitud GET.
    private List<User> findAll(){
        return this.userRepository.findAll();//userRepository, es una funcion que extiende JpaRepository. findAll() es un metodo de Spring DATA JPA quere recupera todas las entradas de la tabla de la base de datos correspondiente a la entidad User.
    }

    @GetMapping("/api/users/active")//Anotaciones de spring que se utiliza para manejar solicitudes HTTP de tipo Get. ("/pi/user"), define el endpoint al cual se le puede hacer la solicitud GET.
    private List<User> findAllActive(){
        return this.userDAO.findAllActive();//userRepository, es una funcion que extiende JpaRepository. findAll() es un metodo de Spring DATA JPA quere recupera todas las entradas de la tabla de la base de datos correspondiente a la entidad User.
    }

    @PostMapping("/api/users")//Esta anotación se utiliza para menejar solicitudes HTTP POST en el endpoint /api/users. Esta anotación indica que el método correspondiente será invocado cuando se envíe una solicitud POST a esa URL. El propósito principal de una solicitud POST es enviar datos al servidor para crear un nuevo recurso, como un usario en este caso.
    private User create(@RequestBody User user){
        return this.userRepository.save(user);
    }

    @PutMapping("/api/users")
    private User update(@RequestBody User user){
        return this.userRepository.save(user);
    }
    @DeleteMapping("/api/users/{id}")
    private void delete(@PathVariable Long id){
        if(this.userRepository.existsById(id)){
            this.userRepository.deleteById(id);//TODO revisar integridad referencial
        }

    }

}
