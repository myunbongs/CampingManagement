package Reserve;

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

import Main.MainWindow;

@SuppressWarnings("serial")
public class ReserveDetailDialog extends JDialog{
	JFrame f;
	JPanel jPanel;
	
	
	JLabel lresNumber, luserid, lcampingname, lresdate, lbegindate, lenddate, lresprice;
	JLabel lresNumberInfo, luseridInfo, lcampingnameInfo, lresdateInfo, lbegindateInfo, lenddateInfo, lrespriceInfo;

	JButton btnReserve, btnRemove, btnModify;
	
	String campingInfo=null;
	String reserveData[]=null;

	
	String hostId = MainWindow.login.tfUsername.getText();

    public ReserveDetailDialog(String reserveNum){
		f = new JFrame("���� �� ������");

    	System.out.println(reserveNum);
    	
    	lresNumberInfo = new JLabel("���� ��ȣ");
    	luseridInfo = new JLabel("������ ID"); 
    	lcampingnameInfo = new JLabel("ķ���� �̸�");
    	lresdateInfo = new JLabel("���� ��¥");
    	lbegindateInfo = new JLabel("�Խ� ��¥");
    	lenddateInfo = new JLabel("��� ��¥");
    	lrespriceInfo = new JLabel("���ڷ�(��/��)");

    	btnRemove = new JButton("����ϱ�");
    	btnModify = new JButton("�����ϱ�");

    	
		File file =new File("reserveData.txt");
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			Object[] tableLines = br.lines().toArray();
			for (int i = 0; i < tableLines.length; i++) {
				String line = tableLines[i].toString().trim();
				reserveData = line.split(",");
				String str = reserveData[0]; 
				
				if(str.equals(String.valueOf(reserveNum))) {
					lresNumber = new JLabel(String.valueOf(reserveData[0]));
					luserid = new JLabel(String.valueOf(reserveData[1]));
					lcampingname = new JLabel(String.valueOf(reserveData[2]));
					lresdate = new JLabel(String.valueOf(reserveData[3]));
					lbegindate = new JLabel(String.valueOf(reserveData[4]));
					lenddate = new JLabel(String.valueOf(reserveData[5]));	
					lresprice = new JLabel(String.valueOf(reserveData[6]));	
				}
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		/*
		 * btnModify.addActionListener(new ActionListener(){
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { ReserveDialog reserve
		 * = new ReserveDialog(reserveNum); } });
		 */
		
    	jPanel=new JPanel(new GridLayout(0,2));
    	
    	jPanel.add(lresNumberInfo);
    	jPanel.add(lresNumber);
    	
    	jPanel.add(luseridInfo);
    	jPanel.add(luserid);
    	
    	jPanel.add(lcampingnameInfo);
    	jPanel.add(lcampingname);
    	
    	jPanel.add(lresdateInfo);
    	jPanel.add(lresdate);
    	
    	jPanel.add(lbegindateInfo);
    	jPanel.add(lbegindate);
    	
    	
    	jPanel.add(lenddateInfo);
    	jPanel.add(lenddate);
    	
    	jPanel.add(lrespriceInfo);
    	jPanel.add(lresprice);
        
    	add(jPanel,BorderLayout.NORTH);

    	
		jPanel.add(btnModify,BorderLayout.SOUTH);
		jPanel.add(btnRemove,BorderLayout.SOUTH);

    	
    	
        setLocation(400, 200);
        setSize(400,300);
        setModal(true); 
        setVisible(true);
    }
    
}
