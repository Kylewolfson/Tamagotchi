import java.util.TimerTask;
import java.util.Timer;

public class TamagotchiTime extends TimerTask {
  public void run() {
    Tamagotchi.timePasses();
  }
}
