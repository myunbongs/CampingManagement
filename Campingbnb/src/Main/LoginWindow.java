package Main;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import User.RegisterUserDialog;
import User.UserVO;

@SuppressWarnings("serial")
public class LoginWindow extends JFrame {

	private JPanel contentPane;
	public JTextField tfUsername;
	private JTextField tfPassword;
	private JButton loginBtn, joinBtn;

	/**
	 * Create the frame.
	 */
	public LoginWindow() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("username");
		lblLogin.setBounds(41, 52, 69, 35);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(41, 103, 69, 35);
		contentPane.add(lblPassword);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(157, 52, 176, 35);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		joinBtn = new JButton("ȸ������");
		joinBtn.setBounds(229, 154, 104, 29);
		contentPane.add(joinBtn);
		
		loginBtn = new JButton("�α���");
		loginBtn.setBounds(108, 154, 106, 29);
		contentPane.add(loginBtn);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(157, 103, 176, 35);
		contentPane.add(tfPassword);
		
		setVisible(true);

		//ȸ������ �׼�
		joinBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new RegisterUserDialog("ȸ������");
			}
		});
		/////////////////////�α��� �׼�//////////////////////
		loginBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				File file =new File("userData.txt");
				FileReader fr = null;
				try {
					fr = new FileReader(file);
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				BufferedReader br=new BufferedReader(fr);
				String userInfo=null;
				String userData[]=null;
								
				boolean check = false;
				try {
					while((userInfo=br.readLine())!=null){
						userData = userInfo.split(",");
						
						for (int i = 0; i < userData.length; i++ ) {
							System.out.println(i + "��°" + userData[i]);
						}
						
						if(userData[0].equals(tfUsername.getText()) && userData[1].equals(tfPassword.getText())) {
							if(userData[5].equals("0")) {
								showMessage("�մ����� �α����մϴ�.");
								check = true;
								MainWindow.login.setVisible(false);
								MainWindow.Main.startFrame1();
								break;
								}
							else if (userData[5].equals("1")){
								showMessage("ķ���� �������� �α����մϴ�.");
								check = true;
								MainWindow.login.setVisible(false);
								MainWindow.Main.startFrame2();
								break;
							}
							else {
								showMessage("�߸��� ȸ�� �����Դϴ�.");
							}
						}
					}
					if(check == false)
						showMessage("�α��� ����.");
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    
				try {
					fr.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				


			}
		});
		/////////////////////�α��� �׼�//////////////////

	}	
	private void showMessage(String msg){
	       JOptionPane.showMessageDialog(this,
	             msg, 
	             "������ �ڽ�",
	               JOptionPane.INFORMATION_MESSAGE);
	    }
}


