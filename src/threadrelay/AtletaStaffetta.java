/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

/**
 *
 * @author pasqui.filippo
 */
public class AtletaStaffetta extends Thread {
    private int atleta;
    IntBox box;

    public AtletaStaffetta(int atleta, IntBox box) {
        this.atleta = atleta;
        this.box = box;
    }

    @Override
    public void run() {
        while(true){
            if(box.getValore()==0){
             box.setValore(atleta);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    System.getLogger(AtletaStaffetta.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
         }
        }
         
    }
    
    
    
    
}
