package com.example.uzbekinvest_producs.Bank.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractCreateRequestDto {

    @Schema(description = "Тип клиента(физ='P', юр='J')",example ="P")
    @NotNull(message = "subject cannot be null")
    private String subject;

    @Schema(description = "Информация о клиента")
    @NotNull(message = "customer cannot be null")
    private Customer customer;

    @Schema(description = "Информация о кредита")
    @NotNull(message = "loan_info cannot be null")
    private LoanInfo loan_info;

    @Schema(description = "Данные организация")
    @NotNull(message = "organization cannot be null")
    private Organization organization;
}
