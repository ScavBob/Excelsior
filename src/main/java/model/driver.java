package model;

import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class driver {
	public static void main(String[] args) {
		//Scanner read = new Scanner(System.in);
		URL url;
		try {
			url = new URL(args[0]);
			System.out.println("Finding suitable tables in " + args[0]);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid URL");
			return;
		}
		findList fl = new findList();
		ArrayList<String>[] tables = null;
		String name;
		name = fl.lister(url.toString(), tables, args[1]);
		if (name != null) {
			try {
				File file = new File(name +".xlsx");
				if (!Desktop.isDesktopSupported()) {
					System.out.println("not supported");
					return;
				}
				Desktop desktop = Desktop.getDesktop();
				if (file.exists()) {
					System.out.println("Spreadsheet created...");
					desktop.open(file);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
