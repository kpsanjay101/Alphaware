package com.alphaware.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	    
	 @Column(columnDefinition = "TEXT")
	 private String content;
	 
	 @JsonIgnore
	 @ManyToOne
	 @JoinColumn(name = "user_id")
	 private Users users;
	    
	 @JsonIgnore
	 @ManyToOne
	 @JoinColumn(name = "post_id")
	 private Posts posts;
	    
	 private LocalDateTime createdAt = LocalDateTime.now();

	    
}
