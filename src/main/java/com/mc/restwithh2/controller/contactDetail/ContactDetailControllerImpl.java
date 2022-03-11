package com.mc.restwithh2.controller.contactDetail;

import com.mc.restwithh2.dto.ContactDetailDto;
import com.mc.restwithh2.service.contactDetail.ContactDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ContactDetailControllerImpl implements ContactDetailController {
    private final ContactDetailService contactDetailService;

    public ContactDetailControllerImpl(ContactDetailService contactDetailService) {
        this.contactDetailService = contactDetailService;
    }

    public Optional<List<ContactDetailDto>> getContactDetails() {
        return contactDetailService.getContactDetails();
    }

    public List<ContactDetailDto> getContactDetailByStudentId(@PathVariable Long studentId) {
        return contactDetailService.getContactDetailsByStudentId(studentId);
    }

    public ResponseEntity<Object> saveContactDetail(@PathVariable Long studentId, @RequestBody ContactDetailDto contactDetailDto) {
        contactDetailService.addContactDetail(studentId, contactDetailDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Object> updateContactDetail(@PathVariable Long studentId, @PathVariable Long contactDetailId, @RequestBody ContactDetailDto contactDetailDto) {
        contactDetailService.updateContactDetail(studentId, contactDetailId, contactDetailDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Object> deleteContactDetail(@PathVariable Long contactDetailId) {
        contactDetailService.deleteContactDetail(contactDetailId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
