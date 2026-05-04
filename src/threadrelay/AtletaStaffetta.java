/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

import java.util.ArrayList;

/**
 *
 * @author pasqui.filippo
 */
public class AtletaStaffetta extends Thread implements Subject {
    private int atleta;
    IntBox box;
    private Observer o;

    public AtletaStaffetta(int atleta, IntBox box) {
        this.atleta = atleta;
        this.box = box;
    }

    @Override
    public void run() {
        while(box.getValore()!=atleta){
            
          try {Thread.sleep(10);} catch (InterruptedException ex) {System.getLogger(AtletaStaffetta.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);}
        }
        
        for(int i =0; i<=100;i++){
            try{
                Thread.sleep(50);
                notifyObserver(i);
                
                if(i==90){
                    box.setValore(atleta+1);
                }
            }catch(InterruptedException e){}
        }
         
    }

    @Override
    public void addObserver(Observer o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeObserver(Observer o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void notifyObserver(int progresso) {
      
        if(o != null){
         o.update(atleta, progresso);
        }
    
    }
    
    
    
    
}
