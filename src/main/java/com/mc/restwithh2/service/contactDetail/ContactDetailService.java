package com.mc.restwithh2.service.contactDetail;

import com.mc.restwithh2.dto.ContactDetailDto;

import java.util.List;
import java.util.Optional;

public interface ContactDetailService {
    Optional<List<ContactDetailDto>> getContactDetails();

    List<ContactDetailDto> getContactDetailsByStudentId(Long studentId);

//    void saveAllContactDetails(List<ContactDetailDto> contactDetailDtoList);

    void addContactDetail(Long studentId, ContactDetailDto contactDetailDto);

    void updateContactDetail(Long studentId, Long contactDetailId, ContactDetailDto contactDetailDto);

    void deleteContactDetail(Long contactDetailId);

}
