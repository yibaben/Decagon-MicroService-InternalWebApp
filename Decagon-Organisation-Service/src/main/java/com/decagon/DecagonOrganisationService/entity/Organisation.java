package com.decagon.DecagonOrganisationService.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "organisations")
public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String orgName;
    @Column(nullable = false)
    private String orgDescription;
    @Column(nullable = false, unique = true)
    private  String orgCodeNum;
    @CreationTimestamp
    private LocalDateTime createdDate;
}
