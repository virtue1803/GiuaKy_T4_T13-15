package org.spring.testspring.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.spring.testspring.enums.Roles;

import java.time.LocalDate;

@Entity @Table(name = "experience")
@Getter @Setter @NoArgsConstructor
public class Experience {
    @Id
    @Column(name = "exp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "company", length = 120)
    private String companyName;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "role")
    private Roles roles;
    @Column(name = "work_desc", length = 400)
    private String workDescription;
    private LocalDate fromDate;
    private LocalDate toDate;
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    public Experience(String companyName, Roles roles, String workDescription, LocalDate fromDate, LocalDate toDate, Candidate candidate) {
        this.companyName = companyName;
        this.roles = roles;
        this.workDescription = workDescription;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.candidate = candidate;
    }
}
