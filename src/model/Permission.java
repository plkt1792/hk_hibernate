package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Pulkit.singh on 1/13/2015.
 */

@Entity
@Table(name = "Permissions", schema = "", catalog = "test")
public class Permission implements Serializable {

    private String rolename;
    private String permission;

    public Permission(){}

    public void setRolename(String rolename){
        this.rolename=rolename;
    }
    @Id
    @Column(name = "rolename")
    public String getRolename(){
        return this.rolename;
    }


    public void setPermission(String permission){
        this.permission=permission;
    }
    @Id
    @Column(name = "perms")
    public String getPermission(){
        return this.permission;
    }
}
