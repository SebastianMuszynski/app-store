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

@SuppressWarnings("serial")
public class ManageCustomersPage extends Page {
	
	private JList<Customer> list;

	/**
	 * Create the panel.
	 */
	public ManageCustomersPage() {
		super();
		addCustomersList();
		addMenuButtons();
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
		if(list != null && list.getModel().getSize() > 0) {
			addShowCustomerBtn();
			addEditCustomerBtn();
			addRemoveCustomerBtn();
		}
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
}
