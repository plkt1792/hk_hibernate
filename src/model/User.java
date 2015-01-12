package model;

import javax.persistence.*;

/**
 * Created by Pulkit.singh on 1/12/2015.
 */

@Entity
@Table(name = "users", schema = "", catalog = "test")
public class User {

    private String username;


    private String password;

    public User(){}

    public void setUsername(String username){
        this.username=username;
    }
    @Id
    @Column(name = "uname")
    public String getUsername()
    {
        return username;
    }

    public void setPassword(String password){
        this.password=password;
    }
    @Basic
    @Column(name = "pwd")
    public String getPassword()
    {
        return password;
    }
}
