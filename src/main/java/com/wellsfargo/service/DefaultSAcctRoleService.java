package com.wellsfargo.service;

import com.wellsfargo.data.SAcctRole;
import com.wellsfargo.dto.GcpSAcctRole;
import com.wellsfargo.dto.SAcctRoleData;
import com.wellsfargo.repository.SAcctRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("sAcctRoleService")
public class DefaultSAcctRoleService implements SAcctRoleService {

    @Autowired
    private SAcctRoleRepository sAcctRoleRepository;


    @Override
    public SAcctRoleData saveSAcctRole(SAcctRoleData sAcctRoleData) {
        SAcctRole SAcctRoleModel = populateCustomerEntity(sAcctRoleData);
        return populateSAcctRoleData(sAcctRoleRepository.save(SAcctRoleModel));
    }


    @Override
    public boolean deleteSAcctRole(Long sAcctRoleId) {
        sAcctRoleRepository.deleteById(sAcctRoleId);
        return true;
    }


    @Override
    public List<GcpSAcctRole> getAllSAcctRoles() {
        List<GcpSAcctRole> sAcctRoles = new ArrayList<>();
        List<SAcctRole> SAcctRoleList = sAcctRoleRepository.findAll();
        SAcctRoleList.forEach(sAcctRole -> {
            SAcctRoleData sAcctRoleData = populateSAcctRoleData(sAcctRole);
            HashMap<String,String> map = new HashMap<String,String>();
            map.put(sAcctRoleData.getProjectId(),sAcctRoleData.getRole());
            GcpSAcctRole gcpSAcctRole = GcpSAcctRole.builder().acctId(sAcctRoleData.getAcct_id())
                    .displayName(sAcctRoleData.getDisplayName())
                    .projectRolePair(map).build();
            sAcctRoles.add(gcpSAcctRole);
        });
        return sAcctRoles;
    }


    @Override
    public SAcctRoleData getSAcctRoleById(Long sAcctRoleId) {
        return populateSAcctRoleData( sAcctRoleRepository.findById(sAcctRoleId).orElseThrow(() -> new EntityNotFoundException("SAcctRoleId not found")));
    }


    private SAcctRoleData populateSAcctRoleData(final SAcctRole sAcctRole){
        SAcctRoleData sAcctRoleData = new SAcctRoleData();
        sAcctRoleData.setId(sAcctRole.getId());
        sAcctRoleData.setAcct_id(sAcctRole.getAcct_id());
        sAcctRoleData.setRole(sAcctRole.getRole());
        sAcctRoleData.setProjectId(sAcctRole.getProjectId());
        sAcctRoleData.setDisplayName(sAcctRole.getDisplayName());
        return sAcctRoleData;
    }


    private SAcctRole populateCustomerEntity(SAcctRoleData SAcctRoleData){
        SAcctRole sAcctRole = new SAcctRole();
        sAcctRole.setAcct_id(SAcctRoleData.getAcct_id());
        sAcctRole.setRole(SAcctRoleData.getRole());
        sAcctRole.setProjectId(SAcctRoleData.getProjectId());
        sAcctRole.setDisplayName(SAcctRoleData.getDisplayName());
        return sAcctRole;
    }
}
