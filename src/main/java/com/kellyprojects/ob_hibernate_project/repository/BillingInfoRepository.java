package com.kellyprojects.ob_hibernate_project.repository;

import com.kellyprojects.ob_hibernate_project.entities.BillingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingInfoRepository extends JpaRepository<BillingInfo, Long> {
}
