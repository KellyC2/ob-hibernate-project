package com.kellyprojects.ob_hibernate_project.controller;

import com.kellyprojects.ob_hibernate_project.entities.Tag;
import com.kellyprojects.ob_hibernate_project.repository.TagRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/tags")
public class TagController {
    private TagRepository tagRepository;

    public TagController(TagRepository tagRepository){
        this.tagRepository=tagRepository;
    }

    @GetMapping("/api/tags")
    private List<Tag> findAll(){
        return this.tagRepository.findAll();
    }

    @PostMapping("/api/tags")
    private Tag create(@RequestBody Tag tag){
        return this.tagRepository.save(tag);
    }

    @PutMapping("/api/tags")
    private Tag update(@RequestBody Tag tag){
        return this.tagRepository.save(tag);
    }

    private void delete(@PathVariable Long id){
        if (this.tagRepository.existsById(id)){
            this.tagRepository.deleteById(id);
        }
    }

}
