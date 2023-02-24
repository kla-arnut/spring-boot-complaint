package com.ssw.ssw_complaint.repository;

import org.springframework.data.repository.CrudRepository;
import com.ssw.ssw_complaint.model.DataSourceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataSourceRepository extends JpaRepository<DataSourceModel,Integer> {
    
}
