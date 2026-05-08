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
    private boolean corre=true;
    private boolean pausa=false;
    private int sleepTime=50;

    public AtletaStaffetta(int atleta, IntBox box) {
        this.atleta = atleta;
        this.box = box;
    }
    
    public synchronized void ferma(){
        this.corre=false;
    }
    
    public synchronized boolean deveCorrere(){
        return this.corre;
    }
    public synchronized void inPausa(){
        this.pausa=true;
    }
    
    public synchronized void riparti(){
        this.pausa=false;
        notify();
    }
    
    public synchronized void checkPausa(){
        while(pausa){
            try{
                wait();
            }catch (InterruptedException e) {}
        }
    }
    
    
    public synchronized void velocizza(){
        if(sleepTime>10){
            sleepTime-=10;
        }
    }
    
    public synchronized void rallenta(){
        sleepTime+=10;
    }
    
    public synchronized int getSleepTime(){
        return this.sleepTime;
    }

    @Override
    public void run() {
        
        while(box.getValore()!=atleta && deveCorrere()){
            checkPausa();
          try {Thread.sleep(getSleepTime());} catch (InterruptedException ex) {System.getLogger(AtletaStaffetta.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);}
        }
        
        for(int i =0; i<=100 && deveCorrere();i++){
            checkPausa();
            try{
                Thread.sleep(getSleepTime());
                notifyObserver(i);
                
                if(i==90 && deveCorrere()){
                    box.setValore(atleta+1);
                }
            }catch(InterruptedException e){}
        }
         
    }

    @Override
    public void addObserver(Observer o) {
        this.o=o;
    }

    @Override
    public void removeObserver(Observer o) {
        
    }

    @Override
    public void notifyObserver(int progresso) {
      
        if(o != null){
         o.update(atleta, progresso);
        }
    
    }
    
    
    
    
}
