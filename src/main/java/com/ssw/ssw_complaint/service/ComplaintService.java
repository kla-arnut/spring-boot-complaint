package com.ssw.ssw_complaint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssw.ssw_complaint.model.ComplaintModel;
import com.ssw.ssw_complaint.repository.ComplaintRepository;
import java.util.List;
import java.util.Optional;


@Service
public class ComplaintService {
    @Autowired
    ComplaintRepository complaintRepository;

    // CREATE
    public ComplaintModel create(ComplaintModel complaint) {
        return complaintRepository.save(complaint);
    }

    // READ
    public List<ComplaintModel> get() {
        return complaintRepository.findAll();
    }

    // FIND
    public Optional<ComplaintModel> find(Integer complaintId) {
        return complaintRepository.findById(complaintId);
    }

    // DELETE
    public void delete(Integer complaintId) {
        complaintRepository.deleteById(complaintId);
    }

    // UPDATE
    public ComplaintModel update(Integer complaintId, ComplaintModel complaintDetails) {
        ComplaintModel cr = complaintRepository.findById(complaintId).get();
        cr.set_area_name(complaintDetails.get_area_name());
        cr.set_branch_code(complaintDetails.get_branch_code());
        cr.set_branch_email(complaintDetails.get_branch_email());
        cr.set_region_name(complaintDetails.get_region_name());
        return complaintRepository.save(cr);
    }
}
