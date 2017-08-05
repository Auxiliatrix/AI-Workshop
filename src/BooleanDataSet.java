
public class BooleanDataSet {

	public static final int INPUTS = 2;
	
	public static void main(String[] args) {
		
		boolean[][] data = generate(INPUTS);
		boolean[] solutions = solve(data);
		print(data);
		String sol = print(solutions);
		System.out.println(sol);
	}
	public static boolean[][] generate(int inputs) {
		boolean[][] data = new boolean[(int) Math.pow(2, inputs)][inputs];
		for( int f=0; f<(int) Math.pow(2, inputs); f++ ) {
			for( int g=0; g<inputs; g++ ) {
				data[f][inputs-(g+1)] = 1 == ((f % (int) Math.pow(2, g+1)) / (int) Math.pow(2, g));
			}
		}
		return data;
	}
	public static boolean[] solve(boolean[][] data) {
		boolean[] solutions = new boolean[data.length];
		for( int f=0; f<data.length; f++) {
			solutions[f] = process(data[f]);
		}
		return solutions;
	}
	public static boolean process(boolean[] set) {
		boolean ret = false;
		ret = set[0] || set[1];
		return ret;
	}
	public static void print(boolean[][] twoD) {
		for( boolean[] oneD : twoD ) {
			System.out.println(print(oneD) + ",");
		}
	}
	public static String print(boolean[] oneD) {
		String ret = "";
		ret += "{";
		for( boolean b : oneD ) {
			if( b )
				ret += "1, ";
			else
				ret += "0, ";
		}
		ret += "}";
		return ret;
	}
}
