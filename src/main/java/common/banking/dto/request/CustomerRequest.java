package common.banking.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class CustomerRequest {

    @NotNull(message = "Passport Number should not be empty")
    private String passportNumber;

    @NotNull(message = "HasCredit must be true or false")
    private boolean hasCredit;

    @Positive(message = "Credit Amount must be positive number:")
    private short creditAmount;
}
