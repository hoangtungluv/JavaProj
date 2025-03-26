package fita.vnua;

public class Diem {
	
	float x;
	float y;
	
	public Diem() {
		x = 0;
		y = 0;
	}
	
	public Diem(float x, float y) {
	
		this.x = x;
		this.y =y;
	}
	
	public float kc(Diem d) {
	
	float kc= (float)Math.sqrt((x-d.x)*(x-d.x) + (y-d.y)*(y-d.y));
	return kc;
	}
	
	public void inDiem() {
	System.out.println("(" + x + "," + y + ")");
	}
	
	public static void main(String[] args) {
	Diem d1 = new Diem();
	d1.inDiem();
	
	Diem d2 = new Diem(3,4);
	d2.inDiem();
	
	System.out.println("Khoảng cách d1-d2 " + d1.kc(d2));
	}
}
