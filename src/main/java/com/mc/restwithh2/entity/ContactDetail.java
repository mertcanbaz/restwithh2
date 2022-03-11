package com.mc.restwithh2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "contact_detail")
public class ContactDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "desc")
    private String desc;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;


    public ContactDetail() {
    }

    public ContactDetail(Long id, String type, String desc) {
        this.id = id;
        this.type = type;
        this.desc = desc;
    }

    public ContactDetail(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}