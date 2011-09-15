package jsop.test;

import java.io.IOException;
import java.net.URL;

import junit.framework.TestCase;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Main extends TestCase {

	public void testJsop() throws IOException {
		// System.out.println(getQQIpInfo("60.253.23.14"));
		for (int i = 0; i < 7; i++) {
			System.out.print(i + "---");
			System.out.println(100 + 161 * i);
		}

	}

	private String getSogouIpInfo(String ip) throws IOException {
		URL url = new URL("http://www.123cha.com/ip/?q=" + ip);
		Document doc = Jsoup.parse(url, 3 * 1000, "UTF-8");
		Element element = doc.select("#csstb>li:eq(7)").first();
		String s = element.text();
		return s.substring(0, s.indexOf(160));
	}

	private String getIp138Info(String ip) throws IOException {
		URL url = new URL("http://www.ip138.com/ips8.asp?ip=" + ip
				+ "&action=2");
		Document doc = Jsoup.parse(url, 3 * 1000, "GB2312");
		Element element = doc.select(".ul1>li:eq(1)").first();
		System.out.println(element.text().split("：")[1].split(" ")[0]);
		return element.text().split("：")[1].split(" ")[0];
	}

	private String getQQIpInfo(String ip) throws IOException {
		URL url = new URL("http://ip.qq.com/cgi-bin/searchip?searchip1=" + ip);
		Document doc = Jsoup.parse(url, 3 * 1000, "GB2312");
		Element element = doc.select("[name=shareip] span").get(2);
		return element.text();
	}

}
