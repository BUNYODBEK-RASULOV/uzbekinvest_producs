package com.example.uzbekinvest_producs.PromStoyBank.service;

import com.example.uzbekinvest_producs.PromStoyBank.payload.request.PSBPolisRequestDto;
import com.example.uzbekinvest_producs.PromStoyBank.payload.responce.PSBPolisResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.sql.Types;
import java.util.Base64;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PromStoyBankService {
    private final JdbcTemplate jdbcTemplate;

    public PSBPolisResponseDto polis(PSBPolisRequestDto polis)  {

        try {
            SimpleJdbcCall jdbcCall =
                    new SimpleJdbcCall(jdbcTemplate)
                            .withProcedureName("generate_policy_for_PCB")
                            .declareParameters(
                                    new SqlOutParameter("err_code",Types.INTEGER),
                                    new SqlOutParameter("err_message",Types.VARCHAR),
                                    new SqlOutParameter("v_blob",Types.BLOB)
                            );
            SqlParameterSource in = new MapSqlParameterSource()

                    .addValue("username", polis.getUsername() )
                    .addValue("password", polis.getPassword() )
                    .addValue("agent",polis.getAgentId() )
                    .addValue("polsery", polis.getPolis_sery() )
                    .addValue("polnum", polis.getPolis_number() )
                    .addValue("polis_lng", polis.getLng() );
            Map<String, Object> out = jdbcCall.execute(in);

            int err_code =Integer.parseInt(String.valueOf(out.get("err_code")));
            String err_message =String.valueOf(out.get("err_message"));
            Blob blob = (Blob) out.get("v_blob");
            if (err_code !=0 || blob==null)
                return new PSBPolisResponseDto(err_code,err_message);

            byte[] bytes = blob.getBytes(1, (int) blob.length());
            return new PSBPolisResponseDto(err_code,err_message,polis.getPolis_sery().toUpperCase()+polis.getPolis_number()+".pdf",Base64.getEncoder().encodeToString(bytes));
        }catch (Exception e){
            return new PSBPolisResponseDto(100,"Системная ошибка при обработке запроса.");
        }
}

}
