package designchallenge1.observer;

import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalendarProgram implements ActionListener{
	private JFrame frmMain;
	private JPanel calendarPanel;
	private Container pane;
	private JScrollPane scrollCalendarTable;
	private JLabel monthLabel, yearLabel;
	private JButton btnPrev, btnNext, newEvent, refreshBtn;
	private JComboBox cmbYear;

	private JTable calendarTable;
	private DefaultTableModel modelCalendarTable;

	private Date d = new Date();
	private Subject sub;

	public CalendarProgram(Subject sub) {
		this.sub = sub;
		init();
	}

	public void init() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}

		frmMain = new JFrame ("Calendar Application");
		frmMain.setSize(660, 750);
		frmMain.setResizable(false);
		frmMain.setVisible(true);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pane = frmMain.getContentPane();
		pane.setLayout(null);
		monthLabel = new JLabel ("January");
		yearLabel = new JLabel ("Change year:");
		cmbYear = new JComboBox();
		btnPrev = new JButton ("<<");
		btnNext = new JButton (">>");
		newEvent = new JButton ("Add Event");
		refreshBtn = new JButton("Refresh");

		modelCalendarTable = new DefaultTableModel()
		{
			public boolean isCellEditable(int rowIndex, int mColIndex)
			{
				return true;
			}
		};

		calendarTable = new JTable(modelCalendarTable);

		scrollCalendarTable = new JScrollPane(calendarTable);

		calendarPanel = new JPanel(null);
		calendarPanel.setBorder(BorderFactory.createTitledBorder("Calendar"));

		btnPrev.addActionListener(this);
		btnNext.addActionListener(this);
		cmbYear.addActionListener(this);
		newEvent.addActionListener(this);
		refreshBtn.addActionListener(this);

		pane.add(calendarPanel);
		calendarPanel.add(monthLabel);
		calendarPanel.add(yearLabel);
		calendarPanel.add(cmbYear);
		calendarPanel.add(btnPrev);
		calendarPanel.add(btnNext);
		calendarPanel.add(newEvent);
		calendarPanel.add(refreshBtn);
		calendarPanel.add(scrollCalendarTable);

		calendarPanel.setBounds(0, 0, 640, 670);
		monthLabel.setBounds(320-monthLabel.getPreferredSize().width/2, 50, 200, 50);
		yearLabel.setBounds(20, 610, 160, 40);
		cmbYear.setBounds(100, 610, 160, 40);
		btnPrev.setBounds(20, 50, 100, 50);
		btnNext.setBounds(520, 50, 100, 50);
		newEvent.setBounds(460, 610, 160, 45);
		refreshBtn.setBounds(350, 610, 100 ,45);
		scrollCalendarTable.setBounds(20, 100, 600, 500);

		String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
		for (int i=0; i<7; i++){
			modelCalendarTable.addColumn(headers[i]);
		}

		calendarTable.getParent().setBackground(calendarTable.getBackground()); //Set background

		calendarTable.getTableHeader().setResizingAllowed(false);
		calendarTable.getTableHeader().setReorderingAllowed(false);

		calendarTable.setColumnSelectionAllowed(true);
		calendarTable.setRowSelectionAllowed(true);
		calendarTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		calendarTable.setRowHeight(76);
		modelCalendarTable.setColumnCount(7);
		modelCalendarTable.setRowCount(6);

		for (int i = d.getYearBound()-100; i <= d.getYearBound()+100; i++)
		{
			cmbYear.addItem(String.valueOf(i));
		}

		refreshCalendar (d.getMonthBound(), d.getYearBound()); //Refresh calendar
	}

	public void refreshCalendar(int month, int year)
	{
		String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int nod, som, i, j;

		btnPrev.setEnabled(true);
		btnNext.setEnabled(true);

		if (month == 0 && year <= d.getYearBound()-10)
			btnPrev.setEnabled(false);
		if (month == 11 && year >= d.getYearBound()+100)
			btnNext.setEnabled(false);

		monthLabel.setText(months[month]);
		monthLabel.setBounds(320-monthLabel.getPreferredSize().width/2, 50, 360, 50);

		cmbYear.setSelectedItem(""+year);

		for (i = 0; i < 6; i++)
			for (j = 0; j < 7; j++)
				modelCalendarTable.setValueAt(null, i, j);

		GregorianCalendar cal = new GregorianCalendar(year, month, 1);
		nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		som = cal.get(GregorianCalendar.DAY_OF_WEEK);

		for (i = 1; i <= nod; i++)
		{
			int row = new Integer((i+som-2)/7);
			int column  =  (i+som-2)%7;
			modelCalendarTable.setValueAt(i, row, column);
		}

		Events evt = new Events();

		for (int x = 0 ; x < evt.getEventsSize(); x++) {
			if (evt.getEvents().get(x).getYear() == year){
				if (evt.getEvents().get(x).getMonth() == month+1) {

					for (int y = 1; y <= nod; y++)
					{
						int row = new Integer((y+som-2)/7);
						int column  =(y+som-2)%7;
						if (modelCalendarTable.getValueAt(row, column).equals(evt.getEvents().get(x).getDay()) && calendarTable.getValueAt(row, column).toString().length() < 3 ) {
							String temp = "<html><font color = \"black\">  " +y+ "<font color=\"" + evt.getEvents().get(x).getColor().replaceAll(" ", "")+"\">" + " " +evt.getEvents().get(x).getTitle()+"<br></html>";
							modelCalendarTable.setValueAt(temp, row, column); 
						}
						else if (calendarTable.getValueAt(row, column).toString().length() > 3 ) { 
							if (modelCalendarTable.getValueAt(row, column).toString().contains(" "+evt.getEvents().get(x).getDay()+"") ) { 
								String old[] = modelCalendarTable.getValueAt(row, column).toString().split("<br>");
								String appended = old[0]+ "<br><font color=\"" + evt.getEvents().get(x).getColor().replaceAll(" ", "")+"\">"+ evt.getEvents().get(x).getTitle()+"<br>" +old[1];
								modelCalendarTable.setValueAt(appended, row, column);
							}
						}
					}
				}
			}
		}

		calendarTable.setDefaultRenderer(calendarTable.getColumnClass(0), new TableRenderer());
	}

	public void actionPerformed(ActionEvent e){
		Object src = e.getSource();

		if (src.equals(btnPrev)) {
			if (d.getMonthToday() == 0){
				d.setMonthToday(11);
				d.setYearToday(d.getYearToday() - 1);
			}
			else{
				d.setMonthToday(d.getMonthToday() - 1);
			}

			refreshCalendar(d.getMonthToday(), d.getYearToday());

			if (sub != null)
				sub.setState();
		}
		else if (src.equals(btnNext)) {
			if (d.getMonthToday() == 11){
				d.setMonthToday(0);
				d.setYearToday(d.getYearToday() + 1);
			}
			else{
				d.setMonthToday(d.getMonthToday() + 1);
			}

			refreshCalendar(d.getMonthToday(), d.getYearToday());

			if (sub != null)
				sub.setState();
		}
		else if (src.equals(cmbYear)) {
			if (cmbYear.getSelectedItem() != null){
				String b = cmbYear.getSelectedItem().toString();
				d.setYearToday(Integer.parseInt(b));
			}

			refreshCalendar(d.getMonthToday(), d.getYearToday());
		}
		else if (src.equals(newEvent)) {
			new EventAdder(sub);
		}
		else if (src.equals(refreshBtn)) {
			refreshCalendar (d.getMonthBound(), d.getYearBound());


			if (sub != null)
				sub.setState();
		}

	}
}