package com.example.uzbekinvest_producs.AnorBank.controller;

import com.example.uzbekinvest_producs.AnorBank.payload.responce.CheckResponse;
import com.example.uzbekinvest_producs.AnorBank.payload.responce.InitiateResponse;
import com.example.uzbekinvest_producs.AnorBank.payload.responce.PerformResponse;
import com.example.uzbekinvest_producs.AnorBank.payload.responce.TokenResponse;
import com.example.uzbekinvest_producs.AnorBank.sevice.AnorbankService;
import com.example.uzbekinvest_producs.commons.payload.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;


@RestController
@RequestMapping("/api/anorbank")
@RequiredArgsConstructor
public class AnorBankController {
    private final AnorbankService service;


    @Operation(summary = "Get token by login password",
           parameters = {
            @Parameter(in= ParameterIn.HEADER,name = "username" ,description = "this is username",example = "username",schema = @Schema(type = "String")),
            @Parameter(in= ParameterIn.HEADER,name = "password" ,description = "this is password",example = "password",schema = @Schema(type = "String")),
            @Parameter(in= ParameterIn.HEADER,name = "transaction_id" ,description = "this is transaction id",example = "1",schema = @Schema(type = "String"))
           }
    )

    @PostMapping(path = "/get_token")
    public TokenResponse getToken( @RequestHeader HttpHeaders headers ){
        return service.token(headers);
    }



    @Operation(summary = "Initiate Transaction Request",
            parameters = {
                    @Parameter(in = ParameterIn.HEADER, name = "username", description = "Username", example = "ANOR_BANK", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "password", description = "Password", example = "0902", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "transaction_id", description = "Transaction ID", example = "34", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "agent_id", description = "Agent ID", example = "1", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "agent_phone", description = "Agent Phone", example = "1290", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "period_begin", description = "Period Begin", example = "10.02.2023", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "product_id", description = "Product ID", example = "207", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "client_name", description = "Client Name", example = "RVNPTk9WIE1BWEFNQURKT04gQUJEVVBBVFRBWUVWSUNI", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "client_address", description = "Client Address", example = "0KDQtdGB0L/Rg9Cx0LvQuNC60LAg0KPQt9Cx0LXQutC40YHRgtCw0L0sINCQ0L3QtNC40LbQsNC90YHQutCw0Y8g0J7QsdC70LDRgdGC0YwsINCQ0L3QtNC40LbQsNC90YHQutC40Lkg0YDQsNC50L7QvSwg0JTRntGB0YLQu9C40Log0JzQodCTLCDRg9C7LiDQqNCe0JTQm9CY0JosINC0LiAzNg==", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "client_phone", description = "Client Phone", example = "998966026067", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "client_passport", description = "Client Passport", example = "AB 6628635", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "client_pinfl", description = "Client PINFL", example = "32803661220018", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "object", description = "Object", example = "Chevrolet Concorde       reg number 01V893AB", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "insurance_cost", description = "Insurance Cost", example = "175000000", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "period_end", description = "Period End", example = "22.01.2026", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "credit_dogovor", description = "Credit Dogovor", example = "23.01.2023", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "credit_summa", description = "Credit Summa", example = "100000000", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "zalogodatel", description = "Zalogodatel", example = "RVNPTk9WIE1BWEFNQURKT04gQUJEVVBBVFRBWUVWSUNI", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "objmarka", description = "Obj Marka", example = "Chevrolet", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "objmodel", description = "Obj Model", example = "Q29uY29yZGU=", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "objzvet", description = "Obj Zvet", example = "0LHQtdC20LXQstGL0Lk=", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "objgosnomer", description = "Obj Gosnomer", example = "01V893AB", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "objtexpsery", description = "Obj Texpsery", example = "", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "objtexpaspnomer", description = "Obj Texpaspnomer", example = "AAE0313180", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "objgodvipuska", description = "Obj Godvipuska", example = "2018", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "objkuzov", description = "Obj Kuzov", example = "WWWWWDDSDADDASDSA", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "objdvigatel", description = "Obj Dvigatel", example = "DSDKSMAKMDKSAMDK", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "insurance_sum", description = "Insurance Sum", example = "150000000", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "zalogodatel_passport", description = "Zalogodatel Passport", example = "AA 6628635", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "zalogodatel_phone", description = "Zalogodatel Phone", example = "998966026067", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "zalogodatel_pinfl", description = "zalogodatel pinfl", example = "42803661220018", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "token", description = "token", example = "4E0ACC864EA72D6B7CB6A72FD65B2849", schema = @Schema(type = "String"))
            }
    )

