package com.kellyprojects.ob_hibernate_project.controller;

import com.kellyprojects.ob_hibernate_project.entities.BillingInfo;
import com.kellyprojects.ob_hibernate_project.entities.User;
import com.kellyprojects.ob_hibernate_project.repository.BillingInfoRepository;
import com.kellyprojects.ob_hibernate_project.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillingInfoController {
    private BillingInfoRepository billingInfoRepository;
    public BillingInfoController(BillingInfoRepository billingInfoRepository){
        this.billingInfoRepository=billingInfoRepository;
    }

    @GetMapping("/api/billingInfo")
    private List<BillingInfo> findAll(){
        return this.billingInfoRepository.findAll();
    }

    @PostMapping("/api/billingInfo")
    private BillingInfo create(@RequestBody BillingInfo billingInfo){
        return this.billingInfoRepository.save(billingInfo);
    }

    @PutMapping("/api/billingInfo")
    private BillingInfo update(@RequestBody BillingInfo billingInfo){
        return this.billingInfoRepository.save(billingInfo);
    }

    @DeleteMapping("/api/billingInfo/{id}")
    private void delete (@PathVariable Long id){
        if(this.billingInfoRepository.existsById(id)){
            this.billingInfoRepository.deleteById(id);
        }
    }

}
