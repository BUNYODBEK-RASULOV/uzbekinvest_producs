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
public class ContractCreateResponseDto {

    @Schema(description = "0=Успешно, 1 и т.д=Ошибка",example ="0")
    private int result;

    @Schema(description = "Информацияо ответа текстом",example ="successful")
    private String result_message;

    @Schema(description = "Контракт номер или ид",example ="101256")
    private String contract_id;

    @Schema(description = "Страховая премия",example ="0.00")
    private double insurance_premium;

    @Schema(description = "Страховая ответственность",example ="0")
    private double insurance_liability;

    public ContractCreateResponseDto(int result, String result_message) {
        this.result = result;
        this.result_message = result_message;
    }
}
