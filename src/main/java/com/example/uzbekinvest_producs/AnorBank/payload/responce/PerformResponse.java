package com.example.uzbekinvest_producs.AnorBank.payload.responce;

import com.example.uzbekinvest_producs.commons.payload.response.ApiResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PerformResponse extends ApiResponse {

    @Schema(description = "polis sery",example ="UI-ANOR")
    private String polis_sery;
    @Schema(description = "polis number",example ="265")
    private String polis_number;
    @Schema(description = "polis_end",example ="2026-01-22T00:00:00Z")
    private String polis_end;
    @Schema(description = "hiperlink",example ="https://eais.uzbekinvest.uz/ords/f?p=300:1:::NO:1:V1,V2:10919430,C60EF9EB4D31019FAF458A1384A324CB")
    private String hiperlink;

    public PerformResponse(int result, String result_message, String polis_sery, String polis_number, String polis_end, String hiperlink) {
        super(result, result_message);
        this.polis_sery = polis_sery;
        this.polis_number = polis_number;
        this.polis_end = polis_end;
        this.hiperlink = hiperlink;
    }

    public PerformResponse(int result, String result_message) {
        super(result, result_message);
    }
}
