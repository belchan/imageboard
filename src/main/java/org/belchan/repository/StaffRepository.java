package org.belchan.repository;

import org.belchan.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("StaffRepository")
public interface StaffRepository extends JpaRepository<Staff,Integer> {
}
