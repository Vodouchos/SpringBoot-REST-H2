package com.RESTexample;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name= "AppUser")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String country;
	

}
