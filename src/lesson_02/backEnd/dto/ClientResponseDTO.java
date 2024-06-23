package lesson_02.backEnd.dto;

import java.util.List;

public class ClientResponseDTO<T> {
    private Integer responseCode;
    private T responseInfo;
    private List<String> errors;

    public ClientResponseDTO(Integer responseCode, T responseInfo, List<String> errors) {
        this.responseCode = responseCode;
        this.responseInfo = responseInfo;
        this.errors = errors;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public T getResponseInfo() {
        return responseInfo;
    }

    public List<String> getErrors() {
        return errors;
    }
}
