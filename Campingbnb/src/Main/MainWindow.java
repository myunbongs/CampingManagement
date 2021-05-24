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
		  f = new JFrame("캠핑장 예약 시스템");
		menuBar = new JMenuBar();
		   //메인 메뉴  항목 객체 생성
		campingMenu = new JMenu("캠핑 관리");
		userMenu = new JMenu("회원관리");
		helpMenu = new JMenu("도움말");
	}
	 

	// 서브메뉴 생성 메소드
		protected void startFrame() { 
		  f.setJMenuBar(menuBar); //Frame에 메뉴바를 단다.
		  menuBar.add(campingMenu); //메뉴바에 "파일"항목을 단다.
		  //파일 메뉴 관련 서브 메뉴 항목
		  campingMenu.add(campingMenu11 = new JMenuItem("캠핑장 등록"));
		  campingMenu.add(campingMenu12 = new JMenuItem("캠핑장 조회"));
		  campingMenu.addSeparator(); //분리선 설정하기
		  campingMenu.add(campingMenu13 = new JMenuItem("캠핑장 수정"));
		  campingMenu.add(campingMenu14 = new JMenuItem("캠핑장 삭제"));
		 
		  menuBar.add(userMenu); 
		  userMenu.add(userMenu21=new JMenuItem("회원가입"));
		  userMenu.add(userMenu22=new JMenuItem("로그인"));
		  userMenu.add(userMenu23=new JMenuItem("회원수정"));
		  userMenu.add(userMenu24=new JMenuItem("회원탈퇴"));
		 
		  
		  menuBar.add(helpMenu);
		  helpMenu.add(helpMenu41 = new JMenuItem("버전"));
		  
		  
		 jPanel=new JPanel();
		 campingName = new JLabel("캠핑장 이름");
		  tf = new JTextField(10);
		  searchBtn = new JButton("캠핑장 조회하기");
		    
		 jPanel.add(campingName);
		 jPanel.add(tf);
		 jPanel.add(searchBtn);
		 
		 Container con=f.getContentPane(); //contentPane 을 가지고 올 때 사용하는 메소드
		 con.add(jPanel,"North");
		 
		  f.setLocation(200, 100);
		  f.setSize(800, 600);
		  f.setVisible(true);
		  f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		  //메뉴 항목 선택 이벤트와 이벤트 리스너를 연결한다.
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
				new CampingUploadDialog("캠핑장 등록");
			}/*else if(e.getSource()==campingMenu12){
				new SearchCarDialog("캠핑장 조회");
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
				new RegMemDialog("회원 등록창");
			}else if(e.getSource()==memMenu22){
				new SearchMemDialog("회원 조회창");
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
	
	//버전 메뉴 클릭 시 수행하는 메소드
		public void version() { // 버전관리창 생성
		  final JDialog d = new JDialog(this, "버전관리");
		  JLabel jbver = new JLabel("       버전1.0");
		  JLabel jbdate = new JLabel("       2015.03.11");
		  JLabel jbauthor = new JLabel("       제작 : idea java");
		  
		  d.setLayout(new FlowLayout());
		  d.add(jbver);
		  d.add(jbdate);
		  d.add(jbauthor);
		  
		  d.setLocation(250, 230);
		  d.setSize(200, 100);
		  d.setVisible(true);
		  
		  d.addWindowListener(new WindowAdapter(){ // 버전관리창 종료
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
