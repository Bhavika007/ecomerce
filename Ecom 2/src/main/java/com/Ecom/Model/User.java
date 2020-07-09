package com.Ecom.Model;


import javax.persistence.*;

@Entity
@Table(name="profile")
public class User {

    @Id
    @GeneratedValue
    private Long Userid;

    @Column(name="FIRSTNAME",length=50,nullable=false,unique=true)
    private String firstname;

    @Column(name="LASTNAME",length=50,nullable=false,unique=true)
    private String lastname;

    @Column(name="EMAIL",length=30,nullable=false)
    private String email;

    @Column(name="MOBILE",length=10,nullable=false)
    private String mobile;

    @Column(name="PASSWORD",length=30,nullable=false)
    private String password;

    //default constructor
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }



    public User(Long Userid, String firstname,String lastname,String email, String mobile, String password) {
        super();
        this.Userid = Userid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
    }




    public Long getUserid() {
        return Userid;
    }



    public void setUserid(Long Userid) {
        this.Userid = Userid;
    }



    public String getFirstName() {
        return firstname;
    }



    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastname;
    }



    public void setLastName(String lastname) {
        this.lastname = lastname;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public String getMobile() {
        return mobile;
    }



    public void setMobile(String mobile) {
        this.mobile = mobile;
    }



    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString() {
        return "User [Userid=" + Userid + ", firstname=" + firstname + ", lastname=" + lastname +", email=" + email + ", mobile=" + mobile + ", password="
                + password + "]";
    }

}
