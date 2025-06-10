package com.example.axsos.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.DecimalMax;
//import jakarta.validation.constraints.DecimalMin;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
@Table(name="ninjas")
public class Ninja {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @NotNull
   @Size(min =2, max = 200)
   private String firstName;
   @NotNull
   @Size(min =2, max = 200)
   private String lastName;
   @NotNull
   @Min(1)
   @Max(200)
   private Integer age;
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name="dojo_id")
   private Dojo dojo;

   // This will not allow the createdAt column to be updated after creation
   @Column(updatable=false)
   @DateTimeFormat(pattern="yyyy-MM-dd")
   private Date createdAt;
   @DateTimeFormat(pattern="yyyy-MM-dd")
   private Date updatedAt;
   public Ninja() {
   }
//create and update لما بدي اعمل 
   public Ninja(String firstName, String lasttName, Integer age) {
       this.firstName = firstName;
       this.lastName = lasttName;
       this.age = age;
   }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLasttName() {
		return lastName;
	}
	public void setLasttName(String lasttName) {
		this.lastName = lasttName;
	}

	public Dojo getDojo() {
		return dojo;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	// other getters and setters removed for brevity
   @PrePersist
   protected void onCreate(){
       this.createdAt = new Date();
   }
   @PreUpdate
   protected void onUpdate(){
       this.updatedAt = new Date();
   }
}