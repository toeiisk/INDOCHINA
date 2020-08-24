
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LAB304_28
 */
public class OvenPool {
    
    private static long expTime = 6000;//6 seconds
    public static HashMap<PizzaOven, Long> available = new HashMap<PizzaOven, Long>();
    public static HashMap<PizzaOven, Long> inUse = new HashMap<PizzaOven, Long>();

    public synchronized static PizzaOven getObject() {
        long now = System.currentTimeMillis();
        if (!available.isEmpty()) {
            for (Map.Entry<PizzaOven, Long> entry : available.entrySet()) {
                if (now - entry.getValue() > expTime) { //object has expired
                    popElement(available);
                } else {
                    PizzaOven po = popElement(available, entry.getKey());
                    push(inUse, po, now);
                    return po;
                }
            }
        }

        // either no PooledObject is available or each has expired, so return a new one
        return createPooledObject(now);
    }

    private synchronized static PizzaOven createPooledObject(long now) {
        PizzaOven po = new PizzaOven();
        push(inUse, po, now);
        return po;
    }

    private synchronized static void push(HashMap<PizzaOven, Long> map,
            PizzaOven po, long now) {
        map.put(po, now);
    }

    public static void releaseObject(PizzaOven po) {
        cleanUp(po);
        available.put(po, System.currentTimeMillis());
        inUse.remove(po);
    }

    private static PizzaOven popElement(HashMap<PizzaOven, Long> map) {
        Map.Entry<PizzaOven, Long> entry = map.entrySet().iterator().next();
        PizzaOven key = entry.getKey();
        //Long value=entry.getValue();
        map.remove(entry.getKey());
        return key;
    }

    private static PizzaOven popElement(HashMap<PizzaOven, Long> map, PizzaOven key) {
        map.remove(key);
        return key;
    }

    public static void cleanUp(PizzaOven po) {
        po.setOvenStatus("AVAILABLE");
        po.setTimeRemaining(0);
        po.setPizzaInOven(null);
    }
}
