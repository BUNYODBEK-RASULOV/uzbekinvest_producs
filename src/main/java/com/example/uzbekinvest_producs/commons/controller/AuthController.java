package com.example.uzbekinvest_producs.commons.controller;

import com.example.uzbekinvest_producs.commons.payload.request.LoginDTO;
import com.example.uzbekinvest_producs.commons.payload.response.ApiResponse;
import com.example.uzbekinvest_producs.commons.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
@RequestMapping("/api/products/auth")
@RequiredArgsConstructor
//@Tag(name = "Auth",description = "Authentication operations")
public class AuthController {
    private final AuthService authService;
//
//    @Operation(summary = "Get token by login password")
//    @ApiResponses(value = {
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "completed successfully",
//                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponse.class)) })})
//    @PostMapping("/login")
//    public HttpEntity<?> loginUser(@Valid @RequestBody LoginDTO loginDTO) {
//        return ResponseEntity.ok(authService.loginUser(loginDTO));
//    }
}
