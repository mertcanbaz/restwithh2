package com.mc.restwithh2.repository;

import com.mc.restwithh2.entity.ContactDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactDetailRepository extends JpaRepository<ContactDetail, Long> {

    List<ContactDetail> findAllByStudentId(Long studentId);

    Optional<ContactDetail> findContactDetailByType(String code);
}
