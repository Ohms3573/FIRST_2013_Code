/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Paul
 */
public class Dashboard  {

    
   public static void write(String id, String message){
       SmartDashboard.putString(id, message);
   }
}
