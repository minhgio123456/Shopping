package com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "Role")
public class Role {
	@Id
	String role_id;
	String role_name;
	Boolean role_isdelete;
	
	@JsonIgnore
	@OneToMany(mappedBy = "role")
	List<Users> users;
	
}
