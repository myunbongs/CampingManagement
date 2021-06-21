package Main;

import java.awt.BorderLayout;
import java.awt.Container;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.Buffer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Camping.CampingUploadDialog;
import Camping.MyCampingListDialog;
import Reserve.MyReserveListDialog;
import Reserve.ReserveDialog;
import User.RegisterUserDialog;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	public static LoginWindow login;
	public static DetailWindow detail;
	static MainWindow Main;
	JFrame f;
	JMenuBar menuBar;
	JMenu campingMenu, userMenu, reserveMenu, helpMenu;
	JMenuItem campingMenu11, campingMenu12, campingMenu13, campingMenu14;
	JMenuItem reserveMenu11, reserveMenu12, reserveMenu13;
	JMenuItem userMenu21, userMenu22, userMenu23, userMenu24;
	JMenuItem helpMenu41;
	JPanel jPanel;
	JLabel campingName;
	JTextField tf;
	JButton searchBtn;

	public MainWindow() {
		f = new JFrame("캠핑장 예약 시스템");
		menuBar = new JMenuBar();
		// 메인 메뉴 항목 객체 생성
		campingMenu = new JMenu("캠핑관리");
		reserveMenu = new JMenu("예약관리");
		userMenu = new JMenu("회원관리");
		helpMenu = new JMenu("도움말");
	}

	// 서브메뉴 생성 메소드
	protected void startFrame1() {
		f.setJMenuBar(menuBar); // Frame에 메뉴바를 단다.
		/*
		 * menuBar.add(campingMenu); //메뉴바에 "파일"항목을 단다. //파일 메뉴 관련 서브 메뉴 항목
		 * campingMenu.add(campingMenu11 = new JMenuItem("캠핑장 등록"));
		 * campingMenu.add(campingMenu12 = new JMenuItem("캠핑장 조회"));
		 * campingMenu.addSeparator(); //분리선 설정하기 campingMenu.add(campingMenu13 = new
		 * JMenuItem("캠핑장 수정")); campingMenu.add(campingMenu14 = new
		 * JMenuItem("캠핑장 삭제"));
		 */

		menuBar.add(reserveMenu);
		reserveMenu.add(reserveMenu11 = new JMenuItem("예약조회"));

		menuBar.add(userMenu);
		userMenu.add(userMenu21 = new JMenuItem("로그아웃"));
		userMenu.add(userMenu23 = new JMenuItem("회원수정"));
		userMenu.add(userMenu24 = new JMenuItem("회원탈퇴"));

		jPanel = new JPanel();
		campingName = new JLabel("캠핑장 이름");
		tf = new JTextField(10);
		searchBtn = new JButton("캠핑장 조회하기");

		jPanel.add(campingName);
		jPanel.add(tf);
		jPanel.add(searchBtn);

		Container con = f.getContentPane(); // contentPane 을 가지고 올 때 사용하는 메소드
		con.add(jPanel, "North");

		f.setLocation(200, 100);
		f.setSize(800, 600);
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 메뉴 항목 선택 이벤트와 이벤트 리스너를 연결한다.
		/*
		 * campingMenu11.addActionListener(new CampingHandler());
		 * campingMenu12.addActionListener(new CampingHandler());
		 * campingMenu13.addActionListener(new CampingHandler());
		 * campingMenu14.addActionListener(new CampingHandler());
		 */
		reserveMenu11.addActionListener(new ReserveHandler());
		userMenu21.addActionListener(new UserHandler());
		/*
		 * userMenu21.addActionListener(new UserHandler());
		 * userMenu22.addActionListener(new UserHandler());
		 * userMenu23.addActionListener(new UserHandler());
		 * userMenu24.addActionListener(new UserHandler());
		 * 
		 * helpMenu41.addActionListener(new HelpHandler());
		 */

		JTable jTable = new JTable();

		File file = new File("campingData.txt");

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String[] header = { "No.", "주인 ID", "캠핑장 이름", "최대인원", "주소", "가격(원)" };
			DefaultTableModel model = (DefaultTableModel) jTable.getModel();
			model.setColumnIdentifiers(header);
			model.addRow(header);

			Object[] tableLines = br.lines().toArray();

			for (int i = 0; i < tableLines.length; i++) {
				String line = tableLines[i].toString().trim();
				String[] dataRow = line.split(",");
				model.addRow(dataRow);

			}

			jTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent event) {
					// do some actions here, for example
					// print first column value from selected row
					String select = jTable.getValueAt(jTable.getSelectedRow(), 0).toString();
					System.out.println(select);
					detail = new DetailWindow(select);
				}
			});

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		con.add(jTable);
		

	}

	/*
	 * private class CampingHandler implements ActionListener{
	 * 
	 * @Override public void actionPerformed(ActionEvent e) {
	 * System.out.println(e.getActionCommand()); if(e.getSource()== campingMenu11){
	 * new CampingUploadDialog("캠핑장 등록"); }else if(e.getSource()==campingMenu12){
	 * new SearchCarDialog("캠핑장 조회"); }else if(e.getSource()==campingMenu13){ } } }
	 * }
	 */
	
	protected void startFrame2() {
		f.setJMenuBar(menuBar); // Frame에 메뉴바를 단다.

		menuBar.add(campingMenu); // 메뉴바에 "파일"항목을 단다. //파일 메뉴 관련 서브 메뉴 항목
		campingMenu.add(campingMenu11 = new JMenuItem("캠핑장 등록"));
		campingMenu.add(campingMenu12 = new JMenuItem("내 캠핑장"));
		// campingMenu.addSeparator(); //분리선 설정하기 campingMenu.add(campingMenu13 = new

		menuBar.add(reserveMenu);
		reserveMenu.add(reserveMenu11 = new JMenuItem("예약조회"));

		menuBar.add(userMenu);
		userMenu.add(userMenu21 = new JMenuItem("로그아웃"));
		userMenu.add(userMenu23 = new JMenuItem("회원수정"));
		userMenu.add(userMenu24 = new JMenuItem("회원탈퇴"));

		jPanel = new JPanel();
		campingName = new JLabel("캠핑장 이름");
		tf = new JTextField(10);
		searchBtn = new JButton("캠핑장 조회하기");

		jPanel.add(campingName);
		jPanel.add(tf);
		jPanel.add(searchBtn);

		Container con = f.getContentPane(); // contentPane 을 가지고 올 때 사용하는 메소드
		con.add(jPanel, "North");

		f.setLocation(200, 100);
		f.setSize(800, 600);
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 메뉴 항목 선택 이벤트와 이벤트 리스너를 연결한다.

		campingMenu11.addActionListener(new CampingHandler());
		campingMenu12.addActionListener(new CampingHandler());
		// campingMenu13.addActionListener(new CampingHandler());
		//campingMenu14.addActionListener(new CampingHandler());
		
		reserveMenu11.addActionListener(new ReserveHandler());

		userMenu21.addActionListener(new UserHandler());
		//userMenu22.addActionListener(new UserHandler());
		userMenu23.addActionListener(new UserHandler());
		userMenu24.addActionListener(new UserHandler());
		 
		 //helpMenu41.addActionListener(new HelpHandler());
		

		JTable jTable = new JTable();

		File file = new File("campingData.txt");

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String[] header = { "No.", "주인 ID", "캠핑장 이름", "최대인원", "주소", "가격(원)" };
			DefaultTableModel model = (DefaultTableModel) jTable.getModel();
			model.setColumnIdentifiers(header);
			model.addRow(header);

			Object[] tableLines = br.lines().toArray();

			for (int i = 0; i < tableLines.length; i++) {
				String line = tableLines[i].toString().trim();
				String[] dataRow = line.split(",");
				model.addRow(dataRow);
			}

			jTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent event) {
					// do some actions here, for example
					// print first column value from selected row
					String select = jTable.getValueAt(jTable.getSelectedRow(), 0).toString();
					System.out.println(select);
					detail = new DetailWindow(select);
				}
			});

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		con.add(jTable);

	}

	private class UserHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			if (e.getSource() == userMenu21) {
				MainWindow.Main.f.setVisible(false);
				MainWindow.login.setVisible(true);
			} else if (e.getSource() == userMenu23) {
				// 회원 수정
			}
		}
	}
	
	private class ReserveHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			if (e.getSource() == reserveMenu11) {
				new MyReserveListDialog();
			} 
		}
	}



	
	private class CampingHandler implements ActionListener{
	 
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			if(e.getSource()== campingMenu11){
				new CampingUploadDialog("캠핑장 등록"); 
			}
			else if(e.getSource()==campingMenu12){
				new MyCampingListDialog(); 
			}
			else if(e.getSource()==campingMenu12){ } 
			}
		}



	public static void main(String[] args) {
		// MainWindow test=new MainWindow();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login = new LoginWindow();
					Main = new MainWindow();
					// ReserveDialog reserve = new ReserveDialog("예약하기");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
