package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private  UUID id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" ,nullable = false)
    @ToString.Exclude
    private User user;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name="role", nullable = false)
    private String role;

    @Column(name = "job_url")
    private String jobUrl;

    @Column(name = "salary_range")
    private String salaryRange;

    private String location;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "job_status")
    @org.hibernate.annotations.JdbcTypeCode(org.hibernate.type.SqlTypes.NAMED_ENUM)
    private JobStatus status = JobStatus.APPLIED;

    private String source;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(name = "applied_date")
    private LocalDate appliedDate;

    @OneToMany(mappedBy = "job",cascade = CascadeType.ALL,orphanRemoval = true)
    @Builder.Default
    public List<Skill> skills= new ArrayList<>();

    @OneToMany(mappedBy = "job",cascade = CascadeType.ALL,orphanRemoval = true)
    @Builder.Default
    public List<Interview> interviews= new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;




}