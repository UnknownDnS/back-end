package com.unstar.backend.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.unstar.backend.constant.JsonFormatConstant;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RootResponseDTO<T> {

    private Integer code;

    private String errorMsg;

    private T response;

    @JsonFormat(pattern = JsonFormatConstant.YYYYMMDD_HHMMSS)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime timestamp;

    public RootResponseDTO<T> response(T response) {
        this.response = response;
        return this;
    }

    public RootResponseDTO<T> code(Integer code) {
        this.code = code;
        return this;
    }

    public RootResponseDTO<T> errorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    public RootResponseDTO<T> build() {
        this.timestamp = LocalDateTime.now();
        return this;
    }
}
