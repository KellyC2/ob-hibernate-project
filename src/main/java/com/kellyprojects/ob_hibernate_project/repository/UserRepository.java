package com.kellyprojects.ob_hibernate_project.repository;

import com.kellyprojects.ob_hibernate_project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
