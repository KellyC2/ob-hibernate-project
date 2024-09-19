package com.kellyprojects.ob_hibernate_project.service;

import com.kellyprojects.ob_hibernate_project.dao.UserDAO;
import com.kellyprojects.ob_hibernate_project.entities.User;
import com.kellyprojects.ob_hibernate_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDAO userDAO;

    private List<User> findAll(){
        return this.userRepository.findAll();
    }

   private List<User> findAllActive(){
        return this.userDAO.findAllActive();
    }

   private User create( User user){
        return this.userRepository.save(user);
    }

    private User update( User user){
        return this.userRepository.save(user);
    }
    private void delete( Long id){
        if(this.userRepository.existsById(id)){
            this.userRepository.deleteById(id);
        }
    }

}
