package com.wellsfargo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TfResponse {
    private String level;
    private String message;
    private String module;
    private String timestamp;
    private Hook hook;
    private String type;

    @Override
    public String toString() {
        return "TfResponse{" +
                "level='" + level + '\'' +
                ", message='" + message + '\'' +
                ", module='" + module + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", hook=" + hook +
                ", type='" + type + '\'' +
                '}';
    }
}
