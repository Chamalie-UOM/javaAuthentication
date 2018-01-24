/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package securitysystem;

import java.util.ArrayList;
import javax.swing.JOptionPane;

//import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Validator {
   Long startT;
   Long endT;
   ArrayList<Long> start = new ArrayList<Long>();
   ArrayList<Long> end = new ArrayList<Long>();
    
   public void authenticateUser(long startT, long endT,String userIn){
        Long speed =checkSpeed(startT, endT);
        System.out.println(validateInput(userIn));
        if (validateInput(userIn)){
            if ((5300 < speed)&&(speed<6500)&&(155<getPressTime())&&(getPressTime()<170)){
            	JOptionPane.showMessageDialog(null,"Authentication successfull" );
                System.out.println("Authentication successfull");
                System.out.println(speed);
                this.start.clear();
                this.end.clear();
            }else{
            	JOptionPane.showMessageDialog(null,"You are not authorized to enter this system." );
                System.out.println("You are not authorized to enter this system.");
                System.out.println(speed);
                this.start.clear();
                this.end.clear();
            }
        }else{
        	JOptionPane.showMessageDialog(null,"Please enter the text correctly. Press Enter and type \"This is my typing speed\" ." );
            System.out.println("Please enter the text correctly. Press Enter and type \"This is my typing speed\" ");
            this.start.clear();
            this.end.clear();
        }
        
    }
    
    public long checkSpeed(long start,long end){
        long speed = end -start;
        return speed;
    }
    
    public boolean validateInput(String wordsIn){
        String data = "This is my typing speed";
        if(wordsIn.equals(data)){
            return true;
        }else{
            return false;
        }
    }
    
    public Long getPressTime() {
    	ArrayList<Long> PressTime =new ArrayList<Long>();
    	for(int i=0; i<this.start.size(); i++) {
    		Long elem = this.end.get(i) - this.start.get(i);
    		PressTime.add(elem);
    	}
    	long sum=0;
    	for (long j :PressTime) {
    		sum = sum +j;
    	}
    	long avgtime=sum/PressTime.size();
    	System.out.println(avgtime);
    	return avgtime;
    }
}


