package com.app.ToDoApp.repository;

// REPOSITORY IS A CLASS OR INTERFACE THAT CONNECTS  YOUR APPLICATION TO THE DATABASE
 // ALLOWING YOU TO PERFORM BASIC CRUD OPERATIONS

import com.app.ToDoApp.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

// JPA Repo gives some predefined methods to interact with the database - CRUD
// JpaRepository< ENTITY FOR WHICH YOU NEED METHODS, PRIMARY KEY TYPE >
public interface TaskRepository extends JpaRepository<Task,Long> {
}
