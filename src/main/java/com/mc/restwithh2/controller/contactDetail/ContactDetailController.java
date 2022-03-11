package com.mc.restwithh2.controller.contactDetail;

import com.mc.restwithh2.dto.ContactDetailDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Contact Detail API Documentation")
public interface ContactDetailController {

    @GetMapping("/contactDetails")
    @ApiOperation(value = "returns all contact details")
    Optional<List<ContactDetailDto>> getContactDetails();

    @GetMapping("/students/{studentId}/contactDetails")
    @ApiOperation(value = "returns all contact details by studentId")
    List<ContactDetailDto> getContactDetailByStudentId(@PathVariable Long studentId);

    @PostMapping("/students/{studentId}/contactDetails")
    @ApiOperation(value = "saves contact detail by studentId")
    ResponseEntity<Object> saveContactDetail(@PathVariable Long studentId, @RequestBody ContactDetailDto contactDetailDto);

    @PutMapping("/contactDetails/{contactDetailId}")
    @ApiOperation(value = "updates contact detail by contactDetailId")
    ResponseEntity<Object> updateContactDetail(@PathVariable Long contactDetailId, @RequestBody ContactDetailDto contactDetailDto);

    @DeleteMapping("/contactDetails/{contactDetailId}")
    @ApiOperation(value = "deletes contact detail by contactDetailId")
    ResponseEntity<Object> deleteContactDetail(@PathVariable Long contactDetailId);
}
