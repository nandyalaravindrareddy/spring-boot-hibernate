package com.wellsfargo.controller;

import com.wellsfargo.dto.GcpSAcctRole;
import com.wellsfargo.dto.SAcctRoleData;
import com.wellsfargo.service.SAcctRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/iam")
public class SAcctRolesController {

    Logger logger = LoggerFactory.getLogger(SAcctRolesController.class);

    @Resource(name = "sAcctRoleService")
    private SAcctRoleService SAcctRoleService;



    @GetMapping("/fetchSAcctRoles")
    public Map<String,List<GcpSAcctRole>> getSAcctRoles(){
        logger.info("*********trying to fetch service account roles***********");
        List<GcpSAcctRole> projectRoles = SAcctRoleService.getAllSAcctRoles();
        Map<String,List<GcpSAcctRole>> map = new HashMap<>();
        map.put("saroles",projectRoles);
        logger.info("*********successfully fetched service account roles***********");
        return map;
    }


    @GetMapping("/fetchSAcctRole/{id}")
    public SAcctRoleData getSAcctRole(@PathVariable Long id){
        return SAcctRoleService.getSAcctRoleById(id);
    }


    @PostMapping("/saveSAcctRole")
    public SAcctRoleData saveSAcctRole(final @RequestBody SAcctRoleData SAcctRoleData){
        return SAcctRoleService.saveSAcctRole(SAcctRoleData);
    }

    @PutMapping("/saveSAcctRole")
    public SAcctRoleData updateSAcctRole(final @RequestBody SAcctRoleData SAcctRoleData){
        return SAcctRoleService.saveSAcctRole(SAcctRoleData);
    }

    @DeleteMapping("/deleteSAcctRole/{id}")
    public Boolean deleteCustomer(@PathVariable Long id){
        return SAcctRoleService.deleteSAcctRole(id);
    }

}
