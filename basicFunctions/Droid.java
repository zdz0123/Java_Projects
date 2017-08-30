public class Droid {
  int batteryLevel;
  //constructor
  public Droid () {
    batteryLevel = 100;
  }
  
  public void activate () {
    System.out.println("Activate. How can I help you?");
    batteryLevel -= 5;
    System.out.println("Battery level is: " + batteryLevel + "percent.");
  }
  
  public void chargeBattery (int hours) {
    System.out.println("Droid charging...");
    batteryLevel += hours;
    if (batteryLevel >= 100) {
      batteryLevel = 100;
      System.out.println("Battery level is: " + batteryLevel + "percent.");
    } else {
      System.out.println("Battery level is: " + batteryLevel + "percent.");
    }
  }
  
  public int checkBatteryLevel () {
    System.out.println("Battery level is: " + batteryLevel + "percent.");
    return batteryLevel;
  }
  
  public void hover (int feet) {
    if (feet >= 2) {
      System.out.println("Error! I cannot hover above 2 feet.");
    } else {
      System.out.println("Hovering...");
      batteryLevel -= 20;
      System.out.println("Battery level is: " + batteryLevel + "percent.");
    }
  }
  
  public static void main (String[] args) {
    Droid rua = new Droid();
    rua.activate();
    rua.chargeBattery(5);
    rua.hover(1);
  }
}
