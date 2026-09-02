package library.daesu.com.lending_service.entity;

import jakarta.persistence.*;
import library.daesu.com.lending_service.entity.enums.LoanStatus;
import lombok.*;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "loan")
@Check(constraints = "renewal_count >= 0 AND fine_amount >= 0 AND due_at > borrowed_at")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Loan extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(name = "borrowed_at", nullable = false)
    private LocalDateTime borrowedAt;

    @Column(name = "due_at", nullable = false)
    private LocalDateTime dueAt;

    @Column(name = "returned_at")
    private LocalDateTime returnedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private LoanStatus status;

    @Column(name = "fine_amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal fineAmount;

    @Column(name = "renewal_count", nullable = false)
    private int renewalCount;

    @Builder
    public Loan(Book book, Member member, LocalDateTime borrowedAt, LocalDateTime dueAt, LocalDateTime returnedAt, LoanStatus status, BigDecimal fineAmount, int renewalCount) {
        this.book = book;
        this.member = member;
        this.borrowedAt = borrowedAt;
        this.dueAt = dueAt;
        this.returnedAt = returnedAt;
        this.status = status;
        this.fineAmount = (fineAmount != null) ? fineAmount : BigDecimal.ZERO;
        this.renewalCount = renewalCount;
    }
}
