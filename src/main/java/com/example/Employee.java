package com.example;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name = "employees_table")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String employeeId;

    @Column(name = "emp_name", columnDefinition = "VARCHAR(100)", nullable = false, unique = true)
    private String employeeName;

    @Lob
    @Column(columnDefinition = "MEDIUMTEXT")
    private String employeeDesription;
    @Transient
    private double employeeSalary;
    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus;
    @CreationTimestamp
    private LocalDateTime createdDateTime;
    @UpdateTimestamp
    private LocalDateTime updatedDateTime;
}
