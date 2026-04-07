package  com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false,length = 100)
    private String name;

    @Column(nullable = false,unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "target_role")
    private String targetRole;

    @Column(name = "target_salary")
    private String targetSalary ;

    @Column(name="resume_url")
    private String resumeUrl;

    @CreationTimestamp
    @Column(name = "created_at" ,updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name="updated_at",updatable = false)
    private LocalDateTime updatedAt;
    //
}


