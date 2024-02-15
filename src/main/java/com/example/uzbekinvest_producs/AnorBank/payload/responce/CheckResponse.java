package com.example.uzbekinvest_producs.AnorBank.payload.responce;

import com.example.uzbekinvest_producs.commons.payload.response.ApiResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckResponse extends ApiResponse {
    @Schema(description = "polis status",example ="ВЫДАН")
    private String polis_status;
    @Schema(description = "polis begin",example ="2023-02-10T00:00:00Z")
    private String polis_begin;
    @Schema(description = "polis end",example ="2026-01-22T00:00:00Z")
    private String polis_end;
    @Schema(description = "polis owner",example ="ESONOV MAXAMADJON ABDUPATTAYEVICH , паспорт AB 6628635, ПИНФЛ 32803661220018")
    private String polis_owner;

    @Schema(description = "hiperlink",example ="https:/dvvsdf")
    private String hiperlink;



    public CheckResponse(int result, String result_message, String polis_status, String polis_begin, String polis_end, String polis_owner,String hiperlink) {
        super(result, result_message);
        this.polis_status = polis_status;
        this.polis_begin = polis_begin;
        this.polis_end = polis_end;
        this.polis_owner = polis_owner;
        this.hiperlink=hiperlink;
    }

    public CheckResponse(int result, String result_message) {
        super(result, result_message);
    }
}
