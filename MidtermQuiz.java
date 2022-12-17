import java.io.EOFException;
import java.util.Scanner;

interface Shape {
    double Area();

    void GetDimensionType();

}

interface TwoDimentionShape extends Shape {
    int dimension_type = 2;

    void SetDimension(double d);
}

interface ThreeDimentionShape extends Shape {
    int dimension_type = 3;

    void SetDimension(double d);
}

class Circle implements TwoDimentionShape {
    private double r;

    @Override
    public void GetDimensionType() {
        System.out.println("DimensionType of Circle = " + dimension_type);
    }

    @Override
    public void SetDimension(double d) {
        this.r = d;
    }

    @Override
    public double Area() {
        return 3.14 * r * r;
    }
}

class Square implements TwoDimentionShape {
    private double l;

    @Override
    public void GetDimensionType() {
        System.out.println("DimensionType of Square = " + dimension_type);
    }

    @Override
    public void SetDimension(double d) {
        this.l = d;
    }

    @Override
    public double Area() {
        return l * l;
    }
}

class Sphere implements ThreeDimentionShape {
    private double r;

    @Override
    public void GetDimensionType() {
        System.out.println("DimensionType of Sphere = " + dimension_type);
    }

    @Override
    public void SetDimension(double d) {
        this.r = d;
    }

    @Override
    public double Area() {
        return 4 * 3.14 * r * r;
    }
}

class Cube implements ThreeDimentionShape {
    private double l;

    @Override
    public void GetDimensionType() {
        System.out.println("DimensionType of Cube = " + dimension_type);
    }

    @Override
    public void SetDimension(double d) {
        this.l = d;
    }

    @Override
    public double Area() {
        return 6 * l * l;
    }
}

public class MidtermQuiz {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";

    // this function is used to scan value from user
    // validate the value not to be string or other value else 1,2,3,4
    public static double EnteredValue() {
        Scanner s = new Scanner(System.in);
        double value = 0;
        boolean error;
        do {
            try {
                System.out.print("-->");
                value = s.nextDouble();
                error = false;
                if (value != 1 && value != 2 && value != 3 && value != 4) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println(RED + "Value Entered is a invalid value" + RESET);
                s.nextLine();
                error = true;
                value = 0;
            }
        } while (error);
        return value;
    }

    public static int ShowMenu() {
        int ch;
        do {
            System.out.println(BLUE + "\nWelcome" + RESET);
            System.out.println("Plz Enter Shape You want to calc its area");
            System.out.println("1) Circle ");
            System.out.println("2) Square ");
            System.out.println("3) Sphere ");
            System.out.println("4) Cube ");
            ch = (int) EnteredValue();

        } while (ch != 1 && ch != 2 && ch != 3 && ch != 4);
        return ch;
    }

    public static void main(String[] args) {
        // #region Object Allocation
        Circle circle = new Circle();
        Square square = new Square();
        Sphere sphere = new Sphere();
        Cube cube = new Cube();
        // #endregion
        int ch = ShowMenu();
        switch (ch) {
            case 1:
                circle.GetDimensionType();
                System.out.println("Plz Enter Circle Radius");
                circle.SetDimension(ch);
                System.out.println("Circle Area of");
                break;

            default:
                break;
        }
    }
}