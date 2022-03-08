package com.mc.restwithh2.service.contactDetail;

import com.mc.restwithh2.entity.ContactDetail;

import java.util.List;

public interface ContactDetailService {
    List<ContactDetail> getContactDetails();

    List<ContactDetail> getContactDetailsByStudentId(Long studentId);

    void saveAllContactDetails(List<ContactDetail> contactDetailList);

    void addContactDetail(Long studentId, ContactDetail contactDetail);

    void deleteContactDetail(Long contactDetailId);

    void updateContactDetail(Long contactDetailId, ContactDetail contactDetail);
}
