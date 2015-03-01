/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmagazine;

/**
 *
 * @author Obaro
 */
class Journalist implements java.io.Serializable{
    private String firstname;
    private String lastname;
    private String id;
    private String email;
    private String address;
    private String phonenumber;
    static int CODE;
    
    static final int FIRSTNAME=0;
    static final int LASTNAME=1;
    static final int EMAIL=2;
    static final int ADDRESS=3;
    static final int PHONENUMBER=4;
    public String Error;
        

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    boolean validate()
    {
        boolean okay=false;
        String NPattern="^[a-zA-Z_]+[a-zA-Z0-9 ]+$";
        String NPhone="^[0-9\\+]{0,1}([0-9]+){10,15}$";
        
       if(!Validator.isMatch("^[a-zA-Z_]+[a-zA-Z0-9\\.]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]{2,4}$", this.email.trim()))
       {
           Error="Enter a valid email address !!!";
           CODE=EMAIL;
       }
       else if(!Validator.isMatch(NPattern, this.getFirstname()))
       {
           Error="Enter a valid firstname !!";
           CODE=FIRSTNAME;
       }
       else if(!Validator.isMatch(NPattern, this.getLastname()))
       {
           Error="Enter a valid lastname";
           CODE=LASTNAME;
       }
       else if(!Validator.isMatch(NPhone,this.getPhonenumber() ))
       {
           Error="Enter a valid phone number !!";
           CODE=PHONENUMBER;
           
       }else if ("".equalsIgnoreCase(this.getAddress().trim()))
       {
           Error="Enter your address again !!!";
           CODE=ADDRESS;
       }else
       {
           okay=true;
       }
     return okay;
    }
    
}
