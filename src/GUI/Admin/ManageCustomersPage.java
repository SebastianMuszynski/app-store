package GUI.Admin;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import AppShop.Customer;
import GUI.AppWindow;
import GUI.Page;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ManageCustomersPage extends Page {
	
	private JList<Customer> list;
	private JTextField customerUsernameTxt;
	private Label noCustomerFound;

	/**
	 * Create the panel.
	 */
	public ManageCustomersPage() {
		super();
		addCustomersList();
		addMenuButtons();
		addCustomerSearchFields();
	}
	
	private void addCustomersList() {
		list = new JList<Customer>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel<Customer>() {
			ArrayList<Customer> customers = AppWindow.SHOP.getCustomers();
			public int getSize() { 
				return customers.size();
			}
			public Customer getElementAt(int index) {
				return customers.get(index);
			}
		});
		list.setSelectedIndex(0);
		list.setBounds(79, 175, 388, 228);
		if(list.getModel().getSize() != 0)
			add(list);
		else
			displayNoCustomersInfo();
	}
	
	private void displayNoCustomersInfo() {
		Label label = new Label("There are no customers :(");
		label.setBounds(277, 289, 245, 21);
		add(label);
	}
	
	private void addMenuButtons() { 
		addCreateCustomerBtn();
		if(list != null && list.getModel().getSize() > 0) {
			addShowCustomerBtn();
			addEditCustomerBtn();
			addRemoveCustomerBtn();
		}
	}
	
	private void addCreateCustomerBtn() {
		JButton btnNew = new JButton("Create");
		btnNew.setBounds(508, 193, 150, 25);
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AppWindow.openAddCustomerPage();
			}
		});
		add(btnNew);
	}
	
	private void addShowCustomerBtn() {
		JButton btnNewButton = new JButton("Show details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppWindow.openShowCustomerPage(getSelectedCustomer());
			}
		});
		btnNewButton.setBounds(508, 230, 150, 25);
		add(btnNewButton);
	}
	
	private void addEditCustomerBtn() {
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(508, 267, 150, 25);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppWindow.openEditCustomerPage(getSelectedCustomer());
			}
		});
		add(btnEdit);
	}
	
	private void addRemoveCustomerBtn() {
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(508, 304, 150, 25);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = list.getSelectedIndex();
				Customer customer = list.getModel().getElementAt(selectedIndex);
				AppWindow.SHOP.deleteUserByUsername(customer.getUsername());
				AppWindow.openManageCustomersPage();
			}
		});
		add(btnRemove);
	}
	
	private Customer getSelectedCustomer() {
		int selectedIndex = list.getSelectedIndex();
		return list.getModel().getElementAt(selectedIndex);
	}
	
	private void addCustomerSearchFields() {
		customerUsernameTxt = new JTextField();
		customerUsernameTxt.setBounds(288, 482, 196, 19);
		customerUsernameTxt.setColumns(10);
		add(customerUsernameTxt);
		
		Label label = new Label("Type customer's username:");
		label.setBounds(98, 480, 184, 21);
		add(label);
		
		JButton searchBtn = new JButton("Search");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = customerUsernameTxt.getText();
				Customer customer = (Customer) AppWindow.SHOP.findUserByUsername(username);
				if(customer != null)
					AppWindow.openShowCustomerPage(customer);
				else
					displayNoCustomerFoundInfo();
			}
		});
		searchBtn.setBounds(496, 479, 117, 25);
		add(searchBtn);
	}
	
	private void displayNoCustomerFoundInfo() {
		noCustomerFound = new Label("There is no customer with provided username.");
		noCustomerFound.setBounds(98, 510, 300, 21);
		add(noCustomerFound);
	}
}
