package com.ssw.ssw_complaint.repository;

import org.springframework.data.repository.CrudRepository;
import com.ssw.ssw_complaint.model.ComplaintContactLogsModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ComplaintContactLogsRepository extends JpaRepository<ComplaintContactLogsModel,Integer> {
    
}
