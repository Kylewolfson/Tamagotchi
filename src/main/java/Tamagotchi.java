public class Tamagotchi {
  private String mName;
  private int mFoodLevel;
  private int mActivityLevel;
  private int mSleepLevel;
  private boolean mAlive = true;

  public Tamagotchi (String name){
    mName = name;
    mFoodLevel = 10;
    mActivityLevel = 10;
    mSleepLevel = 10;
  }

  public void timePasses() {
    mFoodLevel--;
    mSleepLevel--;
    mActivityLevel--;
    if (mFoodLevel == 0 || mSleepLevel == 0 || mActivityLevel == 0) {
      mAlive = false;
    }
  }

  public void feed() {
    mFoodLevel = 10;
  }
  public void sleep() {
    mSleepLevel = 10;
  }
  public void exercise() {
    mActivityLevel = 10;
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
