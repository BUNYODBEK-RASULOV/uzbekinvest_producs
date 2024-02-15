package com.example.uzbekinvest_producs.Bank.service;

import com.example.uzbekinvest_producs.Bank.payload.request.BankPolisRequestDto;
import com.example.uzbekinvest_producs.Bank.payload.request.ContractCreateRequestDto;
import com.example.uzbekinvest_producs.Bank.payload.request.PaymentRequestDto;
import com.example.uzbekinvest_producs.Bank.payload.responce.ContractCreateResponseDto;
import com.example.uzbekinvest_producs.Bank.payload.responce.PaymentResponseDto;
import com.example.uzbekinvest_producs.Bank.payload.responce.PolisResponseDto;
import com.example.uzbekinvest_producs.commons.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.sql.Types;
import java.util.Base64;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BankService {
    private final JdbcTemplate jdbcTemplate;

    public ContractCreateResponseDto contract(ContractCreateRequestDto contract)  {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity users=(UserEntity) authentication.getPrincipal();

        try {


            SimpleJdbcCall jdbcCall =
                    new SimpleJdbcCall(jdbcTemplate)
                            .withCatalogName("FOR_ASAKA_BANK_API")
                            .withFunctionName("Insert_Anketa")
                            .declareParameters(
                                    new SqlOutParameter("out_error", Types.INTEGER),
                                    new SqlOutParameter("out_ins_prem", Types.DOUBLE),
                                    new SqlOutParameter("out_ins_otv", Types.DOUBLE)
                            );



            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("v_fizyur", contract.getSubject().equals("P") ? 0 : 1)
                    .addValue("v_inn", contract.getCustomer().getInn())
                    .addValue("v_pinfl", contract.getCustomer().getPinfl())
                    .addValue("v_passport", contract.getCustomer().getPassport())
                    .addValue("v_full_name", contract.getCustomer().getFull_name())
                    .addValue("v_phone", contract.getCustomer().getPhone())
                    .addValue("v_address", contract.getCustomer().getAddress())
                    .addValue("v_birth_date",contract.getCustomer().getBirth_date().isBlank() ? null:contract.getCustomer().getBirth_date(),Types.DATE)
                    .addValue("v_gender", contract.getCustomer().getGender())
                    .addValue("v_claim_id", contract.getLoan_info().getClaim_id())
                    .addValue("v_loan_type", contract.getLoan_info().getLoan_type())
                    .addValue("v_loan_total", contract.getLoan_info().getLoan_total())
                    .addValue("v_loan_amount", contract.getLoan_info().getLoan_amount())
                    .addValue("v_loan_term", contract.getLoan_info().getLoan_term())
                    .addValue("v_start_date", contract.getLoan_info().getS_date(), Types.DATE)
                    .addValue("v_end_date", contract.getLoan_info().getE_date(), Types.DATE)
                    .addValue("v_ins_coef", contract.getLoan_info().getInsurance_coefficient())
                    .addValue("v_object_brand", contract.getLoan_info().getObject_brand())
                    .addValue("v_object_name", contract.getLoan_info().getObject_name())
                    .addValue("v_org_mfo", contract.getOrganization().getMfo())
                    .addValue("v_org_inn", contract.getOrganization().getInn())
                    .addValue("v_org_name", contract.getOrganization().getName())
                    .addValue("v_org_name", contract.getOrganization().getName()) //buni uchirish kerak
                    .addValue("v_org_address", contract.getOrganization().getAddress())
                    .addValue("v_user_id", users.getTbId())
                    .addValue("v_user_div", users.getTbDivision());


            Map<String, Object> out = jdbcCall.execute(in);
            int result = (int) out.get("out_error");
            if (result == 0)
                return new ContractCreateResponseDto(result, "successful", (String) out.get("return"), (double) out.get("out_ins_prem"), (double) out.get("out_ins_otv"));

            return new ContractCreateResponseDto(result, (String) out.get("return"));
        }catch (Exception e){
            return new ContractCreateResponseDto(1, e.getMessage());
        }
    }

    public ContractCreateResponseDto contractIpoteka(ContractCreateRequestDto contract) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity users = (UserEntity) authentication.getPrincipal();


        SimpleJdbcCall jdbcCall =
                new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName("FOR_ASAKA_BANK_API")
                        .withFunctionName("Insert_AnketaKochmasMulk")
                        .declareParameters(
                                new SqlOutParameter("out_error", Types.INTEGER),
                                new SqlOutParameter("out_ins_prem", Types.DOUBLE),
                                new SqlOutParameter("out_ins_otv", Types.DOUBLE)
                        );


        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("v_fizyur", contract.getSubject().equals("P") ? 0 : 1)
                .addValue("v_inn", contract.getCustomer().getInn())
                .addValue("v_pinfl", contract.getCustomer().getPinfl())
                .addValue("v_passport", contract.getCustomer().getPassport())
                .addValue("v_full_name", contract.getCustomer().getFull_name())
                .addValue("v_phone", contract.getCustomer().getPhone())
                .addValue("v_address", contract.getCustomer().getAddress())
                .addValue("v_birth_date", contract.getCustomer().getBirth_date().isBlank() ? null : contract.getCustomer().getBirth_date(), Types.DATE)
                .addValue("v_gender", contract.getCustomer().getGender())
                .addValue("v_claim_id", contract.getLoan_info().getClaim_id())
                .addValue("v_loan_type", contract.getLoan_info().getLoan_type())
                .addValue("v_loan_total", contract.getLoan_info().getLoan_total())
                .addValue("v_loan_amount", contract.getLoan_info().getLoan_amount())
                .addValue("v_loan_term", contract.getLoan_info().getLoan_term())
                .addValue("v_start_date", contract.getLoan_info().getS_date(), Types.DATE)
                .addValue("v_end_date", contract.getLoan_info().getE_date(), Types.DATE)
                .addValue("v_org_mfo", contract.getOrganization().getMfo())
                .addValue("v_org_inn", contract.getOrganization().getInn())
                .addValue("v_org_name", contract.getOrganization().getName())
                .addValue("v_region_code", contract.getLoan_info().getCadastr_info().getRegion_code())////////
                .addValue("v_right_land_type", contract.getLoan_info().getCadastr_info().getRight_land_type())
                .addValue("v_is_foreign", contract.getLoan_info().getCadastr_info().getIs_foreign())
                .addValue("v_cadastr_number", contract.getLoan_info().getCadastr_info().getCadastr_number())
                .addValue("v_cadastr_issue_date", contract.getLoan_info().getCadastr_info().getCadastr_issue_date(), Types.DATE)
                .addValue("v_building_type", contract.getLoan_info().getCadastr_info().getBuilding_type())
                .addValue("v_description", contract.getLoan_info().getCadastr_info().getDescription())
                .addValue("v_cadastr_address", contract.getLoan_info().getCadastr_info().getAddress())
                .addValue("v_sum_bank", contract.getLoan_info().getCadastr_info().getSum_bank())
                .addValue("v_is_owner", contract.getLoan_info().getCadastr_info().getIs_owner())
                .addValue("v_subject_full_name", contract.getLoan_info().getCadastr_info().getSubject_full_name())
                .addValue("v_user_id", users.getTbId())
                .addValue("v_user_div", users.getTbDivision());


        Map<String, Object> out = jdbcCall.execute(in);
        int result = (int) out.get("out_error");
        if (result == 0)
            return new ContractCreateResponseDto(result, "successful", (String) out.get("return"), (double) out.get("out_ins_prem"), (double) out.get("out_ins_otv"));
        return new ContractCreateResponseDto(result, (String) out.get("return"));

    }
    public PaymentResponseDto payment(PaymentRequestDto payment)  {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity users=(UserEntity) authentication.getPrincipal();

        try {
            SimpleJdbcCall jdbcCall =
                    new SimpleJdbcCall(jdbcTemplate)
                            .withCatalogName("FOR_ASAKA_BANK_API")
                            .withFunctionName("Insert_Oplata_Polis")
                            .declareParameters(
                                    new SqlOutParameter("out_psery", Types.VARCHAR)
                            );

            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("v_anketa_id",payment.getContract_id() )
                    .addValue("v_contract_number", payment.getContract_number())
                    .addValue("v_payment_date", payment.getPayment_date(),Types.DATE)
                    .addValue("v_contract_date", payment.getContract_date(),Types.DATE)
                    .addValue("v_s_date", payment.getS_date(),Types.DATE)
                    .addValue("v_e_date",payment.getE_date(),Types.DATE)
                    .addValue("v_user_id",users.getTbId())
                    .addValue("v_user_div",users.getTbDivision());


            Map<String, Object> out = jdbcCall.execute(in);
            String series=(String) out.get("out_psery");
            if (!series.equals("1"))
                return new PaymentResponseDto(0,"successful",series,(String)out.get("return"));
            return new PaymentResponseDto(1,(String)out.get("return"));
        }catch (Exception e){
        return new PaymentResponseDto(1,"paynet failed");
        }
    }

    public PolisResponseDto polis(BankPolisRequestDto polis)  {
        try {
            SimpleJdbcCall jdbcCall =
                    new SimpleJdbcCall(jdbcTemplate)
                            .withCatalogName("FOR_ASAKA_BANK_API")
                            .withProcedureName("Generate_epolis_pdf")
                            .declareParameters(
                                    new SqlOutParameter("v_blob",Types.BLOB)
                            );
            SqlParameterSource in = new MapSqlParameterSource()

                    .addValue("p_seria", polis.getPolis_sery().toUpperCase() )
                    .addValue("p_number", polis.getPolis_number() );
            Map<String, Object> out = jdbcCall.execute(in);
            Blob blob = (Blob) out.get("v_blob");

            byte[] bytes = blob.getBytes(1, (int) blob.length());
            return new PolisResponseDto(0,"Успешная обработка запроса.",polis.getPolis_sery().toUpperCase()+polis.getPolis_number()+".pdf",Base64.getEncoder().encodeToString(bytes));
        }catch (Exception e){
            return new PolisResponseDto(1,"polis not found");
        }
}

}
