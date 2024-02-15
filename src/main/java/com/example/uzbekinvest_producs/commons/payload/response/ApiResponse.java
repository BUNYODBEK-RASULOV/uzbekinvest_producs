package com.example.uzbekinvest_producs.commons.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {
    @Schema(description = "0=Успешно, 1 и т.д=Ошибка",example ="0")
    private int result;

    @Schema(description = "Информацияо ответа текстом",example ="successful")
    private String result_message;
}
