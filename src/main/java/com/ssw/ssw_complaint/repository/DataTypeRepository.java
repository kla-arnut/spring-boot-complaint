package com.ssw.ssw_complaint.repository;

import org.springframework.data.repository.CrudRepository;
import com.ssw.ssw_complaint.model.DataTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DataTypeRepository extends JpaRepository<DataTypeModel,Integer> {
    
}
