package com.mc.restwithh2.config;

import com.mc.restwithh2.entity.ContactDetail;
import com.mc.restwithh2.entity.Student;
import com.mc.restwithh2.repository.ContactDetailRepository;
import com.mc.restwithh2.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class Config {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, ContactDetailRepository contactDetailRepository) {
        return args -> {

            Student student1 = new Student(
                    "Student 1",
                    "student1@gmail.com",
                    LocalDate.of(2011, Month.SEPTEMBER, 27));

            Student student2 = new Student(
                    "Student 2",
                    "student2@gmail.com",
                    LocalDate.of(2021,
                            Month.SEPTEMBER,
                            27));

            studentRepository.save(student1);
            studentRepository.save(student2);

            ContactDetail erenContactDetail1 = new ContactDetail("Telefon", "+903121112233");
            ContactDetail erenContactDetail2 = new ContactDetail("Faks", "+903124445566");
            ContactDetail kucukContactDetail = new ContactDetail("GSM", "+905337778899");

            erenContactDetail1.setStudent(student1);
            erenContactDetail2.setStudent(student1);
            kucukContactDetail.setStudent(student2);

            contactDetailRepository.save(erenContactDetail1);
            contactDetailRepository.save(erenContactDetail2);
            contactDetailRepository.save(kucukContactDetail);
        };
    }
}
