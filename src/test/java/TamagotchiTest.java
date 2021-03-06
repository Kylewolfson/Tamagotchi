import org.junit.*;
import static org.junit.Assert.*;

public class TamagotchiTest {

  @Test
  public void tamagotchi_instantiatesCorrectly() {
    Tamagotchi myPet = new Tamagotchi("lil dragon");
    assertEquals("lil dragon", myPet.getName());
    assertEquals(10, myPet.getFoodLevel());
    assertEquals(10, myPet.getSleepLevel());
    assertEquals(10, myPet.getActivityLevel());
  }

  @Test
  public void timePasses_foodDecreasesByOne_9() {
    Tamagotchi myPet = new Tamagotchi("lil dragon");
    myPet.timePasses();
    assertEquals(9, myPet.getFoodLevel());
  }
}
