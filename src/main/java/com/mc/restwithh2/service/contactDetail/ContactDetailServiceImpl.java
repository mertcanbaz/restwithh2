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
    private final StudentMapper studentMapper;

    public ContactDetailServiceImpl(StudentService studentService, ContactDetailRepository contactDetailRepository, ContactDetailMapper contactDetailMapper, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.contactDetailRepository = contactDetailRepository;
        this.contactDetailMapper = contactDetailMapper;
        this.studentMapper = studentMapper;
    }

    @Override
    public Optional<List<ContactDetailDto>> getContactDetails() {
        return Optional.ofNullable(contactDetailMapper.entityListToDtoList(contactDetailRepository.findAll()));
    }

    @Override
    public List<ContactDetailDto> getContactDetailsByStudentId(Long studentId) {
        return contactDetailMapper.entityListToDtoList(contactDetailRepository.findAllByStudentId(studentId));
    }

    @Override
    public void saveAllContactDetails(List<ContactDetailDto> contactDetailDtoList) {
        contactDetailRepository.saveAll(contactDetailMapper.dtoListToEntityList(contactDetailDtoList));
    }

    @Override
    public void addContactDetail(Long studentId, ContactDetailDto contactDetailDto) {

        Optional<Student> studentCheck = studentService.findById(studentId);
        if (!studentCheck.isPresent()) {
            throw new ResourceNotFoundException("Not found Student with id = " + studentId);
        }
        //should we set student to contactDetail ?
        contactDetailRepository.save(contactDetailMapper.dtoToEntity(contactDetailDto));
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
    public void updateContactDetail(Long contactDetailId, ContactDetailDto contactDetailDto) {

        boolean exists = contactDetailRepository.existsById(contactDetailId);
        if(!exists){
            throw new ResourceNotFoundException("Contact Detail with id : " + contactDetailId + " does not exists");
        }

        contactDetailDto.setId(contactDetailId);
        contactDetailRepository.save(contactDetailMapper.dtoToEntity(contactDetailDto));
    }
}
