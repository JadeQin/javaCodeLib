package javaCore.ch7;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleFrameTest {

	public static void main(String[] args) {
		JFrame frame = new SizedFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class SimpleFrame extends JFrame {

	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;

	public SimpleFrame() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle(screenWidth + "*" + screenHeight);
	}
}

class SizedFrame extends JFrame {

	public SizedFrame() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		setSize(screenWidth / 2, screenHeight / 2);
		setLocationByPlatform(true);
		setTitle("SizedFrame");
		add(new StringPanel("Hello World!"));
	}
}

class StringPanel extends JPanel {

	public static final int MESSAGE_X = 75;
	public static final int MESSAGE_Y = 100;

	private String msg;

	public StringPanel(String msg) {
		super();
		this.msg = msg;
	}

	public void paintComponent(Graphics g) {
		g.drawString(msg, MESSAGE_X, MESSAGE_Y);
	}
}
