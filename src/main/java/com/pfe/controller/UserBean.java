package com.pfe.controller;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.faces.bean.ManagedBean;
import org.primefaces.context.RequestContext;
import com.pfe.model.User;
import com.pfe.model.Role;
import com.pfe.service.UserB;
import com.pfe.service.RoleB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;


/**
 *
 * @author Raichand
 */
@Component//with it spring can scan this class as a bean.@Named also does same thing
@ManagedBean(name="userBean")
@SessionScoped
public class UserBean implements Serializable {

    private static final long serialVersionUID = 1L;
    

   @Autowired//@Inject or #(ManagedProperty) can also be used		   
    private UserB userService;
    //Spring User Service is injected...
     @Autowired//@Inject or #(ManagedProperty) can also be used	
     private RoleB roleService;    

    private String ConfirmPassword;
    List<User> userList;
    private User user = new User();

    

    /**
     * Add User
     *
     * @return String - Response Message
     */
    public String addUser() {
        try {
            this.validateUser();
            int newid = userService.CreateNewUserId();
            User newuser = new User();             
           String cryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());            
            newuser.setUserId(newid);
            newuser.setFirstName(user.getFirstName());
            newuser.setLastName(user.getLastName());
            newuser.setUsername(user.getUsername());
            newuser.setEmail(user.getEmail());
            newuser.setPassword(cryptedPassword);
            newuser.setEnabled(user.getEnabled());
            Role role = new Role();
            role = roleService.findById(newid);
            Role  newrole = new Role();
            if (role == null) {
               
            newrole.setRoleId(newid);
            newrole.setUser(newuser);
            newrole.setRole("ROLE_USER");          
            
            }
            
            Set<Role> Roles = new HashSet<Role>(0);
            Roles.add(role);
            newuser.setRoles(Roles);         
            getUserService().create(newuser);
            getRoleService().create(newrole);
            FacesMessage message= new FacesMessage(FacesMessage.SEVERITY_INFO, "Save ","User Information saved successfully.");
            RequestContext.getCurrentInstance().showMessageInDialog(message); 
            return "login";
        } catch (DataAccessException e) {
            e.printStackTrace();
            FacesMessage message= new FacesMessage(FacesMessage.SEVERITY_INFO, "Save ","Failed to save  User Information .");
            RequestContext.getCurrentInstance().showMessageInDialog(message); 
            return null;
        }     
            
    }
    
    /**
     * Validate input data in registering user
     *
     */
    public void validateUser() { 
        System.out.println(getConfirmPassword());
        System.out.println(user.getPassword());
       if (!(user.getPassword().equals(getConfirmPassword())) ){ 
                
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Password","Password and confirm password does not match");
            RequestContext.getCurrentInstance().showMessageInDialog(message); 
            return ;
            }
         
    }
    
     public void changeUser(User user)  
    {  
        this.user = user;  
    }  
    public void UpdateUser(User user)  
    {  
        String Name = user.getUsername();  
        FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Name", Name);  
        RequestContext.getCurrentInstance().showMessageInDialog(message1);  
        getUserService(). update(user);  
        System.out.println("User Info successfully saved.");  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Information", "User updated successfully .");  
        RequestContext.getCurrentInstance().showMessageInDialog(message);  
        user = new User();  
    }  
    public void deleteUser(User user)  
    {  
        String Name = user.getUsername();  
        //FacesMessage message3= new FacesMessage(FacesMessage.SEVERITY_INFO, "Delete Item",contactName);  
        // RequestContext.getCurrentInstance().showMessageInDialog(message3);  
          getUserService().delete(user);  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Delete", "Record deleted successfully");  
        RequestContext.getCurrentInstance().showMessageInDialog(message);  
    } 

    /**
     * Reset Fields
     *
     */
    public void reset() {
        user.reset();
        this.ConfirmPassword="";
    }

    /**
     * Get User List
     *
     * @return List - User List
     */
   public List<User> getUserList() {
        userList = new ArrayList<User>();
        userList.addAll(getUserService().findAll());
        return userList;
    }

   
   
   
    /**
     * Get User Service
     *
     * @return UserServiceImpl - User Service
     */
    public UserB getUserService() {
        return userService;
    }

    /**
     * Set User Service
     *
     * @param userService UserServiceImpl - User Service
     */
    public void setUserService(UserB userService) {
        this.userService = userService;
    }
    
    /**
     * Get Role Service
     *
     * @return RoleServiceImpl - Role Service
     */
    
     public RoleB getRoleService() {
        return roleService;
    }
     
     /**
     * Set Role Service
     *
     * @param roleService RoleServiceImpl - User Service
     */

    public void setRoleService(RoleB roleService) {
        this.roleService = roleService;
    }

    /**
     * Set  User List
     *
     * @param userList List - User List
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
     public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String ConfirmPassword) {
        this.ConfirmPassword = ConfirmPassword;
    }



}