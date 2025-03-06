package com.app.ToDoApp.models;

// This entire class is being translated into a database table, being used in the application and also going into the database

import jakarta.persistence.Entity; // marks this class as a JPA entity-> will be mapped to a table in RDMBS
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;

@Entity
@Data // configured thru lombok (combo of multiple annotations)
public class Task
{
    @Id // Marks id as the primary key of the table
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String title;
    private boolean completed;
}
