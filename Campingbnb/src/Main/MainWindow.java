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
		f = new JFrame("ķ���� ���� �ý���");
		menuBar = new JMenuBar();
		// ���� �޴� �׸� ��ü ����
		campingMenu = new JMenu("ķ�ΰ���");
		reserveMenu = new JMenu("�������");
		userMenu = new JMenu("ȸ������");
		helpMenu = new JMenu("����");
	}

	// ����޴� ���� �޼ҵ�
	protected void startFrame1() {
		f.setJMenuBar(menuBar); // Frame�� �޴��ٸ� �ܴ�.
		/*
		 * menuBar.add(campingMenu); //�޴��ٿ� "����"�׸��� �ܴ�. //���� �޴� ���� ���� �޴� �׸�
		 * campingMenu.add(campingMenu11 = new JMenuItem("ķ���� ���"));
		 * campingMenu.add(campingMenu12 = new JMenuItem("ķ���� ��ȸ"));
		 * campingMenu.addSeparator(); //�и��� �����ϱ� campingMenu.add(campingMenu13 = new
		 * JMenuItem("ķ���� ����")); campingMenu.add(campingMenu14 = new
		 * JMenuItem("ķ���� ����"));
		 */

		menuBar.add(reserveMenu);
		reserveMenu.add(reserveMenu11 = new JMenuItem("������ȸ"));

		menuBar.add(userMenu);
		userMenu.add(userMenu21 = new JMenuItem("�α׾ƿ�"));
		userMenu.add(userMenu23 = new JMenuItem("ȸ������"));
		userMenu.add(userMenu24 = new JMenuItem("ȸ��Ż��"));

		jPanel = new JPanel();
		campingName = new JLabel("ķ���� �̸�");
		tf = new JTextField(10);
		searchBtn = new JButton("ķ���� ��ȸ�ϱ�");

		jPanel.add(campingName);
		jPanel.add(tf);
		jPanel.add(searchBtn);

		Container con = f.getContentPane(); // contentPane �� ������ �� �� ����ϴ� �޼ҵ�
		con.add(jPanel, "North");

		f.setLocation(200, 100);
		f.setSize(800, 600);
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// �޴� �׸� ���� �̺�Ʈ�� �̺�Ʈ �����ʸ� �����Ѵ�.
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
			String[] header = { "No.", "���� ID", "ķ���� �̸�", "�ִ��ο�", "�ּ�", "����(��)" };
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
	 * new CampingUploadDialog("ķ���� ���"); }else if(e.getSource()==campingMenu12){
	 * new SearchCarDialog("ķ���� ��ȸ"); }else if(e.getSource()==campingMenu13){ } } }
	 * }
	 */
	
	protected void startFrame2() {
		f.setJMenuBar(menuBar); // Frame�� �޴��ٸ� �ܴ�.

		menuBar.add(campingMenu); // �޴��ٿ� "����"�׸��� �ܴ�. //���� �޴� ���� ���� �޴� �׸�
		campingMenu.add(campingMenu11 = new JMenuItem("ķ���� ���"));
		campingMenu.add(campingMenu12 = new JMenuItem("�� ķ����"));
		// campingMenu.addSeparator(); //�и��� �����ϱ� campingMenu.add(campingMenu13 = new

		menuBar.add(reserveMenu);
		reserveMenu.add(reserveMenu11 = new JMenuItem("������ȸ"));

		menuBar.add(userMenu);
		userMenu.add(userMenu21 = new JMenuItem("�α׾ƿ�"));
		userMenu.add(userMenu23 = new JMenuItem("ȸ������"));
		userMenu.add(userMenu24 = new JMenuItem("ȸ��Ż��"));

		jPanel = new JPanel();
		campingName = new JLabel("ķ���� �̸�");
		tf = new JTextField(10);
		searchBtn = new JButton("ķ���� ��ȸ�ϱ�");

		jPanel.add(campingName);
		jPanel.add(tf);
		jPanel.add(searchBtn);

		Container con = f.getContentPane(); // contentPane �� ������ �� �� ����ϴ� �޼ҵ�
		con.add(jPanel, "North");

		f.setLocation(200, 100);
		f.setSize(800, 600);
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// �޴� �׸� ���� �̺�Ʈ�� �̺�Ʈ �����ʸ� �����Ѵ�.

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
			String[] header = { "No.", "���� ID", "ķ���� �̸�", "�ִ��ο�", "�ּ�", "����(��)" };
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
				// ȸ�� ����
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
				new CampingUploadDialog("ķ���� ���"); 
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
					// ReserveDialog reserve = new ReserveDialog("�����ϱ�");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
