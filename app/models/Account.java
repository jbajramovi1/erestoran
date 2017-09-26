package models;

import javax.persistence.*;

@Entity
public class Account extends BaseModel<Account> {

	private String email;
	private String password;
	private String phone;
	private String country;
	private String city;
	private String firstName;
	private String lastName;
	
	@Basic
    @Column(name = "email",unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Basic
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Basic
    @Column(name = "phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Basic
    @Column(name = "country")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Basic
    @Column(name = "city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

	@Basic
    @Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Basic
    @Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	 @Override
	 public void update(Account data) {
	     if(data.getFirstName() != null) setFirstName(data.getFirstName());
	     if(data.getLastName() != null) setLastName(data.getLastName());
         if(data.getPassword() != null) setPassword(data.getPassword());
         if(data.getCity() != null) setCity(data.getCity());
         if(data.getEmail() != null) setEmail(data.getEmail());
	 }
	
}
