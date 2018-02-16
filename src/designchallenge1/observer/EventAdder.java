package designchallenge1.observer;

import designchallenge1.template.CSVDataParser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EventAdder extends JFrame implements ActionListener {

    Date d = new Date();
    Subject sub;

	public JFrame frmEvent;
	public JPanel eventPanel;
	public Container pane;
	
    public JTextField titleField;
	public JLabel titleLabel, dateLabel, colorLabel, invalidDateLabel, noTitleLabel;
	
	public JButton btnAdd;
    public JComboBox<String> cmbDay, cmbMonth, cmbYear, cmbColor;
    
    public String[] colors = {"Green","Red","Blue","Orange", "Purple"};
        
    public EventAdder() {

    	frmEvent = new JFrame ("Add New Event");
    	frmEvent.setSize(400, 450);
    	frmEvent.setResizable(false);
    	frmEvent.setVisible(true);
    	frmEvent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	
    	init();
    }

    public EventAdder(Subject sub) {
    	this();
    	this.sub = sub;
	}

    public void init() {

		pane = frmEvent.getContentPane();
		pane.setLayout(null);
		
		titleField = new JTextField("");
		titleLabel = new JLabel("Event Name");
		dateLabel = new JLabel("Date (mm-dd-yyyy)");
		colorLabel = new JLabel("Color");
		invalidDateLabel = new JLabel("Invalid input of date.");
		invalidDateLabel.setForeground(Color.RED);
		noTitleLabel = new JLabel("Cannot have an empty title.");
		noTitleLabel.setForeground(Color.RED);
		cmbDay = new JComboBox();
		cmbMonth = new JComboBox();
		cmbYear = new JComboBox();
		cmbColor = new JComboBox();
		
		btnAdd = new JButton ("ADD");

		btnAdd.addActionListener(this);
		eventPanel = new JPanel(null);

		pane.add(eventPanel);
		eventPanel.add(titleField);
		eventPanel.add(titleLabel);
		eventPanel.add(dateLabel);
		eventPanel.add(colorLabel);
		eventPanel.add(cmbMonth);
		eventPanel.add(cmbDay);
		eventPanel.add(cmbYear);
		eventPanel.add(cmbColor);

		eventPanel.add(btnAdd);
		
		eventPanel.setBounds(0, 00, 380, 700);
		titleField.setBounds(150, 80,200, 40);
		titleLabel.setBounds(40,30, 100, 150);
		dateLabel.setBounds(40,100, 100,150);
		colorLabel.setBounds(40,170, 100,150);
		cmbMonth.setBounds(160, 150, 90, 50);
		cmbDay.setBounds(220, 150, 80, 50);
		cmbYear.setBounds(280, 150, 80, 50);
		cmbColor.setBounds(170, 220, 180,40);
		
		cmbDay.setSize(40, 40);
		cmbMonth.setSize(40, 40);
		cmbYear.setSize(60, 40);
		cmbColor.setSize(160, 45);
		
		btnAdd.setBounds(240, 330, 100, 50);
		
		for (int i=1; i <=31; i++){
			cmbDay.addItem(String.valueOf(i));
		}
		for (int i=1; i <=12; i++){
			cmbMonth.addItem(String.valueOf(i));
		}
		for (int i= d.getYearBound()-100; i <= d.getYearBound()+100; i++){
			cmbYear.addItem(String.valueOf(i));
		}
		for (int i=0; i<colors.length; i++){
			cmbColor.addItem(String.valueOf(colors[i]));
		}

		cmbYear.setSelectedIndex(100);
    }

	public void actionPerformed(ActionEvent e) {
		if (titleField.getText().isEmpty()) {
			eventPanel.add(noTitleLabel);
			noTitleLabel.setBounds(40, 250, 150, 150);
			eventPanel.setVisible(true);

		} else {
			String title = titleField.getText();
			int day = Integer.parseInt(cmbDay.getSelectedItem().toString());
			int month = Integer.parseInt(cmbMonth.getSelectedItem().toString());
			int year = Integer.parseInt(cmbYear.getSelectedItem().toString());
			String color = cmbColor.getSelectedItem().toString();

			boolean validation = dateChecker(month, day, year);

			System.out.println(validation);

			if (validation == true) {
				designchallenge1.observer.Event newEvent = new Event(month, day, year);
				newEvent.setTitle(title);
				newEvent.setColor(color.toLowerCase());

				Events evt = new Events();
				evt.addEvent(newEvent);
				int index = evt.getIndex(newEvent);

				CSVDataParser csv = new CSVDataParser();
				csv.writeData(index);

				sub.setState();
				frmEvent.dispose();
				
			} else {
				eventPanel.add(invalidDateLabel);
				invalidDateLabel.setBounds(40, 250, 150, 150);
				eventPanel.setVisible(true);
			}

		}
	}

	public boolean dateChecker(int month, int date, int year) {
		switch (month) {
			case 2:
				if (date >= 1 && date <= 28)
					return true;
				else if (date == 29){
					if (year % 4 == 0) {
						if (year % 100 == 0) {
							if (year % 400 == 0)
								return true;
							else
								return false;
						} else
							return true;
					} else
						return false;
				}

				break;
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12: if (date >= 1 && date <= 31)
				return true;
				break;
			default: if (date >= 1 && date <= 30)
				return true;

		}
		return false;
	}
	
	
}