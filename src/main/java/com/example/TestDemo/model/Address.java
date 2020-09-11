/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.TestDemo.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author DEVELOPER
 */
@Entity
@Table(name = "address")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @OneToMany(mappedBy = "oldPrince", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<User> usersOld;
    
    @OneToMany(mappedBy = "newPrince", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<User> usersNew;
}
