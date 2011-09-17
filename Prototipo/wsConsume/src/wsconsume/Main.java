/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wsconsume;

import java.util.Date;


/**
 *
 * @author diego
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        long sum = 0;
        for (int i = 0; i < 1000; i++) {
            long uno = new Date().getTime();

            
            long dos = new Date().getTime();
            System.out.println(dos - uno);
            sum+= dos - uno;
            //System.out.println(da.getDataAccessPort().getData(null));
        }
        System.out.println("Promedio: "+sum/1000);
        
    }


  

    

}
