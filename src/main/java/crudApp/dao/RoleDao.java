package crudApp.dao;

import crudApp.model.Role;

import java.util.HashSet;
import java.util.List;

public interface RoleDao {
    List<Role> allRoles();
    void addRole (Role role);
    void deleteRole (int id);
    void editRole (Role role);
    HashSet<Role> getRoleSet(String[] s);
    Role getRoleByName (String name);
}
