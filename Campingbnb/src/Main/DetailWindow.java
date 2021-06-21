package Main;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Reserve.ReserveDialog;


@SuppressWarnings("serial")
public class DetailWindow extends JDialog{
	JFrame f;
	JPanel jPanel;
	
	JLabel lCampingNumberInfo, lCampingHostIdInfo, lCampingNameInfo,lCampingMaxInfo, lCampingAddressInfo, lCampingPriceInfo;
	JLabel lCampingNumber, lCampingHostId, lCampingName,lCampingMax, lCampingAddress, lCampingPrice;

	JButton btnReserve, btnRemove, btnModify;
	
	String campingInfo=null;
	String campingData[]=null;

	
	String hostId = MainWindow.login.tfUsername.getText();

    public DetailWindow(String campingNum){
    	System.out.println(campingNum);
    	
      	lCampingNumberInfo = new JLabel("캠핑장 번호");
      	lCampingHostIdInfo = new JLabel("캠핑장 주인"); 
    	lCampingNameInfo = new JLabel("캠핑장 이름");
    	lCampingMaxInfo = new JLabel("캠핑 최대 인원");
    	lCampingAddressInfo = new JLabel("캠핑장 주소");
    	lCampingPriceInfo = new JLabel("숙박료(일/원)");

    	btnReserve = new JButton("예약하기");
    	btnRemove = new JButton("삭제하기");
    	btnModify = new JButton("수정하기");

    	
		File file =new File("campingData.txt");
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			Object[] tableLines = br.lines().toArray();
			for (int i = 0; i < tableLines.length; i++) {
				String line = tableLines[i].toString().trim();
				campingData = line.split(",");
				String str = campingData[0]; 
				
				if(str.equals(String.valueOf(campingNum))) {
					lCampingNumber = new JLabel(String.valueOf(campingData[0]));
					lCampingHostId = new JLabel(String.valueOf(campingData[1]));
					lCampingName = new JLabel(String.valueOf(campingData[2]));
					lCampingMax = new JLabel(String.valueOf(campingData[3]));
					lCampingAddress = new JLabel(String.valueOf(campingData[4]));
					lCampingPrice = new JLabel(String.valueOf(campingData[5]));	
				}
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		btnReserve.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ReserveDialog reserve = new ReserveDialog(campingNum);
			}
		});

		
    	jPanel=new JPanel(new GridLayout(0,2));
    	
    	jPanel.add(lCampingNumberInfo);
    	jPanel.add(lCampingNumber);
    	
    	jPanel.add(lCampingHostIdInfo);
    	jPanel.add(lCampingHostId);
    	
    	jPanel.add(lCampingNameInfo);
    	jPanel.add(lCampingName);
    	
    	jPanel.add(lCampingMaxInfo);
    	jPanel.add(lCampingMax);
    	
    	jPanel.add(lCampingAddressInfo);
    	jPanel.add(lCampingAddress);
    	
    	
    	jPanel.add(lCampingPriceInfo);
    	jPanel.add(lCampingPrice);
    	
    	add(jPanel,BorderLayout.NORTH);
    	
    	
		File file1 =new File("userData.txt");
		FileReader fr = null;
		try {
			fr = new FileReader(file1);
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		BufferedReader br1=new BufferedReader(fr);
		String userInfo=null;
		String userData[]=null;

    	try {
			while((userInfo=br1.readLine())!=null){
				userData = userInfo.split(",");
				
				if(userData[0].equals(hostId)) {
					if(userData[5].equals("0")) {
						add(btnReserve,BorderLayout.SOUTH);
					}
				}
				else if (hostId.equals(String.valueOf(campingData[1]))){
					jPanel.add(btnModify,BorderLayout.SOUTH);
					jPanel.add(btnRemove,BorderLayout.SOUTH);
				}
			}
    	} catch ( Exception e ) {
    		
    	}
    	
    	
    	
        setLocation(400, 200);
        setSize(400,300);
        setModal(true); 
        setVisible(true);
    }
}
