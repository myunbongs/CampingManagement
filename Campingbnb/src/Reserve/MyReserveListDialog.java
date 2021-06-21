package Reserve;

import java.awt.Container;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Main.DetailWindow;
import Main.MainWindow;

public class MyReserveListDialog {
	JFrame f;
	JPanel jPanel;
	
	ReserveDetailDialog detail;
	
	public MyReserveListDialog() {
		init();
	}
	
	private void init() {
		f = new JFrame("예약 리스트");

		jPanel = new JPanel();
		
		f.setLocation(200, 100);
		f.setSize(800, 600);
		f.setVisible(true);


		Container con = f.getContentPane(); // contentPane 을 가지고 올 때 사용하는 메소드
		con.add(jPanel, "North");

		JTable jTable = new JTable();

		String hostId = MainWindow.login.tfUsername.getText();

		
		File file1 = new File("reserveData.txt");

		try {
			BufferedReader br = new BufferedReader(new FileReader(file1));
			String[] header = { "예약 번호", "예약자 ID", "캠핑장 이름", "예약 날짜", "입실 날짜", "퇴실 날짜", "가격(일)" };
			DefaultTableModel model = (DefaultTableModel) jTable.getModel();
			model.setColumnIdentifiers(header);
			model.addRow(header);

			Object[] tableLines = br.lines().toArray();
			
			for (int i = 0; i < tableLines.length; i++) {
				String line = tableLines[i].toString().trim();
				String[] dataRow = line.split(",");
				
				int count = 0; 
				
				File file = new File("campingData.txt");
				
				try {
					
					BufferedReader br1 = new BufferedReader(new FileReader(file));
					
					Object[] tableLines1 = br1.lines().toArray();

					for (int i1 = 0; i1 < tableLines1.length; i1++) {
						String line1 = tableLines1[i1].toString().trim();
						String[] dataRow1 = line1.split(",");
						
						if (dataRow[1].equals(hostId)) {
							dataRow[2] = dataRow1[2];
							model.addRow(dataRow);
							count++;
						}	
						
						 else if ( dataRow1[1].equals(hostId) && dataRow[2].equals(dataRow1[0])) {
							 dataRow[2] = dataRow1[2];
							 model.addRow(dataRow); 
							 count++;
						 }
						if ( count > 0 ) {
							break; 
						}
					}
				} catch (Exception e) {
						
				}
			}

			jTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent event) {
					// do some actions here, for example
					// print first column value from selected row
					String select = jTable.getValueAt(jTable.getSelectedRow(), 0).toString();
					System.out.println(select);
					detail = new ReserveDetailDialog(select);
				}
			});

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		con.add(jTable);
		
		
	}
}
