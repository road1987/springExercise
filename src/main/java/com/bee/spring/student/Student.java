package com.bee.spring.student;

import java.time.LocalDate;
import java.time.Period;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor()
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    @Transient
    private int age;

    public Student(String name, String email, LocalDate birthDate) {
        super();
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public int getAge() {
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
