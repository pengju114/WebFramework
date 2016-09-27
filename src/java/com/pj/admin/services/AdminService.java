/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pj.admin.services;

import com.pj.admin.beans.AdminUser;
import com.pj.admin.beans.Authority;
import com.pj.admin.beans.Role;
import com.pj.jdbc.core.ResultList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author lzw
 */
@Component
public interface AdminService {
    
    
    public AdminUser findAdminUserByNameAndPassword(String name,String pwd);
    
    public List<AdminUser> findAdminUserByName(String name);
    
    public ResultList<AdminUser> listAdmins(int startRow,int rowCount);
    
    public ResultList<AdminUser> listAdmins(String name,int startRow,int rowCount);
    
    public ResultList<Role> listRoles();
    
    public ResultList<Authority> listAuthorities();
    
    public boolean hasAuthority(AdminUser adminUser,Authority authority);
    
    public ResultList<Role> getRolesByAdminId(Integer adminId);
    
    public boolean hasAuthorityByAuthorityKey(Integer adminUserId,String key);
    
    public boolean addAdmin( AdminUser adminUser, String[] roleIds);
    
    public boolean deleteAdmins(Integer[] adminIds);

    public ResultList<Authority> getAuthoritiesByAdminId(Integer adminId);
}
