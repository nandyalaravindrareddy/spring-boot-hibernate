package com.wellsfargo.service;

import com.wellsfargo.dto.GcpSAcctRole;
import com.wellsfargo.dto.SAcctRoleData;

import java.util.List;

public interface SAcctRoleService {

    SAcctRoleData saveSAcctRole(SAcctRoleData customer);
    boolean deleteSAcctRole(final Long customerId);
    List<GcpSAcctRole> getAllSAcctRoles();
    SAcctRoleData getSAcctRoleById(final Long sAcctRole);
}
