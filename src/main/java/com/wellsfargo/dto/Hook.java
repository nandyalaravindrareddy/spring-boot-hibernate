package com.wellsfargo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hook {
    private Resource resource;
    private String action;
    private String id_key;
    private String id_value;
    private String elapsed_seconds;

    @Override
    public String toString() {
        return "Hook{" +
                "resource=" + resource +
                ", action='" + action + '\'' +
                ", id_key='" + id_key + '\'' +
                ", id_value='" + id_value + '\'' +
                ", elapsed_seconds='" + elapsed_seconds + '\'' +
                '}';
    }
}
