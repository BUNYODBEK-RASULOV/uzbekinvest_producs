package com.example.uzbekinvest_producs.Bank.payload.responce;


import com.example.uzbekinvest_producs.commons.payload.response.ApiResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentResponseDto extends ApiResponse {

    @Schema(description = "polis sery",example ="INB")
    private String polis_sery;

    @Schema(description = "polis number",example ="0000707")
    private String polis_number;

    public PaymentResponseDto(int result, String result_message) {
        super(result,result_message);
    }

    public PaymentResponseDto(int result, String result_message, String polis_sery, String polis_number) {
        super(result, result_message);
        this.polis_sery = polis_sery;
        this.polis_number = polis_number;
    }

}
