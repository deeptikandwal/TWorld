package com.travel.world.Tworld.documents;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document // collection name
public class Customer {

	@Id
	private String id;
	private String name;
	private String email;
	private int age;
}
