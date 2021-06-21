package Reserve;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Camping.CampingVO;
import Main.MainWindow;
import User.UserVO;

/*
 	int resCampingNumber;
	String resDate;
	String beginDate;
	String endDate;
	int resPrice;
 
 */

@SuppressWarnings("serial")
public class ReserveDialog  extends JDialog{
	JPanel jPanel;
	JLabel lresCampingNumber, lresDate, lbeginDate, lendDate, lresPrice;
	JTextField tfresCampingNumber, tfuserId, tfhostId, tfresDate, tfbeginDate, tfendDate, tfresPrice ;
    JButton btnReg, btnCal;
    
	String campingPrice = null;
	String campingNumber = null; 
    Reserve reserveController;
    

    public ReserveDialog(String campingNum){
    	init(campingNum);
    }
    
    private void init(String campingNum){

    	reserveController = new ReserveImpl();
    	
    	lbeginDate = new JLabel("�Խ� ��¥");
    	lendDate = new JLabel("��� ��¥");
    	
    	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
    	Date time = new Date();
    	String now = format1.format(time);

    	
    	tfbeginDate = new JTextField(20);
    	tfendDate = new JTextField(20);
    	
    	btnReg=new JButton("����ϱ�");
    	
		/*
		 * ImageIcon startCalcon = new ImageIcon("cal.png"); Image im =
		 * startCalcon.getImage(); Image im2 = im.getScaledInstance(50, 50,
		 * Image.SCALE_DEFAULT); ImageIcon startCalcon2 = new ImageIcon(im2); JLabel
		 * startCalendar = new JLabel(startCalcon2);
		 */		
    	
    	// btnCal = new JButton("�޷�");
		File file =new File("campingData.txt");
		
		String[] campingData = null;


		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			Object[] tableLines = br.lines().toArray();
			for (int i = 0; i < tableLines.length; i++) {
				String line = tableLines[i].toString().trim();
				campingData = line.split(",");				
				String str = campingData[0]; 
				
				if(str.equals(String.valueOf(campingNum))) {
					campingPrice = String.valueOf(campingData[5]);	
					campingNumber = campingData[0];
				}
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        	
    	
		///Ķ����///
//		btnCal.addActionListener((ActionListener) new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				Calendarmain calender = new Calendarmain();				
//			}
//		});

    	
    	
   	 	btnReg.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				
				File file = new File("reserveData.txt");
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

				String id = MainWindow.login.tfUsername.getText();
				
				String resDate = now.toString();
				String beginDate = tfbeginDate.getText().trim();
				String endDate = tfendDate.getText().trim();

				ReserveVO vo = new ReserveVO(num, id, campingNumber, resDate, beginDate, endDate, campingPrice);

				try {
					reserveController.reserveCamping(vo);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				
				
				//////////

				
				showMessage("������ �Ϸ�Ǿ����ϴ�.");
				tfbeginDate.setText("");
				tfendDate.setText("");
				
				//dispose();
				
			}

        });
    	   	 	
   	 	
		jPanel=new JPanel(new GridLayout(0,2));		
	
		jPanel.add(lbeginDate);
		jPanel.add(tfbeginDate);
//		jPanel.add(btnCal);
		
		jPanel.add(lendDate);
		jPanel.add(tfendDate);
//		jPanel.add(btnCal);
				

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
////////////////////////////////////////////////////Ķ����/////////////////////////////////////////////////////
@SuppressWarnings("serial")
class Calendarmain extends JFrame implements ActionListener{
	
	Container container = getContentPane();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	
	JButton buttonBefore = new JButton("Before");
	JButton buttonAfter = new JButton("After");
	
	JLabel label = new JLabel("00�� 0��");
	
	JButton[] buttons = new JButton[49];
	String[] dayNames = {"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};
	
	CalendarFunction cF = new CalendarFunction();
	
	public Calendarmain() {
		setTitle("���� �޷�");
		setSize(550, 400);
		setLocation(400, 400);
		init();
		start();
		setVisible(true);
	}
	private void init() {
		 container.setLayout(new BorderLayout());
		 container.add("North", panel1);
		 container.add("Center", panel2);
		 
		 panel1.setLayout(new FlowLayout());
		 panel1.add(buttonBefore);
		 panel1.add(label);
		 panel1.add(buttonAfter);
		 
		 Font font = new Font("SansSerif", Font.BOLD, 20);
		 buttonAfter.setFont(font);
		 buttonBefore.setFont(font);
		 label.setFont(font);
		 
		 label.setText(cF.getCalText());
		 
		 panel2.setLayout(new GridLayout(7, 7, 5, 5));
		 for(int i = 0; i < buttons.length; i++) {
			 buttons[i] = new JButton();
			 panel2.add(buttons[i]);
			 
			 buttons[i].setFont(new Font("SansSerif", Font.BOLD, 24));
			 
			 //if(i < 7) buttons[i].setText(dayNames[i]); 
			 
			 if(i%7 == 0) buttons[i].setForeground(Color.RED);
			 if(i%7 == 6) buttons[i].setForeground(Color.BLUE);
		 }
		 cF.setButtons(buttons);
		 cF.calSet();
	}

	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buttonAfter.addActionListener(this);
		buttonBefore.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int gap = 0;
		if(e.getSource() == buttonAfter) {				// 1�� ��
			gap = 1;
		} else if(e.getSource() == buttonBefore ) {		// 1�� ��
			gap = -1;
		}
		cF.allInit(gap);
		label.setText(cF.getCalText());		// ��� ���� ����		
	}	
}

class CalendarFunction {
	JButton[] buttons;
	Calendar cal = Calendar.getInstance();
	int year, month;
	
	public CalendarFunction() {
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;
	}
	public void setButtons(JButton[] buttons) {
		this.buttons = buttons;
	}
	// Label -> 0000�� 00�� ���ڿ� ����
	public String getCalText() {
		return year + "��" + month + "��";
	}
	// ��ư ��¥ ���
	public void calSet() {
		// calendar ��ü ��¥ 1�� ����
		cal.set(year, month-1, 1);
		
		// �� ���� 1�� ���� ��
		int firstDay = cal.get(Calendar.DAY_OF_WEEK);
		// ���� �� 1�� ����, �迭 0���� ����
		firstDay--;
		
		for(int i = 1; i <= cal.getActualMaximum(cal.DATE); i++) {
			// buttons[0] ~ [6] : �� ~ ��
			// buttons[7] ~     : ��¥ ���
			buttons[6 + firstDay + i].setText(String.valueOf(i));
		}			
	}
	// �޷� ���ο� ��� ���
	public void allInit(int gap) {
		// ��ư ��¥ �����
		for(int i =7; i < buttons.length; i++) {
			buttons[i].setText("");
		}
		month += gap;
		if(month <= 0) {
			year--;
			month = 12;
		} else if(month >= 13) {
			year++;
			month = 1;
		}
		calSet();
	}		
}



