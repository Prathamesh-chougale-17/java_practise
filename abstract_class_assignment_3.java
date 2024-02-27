import java.util.Scanner;

abstract class shape {
    int l, b;
    Scanner s = new Scanner(System.in);

    abstract void printArea();
}

class triangle extends shape {
    void printArea() {
        System.out.print("Enter the lenght of triangle : ");
        int l = s.nextInt();
        System.out.print("Enter the breath of triangle : ");
        int b = s.nextInt();
        System.out.println("Area of triangle is : " + (1 / 2) * l * b);
    }
}

class rectangle extends shape {
    void printArea() {
        System.out.print("Enter the lenght of rectangle : ");
        int l = s.nextInt();
        System.out.print("Enter the breath of rectangle : ");
        int b = s.nextInt();
        System.out.println("Area of rectangle is : " + l * b);
    }
}

class circle extends shape {
    void printArea() {
        System.out.print("Enter the radius of circle : ");
        int l = s.nextInt();
        System.out.println("Area of circle is : " + (3.14) * l * l);
    }
}

public class abstract_class_assignment_3 {
    public static void main(String arg[]) {
        Scanner s = new Scanner(System.in);
        shape c = new circle();
        shape t = new triangle();
        shape r = new rectangle();
        System.out.println("Enter 1 to find area of circle");
        System.out.println("Enter 2 to find area of triangle");
        System.out.println("Enter 3 to find area of rectangle");
        System.out.println();
        System.out.print("Enter your choice : ");
        System.out.println();
        int choice = s.nextInt();
        switch (choice) {
            case 1:
                c.printArea();
                break;
            case 2:
                t.printArea();
                break;
            case 3:
                r.printArea();
                break;
        }
        s.close();
    }
}
