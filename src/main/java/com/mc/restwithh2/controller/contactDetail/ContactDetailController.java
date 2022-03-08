package com.mc.restwithh2.controller.contactDetail;

import com.mc.restwithh2.entity.ContactDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public interface ContactDetailController {

    @GetMapping("/contactDetails")
    List<ContactDetail> getContactDetails();

    @GetMapping("/students/{studentId}/contactDetails")
    List<ContactDetail> getContactDetailByStudentId(@PathVariable Long studentId);

    @PostMapping("/students/{studentId}/contactDetails")
    ResponseEntity<Object> saveContactDetail(@PathVariable Long studentId, @RequestBody ContactDetail contactDetail);

    @PutMapping("/contactDetails/{contactDetailId}")
    ResponseEntity<Object> updateContactDetail(@PathVariable Long contactDetailId, @RequestBody ContactDetail contactDetail);

    @DeleteMapping("/contactDetails/{contactDetailId}")
    ResponseEntity<Object> deleteContactDetail(@PathVariable Long contactDetailId);
}