    @PostMapping(path = "/InitiateTransactionRequest")
    public InitiateResponse initiate(@RequestHeader HttpHeaders headers ){
        return service.initiate(headers);
    }



    @Operation(summary = "Edit Transaction Request",
            parameters = {
                    @Parameter(in = ParameterIn.HEADER, name = "username", description = "Username", example = "ANOR_BANK", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "password", description = "Password", example = "0902", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "transaction_id", description = "Transaction ID", example = "34", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "object", description = "Object", example = "karta 0862569874122544", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "zalogodatel", description = "Zalogodatel", example = "zalogodatel", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "objmarka", description = "Obj Marka", example = "", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "objmodel", description = "Obj Model", example = "Q29uY29yZGU=", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "objzvet", description = "Obj Zvet", example = "0LHQtdC20LXQstGL0Lk=", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "objgosnomer", description = "Obj Gosnomer", example = "10H890KA111", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "objtexpsery", description = "Obj Texpsery", example = "", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "objtexpaspnomer", description = "Obj Texpaspnomer", example = "AAF 1234567", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "objgodvipuska", description = "Obj Godvipuska", example = "2015", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "objkuzov", description = "Obj Kuzov", example = "XWB5Y31BVNA540856", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "objdvigatel", description = "Obj Dvigatel", example = "RVNPTk9WIE1BWEFNQURKT04gQUJEVVBBVFRBWUVWSUNI", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "zalogodatel_passport", description = "Zalogodatel Passport", example = "BB 9999999", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "zalogodatel_pinfl", description = "Zalogodatel PINFL", example = "42803661220099", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "zalogodatel_phone", description = "Zalogodatel Phone", example = "998666026067", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "token", description = "Token", example = "4E0ACC864EA72D6B7CB6A72FD65B2849", schema = @Schema(type = "String"))
            }
    )
    @PostMapping(path = "/EditTransactionRequest")
    public InitiateResponse edit(@RequestHeader HttpHeaders headers ){
        return service.edit(headers);
    }


    @Operation(summary = "Perform Transaction Request",
            parameters = {
                    @Parameter(in = ParameterIn.HEADER, name = "username", description = "Username", example = "ANOR_BANK", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "password", description = "Password", example = "0902", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "transaction_id", description = "Transaction ID", example = "34", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "agent_id", description = "Agent ID", example = "1", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "agent_phone", description = "Agent Phone", example = "781200370", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "period_begin", description = "Period Begin", example = "10.02.2023", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "payment_date", description = "Payment Date", example = "10.02.2023", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "payment_type", description = "Payment Type", example = "Payment_type", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "token", description = "Token", example = "4E0ACC864EA72D6B7CB6A72FD65B2849", schema = @Schema(type = "String"))
            }
    )
    @PostMapping(path = "/PerformTransactionRequest")
    public PerformResponse perform(@RequestHeader HttpHeaders headers ){
        return service.perform(headers);
    }


    @Operation(summary = "Check Police Request",
            parameters = {
                    @Parameter(in = ParameterIn.HEADER, name = "username", description = "Username", example = "ANOR_BANK", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "password", description = "Password", example = "0902", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "agent_id", description = "Agent ID", example = "1", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "polis_sery", description = "Polis Sery", example = "UI-ANOR", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "polis_number", description = "Polis Number", example = "265", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "transaction_id", description = "Transaction ID", example = "34", schema = @Schema(type = "String")),
                    @Parameter(in = ParameterIn.HEADER, name = "token", description = "Token", example = "AC99FDC66E1FEE36729E03C38FADA8FD", schema = @Schema(type = "String"))
    }
    )
    @PostMapping(path = "/CheckPolisRequest")
    public CheckResponse checkPolice(@RequestHeader HttpHeaders headers ){
        return service.check(headers);
    }
}
