/*
 * Given n points on a 2D plane, find the maximum number 
 * of points that lie on the same straight line.
 */
import java.util.HashMap;

public class MaxPtonLine {
    
    public int maxPoints(Point[] points) {
        int max = 1;
        HashMap<Double,Integer> map;
        
        if (points.length == 0)
            return 0;
        
        for (int i = 0; i < points.length; i++) {
            int t_max = 0;
            int vert_num = 0;
            int duplicate = 0;
            map = new HashMap<Double,Integer>();

            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    if (points[j].x == points[i].x && points[j].y == points[i].y) {
                        duplicate++;
                    } else if (points[j].x == points[i].x) {
                        vert_num++;
                        t_max = Math.max(t_max, vert_num);
                    } else {
                        Double ang = new Double((points[j].y - points[i].y)*1.0/(points[j].x - points[i].x));
                        Integer num = map.get(ang);
                        if (num == null) {
                            map.put(ang, 1);
                            t_max = Math.max(t_max, 1);
                            num = 1;
                        } else {
                            num++;
                            t_max = Math.max(t_max, num);
                            map.put(ang, num);
                        }
                    }
                }
                
            }
            t_max = t_max + duplicate +1;
            max = Math.max(max, t_max);
        }
        
        
        return max;
    }
    
    public static void main(String[] args) {
        Point t1[] = {new Point(84,250), new Point(0,0),new Point(1,0),new Point(0,-70),
                new Point(0,-70),new Point(1,-1),new Point(21,10),new Point(42,90),new Point(-42,-230)};
        Point t2[] = {new Point(2,3), new Point(3,3), new Point(-5,3)};
        MaxPtonLine m = new MaxPtonLine();
        System.out.println(m.maxPoints(t1));
        System.out.println(m.maxPoints(t2));
    }

}
