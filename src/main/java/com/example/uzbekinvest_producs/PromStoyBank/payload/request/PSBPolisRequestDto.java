package com.example.uzbekinvest_producs.PromStoyBank.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PSBPolisRequestDto {
    private String username;
    private String password;
    private Long agentId;
    private String polis_sery;
    private Integer polis_number;
    private Integer lng;
}
