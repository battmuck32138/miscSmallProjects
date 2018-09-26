public class HelloNumbers {
  public static void main(String[] args) {
    int x = 0;
    int tot = 0;
    while(x < 10) {
      tot = tot + x;
      System.out.print(tot + " ");
      x = x + 1;
    }
    System.out.println();
  }
}
