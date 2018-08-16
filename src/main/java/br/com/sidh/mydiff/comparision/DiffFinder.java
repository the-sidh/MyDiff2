package br.com.sidh.mydiff.comparision;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class DiffFinder {

	List<DiffFile> diffs = new ArrayList<DiffFile>();
	String dir1;
	String dir2;
	
	

	public DiffFinder(String dir1, String dir2) {
		super();
		this.dir1 = dir1;
		this.dir2 = dir2;
	}

	public void execute() {
		compare(dir1);

	}

	public void compare(String elem1) {
		File file1 = new File(elem1);
		if (file1.exists()) {
			if (file1.isDirectory()) {
				if(!new File(dir2 + elem1.replace(dir1, "")).exists()) {
					diffs.add(new DiffFile(elem1, DiffLevel.DIR2_NON_EXISTANT));
					return;
				}
				String[] file1Content = file1.list();
				for (String file : file1Content) {
					compare(elem1 +"/" + file);
				}
			} else {
				compareFile(elem1);
			}
		}
	}

	private void compareFile(String elem1) {
		String md51 = getMD5(elem1);
		String md52 = "";
		if (new File(dir2 + elem1.replace(dir1, "")).exists()) {
			md52 = getMD5(dir2 + elem1.replace(dir1, ""));
			if (!md51.equals(md52)) {
				diffs.add(new DiffFile(elem1, DiffLevel.DIFFERENT_FILES));
			}
		}else {
			diffs.add(new DiffFile(elem1, DiffLevel.FILE2_NON_EXISTANT));
		}
	}

	public List<DiffFile> getDiffs() {
		return diffs;
	}

	private String getMD5(String file) {
		MessageDigest m = null;
		try {
			String s = new String(Files.readAllBytes(Paths.get(file)));

			m = MessageDigest.getInstance("MD5");
			m.update(s.getBytes(), 0, s.length());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new BigInteger(1, m.digest()).toString(16);
	}

}
