/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.TestDemo.service;

import com.example.TestDemo.model.Todo;
import com.example.TestDemo.repsitory.TodoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

/**
 *
 * @author DEVELOPER
 */
@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepo;
    
    public List<Todo> findAll(){
        /*return Optional.ofNullable(limit)
                        .map(value ->todoRepo.findAll(PageRequest.of(0,value)).getContent())
                        .orElseGet(() -> todoRepo.findAll());
    */
        return todoRepo.findAll();
    }
    
    public Todo add(Todo todo){
        return todoRepo.save(todo);
    }
    
    public void delete(Long id){
        todoRepo.deleteById(id);
    }
}
