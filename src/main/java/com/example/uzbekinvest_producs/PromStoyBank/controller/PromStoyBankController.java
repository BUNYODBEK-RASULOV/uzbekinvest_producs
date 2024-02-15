package com.example.uzbekinvest_producs.PromStoyBank.controller;

import com.example.uzbekinvest_producs.PromStoyBank.payload.request.PSBPolisRequestDto;
import com.example.uzbekinvest_producs.PromStoyBank.payload.responce.PSBPolisResponseDto;
import com.example.uzbekinvest_producs.PromStoyBank.service.PromStoyBankService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/PromStoyBank")
@Tag(name = "PromStoyBank",description = "Insurance agreement ,")
@RequiredArgsConstructor
public class PromStoyBankController {
    private final PromStoyBankService service;


    @Operation(summary = "Check Police Request PSB",
            parameters = {
                    @Parameter(in = ParameterIn.HEADER, name = "USERNAME", description = "Имя пользователя", example = "SQB", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "PASSWORD", description = "Пароль", example = "password", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "AGENT_ID", description = "Уникальный идентификатор агента", example = "1", schema = @Schema(type = "Long")),
                    @Parameter(in = ParameterIn.HEADER, name = "POLIS_SERY", description = "Серия полиса", example = "UI-PSB", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "POLIS_NUMBER", description = "Номер полиса", example = "265", schema = @Schema(type = "Long")),
                    @Parameter(in = ParameterIn.HEADER, name = "POLIS_LNG", description = "Язык полиса (1 – русский, 2 – узбекский)", example = "1", schema = @Schema(type = "Long"))
            }
    )
    @PostMapping("/PolicyIssuanceRequest")
    public PSBPolisResponseDto polis(
            @RequestHeader(value ="USERNAME",required = false) String username ,
            @RequestHeader(value ="PASSWORD", required = false) String password,
            @RequestHeader(value ="AGENT_ID", required = false) Long agentId,
            @RequestHeader(value ="POLIS_SERY", required = false) String polSery,
            @RequestHeader(value ="POLIS_NUMBER",required = false) Integer polNum,
            @RequestHeader(value ="POLIS_LNG",required = false) Integer lng
    ) {
        return service.polis(new PSBPolisRequestDto(username,password,agentId,polSery,polNum,lng));
    }
}
