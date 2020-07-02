package model;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class findList {
	public String lister(String url, ArrayList[] tables, String file) {
		int[] rowSizes = null;
		try {
			String html = Jsoup.connect(url).get().toString();
			Document doc = Jsoup.parseBodyFragment(html);
			Element body = doc.body();
			Elements lists = doc.getElementsByTag("table");
			tables = new ArrayList[lists.size()];
			rowSizes = new int[lists.size()];
			for (int i = 0; i < lists.size(); i++) {
				tables[i] = new ArrayList<String>();
			}
			int i = 0;
			for (Element list : lists) {
				int rowNo = 0;
				Elements headers = list.getElementsByTag("th");
				for (Element header : headers) {
					tables[i].add(header.text());
					rowNo++;
				}
				rowSizes[i] = rowNo;
				Elements cells = list.getElementsByTag("td");
				for (Element cell : cells) {
					if (cell.hasText()) {
						tables[i].add(cell.text());
					} else {
						tables[i].add(cell.getElementsByTag("a").attr("title"));
					}
				}
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		String name;
		createList cl = new createList();
		name = cl.creator(tables, rowSizes, file);
		return name;
	}
}
