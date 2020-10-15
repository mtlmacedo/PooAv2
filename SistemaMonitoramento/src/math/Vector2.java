package math;

public class Vector2 {
	
	private float x, y;
	
	public Vector2(float x, float y) {
		this.setX(x);
		this.setY(y);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector2 other = (Vector2) obj;
		if( Float.floatToIntBits(x) != Float.floatToIntBits(other.x) || Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
			return false;
		
		return true;
	}

}
