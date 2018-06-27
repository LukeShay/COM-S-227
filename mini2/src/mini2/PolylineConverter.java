package mini2;

import java.awt.Point;

import java.util.ArrayList;
import java.util.Scanner;

import api.Converter;
import plotter.Plotter;
import plotter.Polyline;

/**
 * Converts a string into a <code>Polyline</code> object. The given
 * string must conform to the format specified for one valid line of
 * the file as described in Lab 8, checkpoint 2. See
 * 
 * <pre>
 * http://web.cs.iastate.edu/~cs227/labs/lab8/page12.html
 * </pre>
 */
public class PolylineConverter implements Converter<Polyline> {

	public PolylineConverter() {

	}

	@Override
	public Polyline convert(String s) {
		Scanner scan = new Scanner(s);

		Polyline p;

		if (scan.hasNextInt()) {
			int givenWidth = scan.nextInt();
			p = new Polyline(scan.next(), givenWidth);
		}
		else {
			p = new Polyline(scan.next());
		}


		while (scan.hasNext()) {
			p.addPoint(new Point(scan.nextInt(), scan.nextInt()));
		}
		scan.close();
		return p;
	}
}
