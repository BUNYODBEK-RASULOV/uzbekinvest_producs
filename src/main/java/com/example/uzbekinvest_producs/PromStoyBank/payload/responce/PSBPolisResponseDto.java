package com.example.uzbekinvest_producs.PromStoyBank.payload.responce;

import com.example.uzbekinvest_producs.commons.payload.response.ApiResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PSBPolisResponseDto extends ApiResponse {

    @Schema(description = "Наименования файла",example ="INB0007077.pdf")
    private String file_name;

    @Schema(description = "файл в виде base64String ",example ="successful")
    private String content_string;

    public PSBPolisResponseDto(int result, String result_message) { super(result,result_message); }

    public PSBPolisResponseDto(int result, String result_message, String file_name, String content_string) {
        super(result, result_message);
        this.file_name = file_name;
        this.content_string = content_string;
    }

    public PSBPolisResponseDto(String file_name, String content_string) {
        this.file_name = file_name;
        this.content_string = content_string;
    }
}
