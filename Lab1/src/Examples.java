import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {

	Album classics = new Album("classics");
    Song HapBD = new Song("Happy Birthday", 18, classics);
    Song Africa = new Song("Africa", 20, classics);
    
    
    public Examples(){}
    
    @Test

    public void checkHBLen() {
       assertEquals(18, HapBD.lenInSeconds);
     }
    
    @Test
    public void checkAfrica() {
    	assertEquals(20, Africa.lenInSeconds);
    }
    
    @Test
    public void checkAlbum() {
    	assertEquals(HapBD.onAlbum, classics);
    	assertEquals(Africa.onAlbum, classics);
    }
    
    /*
    // This shows what a test case looks like
    @Test 
    public void simpleCheck() {
	assertEquals(4, 4);
    }
    */
  
}