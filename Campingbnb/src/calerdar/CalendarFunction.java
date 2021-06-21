package calerdar;

import java.util.Calendar;

import javax.swing.JButton;

public class CalendarFunction {
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

