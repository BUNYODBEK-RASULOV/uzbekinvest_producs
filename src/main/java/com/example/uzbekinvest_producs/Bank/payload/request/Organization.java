package com.example.uzbekinvest_producs.Bank.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization {

    @Schema(description = "МФО организация (банковский идентификационный код), required = true",example ="01010")
    private Long mfo;

    @Schema(description = "ИНН организация, required = true",example ="305898643")
    private String inn;

    @Schema(description = "Наименования организация, required = true",example ="MCHJ LIBRETEK")
    private String name;

    @Schema(description = "Адрес организация, required = true",example ="Toshkent shahri, Chilonzor tumani, 20-mavze, 8-uy")
    private String address;

}
