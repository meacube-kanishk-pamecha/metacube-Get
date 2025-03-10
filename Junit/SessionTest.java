import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class SessionTest {
  
    @Test
    public void addTest(){
       Session s = new Session();
        assertEquals(10, s.sum(5,5 ));
   }

}
