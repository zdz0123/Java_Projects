public class Calculator {
  public Calculator() {
    
  }
  //add function
  public int add (int a, int b) {
    return a + b;
  }
  //subtract function
  public int subtract (int a, int b) {
    return a - b;
  }
  //multiply function
  public int multiply (int a, int b) {
    return a * b;
  }
  //divide function
  public int divide (int a, int b) {
    if (b == 0) {
      System.out.println("Error! Dividing by zero is not allowed.");
      return 0;
    } else {
      return a / b;
    }
  }
  //modulo function
  public int modulo (int a, int b) {
    if (b == 0) {
      System.out.println("Error! Dividing by zero is not allowed.");
      return 0;
    } else {
      return a % b;
    }
  }
  //main function
  public static void main (String[] args) {
    Calculator myCalculator = new Calculator();
    System.out.println(myCalculator.add(5, 7));
    System.out.println(myCalculator.subtract(45, 11));
    System.out.println(myCalculator.modulo(12, 0));
  }
}
