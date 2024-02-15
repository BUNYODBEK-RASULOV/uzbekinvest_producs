package com.example.uzbekinvest_producs.Bank.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankPolisRequestDto {

    @Schema(description = "Серия полиса",example ="UI-EP-ASB")
    @NotNull(message = "polis_sery cannot be null")
    private String polis_sery;

    @Schema(description = "Номер полиса",example ="0000707")
    @NotNull(message = "polis_number cannot be null")
    private String polis_number;
}
