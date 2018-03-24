/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundaments.data.structure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author vjrojasb
 */
public class StructMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map map = new HashMap<>();
        int cont = 1;
        map.put("1", cont++);
        map.put("2", cont++);
        
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
//            it.remove(); // avoids a ConcurrentModificationException
        }
    }
    
}
