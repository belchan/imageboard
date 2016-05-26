package org.belchan.service;

import org.belchan.entity.Staff;
import org.belchan.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    public Staff findByUsername(String username) {
        List<Staff> l = staffRepository.findByUserName(username);
        switch (l.size()) {
            case 0: {
                throw new UsernameNotFoundException("U N F" + username);
            }
            case 1: {
                return l.get(0);
            }
            default: {
                throw new RuntimeException("MULTIPLE EXCEPTION");
            }
        }
    }


}
