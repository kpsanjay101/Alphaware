package com.alphaware.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Posts {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String title;
    
    @Column(columnDefinition = "TEXT")
    private String content;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @JsonIgnore
    @OneToMany(mappedBy = "post")
    private List<Likes> likesList = new ArrayList<>();

    @JsonIgnore
    @Transient
    public int getLikeCount() {
        return this.likesList.size();
    }
    
    @JsonIgnore
    @OneToMany(mappedBy = "post")
    private List<DisLikes> disLikesList = new ArrayList<>();

    @JsonIgnore
    @Transient
    public int getDisLikeCount() {
        return this.likesList.size();
    }

}
