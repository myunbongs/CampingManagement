package Camping;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Main.DetailWindow;
import Main.MainWindow;

@SuppressWarnings("serial")
public class MyCampingListDialog extends JDialog{
	JFrame f;
	JPanel jPanel;
	
	DetailWindow detail;
	
	public MyCampingListDialog() {
		init();
	}
	
	private void init() {
		f = new JFrame("ķ���� ����Ʈ");

		jPanel = new JPanel();
		
		f.setLocation(200, 100);
		f.setSize(800, 600);
		f.setVisible(true);


		Container con = f.getContentPane(); // contentPane �� ������ �� �� ����ϴ� �޼ҵ�
		con.add(jPanel, "North");

		JTable jTable = new JTable();

		File file = new File("campingData.txt");
		
		String hostId = MainWindow.login.tfUsername.getText();

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
				if ( hostId.equals(dataRow[1])) {
					model.addRow(dataRow);
				}
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
 

}
