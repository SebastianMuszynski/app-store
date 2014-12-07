package GUI.Admin;

import javax.swing.JLabel;

import AppShop.Customer;
import GUI.AppWindow;
import GUI.Page;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ShowCustomerPage extends Page {

	/**
	 * Create the panel.
	 */
	public ShowCustomerPage(Customer customer) {
		super();
		addCustomerInfo(customer);
		addBackBtn();
	}
	
	private void addCustomerInfo(Customer customer) {
		JLabel label = new JLabel("Username: " + customer.getUsername());
		label.setBounds(116, 184, 300, 15);
		add(label);
		
		JLabel label_2 = new JLabel("Name: " + customer.getName());
		label_2.setBounds(116, 211, 300, 15);
		add(label_2);
		
		JLabel label_3 = new JLabel("Address: " + customer.getAddress());
		label_3.setBounds(116, 238, 300, 15);
		add(label_3);
		
		JLabel label_4 = new JLabel("Profession: " + customer.getProfession());
		label_4.setBounds(116, 265, 300, 15);
		add(label_4);
	}
	
	private void addBackBtn() {
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppWindow.openManageCustomersPage();
			}
		});
		btnBack.setBounds(116, 305, 81, 25);
		add(btnBack);
	}

}
