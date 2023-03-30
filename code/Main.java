import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Chan is = new Chan();
        String fileName = "C:/Users/Huawei/Desktop/Chan_algoritm/data.txt";
        Point np = new Point(0, 0);
        try {
            Scanner fileReader = new Scanner(new File(fileName));
            for(int i = 0; i < 100; i++){
                long startTime = System.nanoTime();
                List<Point> points = new ArrayList<Point>();
                List<Point> result = new ArrayList<Point>();
                int length = fileReader.nextInt();
                for(int j = 0; j < length; j++){
                    double x = fileReader.nextDouble();
                    np.setX(x);
                    double y = fileReader.nextDouble();
                    np.setY(y);
                    points.add(np);
                }
                if(points.size() <= 3){
                    System.out.println("Number of points must be at least 3");
                    return;
                }
                result=is.convexHull(points);
                long endTime = System.nanoTime();
                System.out.println( length + " " +is.iterate);
            }
        } catch(FileNotFoundException ex){
            System.out.println("Error reading file '"+ fileName + "'");
        } catch(IOException ex) {
            System.out.println("Error reading file '"+ fileName + "'");
        }
    }
}
