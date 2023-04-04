package prog52instinner;

public class Top {
	int t = 1;
	Middle mid;
	Middle.Bottom midbot;
	//returns the value in the instance vble of Bottom
	int readBottom() {
		if(mid == null) this.mid = new Middle();
		if(midbot == null) this.midbot = this.mid.new Bottom();

		return this.midbot.b;
	}
	class Middle {
		int m = 2;

		int addTopAndBottom() {
			return t + midbot.b;
		}
		class Bottom {
			int b = 3;
			int multiplyAllThree() {
				return t * m * b;
			}
		}
	}
	public static void main(String[] args){
		Top top = new Top();

		System.out.println(top.readBottom());
		System.out.println(top.mid.addTopAndBottom());
		System.out.println(top.midbot.multiplyAllThree());
	}
}