package br.com.sidh.mydiff.comparision;

public class AppMain {

	public static void main(String[] args) {

		String dir1 = "C:/Users/itau-consultor09/compare/prod";
		String dir2 = "C:/Users/itau-consultor09/compare/repo";
		DiffFinder finder = new DiffFinder(dir1, dir2);
		finder.execute();
		
		for(DiffFile diff: finder.getDiffs()) {
			System.out.println(diff);
		}
	}

}
