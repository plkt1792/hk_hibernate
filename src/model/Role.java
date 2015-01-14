package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Pulkit.singh on 1/13/2015.
 */

@Entity
@Table(name = "Roles", schema = "", catalog = "test")
public class Role implements Serializable {

    private String username;
    private String rolename;

    public Role(){}

    public void setUsername(String username){
        this.username=username;
    }
    @Id
    @Column(name = "username")
    public String getUsername()
    {
        return this.username;
    }

    public void setRolename(String rolename){
        this.rolename=rolename;
    }
    @Id
    @Column(name = "rolename")
    public String getRolename(){
        return this.rolename;
    }
}
