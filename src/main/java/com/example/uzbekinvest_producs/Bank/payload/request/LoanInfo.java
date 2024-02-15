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
public class LoanInfo {

    @NotNull(message = "Ид договора (claim_id) cannot be null")
    @Schema(description = "Ид договора, required = true",example ="1")
    private long claim_id;

    @NotNull(message = "Тип кредита (loan_type) cannot be null")
    @Schema(description = "Тип кредита (Микрозайм='32',Автокредит='34', АвтоРиск='34/1',ипотека=24),required = true",example ="34")
    private String loan_type;

    @Schema(description = "Общая сумма кредита(если Автокредит стоимость автомобиля), required = true",example ="1000")
    private double loan_total;

    @NotNull(message = "Сумма кредита (loan_amount) cannot be null")
    @Schema(description = "Сумма кредита, required = true",example ="10000")
    private double loan_amount;

    @Schema(description = "Срок кредита(в месяц), required = true",example ="12")
    private int loan_term;

    @NotNull(message = "Дата начала кредита (s_dat) cannot be null")
    @Schema(description = "Дата начала кредита (формат: 'dd.MM.yyyy'), required = true",example ="01.07.2023")
    private String s_date;

    @NotNull(message = "Дата окончания кредита (e_date) cannot be null")
    @Schema(description = "Дата окончания кредита (формат: 'dd.MM.yyyy'), required = true",example ="01.07.2024")
    private String e_date;

    @Schema(description = "Марка объекта для страхования если Автокредит required = true",example ="1")
    private String object_brand;

    @Schema(description = "Наименования объекта для страхования если Автокредит required = true",example ="1")
    private String object_name;

    @Schema(description = "страховой коэффициент required = true",example ="0.00")
    private double insurance_coefficient;

    @NotNull(message = "cadaster info (cadastr_info) cannot be null")
    @Schema(description = "кадастровая информация для страхования если ипотека required = true, required = true")
    private CadastrInfo cadastr_info;

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
}
