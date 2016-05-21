package org.belchan.service;

import org.belchan.entity.Staff;
import org.belchan.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    @Qualifier("StaffRepository")
    StaffRepository staffRepository;

    public List<Staff> get() {
        return staffRepository.findAll();
    }

    public List<Staff> findByUsername(String username) {
        return staffRepository.findByUserName(username);
    }
}
