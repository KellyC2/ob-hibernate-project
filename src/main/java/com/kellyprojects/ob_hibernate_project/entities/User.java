package com.kellyprojects.ob_hibernate_project.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "ob_users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false, length =30)
    private String firstName;
    @Column(name ="last_name")
    private String lastName;
    @Column(nullable = false, unique = true)
    private String dni;
    private Boolean isActive;
    @Column(name = "birth_date")
    private LocalDate birthDate;

    //ASOCIACIONES =============================
    /*
        Un usuario tiene una información de facturación (BillingInfo) y una información
        de facturación solo puede pertenecer a un mismo usuario: OneToOne
    * */
    @JsonIgnoreProperties("user")
    @OneToOne
    @JoinColumn(name = "billing_info_id", unique = true)
    private BillingInfo billingInfo;

    /*
    * Un usuario tiene muschas tareas, una tarea solo puede pertenecer a un mismo usuario a la vez. One To Many
    * */
    @JsonIgnoreProperties("user")
    @OneToMany(mappedBy = "user")
    private List<Task> tasks=new ArrayList<>();

    public  User(){}
    public User(Long id, String firstName, String lastName, String dni, Boolean isActive, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.isActive = isActive;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public BillingInfo getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(BillingInfo billingInfo) {
        this.billingInfo = billingInfo;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                ", isActive=" + isActive +
                ", birthDate=" + birthDate +
                '}';
    }
}