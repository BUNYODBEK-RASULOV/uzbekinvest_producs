package com.example.uzbekinvest_producs.AnorBank.sevice;

import com.example.uzbekinvest_producs.AnorBank.payload.responce.CheckResponse;
import com.example.uzbekinvest_producs.AnorBank.payload.responce.InitiateResponse;
import com.example.uzbekinvest_producs.AnorBank.payload.responce.PerformResponse;
import com.example.uzbekinvest_producs.AnorBank.payload.responce.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import java.sql.Types;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AnorbankService {
    private final JdbcTemplate jdbcTemplate;

    public TokenResponse token(HttpHeaders headers){
        try {
            SimpleJdbcCall jdbcCall =
                    new SimpleJdbcCall(jdbcTemplate)
                            .withCatalogName("FOR_ASAKA_BANK_API")
                            .withFunctionName("Get_Token_Anorbank")
                            .declareParameters(
                                    new SqlOutParameter("out_result", Types.INTEGER),
                                    new SqlOutParameter("out_result_text", Types.VARCHAR)
                            );



            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("v_USERNAME",headers.getFirst("username"))
                    .addValue("v_PASSWORD", headers.getFirst("password"))
                    .addValue("v_TRANSACTION_ID", headers.getFirst("transaction_id"));


            Map<String, Object> out = jdbcCall.execute(in);
            return new TokenResponse(
                    Integer.parseInt(String.valueOf(out.get("out_result"))),
                    String.valueOf(out.get("out_result_text")),
                    String.valueOf(out.get("return")));
        }catch (Exception e){
            return new TokenResponse(-1,e.getMessage());
        }
    }

    public InitiateResponse initiate(HttpHeaders headers){
        try {
            SimpleJdbcCall jdbcCall =
                    new SimpleJdbcCall(jdbcTemplate)
                            .withCatalogName("FOR_ASAKA_BANK_API")
                            .withFunctionName("Insert_Anketa_Anorbank")
                            .declareParameters(
                                    new SqlOutParameter("out_result", Types.INTEGER),
                                    new SqlOutParameter("out_ins_prem", Types.DOUBLE),
                                    new SqlOutParameter("out_ins_otv", Types.DOUBLE)
                            );



            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("v_OBJTEXPSERY",headers.getFirst("objtexpsery"))
                    .addValue("v_CREDIT_DOGOVOR",headers.getFirst("credit_dogovor"))
                    .addValue("v_CREDIT_SUMMA",headers.getFirst("credit_summa"))
                    .addValue("v_ZALOGODATEL",headers.getFirst("zalogodatel"))
                    .addValue("v_OBJMARKA",headers.getFirst("objmarka"))
                    .addValue("v_PASSWORD",headers.getFirst("password"))
                    .addValue("v_CLIENT_PASSPORT",headers.getFirst("client_passport"))
                    .addValue("v_OBJGODVIPUSKA",headers.getFirst("objgodvipuska"))
                    .addValue("v_INSURANCE_COST",headers.getFirst("insurance_cost"))
                    .addValue("v_PERIOD_BEGIN",headers.getFirst("period_begin"))
                    .addValue("v_PERIOD_END",headers.getFirst("period_end"))
                    .addValue("v_INSURANCE_SUM",headers.getFirst("insurance_sum"))
                    .addValue("v_OBJMODEL",headers.getFirst("objmodel"))
                    .addValue("v_OBJTEXPASPNOMER",headers.getFirst("objtexpaspnomer"))
                    .addValue("v_ZALOGODATEL_PASSPORT",headers.getFirst("zalogodatel_passport"))
                    .addValue("v_ZALOGODATEL_PINFL",headers.getFirst("zalogodatel_pinfl"))
                    .addValue("v_ZALOGODATEL_PHONE",headers.getFirst("zalogodatel_phone"))
                    .addValue("v_OBJGOSNOMER",headers.getFirst("objgosnomer"))
                    .addValue("v_AGENT_ID",headers.getFirst("agent_id"))
                    .addValue("v_USERNAME",headers.getFirst("username"))
                    .addValue("v_CLIENT_PHONE",headers.getFirst("client_phone"))
                    .addValue("v_OBJECT",headers.getFirst("object"))
                    .addValue("v_PRODUCT_ID", headers.getFirst("product_id"))
                    .addValue("v_TOKEN", headers.getFirst("token"))
                    .addValue("v_CLIENT_NAME", headers.getFirst("client_name"))
                    .addValue("v_TRANSACTION_ID", headers.getFirst("transaction_id"))
                    .addValue("v_AGENT_PHONE", headers.getFirst("agent_phone"))
                    .addValue("v_OBJKUZOV", headers.getFirst("objkuzov"))
                    .addValue("v_CLIENT_PINFL", headers.getFirst("client_pinfl"))
                    .addValue("v_CLIENT_ADDRESS", headers.getFirst("client_address"))
                    .addValue("v_OBJDVIGATEL", headers.getFirst("objdvigatel"));


            Map<String, Object> out = jdbcCall.execute(in);
            return new InitiateResponse(
                    Integer.parseInt(String.valueOf(out.get("out_result"))),
                    String.valueOf(out.get("return")),
                    Double.parseDouble(String.valueOf(out.get("out_ins_prem"))),
                    Double.parseDouble(String.valueOf(out.get("out_ins_otv"))));
        }catch (Exception e){
            return new InitiateResponse(-1,e.getMessage());
        }
    }

    public InitiateResponse edit(HttpHeaders headers){
        try {
            SimpleJdbcCall jdbcCall =
                    new SimpleJdbcCall(jdbcTemplate)
                            .withCatalogName("FOR_ASAKA_BANK_API")
                            .withFunctionName("Edit_Anketa_Anorbank")
                            .declareParameters(
                                    new SqlOutParameter("out_result", Types.INTEGER),
                                    new SqlOutParameter("out_ins_prem", Types.DOUBLE),
                                    new SqlOutParameter("out_ins_otv", Types.DOUBLE)
                            );



            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("v_OBJDVIGATEL",headers.getFirst("objdvigatel"))
                    .addValue("v_OBJECT",headers.getFirst("object"))
                    .addValue("v_OBJGODVIPUSKA",headers.getFirst("objgodvipuska"))
                    .addValue("v_OBJGOSNOMER",headers.getFirst("objgosnomer"))
                    .addValue("v_OBJKUZOV",headers.getFirst("objkuzov"))
                    .addValue("v_OBJMARKA",headers.getFirst("objmarka"))
                    .addValue("v_OBJMODEL",headers.getFirst("objmodel"))
                    .addValue("v_OBJTEXPASPNOMER",headers.getFirst("objtexpaspnomer"))
                    .addValue("v_OBJTEXPSERY",headers.getFirst("objtexpsery"))
                    .addValue("v_OBJZVET",headers.getFirst("objzvet"))
                    .addValue("v_PASSWORD",headers.getFirst("password"))
                    .addValue("v_TOKEN",headers.getFirst("token"))
                    .addValue("v_TRANSACTION_ID",headers.getFirst("transaction_id"))
                    .addValue("v_USERNAME",headers.getFirst("username"))
                    .addValue("v_ZALOGODATEL",headers.getFirst("zalogodatel"))
                    .addValue("v_ZALOGODATEL_PASSPORT",headers.getFirst("zalogodatel_passport"))
                    .addValue("v_ZALOGODATEL_PHONE",headers.getFirst("zalogodatel_phone"))
                    .addValue("v_ZALOGODATEL_PINFL",headers.getFirst("zalogodatel_pinfl"));


            Map<String, Object> out = jdbcCall.execute(in);
            return new InitiateResponse(
                    Integer.parseInt(String.valueOf(out.get("out_result"))),
                    String.valueOf(out.get("return")));
//                    Double.parseDouble(String.valueOf(out.get("out_ins_prem"))),
//                    Double.parseDouble(String.valueOf(out.get("out_ins_otv"))));
        }catch (Exception e){
            return new InitiateResponse(-1,e.getMessage());
        }
    }

    public PerformResponse perform(HttpHeaders headers) {
        try {
            SimpleJdbcCall jdbcCall =
                    new SimpleJdbcCall(jdbcTemplate)
                            .withCatalogName("FOR_ASAKA_BANK_API")
                            .withFunctionName("Insert_Oplata_Polis_Anorbank")
                            .declareParameters(
                                    new SqlOutParameter("out_result", Types.INTEGER),
                                    new SqlOutParameter("out_psery", Types.VARCHAR),
                                    new SqlOutParameter("out_pnumber", Types.INTEGER),
                                    new SqlOutParameter("out_polis_end", Types.VARCHAR),
                                    new SqlOutParameter("out_hiperlink", Types.VARCHAR)
                            );

            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("v_TOKEN",headers.getFirst("token"))
                    .addValue("v_PERIOD_BEGIN",headers.getFirst("period_begin"))
                    .addValue("v_PASSWORD",headers.getFirst("password"))
                    .addValue("v_PAYMENT_DATE",headers.getFirst("payment_date"))
                    .addValue("v_AGENT_PHONE",headers.getFirst("agent_phone"))
                    .addValue("v_TRANSACTION_ID",headers.getFirst("transaction_id"))
                    .addValue("v_USERNAME",headers.getFirst("username"))
                    .addValue("v_AGENT_ID",headers.getFirst("agent_id"))
                    .addValue("v_PAYMENT_TYPE",headers.getFirst("payment_type"));


            Map<String, Object> out = jdbcCall.execute(in);
            return new PerformResponse(
                    Integer.parseInt(String.valueOf(out.get("out_result"))),
                    String.valueOf(out.get("return")),
                    String.valueOf(out.get("out_psery")),
                    String.valueOf(out.get("out_pnumber")),
                    String.valueOf(out.get("out_polis_end")),
                    String.valueOf(out.get("out_hiperlink")));
        }catch (Exception e){
            return new PerformResponse(-1,e.getMessage());
        }
    }

    public CheckResponse check(HttpHeaders headers) {
        try {
            SimpleJdbcCall jdbcCall =
                    new SimpleJdbcCall(jdbcTemplate)
                            .withCatalogName("FOR_ASAKA_BANK_API")
                            .withFunctionName("Check_Polis_Anorbank")
                            .declareParameters(
                                    new SqlOutParameter("out_result", Types.INTEGER),
                                    new SqlOutParameter("out_polis_status", Types.VARCHAR),
                                    new SqlOutParameter("out_polis_begin", Types.VARCHAR),
                                    new SqlOutParameter("out_polis_end", Types.VARCHAR),
                                    new SqlOutParameter("out_polis_owner", Types.VARCHAR),
                                    new SqlOutParameter("out_hiperlink", Types.VARCHAR)
                            );



            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("v_USERNAME",headers.getFirst("username"))
                    .addValue("v_PASSWORD",headers.getFirst("password"))
                    .addValue("v_AGENT_ID",headers.getFirst("agent_id"))
                    .addValue("v_polis_sery",headers.getFirst("polis_sery"))
                    .addValue("v_polis_number",headers.getFirst("polis_number"))
                    .addValue("v_TRANSACTION_ID",headers.getFirst("transaction_id"))
                    .addValue("v_TOKEN",headers.getFirst("token"));


            Map<String, Object> out = jdbcCall.execute(in);
            return
                    new CheckResponse(
                            Integer.parseInt(String.valueOf(out.get("out_result"))),
                            String.valueOf(out.get("return")),
                            String.valueOf(out.get("out_polis_status")),
                            String.valueOf(out.get("out_polis_begin")),
                            String.valueOf(out.get("out_polis_end")),
                            String.valueOf(out.get("out_polis_owner")),
                            String.valueOf(out.get("out_hiperlink"))
                            );
        }catch (Exception e){
            return new CheckResponse(-1,e.getMessage());
        }

    }
}
