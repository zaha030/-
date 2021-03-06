import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EndingWork extends JFrame{
	String[] strength = {"低" ,"中" ,"高"};
	private Container cp;
	private JLabel lab = new JLabel("長度:");
	private JLabel lab1 = new JLabel("強度:");
	private JLabel lab2 = new JLabel("組數:");
	private JLabel lab3 = new JLabel("身分證:");
	private JLabel lab4 = new JLabel("生日:");
	private JLabel lab5 = new JLabel("(生日格式:MMDD)");
	private JButton btn = new JButton("執行");
	private JButton btn1 = new JButton("儲存");
	private JButton btn2 = new JButton("結束");
	private JTextField tf = new JTextField();
	private JTextField tf1 = new JTextField();
	private JTextField tf2 = new JTextField();
	private JTextField tf3 = new JTextField();
	private JTextArea ta = new JTextArea();
	private JTextArea ta1 = new JTextArea();
	private JComboBox cb = new JComboBox(strength);
	private JScrollPane jsp=new JScrollPane(ta);
	private JScrollPane jsp1=new JScrollPane(ta1);
	private Dialog dlg;
	private FileDialog fDialog;
	
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
		lab5.setBounds(100, 220, 150, 30);
		this.add(lab5);
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
		jsp.setBounds(300, 20, 280, 150);
		this.add(jsp);
		ta.setBackground(Color.CYAN);
		jsp1.setBounds(300, 180, 280, 150);
		this.add(jsp1);
		ta1.setBackground(Color.LIGHT_GRAY);
		dlg = new Dialog(this);
		fDialog = new FileDialog(this);
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ta.setText("");
				String s1 = (String) cb.getSelectedItem();//強度
				int i1 = Integer.parseInt(tf.getText());//長度
				int i2 = Integer.parseInt(tf1.getText());//組數
				int num=0;
				String s4 = "";//顯示密碼
				String s5 = "";//暫存密碼
				
				String str = "";//字典檔
				String str1 = tf2.getText();
				String str2 = tf3.getText();
				String nstr = str1+str2;
				char [] array = nstr.toCharArray();
				fun(array, 0, array.length);
				
				switch(s1){
				case "低":
					for(int j =0;j<i2;j++){
						if(j>0){
							s4+="\n";
							s5="";
						}
						while(s5.length()<i1){
							num = (int) (( Math.random()*(10) ) + 48);
							s5+=(char)num;
						}
						s4+=s5;
					}
					break;
				case "中":
					for(int j =0;j<i2;j++){
						if(j>0){
							s4+="\n";
							s5="";
						}
						while(s5.length()<i1){
							num = (int) (( Math.random()*(75) ) + 48);
							  if (num > 57 && num < 97){
								  continue;
							  } else if (num == 79 || num == 73){
								  continue;//排除I跟O
							  }
							s5+=(char)num;
						}
						s4+=s5;
					}
					break;
				case "高":
					for(int j =0;j<i2;j++){
						if(j>0){
							s4+="\n";
							s5="";
						}
						while(s5.length()<i1){
							num = (int) (( Math.random()*(75) ) + 48);
							  if (num > 57 && num < 65){
								  continue;
							  }else if (num > 90 && num < 97){
								  continue;
							  }else if (num == 79 || num == 73){
								  continue;//排除I跟O
							  }
							s5+=(char)num;
						}
						s4+=s5;
					}
					break;
				}
				ta.append(s4);
			}
			
			public void fun(char[] a,int s, int e){
			     String str = "";
			        if(s==e){
			            for(int i=0; i<e; i++) {
			                ta1.append(a[i]+" ");
			            }
			            ta1.append("\n");
			        }
			        else {
			            for (int i = s; i < e; i++) {
			                swap(a, s, i);
			                fun(a, s + 1, e);
			                swap(a, i, s);
			            }
			        }
			    }

			    private void swap(char[]a,int x1, int x2){
			        char tmp = a[x1];
			        a[x1] = a[x2];
			        a[x2] = tmp;
			    }
		});
		
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				fDialog.setVisible(true);
				String fileName = fDialog.getDirectory() + fDialog.getFile();
				try {
					FileOutputStream fo = new FileOutputStream(fileName);
					byte data[] = ta1.getText().getBytes();
					fo.write(data);
					fo.close();
				} catch (IOException ioe) {
				}	
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EndingWork mfrm = new EndingWork();
		mfrm.setVisible(true);
	}

}
