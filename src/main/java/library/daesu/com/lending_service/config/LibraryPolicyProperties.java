package library.daesu.com.lending_service.config;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Validated
@ConfigurationProperties(prefix = "app.library.policy")
public class LibraryPolicyProperties {
    @Min(1)
    private int maxActiveLoansPerMember;

    @Min(1)
    private int loanDurationDays;

    @Min(0)
    private int maxRenewals;

    @Min(0)
    private long finePerDayCents;

    @NotNull
    @Min(0)
    private BigDecimal maxOutstandingFines;

    public int getMaxActiveLoansPerMember() {
        return maxActiveLoansPerMember;
    }

    public void setMaxActiveLoansPerMember(int maxActiveLoansPerMember) {
        this.maxActiveLoansPerMember = maxActiveLoansPerMember;
    }

    public int getLoanDurationDays() {
        return loanDurationDays;
    }

    public void setLoanDurationDays(int loanDurationDays) {
        this.loanDurationDays = loanDurationDays;
    }

    public int getMaxRenewals() {
        return maxRenewals;
    }

    public void setMaxRenewals(int maxRenewals) {
        this.maxRenewals = maxRenewals;
    }

    public long getFinePerDayCents() {
        return finePerDayCents;
    }

    public void setFinePerDayCents(long finePerDayCents) {
        this.finePerDayCents = finePerDayCents;
    }

    public BigDecimal getMaxOutstandingFines() {
        return maxOutstandingFines;
    }

    public void setMaxOutstandingFines(BigDecimal maxOutstandingFines) {
        this.maxOutstandingFines = maxOutstandingFines;
    }
}
