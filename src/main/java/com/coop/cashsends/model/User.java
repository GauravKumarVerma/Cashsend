package com.coop.cashsends.model;


import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.coop.cashsends.model.Role;
import com.coop.cashsends.audit.Auditable;
import com.coop.cashsends.dto.UserDto;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
	
	
	@Column(name = "user_name")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "first_name")
	private String firstname;
	
	@Column(name = "last_name")
	private String lastname;
	
	@Column(name = "mobile_number")
	private long mobilenumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "is_active")
	private boolean isactive;

	@Column(name = "is_firstuser", nullable = false, columnDefinition = "int default 0")
	private boolean isfirstuser;
	
	
	@Column(name = "check_password")
	private String checkpassword;
	
	
	
	
	 @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(name = "User_roles",
	            joinColumns =  @JoinColumn(name ="user_id"),inverseJoinColumns= @JoinColumn(name="role_id"))
	    private Set<Role> roles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	
	
	public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


	public String getCheckpassword() {
		return checkpassword;
	}

	public void setCheckpassword(String checkpassword) {
		this.checkpassword = checkpassword;
	}

	public boolean isIsfirstuser() {
		return isfirstuser;
	}

	public void setIsfirstuser(boolean isfirstuser) {
		this.isfirstuser = isfirstuser;
	}

	public UserDto toUserDto(){
		UserDto userDto =null;
		userDto =new UserDto();
		userDto.setEmail(this.email);
		userDto.setFirstname(this.firstname);
		userDto.setId(this.id);
		userDto.setIsactive(this.isactive);
		userDto.setLastname(this.lastname);
		userDto.setMobilenumber(this.mobilenumber);
		userDto.setPassword(this.password);
		userDto.setUsername(this.username);
		userDto.setIsfirstuser(this.isfirstuser);
		userDto.setRole(this.roles.stream().map(role -> role.getName().toString()).collect(Collectors.toList()));
		return userDto;
		
	}
	

}
