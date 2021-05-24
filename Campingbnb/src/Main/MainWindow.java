package Main;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Camping.CampingUploadDialog;

@SuppressWarnings("serial")
public class MainWindow extends JFrame  {
	JFrame f;
	JMenuBar menuBar;
	JMenu campingMenu, userMenu, reserveMenu, helpMenu; 
		 JMenuItem campingMenu11, campingMenu12, campingMenu13, campingMenu14;
		 JMenuItem userMenu21, userMenu22, userMenu23, userMenu24;
		 JMenuItem helpMenu41;
	JPanel jPanel;
	JLabel campingName;
	JTextField tf ;
    JButton searchBtn ;
    
   
	public MainWindow(){
		  f = new JFrame("ķ���� ���� �ý���");
		menuBar = new JMenuBar();
		   //���� �޴�  �׸� ��ü ����
		campingMenu = new JMenu("ķ�� ����");
		userMenu = new JMenu("ȸ������");
		helpMenu = new JMenu("����");
	}
	 

	// ����޴� ���� �޼ҵ�
		protected void startFrame() { 
		  f.setJMenuBar(menuBar); //Frame�� �޴��ٸ� �ܴ�.
		  menuBar.add(campingMenu); //�޴��ٿ� "����"�׸��� �ܴ�.
		  //���� �޴� ���� ���� �޴� �׸�
		  campingMenu.add(campingMenu11 = new JMenuItem("ķ���� ���"));
		  campingMenu.add(campingMenu12 = new JMenuItem("ķ���� ��ȸ"));
		  campingMenu.addSeparator(); //�и��� �����ϱ�
		  campingMenu.add(campingMenu13 = new JMenuItem("ķ���� ����"));
		  campingMenu.add(campingMenu14 = new JMenuItem("ķ���� ����"));
		 
		  menuBar.add(userMenu); 
		  userMenu.add(userMenu21=new JMenuItem("ȸ������"));
		  userMenu.add(userMenu22=new JMenuItem("�α���"));
		  userMenu.add(userMenu23=new JMenuItem("ȸ������"));
		  userMenu.add(userMenu24=new JMenuItem("ȸ��Ż��"));
		 
		  
		  menuBar.add(helpMenu);
		  helpMenu.add(helpMenu41 = new JMenuItem("����"));
		  
		  
		 jPanel=new JPanel();
		 campingName = new JLabel("ķ���� �̸�");
		  tf = new JTextField(10);
		  searchBtn = new JButton("ķ���� ��ȸ�ϱ�");
		    
		 jPanel.add(campingName);
		 jPanel.add(tf);
		 jPanel.add(searchBtn);
		 
		 Container con=f.getContentPane(); //contentPane �� ������ �� �� ����ϴ� �޼ҵ�
		 con.add(jPanel,"North");
		 
		  f.setLocation(200, 100);
		  f.setSize(800, 600);
		  f.setVisible(true);
		  f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		  //�޴� �׸� ���� �̺�Ʈ�� �̺�Ʈ �����ʸ� �����Ѵ�.
		  campingMenu11.addActionListener(new CampingHandler());
		  campingMenu12.addActionListener(new CampingHandler());
		  campingMenu13.addActionListener(new CampingHandler());
		  campingMenu14.addActionListener(new CampingHandler());
		  
			/*
			 * userMenu21.addActionListener(new UserHandler());
			 * userMenu22.addActionListener(new UserHandler());
			 * userMenu23.addActionListener(new UserHandler());
			 * userMenu24.addActionListener(new UserHandler());
			 * 
			 * helpMenu41.addActionListener(new HelpHandler());
			 */
	}

	private class CampingHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			if(e.getSource()== campingMenu11){
				new CampingUploadDialog("ķ���� ���");
			}/*else if(e.getSource()==campingMenu12){
				new SearchCarDialog("ķ���� ��ȸ");
			}else if(e.getSource()==campingMenu13){
			}
		}*/
		}
	}
	
	/*	
	
	private class MemberHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			if(e.getSource()==memMenu21){
				new RegMemDialog("ȸ�� ���â");
			}else if(e.getSource()==memMenu22){
				new SearchMemDialog("ȸ�� ��ȸâ");
			}else if(e.getSource()==memMenu23){
			}
		}
	}
	
	private class HelpHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			version();
		}
	}
	
	//���� �޴� Ŭ�� �� �����ϴ� �޼ҵ�
		public void version() { // ��������â ����
		  final JDialog d = new JDialog(this, "��������");
		  JLabel jbver = new JLabel("       ����1.0");
		  JLabel jbdate = new JLabel("       2015.03.11");
		  JLabel jbauthor = new JLabel("       ���� : idea java");
		  
		  d.setLayout(new FlowLayout());
		  d.add(jbver);
		  d.add(jbdate);
		  d.add(jbauthor);
		  
		  d.setLocation(250, 230);
		  d.setSize(200, 100);
		  d.setVisible(true);
		  
		  d.addWindowListener(new WindowAdapter(){ // ��������â ����
			   public void windowClosing(WindowEvent e){
				   d.dispose();
				   d.setVisible(false);
			   }
		  });
		 }	
	
	*/
	 
	public static void main(String[] args){
		MainWindow test=new MainWindow();
		test.startFrame();
	}
}
