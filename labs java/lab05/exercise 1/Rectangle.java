import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Rectangle {
    private double width = 1;
    private double height = 1;

    public Rectangle(double width, double height) {

        setWidth(width);
        setHeight(height);
    }

    public void setWidth(double width) {
        if (width < 0) {
            throw new IllegalArgumentException("Width must be a positive. ");
        } else {
            this.width = width;
        }
    }

    public void setHeight(double height) {
        if (height < 0) {
            throw new IllegalArgumentException("Width must be a positive. ");
        } else {
            this.height = height;
        }
    }

    public double getArea() {
        return width * height;
    }

    public String toString() {
        return "width = " + width + ", height = " + height + ", area = " + getArea();
    }

}

class TestRectangle {
    public static void main(String[] args) {
        ArrayList<Rectangle> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        double width, height;
        do {
            try {
                System.out.println("Enter width and height (0 to finish): ");
                width = input.nextDouble();
                if (width == 0) {
                    break;
                }
                height = input.nextDouble();
                if (height == 0) {
                    break;
                }

                list.add(new Rectangle(width, height));
            } catch (InputMismatchException ex) {
                System.out.println("Input Error: 2 positive numbers are required");
                input.nextLine();// Read away the letter. If not it will go into an infinite loop.
            } catch (IllegalArgumentException ex) {
                System.out.println("Input Error: " + ex.getMessage());
            }
        } while (true);

        System.out.println("No\tRectangles");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + "\t" + list.get(i));
        }

    }
}
