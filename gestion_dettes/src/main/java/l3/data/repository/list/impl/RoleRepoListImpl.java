package l3.data.repository.list.impl;

import l3.data.entity.Client;
import l3.data.entity.User;
import l3.data.entity.UserRole;
import l3.data.repository.list.ClientRepoList;
import l3.data.repository.list.RoleRepoList;

public class RoleRepoListImpl extends RepositoryListImpl<UserRole> implements RoleRepoList {

    public RoleRepoListImpl() {
      
        UserRole role1 = new UserRole(1, "ADMIN");
        data.add(role1);
        UserRole role2 = new UserRole(1, "BOUTIQUIER");
        data.add(role2);
        UserRole role3 = new UserRole(1, "CLIENT");
        data.add(role3);
    }
    
}
