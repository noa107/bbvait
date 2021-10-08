package com.weather.service.dao.entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cities")
public class City {

    @Id     
    private Long id;  
	private String name;
    private String email;
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
    // getter, setters, contructors
}
