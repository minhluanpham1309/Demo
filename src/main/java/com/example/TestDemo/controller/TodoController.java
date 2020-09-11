/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.TestDemo.controller;

import com.example.TestDemo.model.Info;
import com.example.TestDemo.model.Info;
import com.example.TestDemo.model.Todo;
import com.example.TestDemo.service.ProvinceService;
import com.example.TestDemo.service.TodoService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DEVELOPER
 */
@Controller
public class TodoController {
    @Autowired
    private TodoService todoServ;
    
    @Autowired
    private ProvinceService proServ;
    
    @RequestMapping(value = "/listtodo")
    public String index(Model model){
        model.addAttribute("todoList", todoServ.findAll());
        model.addAttribute("provinces", proServ.findAll());
        return "listTodo";
    }
    
    @GetMapping("/addTodo")
    public String addTodo(Model model){
        model.addAttribute("todo", new Todo());
        return "addTodo";
    }
    
    @PostMapping("/addTodo")
    public String addTodo(Model model, @ModelAttribute Todo todo){
        todoServ.add(todo);
         model.addAttribute("todoList", todoServ.findAll());
        return "redirect:/listtodo";
    }
    
    @RequestMapping("/deleteTodo/{id}")
    public String deleteTodo(@PathVariable Long id, Model model){
        todoServ.delete(id);
        model.addAttribute("todoList", todoServ.findAll());
        return "redirect:/listtodo";
    }
    
     @RequestMapping(value = "/listAddress")
    public String listAddress(Model model){
       
        model.addAttribute("provinces", proServ.findAll());
        return "selectList";
    }
    
}
