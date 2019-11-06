import java.io.File;
import java.util.Scanner;

public class PointApp {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("points.txt"));
		while(in.hasNextInt()) {
			Point p1 = new Point();
			p1 = p1.read(in);
			Point p2 = new Point();
			p2 = p2.read(in);
			printPoints(p1,p2);
			xRefl(p1,p2);
			yRefl(p1,p2);
			oRefl(p1,p2);
			equiDist(p1,p2);
			printDist(p1,p2);
			System.out.println();
		}
		in.close();
	}




	// prints the distance between p1, and p2
	private static void printDist(Point p1, Point p2) {
		System.out.println("The distance between "+p1 + " and "+ p2 + " is "
				+ p1.distance(p2));
	}
	// checks if the two points reflect across the y-axis
	private static void equiDist(Point p1, Point p2) {
		if(p1.equals(p2) || p1.originReflection().equals(p2) ||p1.xReflection().equals(p2) || p1.yReflection().equals(p2)) {
			System.out.println("p1 and p2 are equidistant from the origin");
		}
	}
	// checks if the two points reflect across the origin
	private static void oRefl(Point p1, Point p2) {
		if(p1.originReflection().equals(p2)) {
			System.out.println("p1 and p2 are reflections through the origin");
		}
	}

	// checks if the two points reflect across the x-axis
	private static void xRefl(Point p1, Point p2) {
		if(p1.xReflection().equals(p2)) {
			System.out.println("p1 and p2 are reflections across the x-axis");
		}

	}

	// checks if the two points reflect across the origin
	private static void yRefl(Point p1, Point p2) {

		if(p1.yReflection().equals(p2)) {
			System.out.println("p1 and p2 are reflections across the y-axis");
		}
	}

	// prints the points passed in
	private static void printPoints(Point p1, Point p2) {
		System.out.println("p1: "+ p1 + " (quadrant "+ p1.quadrant()+ ") / "
				+ ("p2: "+ p2 + " (quadrant "+ p2.quadrant()+ ")"));
		Point p3 = new Point();
		p3 = p1.add(p2);
		System.out.println("p1+p2: "+ p3 + " (quadrant "+ p3.quadrant()+ ")");
	}

}
