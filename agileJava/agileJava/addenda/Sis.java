package agileJava.addenda;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sis {

	private JFrame frame=new JFrame();
	
	public static void main(String[] args){
		Sis sis=new Sis(300,200);
		sis.draw(new CoursePanel());
		sis.show();
	}
	
	public Sis(int width,int height){
		frame.setSize(width, height);
	}
	
	public void draw(JPanel panel){
		frame.getContentPane().add(panel);
	}
	
	public void show(){
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void close(){
		frame.dispose();
	}
}

class CoursePanel extends JPanel{
	
	public CoursePanel(){
		JLabel label=new JLabel("Course:");
		add(label);
	}
}