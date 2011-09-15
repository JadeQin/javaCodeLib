package agileJava.ch11;

import java.io.File;

public class FileUtil {

	public void printFileTree(String dir) {
		File file = new File(dir);
		if (!file.exists() || !file.isDirectory()) {
			System.out.println("---");
		}
		System.out.println("/");
		printDir(file);
	}

	private void printDir(File dir) {
		File[] files = dir.listFiles();
		for (File f : files) {
			if (f.isFile()) {
				System.out.println("|-" + f.getName());
			} else {
				printDir(f);
			}
		}
	}

	public static void main(String[] ars) {
		FileUtil f = new FileUtil();
		f.printFileTree("D:/netbeans");
	}
}
