/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.exceptions;

import javax.ejb.EJBException;

/**
 *
 * @author attia
 */
public class BusinessExceptions extends EJBException{
    
    public BusinessExceptions(){
        
    }
    
    public BusinessExceptions(String message){
        super(message);
    }
    
    
}
