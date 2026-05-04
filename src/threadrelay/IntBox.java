/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

/**
 *
 * @author pasqui.filippo
 */
public class IntBox {
   private int valore=1;

    public synchronized int getValore() {
        return valore;
    }

    public synchronized void setValore(int valore) {
        this.valore = valore;
    }
   
   public synchronized void resetValore(){
       this.valore=0;
   }
   
}
