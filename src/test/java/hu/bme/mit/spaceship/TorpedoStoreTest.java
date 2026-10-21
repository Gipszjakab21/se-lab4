package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
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
    }

    @Test
    void outOfBoundFire(){
        TorpedoStore store=new TorpedoStore(26);
        assertThrows(IllegalArgumentException.class, ()->{store.fire(0);});
        assertThrows(IllegalArgumentException.class, ()->{store.fire(27);});
    }

    
}
