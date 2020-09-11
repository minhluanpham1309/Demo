/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.TestDemo.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author DEVELOPER
 */
@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "oldAddrId", nullable = false)
    private Address oldPrince;
    
    @ManyToOne
    @JoinColumn(name = "newAddrId", nullable = false)
    private Address newPrince;
    
    @OneToMany(mappedBy = "user")
    private Set<Todo> todo;
}
