package com.example.uzbekinvest_producs.AnorBank.payload.responce;

import com.example.uzbekinvest_producs.commons.payload.response.ApiResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InitiateResponse extends ApiResponse {
    @Schema(description = "insurance premium",example ="1000")
    private Double insurance_premium;
    @Schema(description = "insurance liability",example ="10000")
    private Double insurance_liability;

    public InitiateResponse(int result, String result_message, Double insurance_premium, Double insurance_liability) {
        super(result, result_message);
        this.insurance_premium = insurance_premium;
        this.insurance_liability = insurance_liability;
    }

    public InitiateResponse(int result, String result_message) {
        super(result, result_message);
    }

}
