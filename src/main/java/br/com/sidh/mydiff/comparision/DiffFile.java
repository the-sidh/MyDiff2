package br.com.sidh.mydiff.comparision;

public class DiffFile {
 
	private String fileName;
	private DiffLevel level;
	
		
	public DiffFile() {
		super();
	}
	public DiffFile(String fileName, DiffLevel level) {
		super();
		this.fileName = fileName;
		this.level = level;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public DiffLevel getLevel() {
		return level;
	}
	public void setLevel(DiffLevel level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "DiffFile [fileName=" + fileName + ", level=" + level + "]";
	}
	
	
	
}
