package com.ssw.ssw_complaint.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "complaint")
public class ComplaintModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private Integer data_type; // insert data by?, such as excel-import, api-post, website-add // has a table relation data_type_description
    private String region_code;
    private String region_name;
    private String area_code;
    private String area_name;
    private String branch_code;
    private String branch_name;
    private String branch_email;
    // @Column(nullable = false)
    private String first_name;
    private String last_name;
    private String phone_number;
    private String email; 
    // @Column(nullable = false)
    private String complaint_description;
    private Integer data_source; // what is department are add ?, such as call-center, branch, customer-himself // has a table relation data_source_description
    private String accused; // who or branch was accused? พนักงาน หรือ สาขา ที่โดนร้องเรียน
    private Integer state; // current state id // has a table relation state_source_description
    private Integer deleted;
    private java.sql.Date reaction_at; // time at reaction
    private java.sql.Date created_at;
    private java.sql.Date updated_at;
    private java.sql.Date deleted_at;
    private String contract_number;

    public String get_contract_number() {
        return contract_number;
    }

    public void set_contract_number(String contract_number) {
        this.contract_number = contract_number;
    }

    public Integer get_deleted() {
        return deleted;
    }

    public void set_deleted(Integer deleted) {
        this.deleted = deleted;
    }

    public java.sql.Date get_deleted_at() {
        return deleted_at;
    }

    public void set_deleted_at(java.sql.Date deleted_at) {
        this.deleted_at = deleted_at;
    }

    public java.sql.Date get_updated_at() {
        return updated_at;
    }

    public void set_updated_at(java.sql.Date updated_at) {
        this.updated_at = updated_at;
    }

    public java.sql.Date get_created_at() {
        return created_at;
    }

    public void set_created_at(java.sql.Date created_at) {
        this.created_at = created_at;
    }

    public java.sql.Date get_reaction_at() {
        return reaction_at;
    }

    public void set_reaction_at(java.sql.Date reaction_at) {
        this.reaction_at = reaction_at;
    }

    public Integer get_state() {
        return state;
    }

    public void set_state(Integer state) {
        this.state = state;
    }

    public String get_accused() {
        return accused;
    }

    public void set_accused(String accused) {
        this.accused = accused;
    }

    public Integer get_data_source() {
        return data_source;
    }

    public void set_data_source(Integer data_source) {
        this.data_source = data_source;
    }

    public String get_complaint_description() {
        return complaint_description;
    }

    public void set_complaint_description(String complaint_description) {
        this.complaint_description = complaint_description;
    }

    public String get_email() {
        return email;
    }

    public void set_email(String email) {
        this.email = email;
    }

    public String get_phone_number() {
        return phone_number;
    }

    public void set_phone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String get_last_name() {
        return last_name;
    }

    public void set_last_name(String last_name) {
        this.last_name = last_name;
    }

    public String get_first_name() {
        return first_name;
    }

    public void set_first_name(String first_name) {
        this.first_name = first_name;
    }

    public String get_branch_email() {
        return branch_email;
    }

    public void set_branch_email(String branch_email) {
        this.branch_email = branch_email;
    }

    public String get_branch_name() {
        return branch_name;
    }

    public void set_branch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String get_branch_code() {
        return branch_code;
    }

    public void set_branch_code(String branch_code) {
        this.branch_code = branch_code;
    }

    public String get_area_name() {
        return area_name;
    }

    public void set_area_name(String area_name) {
        this.area_name = area_name;
    }

    public String get_area_code() {
        return area_code;
    }

    public void set_area_code(String area_code) {
        this.area_code = area_code;
    }

    public String get_region_name() {
        return region_name;
    }

    public void set_region_name(String region_name) {
        this.region_name = region_name;
    }

    public String get_region_code() {
        return region_code;
    }

    public void set_region_code(String region_code) {
        this.region_code = region_code;
    }

    public Integer get_data_type() {
        return data_type;
    }

    public void set_data_type(Integer data_type) {
        this.data_type = data_type;
    }

    public Integer get_id() {
        return id;
    }

    public void set_id(Integer id) {
        this.id = id;
    }

    
    
}
