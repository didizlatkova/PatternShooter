package elements.abstracts;

public class Position {

	public int x;
	public int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Position)) {
			return false;
		}

		Position that = (Position) other;

		return this.x == that.x && this.y == that.y;
	}
}
