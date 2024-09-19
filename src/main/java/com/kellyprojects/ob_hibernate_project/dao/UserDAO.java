package com.kellyprojects.ob_hibernate_project.dao;

import com.kellyprojects.ob_hibernate_project.entities.User;

import java.util.List;

public interface UserDAO {
    List<User> findAllActive();
}
