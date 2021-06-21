package Camping;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Main.MainWindow;

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
    	lCampingName = new JLabel("캠핑장 이름");
    	lCampingMax = new JLabel("캠핑 최대 인원");
    	lCampingAddress = new JLabel("캠핑장 주소");
    	lCampingPrice = new JLabel("숙박료(일/원)");
    	
      	tfCampingName = new JTextField(20);
    	tfCampingMax = new JTextField(20);
    	tfCampingAddress = new JTextField(20);
    	tfCampingPrice = new JTextField(20);
    	
    	btnReg=new JButton("등록하기");
    	
   	 	btnReg.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				File file=new File("campingData.txt");
				Scanner scan = null;
				int num = 1; 
				
				try {
					scan = new Scanner(file);
					while (scan.hasNext()) {
						scan.nextLine();
						num++;
					}
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
				String campingName = tfCampingName.getText().trim();
				int campingMax = Integer.parseInt(tfCampingMax.getText().trim());
				String campingAddress = tfCampingAddress.getText().trim();
				int campingPrice = Integer.parseInt(tfCampingPrice.getText().trim());
				
				String hostId = MainWindow.login.tfUsername.getText();

				CampingVO vo=new CampingVO(num,hostId, campingName,campingMax,campingAddress,campingPrice);
				try {
					campingController.uploadCampingInfo(vo);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				showMessage("캠핑장을 등록했습니다.");
				tfCampingName.setText("");
				tfCampingMax.setText("");
				tfCampingAddress.setText("");
				tfCampingPrice.setText("");
				
				//dispose();
				
			}
        });
    	   	 	
    	jPanel=new JPanel(new GridLayout(0,2));
    	
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
    			"메지지 박스",
               JOptionPane.INFORMATION_MESSAGE);
    }
}
