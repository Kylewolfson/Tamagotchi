import java.util.TimerTask;
import java.util.Timer;

public class Tamagotchi {
  private String mName;
  public static int mFoodLevel;
  public static int mActivityLevel;
  public static int mSleepLevel;
  public static boolean mAlive;


  public static void checkPulse() {
    if (mFoodLevel == 0 || mSleepLevel == 0 || mActivityLevel == 0) {
      mAlive = false;
    }
  }

  public Tamagotchi (String name){
    mName = name;
    mFoodLevel = 10;
    mActivityLevel = 10;
    mSleepLevel = 10;
    mAlive = true;
  }

  public static void timePasses() {
    mFoodLevel--;
    mSleepLevel--;
    mActivityLevel--;
    checkPulse();
  }

  public void feed() {
    mFoodLevel = 10;
  }
  public void sleep() {
    mSleepLevel = 10;
  }
  public void exercise() {
    mActivityLevel = 10;
    mSleepLevel--;
    mFoodLevel--;
    checkPulse();
  }

  public String getName(){
    return mName;
  }
  public int getFoodLevel(){
    return mFoodLevel;
  }
  public int getSleepLevel(){
    return mSleepLevel;
  }
  public int getActivityLevel(){
    return mActivityLevel;
  }
  public boolean isAlive() {
    return mAlive;
  }
}
