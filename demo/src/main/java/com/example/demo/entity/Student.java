package com.example.demo.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.Set;
import java.util.HashSet;
import java.util.UUID;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(columnDefinition = "uuid")
    private UUID id;

    private String name;
    private String email;

    @ManyToMany
    @JoinTable(
            name = "enrollments",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses = new HashSet<>();

    private Double gpa;

    // Constructors
    public Student() {}

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }
}
