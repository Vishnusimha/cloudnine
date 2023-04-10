package com.vishnu.cloudnine.repository;

import com.vishnu.cloudnine.entity.PersonalEventFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalEventFormRepository extends JpaRepository<PersonalEventFormEntity, Integer> {
    //    to findBySponsorEmail in db
    PersonalEventFormEntity findBySponsorEmail(String sponsorEmail);
}
