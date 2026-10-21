package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        TorpedoStore store = new TorpedoStore(1,0.0);
        boolean result = store.fire(1);
        assertEquals(true, result);
        assertEquals(0, store.getTorpedoCount());

        TorpedoStore store2 = new TorpedoStore(1,1.1);
        boolean result2 = store2.fire(1);
        assertEquals(false, result2);
        assertEquals(1,store2.getTorpedoCount());
    }

    @Test
    void oneparamconstructor(){
        TorpedoStore store=new TorpedoStore(26);
        int numOfTorpedos=store.getTorpedoCount();
        assertEquals(26,numOfTorpedos);
    }

    @Test
    void twoparamconstructor(){
        TorpedoStore store=new TorpedoStore(0, 0);
        boolean emptyness=store.isEmpty();
        assertEquals(true,emptyness);
        //How should I test the failureRate? There is no getter!
    }

    @Test
    void outOfBoundFire(){
        TorpedoStore store=new TorpedoStore(1);
        assertThrows(IllegalArgumentException.class, ()->{store.fire(0);});
        assertThrows(IllegalArgumentException.class, ()->{store.fire(27);});
        
        TorpedoStore store2=new TorpedoStore(-1);
        assertThrows(IllegalArgumentException.class, ()->{store2.fire(1);});

        TorpedoStore store3=new TorpedoStore(0);
        assertThrows(IllegalArgumentException.class, ()->{store3.fire(1);});
    }

    
}
