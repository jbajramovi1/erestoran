package models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import play.data.validation.Constraints;

import javax.persistence.*;
import javax.validation.Constraint;

@Entity
@Table(name = "account")
public class Account extends BaseModel<Account> {
    @Column
    @Constraints.Required(message = "Email field is required")
    @Constraints.Email(message = "Email format is incorrect")
    private String email;
    @Column
    @JsonIgnore
    @Constraints.Required(message = "Password field is required")
    private String password;
    @Enumerated(value = EnumType.STRING)
    @Column
    private Role role = Role.USER;
    @Column
    private String phone;
    @Column
    private String country;
    @Column
    private String city;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public void update(Account data) {
        if (data.getFirstName() != null) {
            setFirstName(data.getFirstName());
        }
        if (data.getLastName() != null) {
            setLastName(data.getLastName());
        }
        if (data.getPassword() != null) {
            setPassword(data.getPassword());
        }
        if (data.getCity() != null) {
            setCity(data.getCity());
        }
        if (data.getEmail() != null) {
            setEmail(data.getEmail());
        }
        if (data.getRole() != null) {
            setRole(data.getRole());
        }

    }

}
