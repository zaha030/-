import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EndingWork extends JFrame{
	private Container cp;
	private JLabel lab = new JLabel("長度:");
	private JLabel lab1 = new JLabel("強度:");
	private JLabel lab2 = new JLabel("組數:");
	private JLabel lab3 = new JLabel("身分證:");
	private JLabel lab4 = new JLabel("生日:");
	private JButton btn = new JButton("執行");
	private JButton btn1 = new JButton("儲存");
	private JButton btn2 = new JButton("結束");
	private JTextField tf = new JTextField();
	private JTextField tf1 = new JTextField();
	private JTextField tf2 = new JTextField();
	private JTextField tf3 = new JTextField();
	private JTextArea ta = new JTextArea();
	private JTextArea ta1 = new JTextArea();
	private JComboBox cb = new JComboBox();
	
	public EndingWork() {
		initComp();
	}
	
	public void initComp() {
		cp = this.getContentPane();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		cp.setLayout(null);
		this.setTitle("Rand_Password");
		this.setBounds(300, 300, 600, 380);
		lab.setBounds(20, 20, 50, 30);
		this.add(lab);
		lab1.setBounds(20, 60, 50, 30);
		this.add(lab1);
		lab2.setBounds(20, 100, 50, 30);
		this.add(lab2);
		lab3.setBounds(20, 140, 50, 30);
		this.add(lab3);
		lab4.setBounds(20, 180, 50, 30);
		this.add(lab4);
		tf.setBounds(100, 25, 150, 20);
		this.add(tf);
		cb.setBounds(100, 65, 150, 20);
		this.add(cb);
		tf1.setBounds(100, 105, 150, 20);
		this.add(tf1);
		tf2.setBounds(100, 145, 150, 20);
		this.add(tf2);
		tf3.setBounds(100, 185, 150, 20);
		this.add(tf3);
		btn.setBounds(20, 300, 75, 20);
		this.add(btn);
		btn1.setBounds(100, 300, 75, 20);
		this.add(btn1);
		btn2.setBounds(180, 300, 75, 20);
		this.add(btn2);
		ta.setBounds(300, 20, 280, 150);
		this.add(ta);
		ta.setBackground(Color.gray);
		ta1.setBounds(300, 180, 280, 150);
		this.add(ta1);
		ta1.setBackground(Color.gray);
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EndingWork mfrm = new EndingWork();
		mfrm.setVisible(true);
	}

}
