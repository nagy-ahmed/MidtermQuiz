import java.util.Scanner;

interface Shape {
    double Area();

    void GetDimensionType();

}

interface TwoDimentionShape extends Shape {
    String dimension_type = "Two";

    void SetDimension(double d);
}

interface ThreeDimentionShape extends Shape {
    String dimension_type = "Three";

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

    public static void Cal() {
        Circle circle = new Circle();
        circle.GetDimensionType();
        System.out.println(Color.YELLOW + "Plz Enter Circle Radius" + Color.RESET);
        circle.SetDimension(MidtermQuiz.EnteredValue());
        System.out.println("Circle Area = " + circle.Area());
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

    public static void Cal() {
        Square square = new Square();
        square.GetDimensionType();
        System.out.println(Color.YELLOW + "Plz Enter Square Length" + Color.RESET);
        square.SetDimension(MidtermQuiz.EnteredValue());
        System.out.println("Square Area = " + square.Area());
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

    public static void Cal() {
        Sphere sphere = new Sphere();
        sphere.GetDimensionType();
        System.out.println(Color.YELLOW + "Plz Enter Sphere Radius" + Color.RESET);
        sphere.SetDimension(MidtermQuiz.EnteredValue());
        System.out.println("Sphere Area = " + sphere.Area());
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

    public static void Cal() {
        Cube cube = new Cube();
        cube.GetDimensionType();
        System.out.println(Color.YELLOW + "Plz Enter Cube Length" + Color.RESET);
        cube.SetDimension(MidtermQuiz.EnteredValue());
        System.out.println("Cube Area = " + cube.Area());
    }
}

class Color {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";

}

public class MidtermQuiz {
    // this function is used to scan value from user
    // validate the value not to be string
    public static double EnteredValue() {
        Scanner s = new Scanner(System.in);
        double value = 0;
        boolean error;
        do {
            try {
                System.out.print("-->");
                value = s.nextDouble();
                error = false;

            } catch (Exception e) {
                System.out.println(Color.RED + "Value Entered is a invalid value" + Color.RESET);
                s.nextLine();
                error = true;
                value = 0;
            }

        } while (error);

        return value;
    }

    // choose value from 1 to 4 each belongs to diffrent shape
    public static int ShowMenu() {
        int ch = 0;
        System.out.println("Plz Choose Shape You want to calc its area");
        System.out.println("1) Circle ");
        System.out.println("2) Square ");
        System.out.println("3) Sphere ");
        System.out.println("4) Cube ");
        do {
            ch = (int) EnteredValue();
            if (ch != 1 && ch != 2 && ch != 3 && ch != 4) {
                System.out.println(Color.RED + "Your choose not Exist\nPlz Enter another value" + Color.RESET);
            }
        } while (ch != 1 && ch != 2 && ch != 3 && ch != 4);

        return ch;
    }

    public static void DoCore() {
        boolean again = false;
        do {
            switch (ShowMenu()) {
                case 1:
                    Circle.Cal();
                    break;
                case 2:
                    Square.Cal();
                    break;
                case 3:
                    Sphere.Cal();
                    break;
                case 4:
                    Cube.Cal();
                    break;
                default:
                    System.out.println("MidtermQuiz.main()");
                    break;
            }
            System.out.println(Color.YELLOW + "Do you want to calc else? \n1)Yes\n0)N0" + Color.RESET);
            again = EnteredValue() == 1 ? true : false;
        } while (again);
    }

    public static void main(String[] args) {
        System.out.println(Color.BLUE + "\nWelcome" + Color.RESET);
        DoCore();
        System.out.println(Color.GREEN + "GoodBye (:");

    }
}