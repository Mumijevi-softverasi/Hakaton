package org.unibl.etf.hakaton.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name="payment")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="student_id",referencedColumnName = "id",nullable = false)
    private StudentEntity student;

    @Basic
    @Column(name="status",nullable = false)
    private boolean status;


    @OneToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private PaymentInfoEntity paymentInfo;




}
