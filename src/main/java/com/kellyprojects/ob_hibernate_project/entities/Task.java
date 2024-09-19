package com.kellyprojects.ob_hibernate_project.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
* Task: representa una entidad tarea, con los atributos id, titulo, descripcion,
* finalizada (si o no), fecha de entrega (LocalDate)
* */
@Entity
@Table(name = "ob_tasks")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(length = 300)
    private String description;
    @Column(name = "is_finished")
    private  Boolean isFinished;
    @Column(name="delivery_date")
    private LocalDate deliveryDate;

    @JsonIgnoreProperties("tasks")
    @ManyToOne
    @JoinColumn(name="user_id")
    private  User user;

    @JsonIgnoreProperties("tasks")
    @ManyToMany
    @JoinTable(name = "ob_tasks_tags",
            joinColumns = @JoinColumn(name="task_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags=new ArrayList<>();

    public Task(){}

    public Task(Long id, String title, String description, Boolean isFinished, LocalDate deliveryDate, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isFinished = isFinished;
        this.deliveryDate = deliveryDate;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isFinished=" + isFinished +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}
