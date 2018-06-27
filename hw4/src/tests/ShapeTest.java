package tests;

import java.util.Arrays;

import api.Cell;
import api.Shape;
import api.Position;

import hw4.IShape;
import hw4.LShape;
import hw4.OShape;
import hw4.JShape;
import hw4.SZShape;

public class ShapeTest {
	public static void main(String[] args) {

		System.out.println("I Shape:");
		IShapeTest();
		System.out.println();

		System.out.println("L Shape:");
		LShapeTest();
		System.out.println();

		System.out.println("J Shape:");
		JShapeTest();
		System.out.println();

		System.out.println("OShape:");
		OShapeTest();
		System.out.println();

		System.out.println("SZ Shape: ");
		SZShapeTest();
	}

	public static void IShapeTest() {
		Shape IShape = new IShape(new Position(0, 0), false);

		System.out.println("Expected: [(0, 0), (1, 0), (2, 0)]");
		System.out.println("Actual:   " + Arrays.toString(IShape.getCells()));
	}

	public static void LShapeTest() {
		Shape LShape = new LShape(new Position(0, 0), false);

		System.out.println("Expected: [(0, 0), (1, -2), (1, -1), (1, 0)]");
		System.out.println("Actual:   " + Arrays.toString(LShape.getCells()));
	}

	public static void JShapeTest() {
		Shape JShape = new JShape(new Position(0, 0), false);

		System.out.println("Expected: [(0, -1), (1, -1), (1, 0), (1, 1)]");
		System.out.println("Actual:   " + Arrays.toString(JShape.getCells()));
	}

	public static void OShapeTest() {
		Shape OShape = new OShape(new Position(0, 0), false);

		System.out.println("Expected: [(0, 0), (0, 1), (1, 0), (1, 1)]");
		System.out.println("Actual:   " + Arrays.toString(OShape.getCells()));

		OShape.transform();

		System.out.println();
		System.out.println("After Transform:");
		System.out.println("Expected: [(0, 0), (0, 1), (1, 0), (1, 1)]");
		System.out.println("Actual:   " + Arrays.toString(OShape.getCells()));
	}


	public static void SZShapeTest() {
		Shape SZShape = new SZShape(new Position(0, 0), false);

		System.out.println("Expected: [(0, 0), (1, 0), (1, 1), (2, 1)]");
		System.out.println("Actual:   " + Arrays.toString(SZShape.getCells()));

		SZShape.transform();
		Cell[] cells = SZShape.getCells();

		System.out.println();
		System.out.println("After Transform 1:");
		System.out.println("Expected: [(0, 1), (1, 1), (1, 0), (2, 0)]");
		System.out.println("Actual:   " + Arrays.toString(SZShape.getCells()));
		System.out.println("Expected: -65536");
		System.out.println("Actual:   " + cells[0].getBlock().getColorHint().getRGB());

		SZShape.transform();
		cells = SZShape.getCells();

		System.out.println();
		System.out.println("After Transform 2:");
		System.out.println("Expected: [(0, 0), (1, 0), (1, 1), (2, 1)]");
		System.out.println("Actual:   " + Arrays.toString(SZShape.getCells()));
		System.out.println("Expected: -16711936");
		System.out.println("Actual:   " + cells[0].getBlock().getColorHint().getRGB());
	}
}
