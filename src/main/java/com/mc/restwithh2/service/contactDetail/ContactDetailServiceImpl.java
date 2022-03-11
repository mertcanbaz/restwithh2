package com.mc.restwithh2.service.contactDetail;

import com.mc.restwithh2.dto.ContactDetailDto;
import com.mc.restwithh2.entity.ContactDetail;
import com.mc.restwithh2.entity.Student;
import com.mc.restwithh2.exception.ResourceNotFoundException;
import com.mc.restwithh2.repository.ContactDetailRepository;
import com.mc.restwithh2.service.student.StudentService;
import com.mc.restwithh2.mapper.ContactDetailMapper;
import com.mc.restwithh2.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class ContactDetailServiceImpl implements ContactDetailService {
    private final StudentService studentService;
    private final ContactDetailRepository contactDetailRepository;
    private final ContactDetailMapper contactDetailMapper;

    public ContactDetailServiceImpl(StudentService studentService, ContactDetailRepository contactDetailRepository, ContactDetailMapper contactDetailMapper) {
        this.studentService = studentService;
        this.contactDetailRepository = contactDetailRepository;
        this.contactDetailMapper = contactDetailMapper;
    }

    @Override
    public Optional<List<ContactDetailDto>> getContactDetails() {
        return Optional.ofNullable(contactDetailMapper.entityListToDtoList(contactDetailRepository.findAll()));
    }

    @Override
    public List<ContactDetailDto> getContactDetailsByStudentId(Long studentId) {
        return contactDetailMapper.entityListToDtoList(contactDetailRepository.findAllByStudentId(studentId));
    }

//    @Override
//    public void saveAllContactDetails(List<ContactDetailDto> contactDetailDtoList) {
//        contactDetailRepository.saveAll(contactDetailMapper.dtoListToEntityList(contactDetailDtoList));
//    }

    @Override
    public void addContactDetail(Long studentId, ContactDetailDto contactDetailDto) {

        Optional<Student> studentCheck = studentService.findById(studentId);
        if (!studentCheck.isPresent()) {
            throw new ResourceNotFoundException("Not found Student with id = " + studentId);
        }
        contactDetailRepository.save(contactDetailMapper.dtoToEntity(contactDetailDto));
    }

    @Override
    @Transactional
    public void updateContactDetail(Long studentId, Long contactDetailId, ContactDetailDto contactDetailDto) {

        Optional<Student> studentCheck = studentService.findById(studentId);
        if(!studentCheck.isPresent()){
            throw new ResourceNotFoundException("Student with id : " + studentId + " does not exists");
        }

        Optional<ContactDetail> contactDetailCheck = contactDetailRepository.findById(contactDetailId);
        if(!contactDetailCheck.isPresent()){
            throw new ResourceNotFoundException("Contact Detail with id : " + contactDetailId + " does not exists");
        }

        ContactDetail contactDetailToUpdate = contactDetailMapper.dtoToEntity(contactDetailDto);
        contactDetailToUpdate.setId(contactDetailId);
        contactDetailToUpdate.setStudent(studentCheck.get());
        contactDetailRepository.save(contactDetailToUpdate);
    }

    @Override
    public void deleteContactDetail(Long contactDetailId) {

        boolean exists = contactDetailRepository.existsById(contactDetailId);
        if (!exists) {
            throw new ResourceNotFoundException("Contact Detail with id : " + contactDetailId + " does not exists");
        }

        contactDetailRepository.deleteById(contactDetailId);
    }

}
