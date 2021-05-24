package Camping;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CampingUploadDialog  extends JDialog{
	JPanel jPanel;
	JLabel lCampingNumber, lCampingName,lCampingMax, lCampingAddress, lCampingPrice;
	JTextField tfCampingNumber,tfCampingName,tfCampingMax,tfCampingAddress,tfCampingPrice ;
    JButton btnReg;
    
    Camping campingController;
    
    public CampingUploadDialog(String str){
    	setTitle(str);
    	init();
    }
    
    private void init(){
    	campingController = new CampingImpl();
    	lCampingNumber = new JLabel("ķ���� ��ȣ");
    	lCampingName = new JLabel("ķ���� �̸�");
    	lCampingMax = new JLabel("ķ�� �ִ� �ο�");
    	lCampingAddress = new JLabel("ķ���� �ּ�");
    	lCampingPrice = new JLabel("���ڷ�(��/��)");
    	
    	
    	tfCampingNumber = new JTextField(20);
    	tfCampingName = new JTextField(20);
    	tfCampingMax = new JTextField(20);
    	tfCampingAddress = new JTextField(20);
    	tfCampingPrice = new JTextField(20);
    	
    	btnReg=new JButton("����ϱ�");
    	
   	 	btnReg.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int campingNumber = Integer.parseInt(tfCampingNumber.getText().trim());
				String campingName = tfCampingName.getText().trim();
				int campingMax = Integer.parseInt(tfCampingMax.getText().trim());
				String campingAddress = tfCampingAddress.getText().trim();
				int campingPrice = Integer.parseInt(tfCampingPrice.getText().trim());
				
				CampingVO vo=new CampingVO(campingNumber,campingName,campingMax,campingAddress,campingPrice);
				try {
					campingController.uploadCampingInfo(vo);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				showMessage("ķ������ ����߽��ϴ�.");
				tfCampingNumber.setText("");
				tfCampingName.setText("");
				tfCampingMax.setText("");
				tfCampingAddress.setText("");
				tfCampingPrice.setText("");
				
				//dispose();
				
			}
        });
    	   	 	
    	jPanel=new JPanel(new GridLayout(0,2));
    	jPanel.add(lCampingNumber);
    	jPanel.add(tfCampingNumber);
    	
    	jPanel.add(lCampingName);
    	jPanel.add(tfCampingName);
    	
    	jPanel.add(lCampingMax);
    	jPanel.add(tfCampingMax);
    	
    	jPanel.add(lCampingAddress);
    	jPanel.add(tfCampingAddress);
    	
    	jPanel.add(lCampingPrice);
    	jPanel.add(tfCampingPrice);
    	
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
    			"������ �ڽ�",
               JOptionPane.INFORMATION_MESSAGE);
    }
}
