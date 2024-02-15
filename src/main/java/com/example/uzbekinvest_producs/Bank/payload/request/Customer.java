package com.example.uzbekinvest_producs.Bank.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Schema(description = "ИНН клиента если юр.л",example ="305898643")
    private long inn;

    @Schema(description = "ПИНФЛ клиента если физ.л",example ="30101995750028")
    private String pinfl;

    @Schema(description = "Паспорт серия и номер если физ.л.",example ="AB 0112138")
    private String passport;

    @Schema(description = "Полное имя клиента",example ="James jon smith")
    private String full_name;

    @Schema(description = "Номер телефона клиента",example ="+998990000101")
    private String phone;

    @Schema(description = "Адрес клиента",example ="Toshkent shahri, Chilonzor tumani, 20-mavze, 8-uy")
    private String address;

    @Schema(description = "Дата рождения если физ.л",example ="01.11.1999")
    private String birth_date="";

    @Schema(description = "Пол клиента если физ.л (2=Женщина, 1=Мужчина)",example ="1")
    private int gender;

    public String getBirth_date() {
        if (birth_date.isBlank())
            return birth_date;
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(birth_date, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(outputFormatter);
    }
}
