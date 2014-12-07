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
	
	private Customer customer;

	/**
	 * Create the panel.
	 */
	public ShowCustomerPage(Customer customer) {
		super();
		this.customer = customer;
		addCustomerInfo();
		addBackBtn();
		addEditCustomerBtn();
		addRemoveCustomerBtn();
	}
	
	private void addCustomerInfo() {
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

		JLabel label_5 = new JLabel("Number of apps used as a free trial: " + customer.freeAppsNumber());
		label_5.setBounds(116, 292, 300, 15);
		add(label_5);
		
		JLabel label_6 = new JLabel("Number of purchased apps: " + customer.paidAppsNumber());
		label_6.setBounds(116, 319, 300, 15);
		add(label_6);
		
		JLabel label_7 = new JLabel("The amount to be paid for apps: " + customer.amountToPaidForApps());
		label_7.setBounds(116, 346, 300, 15);
		add(label_7);
	}
	
	private void addEditCustomerBtn() {
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(514, 200, 150, 25);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppWindow.openEditCustomerPage(customer);
			}
		});
		add(btnEdit);
	}
	
	private void addRemoveCustomerBtn() {
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(514, 237, 150, 25);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppWindow.SHOP.deleteUserByUsername(customer.getUsername());
				AppWindow.openManageCustomersPage();
			}
		});
		add(btnRemove);
	}
	
	private void addBackBtn() {
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppWindow.openManageCustomersPage();
			}
		});
		btnBack.setBounds(116, 379, 81, 25);
		add(btnBack);
	}

}
