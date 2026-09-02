package library.daesu.com.lending_service.entity;

import jakarta.persistence.*;
import library.daesu.com.lending_service.entity.enums.MembershipStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Member extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "membership_status", nullable = false, length = 20)
    private MembershipStatus membershipStatus;

    @Column(name = "joined_at", nullable = false)
    private LocalDate joinedAt;

    @Column(name = "outstanding_fines", precision = 10, scale = 2, nullable = false)
    private BigDecimal outstandingFines;

    @Builder
    public Member(String firstName, String lastName, String email, String phone, MembershipStatus membershipStatus, LocalDate joinedAt, BigDecimal outstandingFines) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.membershipStatus = membershipStatus;
        this.joinedAt = (joinedAt != null) ? joinedAt : LocalDate.now();
        this.outstandingFines = (outstandingFines != null) ? outstandingFines : BigDecimal.ZERO;
    }
}
