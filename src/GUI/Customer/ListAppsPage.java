package GUI.Customer;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import AppShop.App;
import AppShop.Category;
import AppShop.Customer;
import AppShop.PaidApp;
import GUI.AppWindow;
import GUI.Page;

@SuppressWarnings("serial")
public class ListAppsPage extends Page {
	private JList<App> list;
	private JComboBox<Category> appCategory;
	private Label noAppsTxt;
	private JButton btnShowAppDetails;
	private JButton btnDownload;
	private JButton btnBuyAndDownload;
	private JLabel appPriceTxt;

	/**
	 * Create the panel.
	 */
	public ListAppsPage() {
		super();
		addSelectCategoryFields();
		addShowDetailsBtn();
		addDownloadBtns();
		addAppsList();
		addAppPriceTxt();
		setPriceTxtVisibility();
		refreshListContentAndHideIfEmpty();
		setFieldsVisibility();
		addBackBtn();
	}
	
	private void addSelectCategoryFields() {
		JLabel categoryLabel = new JLabel("Category:");
		categoryLabel.setBounds(79, 193, 137, 15);
		add(categoryLabel);
		
		appCategory = new JComboBox<Category>();
		appCategory.setModel(new DefaultComboBoxModel<Category>(Category.values()));
		appCategory.setBounds(173, 188, 170, 24);
		add(appCategory);
		
		appCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshListContentAndHideIfEmpty();
			}
		});
	}
	
	private void addAppPriceTxt() {
		App currentApp = getSelectedApp();
		double appCost = 0;
		if(currentApp instanceof PaidApp)
			appCost = ((PaidApp) currentApp).getDiscountedCost((Customer) AppWindow.SHOP.getCurrentUser());
		
		appPriceTxt = new JLabel("App price: " + appCost);
		appPriceTxt.setBounds(526, 320, 180, 15);
		add(appPriceTxt);
	}
	
	private void setAppPriceTxt() {
		if(appPriceTxt != null) {
			App currentApp = getSelectedApp();
			double appCost = 0;
			if(currentApp instanceof PaidApp)
				appCost = ((PaidApp) currentApp).getDiscountedCost((Customer) AppWindow.SHOP.getCurrentUser());
			appPriceTxt.setText("App price: " + appCost);
		}
	}
	
	private void addShowDetailsBtn() {
		btnShowAppDetails = new JButton("Show details");
		btnShowAppDetails.setBounds(526, 246, 190, 25);
		add(btnShowAppDetails);
	}
	
	private void addDownloadBtns() {
		btnBuyAndDownload = new JButton("Buy and download");
		btnBuyAndDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Customer) AppWindow.SHOP.getCurrentUser()).addApp(list.getSelectedValue());
			}
		});
		btnBuyAndDownload.setBounds(526, 283, 190, 25);
		add(btnBuyAndDownload);
		
		btnDownload = new JButton("Download");
		btnDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Customer) AppWindow.SHOP.getCurrentUser()).addApp(list.getSelectedValue());
			}
		});
		btnDownload.setBounds(526, 283, 190, 25);
		add(btnDownload);
	}
	
	private void addAppsList() {
		addNoAppsInfoTxt();
		list = new JList<App>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(79, 224, 388, 228);
		add(list);
		refreshListContentAndHideIfEmpty();
	}
	
	private void refreshListContentAndHideIfEmpty() {
		list.setModel(new AbstractListModel<App>() {
			ArrayList<App> apps = AppWindow.SHOP.getAppsByCategoryName(getSelectedCategoryName());
			public int getSize() { 
				return apps.size();
			}
			public App getElementAt(int index) {
				return apps.get(index);
			}
		});
		
		if(list.getModel().getSize() == 0) {
			list.setVisible(false);
			setNoAppsInfoVisibility(true);
		} else {
			list.setSelectedIndex(0);
			list.setVisible(true);
			setNoAppsInfoVisibility(false);
		}
		setFieldsVisibility();
		setPriceTxtVisibility();
		setAppPriceTxt();
	}
	
	private void addNoAppsInfoTxt() {
		noAppsTxt = new Label("There are no apps in selected category.");
		noAppsTxt.setBounds(79, 224, 315, 21);
		add(noAppsTxt);
	}
	
	private void setNoAppsInfoVisibility(boolean isVisible) {
		noAppsTxt.setVisible(isVisible);
	}
	
	private App getSelectedApp() {
		System.out.println(list.getSelectedValue());
		return list.getSelectedValue();
	}
	
	private String getSelectedCategoryName() {
		return appCategory.getSelectedItem().toString();
	}
	
	private void setFieldsVisibility() {
		if(getSelectedApp() instanceof PaidApp) {
			btnDownload.setVisible(false);
			btnBuyAndDownload.setVisible(true);
		} else {
			btnDownload.setVisible(true);
			btnBuyAndDownload.setVisible(false);
		}
	}
	
	private void setPriceTxtVisibility() {
		if(appPriceTxt != null) {
			if(getSelectedApp() instanceof PaidApp)
				appPriceTxt.setVisible(true);
			else
				appPriceTxt.setVisible(false);
		}
	}
	
	private void addBackBtn() {
		JButton btnBack = new JButton("Go back to the home page");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppWindow.openHomePage();
			}
		});
		btnBack.setBounds(290, 525, 220, 25);
		add(btnBack);
	}
}
