package com.mc.restwithh2.service.contactDetail;

import com.mc.restwithh2.entity.ContactDetail;
import com.mc.restwithh2.entity.Student;
import com.mc.restwithh2.exception.ResourceNotFoundException;
import com.mc.restwithh2.repository.ContactDetailRepository;
import com.mc.restwithh2.service.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class ContactDetailServiceImpl implements ContactDetailService {
    private final StudentService studentService;
    private final ContactDetailRepository contactDetailRepository;

    public ContactDetailServiceImpl(StudentService studentService, ContactDetailRepository contactDetailRepository) {
        this.studentService = studentService;
        this.contactDetailRepository = contactDetailRepository;
    }

    @Override
    public List<ContactDetail> getContactDetails() {
        return contactDetailRepository.findAll();
    }

    @Override
    public List<ContactDetail> getContactDetailsByStudentId(Long studentId) {
        return contactDetailRepository.findAllByStudentId(studentId);
    }

    @Override
    public void saveAllContactDetails(List<ContactDetail> contactDetailList) {
        contactDetailRepository.saveAll(contactDetailList);
    }

    @Override
    public void addContactDetail(Long studentId, ContactDetail contactDetail) {

        Optional<Student> studentCheck = studentService.findById(studentId);
        if (!studentCheck.isPresent()) {
            throw new ResourceNotFoundException("Not found Student with id = " + studentId);
        }

        contactDetail.setStudent(studentCheck.get());

        contactDetailRepository.save(contactDetail);
    }

    @Override
    public void deleteContactDetail(Long contactDetailId) {

        boolean exists = contactDetailRepository.existsById(contactDetailId);
        if (!exists) {
            throw new ResourceNotFoundException("Contact Detail with id : " + contactDetailId + " does not exists");
        }

        contactDetailRepository.deleteById(contactDetailId);
    }

    @Override
    @Transactional
    public void updateContactDetail(Long contactDetailId, ContactDetail contactDetail) {

        ContactDetail contactDetailCheck = contactDetailRepository.findById(contactDetailId).orElseThrow(() ->
                new ResourceNotFoundException("Contact Detail with id : " + contactDetailId + " does not exists"));

        contactDetailCheck.setType(contactDetail.getType());
        contactDetailCheck.setDesc(contactDetail.getDesc());
        contactDetailCheck.setStudent(contactDetail.getStudent());

        contactDetailRepository.save(contactDetailCheck);
    }
}
