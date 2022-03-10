package com.mc.restwithh2.controller.contactDetail;

import com.mc.restwithh2.entity.ContactDetail;
import com.mc.restwithh2.service.contactDetail.ContactDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactDetailControllerImpl implements ContactDetailController {
    private final ContactDetailService contactDetailService;

    public ContactDetailControllerImpl(ContactDetailService contactDetailService) {
        this.contactDetailService = contactDetailService;
    }

    public List<ContactDetail> getContactDetails() {
        return contactDetailService.getContactDetails();
    }

    public List<ContactDetail> getContactDetailByStudentId(@PathVariable Long studentId) {
        return contactDetailService.getContactDetailsByStudentId(studentId);
    }

    public ResponseEntity<Object> saveContactDetail(@PathVariable Long studentId, @RequestBody ContactDetail contactDetail) {
        contactDetailService.addContactDetail(studentId, contactDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Object> updateContactDetail(@PathVariable Long contactDetailId, @RequestBody ContactDetail contactDetail) {
        contactDetailService.updateContactDetail(contactDetailId, contactDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Object> deleteContactDetail(@PathVariable Long contactDetailId) {
        contactDetailService.deleteContactDetail(contactDetailId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
