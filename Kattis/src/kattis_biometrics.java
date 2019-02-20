import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_biometrics {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n;
        while ((n = Integer.parseInt(reader.readLine())) != 0) {
            Point[][] f = new Point[n][2];
            for (int t = 0; t < 2; t++) {           
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int i = 0; i < n; i++) {
                    double x = Double.parseDouble(tokenizer.nextToken());
                    double y = Double.parseDouble(tokenizer.nextToken());
                    f[i][t] = new Point(x, y);
                }
            }
            double[][] edges = new double[n][2];
            for (int t = 0; t < 2; t++) {
                for (int i = 0; i < n; i++) {
                    edges[i][t] =  distance(f[i][t], f[(i + 1) % n][t]);
                }
            }
            
            double precision = 0.000001;
            // check scaling
            boolean isSimilar = true;
            double ratio = edges[0][0] / edges[0][1];
            for (int i = 1; i < n; i++) {
                if (Math.abs(edges[i][0] / edges[i][1] - ratio) > precision) {
                    isSimilar = false;
                }
            }
//          
//          if (isSimilar) {
//              for (int i = 0; i < n; i++) {
//                  f[i][1].scale(ratio);
//              }
//          }
//          
//          //move
//          
//          for (int t = 0; t < n; t++) {
//              double x_diff = f[t][0].x - f[t][1].x;
//              double y_diff = f[t][0].y - f[t][1].y;
//              for (int i = t; i < n; i++) {
//                  f[i][1].x += x_diff;
//                  f[i][1].y += y_diff;
//              }
//          }
//          
//          isSimilar = true;
//          for (int i = 0; i < n; i++) {
//              if (f[i][0].x - f[i][1].x > precision || f[i][0].y - f[i][1].y > precision) {
//                  isSimilar = false;
//              }
//          }
            for (int i = 2; i < n; i++) {
                double side1 = (f[1][0].x - f[0][0].x) * (f[i][0].y - f[0][0].y) - (f[i][0].x - f[0][0].x) * (f[1][0].y - f[0][0].y);
                double side2 = (f[1][1].x - f[0][1].x) * (f[i][1].y - f[0][1].y) - (f[i][1].x - f[0][1].x) * (f[1][1].y - f[0][1].y);
                if (side1 * side2 < 0) {
                    isSimilar = false;
                }
            }
            
            if (isSimilar) {
                System.out.println("similar");
            } else {
                System.out.println("dissimilar");
            }
        }
    }
    
    static double distance(Point x, Point y) {
        return Math.sqrt((x.x - y.x) * (x.x - y.x)
                + (x.y - y.y) * (x.y - y.y));
    }
    
    static class Point {
        double x;
        double y;
        Point(double _x, double _y) {
            x = _x;
            y = _y;
        }
        
        public void scale(double ratio) {
            x *= ratio;
            y *= ratio;
        }
    }
}
