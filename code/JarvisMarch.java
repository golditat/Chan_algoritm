import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JarvisMarch {
    public static int iterate = 0;
    public static List<Point> convexHull(List<Point> points) {
        List<Point> result = new ArrayList<Point>();
        Point extreme = Helper.findExtreme(points);
        result.add(extreme);
        Point p = extreme;
        Point q = extreme;

        while(true) {
            Point r = new Point(0, 0);
            for(int i=0; i<points.size();i++) {
                if((points.get(i).getX() == p.getX()) && (points.get(i).getY() == p.getY())) {
                    continue;
                }
                r.setX(points.get(i).getX());
                r.setY(points.get(i).getY());
                int turn = Helper.orientation(p,q,r);
                double dist = Helper.compare(Helper.dist(p,r),Helper.dist(p,q));
                if(turn == -1 || turn == 0 && dist == 1) {
                    q.setX(r.getX());
                    q.setY(r.getY());
                }
                iterate += 1;
            }
            if((q.getX() == result.get(0).getX()) && (q.getY() == result.get(0).getY())) {
                break;
            }
            result.add(q);
            p.setX(q.getX());
            p.setY(q.getY());
            iterate += 1;
        }
        return result;
    }
}
