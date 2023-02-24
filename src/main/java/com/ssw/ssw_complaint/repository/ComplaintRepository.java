package com.ssw.ssw_complaint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.CrudRepository;
import com.ssw.ssw_complaint.model.ComplaintModel;

public interface ComplaintRepository extends JpaRepository<ComplaintModel,Integer> {
    
}
