package zeichnen;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class RectShape extends Shape {

	public RectShape(Color c, int x, int y, int width, int height) {
		super(c, x, y, width, height);
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillRect(r.x, r.y, r.width, r.height);
	}

	@Override
	public double calcArea() {
		return r.width * r.height;
	}

	@Override
	public double calcUmfang() {
		return 2 * (r.width + r.height);
	}

	@Override
	public boolean contains(Point p) {
		return r.contains(p);
	}

	@Override
	public String getTitle() {
		return "Shape Info: Rect";
	}

}
