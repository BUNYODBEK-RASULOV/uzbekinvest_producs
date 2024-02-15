package com.example.uzbekinvest_producs.AnorBank.payload.responce;

import com.example.uzbekinvest_producs.commons.payload.response.ApiResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponse extends ApiResponse {
    @Schema(description = "Информацияо ответа token",example ="fgfkjhjj")
    private String token;

    public TokenResponse(int result, String result_message, String token) {
        super(result, result_message);
        this.token = token;
    }

    public TokenResponse(int result, String result_message) {
        super(result, result_message);
    }

}
