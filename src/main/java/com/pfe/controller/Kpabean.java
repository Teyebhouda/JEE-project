/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import org.springframework.stereotype.Component;

/**
 *
 * @author Houda
 */
@Component//with it spring can scan this class as a bean.@Named also does same thing
@ManagedBean(name="Kpabean")
@SessionScoped

public class Kpabean implements Serializable {

    private static final long serialVersionUID = 1L;
    
 
    
}
