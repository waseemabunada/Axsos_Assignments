package com.example.axsos.models;


import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.DecimalMax;
//import jakarta.validation.constraints.DecimalMin;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
@Table(name="dorms")
public class Dorm {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotNull
  @Size(min =2, max = 200)
  private String name;
  
  @OneToMany(mappedBy="dorm", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
  private List<Student> students;

  public Dorm() {
  }
  public Dorm(String name) {
      this.name = name;
  }
 
//This will not allow the createdAt column to be updated after creation
  @Column(updatable=false)
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date createdAt;
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date updatedAt;

	public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<Student> getStudents() {
	return students;
}
public void setStudents(List<Student> students) {
	this.students = students;
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