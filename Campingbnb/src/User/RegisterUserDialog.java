package User;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RegisterUserDialog extends JDialog{
	JPanel jPanel;
	JLabel lId,lName,lPassword,lPhoneNum, lEmail, lRole;
	JTextField tfId,tfName,tfPassword, tfPhoneNum, tfEmail, tfRole;
    JButton btnReg;
    JRadioButton radioBtn1, radioBtn2;
 
    
    public RegisterUserDialog(String str){
    	setTitle(str);
    	init();
    }
    
    private void init(){
    	lId = new JLabel("아이디");
    	lPassword = new JLabel("비밀번호");
    	lName= new JLabel("이름");
    	lPhoneNum = new JLabel("전화번호");
    	lEmail = new JLabel("이메일");
    	
    	
//     	lRole = new JLabel("역할(손님(0), 캠핑장주인(1)"); // radio 버튼이나 dropdown으로 바꾸면 좋을 듯 
    	radioBtn1 = new JRadioButton("손님");
    	radioBtn1.setSelected(true);
    	radioBtn2 = new JRadioButton("캠핑장 주인");

    	ButtonGroup  group = new ButtonGroup();

    	group.add(radioBtn1);
    	group.add(radioBtn2);

    	
    	
    	tfId=new JTextField(20);
    	tfPassword=new JTextField(20);
    	tfName=new JTextField(20);
    	tfPhoneNum=new JTextField(20);
    	tfEmail=new JTextField(20);
//    	tfRole = new JTextField(20);

    	
    	btnReg=new JButton("등록하기");
    	
   	 	btnReg.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
		    	UserImpl userController = new UserImpl();

				String id = tfId.getText().trim();
				String password = tfPassword.getText().trim();
				String  name = tfName.getText().trim();
				String phoneNum = tfPhoneNum.getText().trim();
				String email = tfEmail.getText().trim();
				String role = null;
				
				Enumeration<AbstractButton> enums = group.getElements();
				
				int gibonCode = 0;
				while(enums.hasMoreElements()) {           
				    AbstractButton ab = enums.nextElement();   
				    JRadioButton jb = (JRadioButton)ab;        
				 
				    if(jb.isSelected())
				    	if (jb.getText().trim().equals("손님")) {
				    		role = "0\n";
				    	} else {
				    		role = "1\n";
				    	}
				}
				
				
				UserVO vo=new UserVO(id,password,name,phoneNum,email, role);
				try {
					userController.registerUser(vo);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				showMessage("새 회원을  등록했습니다.");
				tfId.setText("");
				tfPassword.setText("");
				tfName.setText("");
				tfPhoneNum.setText("");
				tfEmail.setText("");
				
				//dispose();
				
			}
        });
    	
    	
    	jPanel=new JPanel(new GridLayout(0,2));
    	
    	jPanel.add(lId);
    	jPanel.add(tfId);
    	
    	jPanel.add(lPassword);
    	jPanel.add(tfPassword);
    	
    	jPanel.add(lName);
    	jPanel.add(tfName);
    	    	
    	jPanel.add(lPhoneNum);
    	jPanel.add(tfPhoneNum);
    	
    	jPanel.add(lEmail);
    	jPanel.add(tfEmail);
    	
    	
    	
//    	jPanel.add(lRole);
//    	jPanel.add(tfRole);
    	
    	jPanel.add(radioBtn1);
    	jPanel.add(radioBtn2);

    	add(jPanel,BorderLayout.NORTH);
    	add(btnReg,BorderLayout.SOUTH);
    	

        setLocation(400, 200);
        setSize(400,400);
        setModal(true); 
        setVisible(true);
    }
    
    private void showMessage(String msg){
    	JOptionPane.showMessageDialog(this,
    			msg, 
    			"메지지 박스",
               JOptionPane.INFORMATION_MESSAGE);
    }
}
