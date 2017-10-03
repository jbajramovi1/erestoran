package models;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account extends BaseModel<Account> {
	@Basic
    @Column(name = "email",unique=true,nullable=false)
	private String email;
	@Basic
	@Column(name="password",nullable=false)
	private String password;
	@Basic
	@Column(name = "role",nullable=false)
	private Role role;
	@Basic
    @Column(name = "phone")
	private String phone;
	@Basic
    @Column(name = "country")
	private String country;
	@Basic
    @Column(name = "city")
	private String city;
	@Basic
    @Column(name = "first_name")
	private String firstName;
	@Basic
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
	     if(data.getFirstName() != null) setFirstName(data.getFirstName());
	     if(data.getLastName() != null) setLastName(data.getLastName());
         if(data.getPassword() != null) setPassword(data.getPassword());
         if(data.getCity() != null) setCity(data.getCity());
         if(data.getEmail() != null) setEmail(data.getEmail());
         if(data.getRole() != null) setRole(data.getRole());
	 }
	
}
