package com.example.uzbekinvest_producs.Bank.payload.responce;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolisResponseDto {

    @Schema(description = "0=Успешно, 1 и т.д=Ошибка",example ="0")
    private int result;

    @Schema(description = "Информацияо ответа текстом",example ="successful")
    private String result_message;

    @Schema(description = "Наименования файла",example ="INB0007077.pdf")
    private String file_name;

    @Schema(description = "файл в виде base64String ",example ="successful")
    private String content_string;

    public PolisResponseDto(int result, String result_message) {
        this.result = result;
        this.result_message = result_message;
    }
}
