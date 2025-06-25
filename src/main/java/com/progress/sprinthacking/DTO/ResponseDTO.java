package com.progress.sprinthacking.DTO;

import com.progress.sprinthacking.Enums.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class ResponseDTO {
    private ResponseStatus status;
    private String message;
    private Map<String,Object> detail;
    public static ResponseDTO success(String message) {
        return new ResponseDTO(ResponseStatus.SUCCESS, message, null);
    }

    public static ResponseDTO success(String message, Map<String,Object> detail) {
        return new ResponseDTO(ResponseStatus.SUCCESS, message, detail);
    }

    public static ResponseDTO error(String message) {
        return new ResponseDTO(ResponseStatus.ERROR, message, null);
    }

    public static ResponseDTO error(String message, Map<String,Object> detail) {
        return new ResponseDTO(ResponseStatus.ERROR, message, detail);
    }

    public static ResponseDTO notFound(String message) {
        return new ResponseDTO(ResponseStatus.NOT_FOUND, message, null);
    }

    public static ResponseDTO badRequest(String message) {
        return new ResponseDTO(ResponseStatus.BAD_REQUEST, message, null);
    }

    public static ResponseDTO internalError(String message) {
        return new ResponseDTO(ResponseStatus.INTERNAL_SERVER_ERROR, message, null);
    }
}
