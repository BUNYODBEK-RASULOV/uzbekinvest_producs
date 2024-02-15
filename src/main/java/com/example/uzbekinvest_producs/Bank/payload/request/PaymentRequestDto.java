package com.example.uzbekinvest_producs.Bank.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequestDto {

    @Schema(description = "Контракт номер или ид",example ="102003")
    @NotNull(message = "subject cannot be null")
    private long contract_id;

    @Schema(description = "Контракт номер для шаблоне pdf",example ="contract_number")
    @NotNull(message = "contract_number cannot be null")
    private String contract_number;

    @Schema(description = "Дата платежа страховая премия (формат: 'dd.MM.yyyy')",example ="01.07.2023")
    @NotNull(message = "payment_date be null")
    private String payment_date;

    @Schema(description = "Контракт дата (формат: 'dd.MM.yyyy') для шаблоне pdf (Пункт Кредит шартномаси и Берилган сана)",example ="01.07.2023")
    @NotNull(message = "contract_date cannot be null")
    private String contract_date;

    @Schema(description = "Дата начала кредита (формат: 'dd.MM.yyyy')",example ="01.07.2023")
    @NotNull(message = "s_date cannot be null")
    private String s_date;

    @Schema(description = "Дата окончания кредита (формат: 'dd.MM.yyyy')",example ="01.07.2024")
    @NotNull(message = "e_date cannot be null")
    private String e_date;


    public String getS_date() {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(s_date, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(outputFormatter);
    }

    public String getE_date() {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(e_date, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(outputFormatter);
    }

    public String getPayment_date() {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(payment_date, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(outputFormatter);
    }

    public String getContract_date() {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(contract_date, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(outputFormatter);
    }
}
