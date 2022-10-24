package com.wellsfargo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Resource {
    private String addr;
    private String module;
    private String resource;
    private String implied_provider;
    private String resource_type;
    private String resource_name;
    private String resource_key;

    @Override
    public String toString() {
        return "Resource{" +
                "addr='" + addr + '\'' +
                ", module='" + module + '\'' +
                ", resource='" + resource + '\'' +
                ", implied_provider='" + implied_provider + '\'' +
                ", resource_type='" + resource_type + '\'' +
                ", resource_name='" + resource_name + '\'' +
                ", resource_key='" + resource_key + '\'' +
                '}';
    }
}
