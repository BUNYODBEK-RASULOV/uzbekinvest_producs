package com.example.uzbekinvest_producs.Bank.controller;

import com.example.uzbekinvest_producs.Bank.payload.request.BankPolisRequestDto;
import com.example.uzbekinvest_producs.Bank.payload.request.ContractCreateRequestDto;
import com.example.uzbekinvest_producs.Bank.payload.request.PaymentRequestDto;
import com.example.uzbekinvest_producs.Bank.payload.responce.ContractCreateResponseDto;
import com.example.uzbekinvest_producs.Bank.payload.responce.PaymentResponseDto;
import com.example.uzbekinvest_producs.Bank.payload.responce.PolisResponseDto;
import com.example.uzbekinvest_producs.Bank.service.BankService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bank")
@Tag(name = "Bank api",description = "Insurance agreement \"Credit\" (Credit), \"Autocredit\" (Pledge), Ipoteka")
@RequiredArgsConstructor
public class BankController {
    private final BankService bankService;
    @Operation(summary = "API request for drawing up an insurance contract:")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "completed successfully",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ContractCreateResponseDto.class)) }) })
    @PostMapping("/contract")
    public HttpEntity<?> contract(@Valid @RequestBody ContractCreateRequestDto createDto) {
        if (createDto.getLoan_info().getLoan_type().equals("24"))
            return ResponseEntity.ok(bankService.contractIpoteka(createDto));
        return ResponseEntity.ok(bankService.contract(createDto));
    }


    @Operation(summary = "These parameters will be sent after contract")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "completed successfully",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentResponseDto.class)) }) })
    @PostMapping("/payment")
    public HttpEntity<?> payment(@Valid @RequestBody PaymentRequestDto paymentDto) {
        return ResponseEntity.ok(bankService.payment(paymentDto));
    }

    @Operation(summary = "These parameters will be sent after payment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "completed successfully",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = PolisResponseDto.class)) }) })
    @PostMapping("/polis")
    public HttpEntity<?> polis(@Valid @RequestBody BankPolisRequestDto polisReq) {
        return ResponseEntity.ok(bankService.polis(polisReq));
    }
}
