package org.belchan.repository;

import org.belchan.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("StaffRepository")
public interface StaffRepository extends JpaRepository<Staff, Integer> {

    //    @Query("select s from staff s where s.model = :value1")
    //    List<Staff> findByProperty(@Param("column") String column, @Param("value1") String value1);
    @Query("select s from org.belchan.entity.Staff s where s.username = :username")
    List<Staff> findByUserName(@Param("username") String username);
}
