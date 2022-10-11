package com.wellsfargo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GcpSAcctRole {
    @JsonProperty("acct_id")
    private String acctId;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("project-role-pairs")
    private Map<String,String> projectRolePair;
}
