package model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class User extends Person {

    @Column(name="username")
    private String username;
    @Column(name="pass")
    private String password;

    public User(){

    }
    public User(String userName,String password,String firstName,String lastName){
        super(firstName,lastName);
        this.username=userName;
        this.password=password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
