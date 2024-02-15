package com.example.uzbekinvest_producs.Bank.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class CadastrInfo {

    @NotNull(message = "Код региона (region_code) cannot be null")
    @Schema(description = "Код региона из Справочкик(S_Region),required = true",example ="26")
    private String region_code;

    @NotNull(message = "Вид права на земельный участок (right_land_type) cannot be null")
    @Schema(description = "Ид из Справочкик(Doimiy egalik 1,Umrbod meros egaligi 2),required = true",example ="1")
    private int right_land_type;

    @NotNull(message = "Правообладатель иностарнец (is_foreign) cannot be null")
    @Schema(description = "Правообладатель иностарнец(1-иностранное,0-не иностранное),required = true",example ="0")
    private int is_foreign;

    @NotNull(message = "Кадастровый номер (cadastr_number) cannot be null")
    @Schema(description = "Кадастровый номер ,required = true",example ="24")
    private String cadastr_number;

    @NotNull(message = "Дата регистрации кадастрового документа (cadastr_issue_date) cannot be null")
    @Schema(description = "Дата регистрации кадастрового документа (формат: 'dd.MM.yyyy'),required = true",example ="01.09.2023")
    private String cadastr_issue_date ="";

    @NotNull(message = "Классификация строения (building_type) cannot be null")
    @Schema(description = "Ид из Справочкик(Kvartira 2,Hovli uy-joy 3,Bino-inshoat 6 ),required = true",example ="3")
    private int building_type;

    @Schema(description = "Описание объекта ,required = true",example ="Описание объекта")
    private String description;

    @NotNull(message = "Адрес объекта (address) cannot be null")
    @Schema(description = "Адрес объекта ,required = true",example ="24")
    private String address;

    @NotNull(message = "Банковская оценка для стархования (sum_bank) cannot be null")
    @Schema(description = "Банковская оценка для стархования ,required = true",example ="100000")
    private long sum_bank;

    @NotNull(message = "Кадастровый владелец (is_owner) cannot be null")
    @Schema(description = "Кадастровый владелец(1-заемщик,0-не заемщик),required = true",example ="1")
    private int is_owner;

    @NotNull(message = "ФИО кадастрового владельца (subject_full_name) cannot be null")
    @Schema(description = "ФИО кадастрового владельца,required = true",example ="Nurqulov Jamshid Shavkat o'g'li")
    private String subject_full_name;


    public String getCadastr_issue_date() {
        if (cadastr_issue_date.isEmpty())
            return null;
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(cadastr_issue_date, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(outputFormatter);
    }
}
