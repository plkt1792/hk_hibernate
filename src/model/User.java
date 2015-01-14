package model;

import javax.persistence.*;

/**
 * Created by Pulkit.singh on 1/12/2015.
 */

@Entity
@Table(name = "users", schema = "", catalog = "test")
public class User {

    private String username;
    private String name;
    private String password;
    private String manager;

    public User(){}

    public void setUsername(String username){
        this.username=username;
    }
    @Id
    @Column(name = "uname")
    public String getUsername()
    {
        return this.username;
    }

    public void setName(String name){
        this.name=name;
    }
    @Basic
    @Column(name = "name")
    public String getName(){
        return this.name;
    }

    public void setManager(String manager){
        this.manager=manager;
    }
    @Basic
    @Column(name="mngr")
    public String getManager(){
        return this.manager;
    }

    public void setPassword(String password){
        this.password=password;
    }
    @Basic
    @Column(name = "password")
    public String getPassword()
    {
        return this.password;
    }
}
