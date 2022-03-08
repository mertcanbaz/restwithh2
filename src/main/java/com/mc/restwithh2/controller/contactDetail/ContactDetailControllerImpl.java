package com.mc.restwithh2.controller.contactDetail;

import com.mc.restwithh2.entity.ContactDetail;
import com.mc.restwithh2.service.contactDetail.ContactDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ContactDetailControllerImpl implements ContactDetailController {
    private final ContactDetailService contactDetailService;

    @GetMapping("/contactDetails")
    public List<ContactDetail> getContactDetails() {
        return contactDetailService.getContactDetails();
    }

    @GetMapping("/students/{studentId}/contactDetails")
    public List<ContactDetail> getContactDetailByStudentId(@PathVariable Long studentId) {
        return contactDetailService.getContactDetailsByStudentId(studentId);
    }

    @PostMapping("/students/{studentId}/contactDetails")
    public ResponseEntity<Object> saveContactDetail(@PathVariable Long studentId, @RequestBody ContactDetail contactDetail) {
        contactDetailService.addContactDetail(studentId, contactDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/contactDetails/{contactDetailId}")
    public ResponseEntity<Object> updateContactDetail(@PathVariable Long contactDetailId, @RequestBody ContactDetail contactDetail) {
        contactDetailService.updateContactDetail(contactDetailId, contactDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/contactDetails/{contactDetailId}")
    public ResponseEntity<Object> deleteContactDetail(@PathVariable Long contactDetailId) {
        contactDetailService.deleteContactDetail(contactDetailId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
