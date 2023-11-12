import java.util.*;

class calculator {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the First value:");
        int a = s.nextInt();

        System.out.println("Enter the Second value:");
        int b = s.nextInt();

        System.out.println("Enter your option(+,-,*,/,%)");
        int option = s.nextInt();

        switch (option) {
            case 1:
                System.out.println(a + b);
                break;
            case 2:
                System.out.println(a - b);
                break;
            case 3:
                System.out.println(a * b);
                break;
            case 4:
                System.out.println(a / b);
                break;
            case 5:
                System.out.println(a % b);
                break;
            default:
                System.out.println("enter the valid option");
        }
    }
}