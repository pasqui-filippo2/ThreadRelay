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
   private int valore;// 0 libero , 1 occupato

    public int getValore() {
        return valore;
    }

    public void setValore() {
        this.valore = 1;
    }
   
   public void resetValore(){
       this.valore=0;
   }
   
}
