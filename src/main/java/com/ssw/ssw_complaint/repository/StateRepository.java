package com.ssw.ssw_complaint.repository;

import org.springframework.data.repository.CrudRepository;
import com.ssw.ssw_complaint.model.StateModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StateRepository extends JpaRepository<StateModel,Integer> {
    
}
