package com.vishnu.cloudnine.repository;

import com.vishnu.cloudnine.entity.CorporateEventFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateEventFormRepository extends JpaRepository<CorporateEventFormEntity, Integer> {
//    to findBySponsorEmail in db
    CorporateEventFormEntity findBySponsorEmail(String sponsorEmail);
}
