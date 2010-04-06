/*
 * SwitchboardView.java
 *
 * Created on August 14, 2006, 11:45 PM
 */

package com.floreantpos.ui.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.floreantpos.bo.ui.BackOfficeWindow;
import com.floreantpos.main.Application;
import com.floreantpos.model.ActionHistory;
import com.floreantpos.model.AttendenceHistory;
import com.floreantpos.model.Shift;
import com.floreantpos.model.Ticket;
import com.floreantpos.model.User;
import com.floreantpos.model.UserPermission;
import com.floreantpos.model.UserType;
import com.floreantpos.model.dao.ActionHistoryDAO;
import com.floreantpos.model.dao.AttendenceHistoryDAO;
import com.floreantpos.model.dao.TicketDAO;
import com.floreantpos.model.util.POSConstants;
import com.floreantpos.print.PosPrintService;
import com.floreantpos.services.PosTransactionService;
import com.floreantpos.ui.dialog.ManagerDialog;
import com.floreantpos.ui.dialog.NumberSelectionDialog2;
import com.floreantpos.ui.dialog.POSMessageDialog;
import com.floreantpos.ui.dialog.PaymentTypeSelectionDialog;
import com.floreantpos.ui.dialog.PayoutDialog;
import com.floreantpos.ui.dialog.TicketDetailDialog;
import com.floreantpos.ui.dialog.VoidTicketDialog;
import com.floreantpos.ui.views.order.OrderView;
import com.floreantpos.ui.views.order.RootView;

/**
 *
 * @author  MShahriar
 */
public class SwitchboardView extends JPanel implements ActionListener {
	public final static String VIEW_NAME = "SWITCHBOARD";

	private Timer ticketListUpdater;

	/** Creates new form SwitchboardView */
	public SwitchboardView() {
		initComponents();

		btnBackOffice.addActionListener(this);
		btnClockOut.addActionListener(this);
		btnEditTicket.addActionListener(this);
		btnGroupSettle.addActionListener(this);
		btnInfo.addActionListener(this);
		btnLogout.addActionListener(this);
		btnManager.addActionListener(this);
		btnNewTicket.addActionListener(this);
		btnPayout.addActionListener(this);
		btnPrintTicket.addActionListener(this);
		btnReopenTicket.addActionListener(this);
		btnSettleTicket.addActionListener(this);
		btnShutdown.addActionListener(this);
		btnSplitTicket.addActionListener(this);
		btnTakeout.addActionListener(this);
		btnVoidTicket.addActionListener(this);

		ticketListUpdater = new Timer(30 * 1000, new TicketListUpdaterTask());
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc=" Generated Code
	// <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
	private void initComponents() {

		javax.swing.JPanel statusPanel = new javax.swing.JPanel();
		lblUserName = new javax.swing.JLabel();
		javax.swing.JPanel bottomPanel = new javax.swing.JPanel();
		javax.swing.JPanel bottomLeftPanel = new javax.swing.JPanel();
		openTicketList = new com.floreantpos.ui.TicketListView();
		javax.swing.JPanel activityPanel = new javax.swing.JPanel();
		btnInfo = new com.floreantpos.swing.PosButton();
		btnNewTicket = new com.floreantpos.swing.PosButton();
		btnEditTicket = new com.floreantpos.swing.PosButton();
		btnSplitTicket = new com.floreantpos.swing.PosButton();
		btnVoidTicket = new com.floreantpos.swing.PosButton();
		btnReopenTicket = new com.floreantpos.swing.PosButton();
		btnSettleTicket = new com.floreantpos.swing.PosButton();
		btnGroupSettle = new com.floreantpos.swing.PosButton();
		btnPayout = new com.floreantpos.swing.PosButton();
		btnTakeout = new com.floreantpos.swing.PosButton();
		btnPrintTicket = new com.floreantpos.swing.PosButton();
		javax.swing.JPanel bottomRightPanel = new javax.swing.JPanel();
		btnShutdown = new com.floreantpos.swing.PosButton();
		btnLogout = new com.floreantpos.swing.PosButton();
		btnBackOffice = new com.floreantpos.swing.PosButton();
		btnManager = new com.floreantpos.swing.PosButton();
		btnClockOut = new com.floreantpos.swing.PosButton();

		setLayout(new java.awt.BorderLayout());

		statusPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CURRENT USER STATUS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
		statusPanel.setPreferredSize(new java.awt.Dimension(100, 80));
		statusPanel.setLayout(new java.awt.BorderLayout());

		lblUserName.setFont(new java.awt.Font("Tahoma", 1, 18));
		lblUserName.setForeground(new java.awt.Color(0, 102, 102));
		lblUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblUserName.setText("USER NAME");
		statusPanel.add(lblUserName, java.awt.BorderLayout.PAGE_START);

		add(statusPanel, java.awt.BorderLayout.NORTH);

		bottomPanel.setLayout(new java.awt.BorderLayout());

		bottomLeftPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OPEN TICKETS AND ACTIVITY", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
		bottomLeftPanel.setLayout(new java.awt.BorderLayout(5, 5));
		bottomLeftPanel.add(openTicketList, java.awt.BorderLayout.CENTER);

		activityPanel.setPreferredSize(new java.awt.Dimension(655, 160));
		activityPanel.setLayout(new java.awt.GridLayout(3, 0, 5, 5));

		btnInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settle_ticket_32.png")));
		btnInfo.setText("INFO");
		btnInfo.setPreferredSize(new java.awt.Dimension(160, 60));
		activityPanel.add(btnInfo);

		btnNewTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new_ticket_32.png")));
		btnNewTicket.setText("NEW");
		btnNewTicket.setPreferredSize(new java.awt.Dimension(120, 50));
		activityPanel.add(btnNewTicket);

		btnEditTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_ticket_32.png")));
		btnEditTicket.setText("EDIT");
		btnEditTicket.setPreferredSize(new java.awt.Dimension(120, 50));
		activityPanel.add(btnEditTicket);

		btnSplitTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/split_32.png")));
		btnSplitTicket.setText("SPLIT");
		btnSplitTicket.setPreferredSize(new java.awt.Dimension(120, 50));
		activityPanel.add(btnSplitTicket);

		btnVoidTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/void_ticket_32.png")));
		btnVoidTicket.setText("VOID");
		btnVoidTicket.setPreferredSize(new java.awt.Dimension(120, 50));
		activityPanel.add(btnVoidTicket);

		btnReopenTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_ticket_32.png")));
		btnReopenTicket.setText("RE-OPEN");
		btnReopenTicket.setPreferredSize(new java.awt.Dimension(120, 50));
		activityPanel.add(btnReopenTicket);

		btnSettleTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settle_ticket_32.png")));
		btnSettleTicket.setText("SETTLE");
		btnSettleTicket.setPreferredSize(new java.awt.Dimension(160, 60));
		activityPanel.add(btnSettleTicket);

		btnGroupSettle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settle_ticket_32.png")));
		btnGroupSettle.setText("<html><body>GROUP<br>SETTLE</body></html>");
		btnGroupSettle.setPreferredSize(new java.awt.Dimension(160, 60));
		activityPanel.add(btnGroupSettle);

		btnPayout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pay_32.png")));
		btnPayout.setText("PAY OUT");
		btnPayout.setPreferredSize(new java.awt.Dimension(160, 60));
		activityPanel.add(btnPayout);

		btnTakeout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pay_32.png")));
		btnTakeout.setText("TAKE OUT");
		btnTakeout.setPreferredSize(new java.awt.Dimension(160, 60));
		activityPanel.add(btnTakeout);

		btnPrintTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print_32.png")));
		btnPrintTicket.setText("PRINT");
		btnPrintTicket.setPreferredSize(new java.awt.Dimension(120, 50));
		activityPanel.add(btnPrintTicket);

		bottomLeftPanel.add(activityPanel, java.awt.BorderLayout.SOUTH);

		bottomPanel.add(bottomLeftPanel, java.awt.BorderLayout.CENTER);

		bottomRightPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OTHERS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
		bottomRightPanel.setPreferredSize(new java.awt.Dimension(200, 10));

		btnShutdown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shut_down_32.png")));
		btnShutdown.setText("SHUTDOWN");

		btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/log_out_32.png")));
		btnLogout.setText("LOGOUT");

		btnBackOffice.setText("BACK-OFFICE");

		btnManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user_32.png")));
		btnManager.setText("MANAGER");

		btnClockOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/log_out_32.png")));
		btnClockOut.setText("CLOCK OUT");

		org.jdesktop.layout.GroupLayout bottomRightPanelLayout = new org.jdesktop.layout.GroupLayout(bottomRightPanel);
		bottomRightPanel.setLayout(bottomRightPanelLayout);
		bottomRightPanelLayout.setHorizontalGroup(bottomRightPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(
				bottomRightPanelLayout.createSequentialGroup().addContainerGap().add(
						bottomRightPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(btnShutdown, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE).add(btnLogout, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE).add(btnClockOut,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 168, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).add(btnBackOffice, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE).add(btnManager, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
						.addContainerGap()));
		bottomRightPanelLayout.setVerticalGroup(bottomRightPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(
				org.jdesktop.layout.GroupLayout.TRAILING,
				bottomRightPanelLayout.createSequentialGroup().addContainerGap(39, Short.MAX_VALUE).add(btnManager, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED).add(
						btnBackOffice, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED).add(btnClockOut, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
						org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED).add(btnLogout, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
						org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED).add(btnShutdown, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).addContainerGap()));

		bottomRightPanelLayout.linkSize(new java.awt.Component[] { btnBackOffice, btnClockOut, btnLogout, btnManager, btnShutdown }, org.jdesktop.layout.GroupLayout.VERTICAL);

		bottomPanel.add(bottomRightPanel, java.awt.BorderLayout.EAST);

		add(bottomPanel, java.awt.BorderLayout.CENTER);
	}// </editor-fold>//GEN-END:initComponents

	private void doReopenTicket() {
		NumberSelectionDialog2 dialog = new NumberSelectionDialog2();
		dialog.setTitle("Please enter ticket ID");
		dialog.pack();
		dialog.open();

		if (dialog.isCanceled()) {
			return;
		}

		int ticketId = (int) dialog.getValue();
		TicketDAO dao = new TicketDAO();
		Ticket ticket = dao.get(Integer.valueOf(ticketId));
		if (ticket == null) {
			POSMessageDialog.showError("No ticket with ID " + ticketId + " found");
			return;
		}
		if (!ticket.isClosed()) {
			POSMessageDialog.showError("The ticket is not closed");
			return;
		}

		String amount = Application.getCurrencySymbol() + Application.formatNumber(ticket.getTotalAmount());
		String amountMessage = "<span style='color: red; font-weight: bold;'>" + amount + "</span>";
		String message = "<html><body><h3>The ticket will be opened in edit mode. Before that, you must refund <br/>" + "amount " + amountMessage + " to keep the system stable. Do you wish to continue?</h3></body></html>";
		int option = JOptionPane.showOptionDialog(this, message, "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
		if (option != JOptionPane.YES_OPTION) {
			return;
		}

		try {
			PosTransactionService service = PosTransactionService.getInstance();
			service.refundTicket(ticket);

			//REOPEN ACTION
			ActionHistoryDAO.getInstance().saveHistory(Application.getCurrentUser(), ActionHistory.REOPEN_CHECK, "CHK#:" + ticket.getId());

			JOptionPane.showMessageDialog(this, "<html><body>Please press <b>OK</b> after you refund amount " + amountMessage + "</body></html>");
			ticket.setDrawerResetted(false);
			editTicket(ticket);
		} catch (Exception e) {
			POSMessageDialog.showError(this, POSMessageDialog.ERROR_MESSAGE, e);
		}
	}

	private void doClockOut() {
		int option = JOptionPane.showOptionDialog(this, "Are you sure you want to Clock Out?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		if (option != JOptionPane.YES_OPTION) {
			return;
		}

		User user = Application.getCurrentUser();
		AttendenceHistoryDAO attendenceHistoryDAO = new AttendenceHistoryDAO();
		AttendenceHistory attendenceHistory = attendenceHistoryDAO.findHistoryByClockedInTime(user);
		if (attendenceHistory == null) {
			attendenceHistory = new AttendenceHistory();
			Date lastClockInTime = user.getLastClockInTime();
			Calendar c = Calendar.getInstance();
			c.setTime(lastClockInTime);
			attendenceHistory.setClockInTime(lastClockInTime);
			attendenceHistory.setClockInHour(Short.valueOf((short) c.get(Calendar.HOUR)));
			attendenceHistory.setUser(user);
			attendenceHistory.setTerminal(Application.getInstance().getTerminal());
			attendenceHistory.setShift(user.getCurrentShift());
		}

		Shift shift = user.getCurrentShift();
		Calendar calendar = Calendar.getInstance();

		user.doClockOut(attendenceHistory, shift, calendar);

		Application.getInstance().logout();
	}

	private synchronized void doShowBackoffice() {
		BackOfficeWindow window = Application.getInstance().getBackOfficeWindow();
		if (window == null) {
			window = new BackOfficeWindow();
			Application.getInstance().setBackOfficeWindow(window);
		}
		window.setVisible(true);
		window.toFront();
	}

	private void doShutdown() {
		Application.getInstance().shutdownPOS();
	}

	private void doLogout() {
		Application.getInstance().logout();
	}

	private void doSettleTicket() {
		try {
			List<Ticket> selectedTickets = openTicketList.getSelectedTickets();
			if (selectedTickets.size() == 0 || selectedTickets.size() > 1) {
				POSMessageDialog.showMessage("Please select one ticket to settle.");
				return;
			}

			Ticket ticket = selectedTickets.get(0);

			PaymentTypeSelectionDialog dialog = new PaymentTypeSelectionDialog();
			dialog.setSize(250, 400);
			dialog.open();

			if (!dialog.isCanceled()) {
				ticket = TicketDAO.getInstance().initializeTicket(ticket);

				SettleTicketView view = SettleTicketView.getInstance();
				view.setPaymentView(dialog.getSelectedPaymentView());
				view.setCurrentTicket(ticket);
				RootView.getInstance().showView(SettleTicketView.VIEW_NAME);
			}
		} catch (Exception e) {
			POSMessageDialog.showError(POSConstants.RESTART_ERROR_MESSAGE, e);
		}
	}

	private void doPrintTicket() {
		List<Ticket> selectedTickets = openTicketList.getSelectedTickets();
		if (selectedTickets.size() == 0 || selectedTickets.size() > 1) {
			POSMessageDialog.showMessage("Please select one ticket to print.");
			return;
		}

		Ticket ticket = selectedTickets.get(0);
		try {
			ticket = TicketDAO.getInstance().initializeTicket(ticket);
			PosPrintService.printTicket(ticket);

			//			PRINT ACTION
			String actionMessage = "CHK#:" + ticket.getId();
			ActionHistoryDAO.getInstance().saveHistory(Application.getCurrentUser(), ActionHistory.PRINT_CHECK, actionMessage);
		} catch (Exception e) {
			POSMessageDialog.showError(this, e.getMessage(), e);
		}
	}

	private void doVoidTicket() {
		try {
			List<Ticket> selectedTickets = openTicketList.getSelectedTickets();
			if (selectedTickets.size() == 0 || selectedTickets.size() > 1) {
				POSMessageDialog.showMessage("Please select one ticket to void.");
				return;
			}

			Ticket ticket = selectedTickets.get(0);

			if (!ticket.getTotalAmount().equals(ticket.getDueAmount())) {
				POSMessageDialog.showMessage("You cannot void the ticket since it is partially paid.");
				return;
			}

			//initialize the ticket.
			ticket = TicketDAO.getInstance().initializeTicket(ticket);

			VoidTicketDialog voidTicketDialog = new VoidTicketDialog(Application.getPosWindow(), true);
			voidTicketDialog.setTicket(ticket);
			voidTicketDialog.open();

			if (!voidTicketDialog.isCanceled()) {
				updateView();
			}
		} catch (Exception e) {
			POSMessageDialog.showError(POSConstants.RESTART_ERROR_MESSAGE, e);
		}
	}

	private void doSplitTicket() {
		try {
			List<Ticket> selectedTickets = openTicketList.getSelectedTickets();
			if (selectedTickets.size() == 0 || selectedTickets.size() > 1) {
				POSMessageDialog.showMessage("Please select one ticket to split.");
				return;
			}

			Ticket ticket = selectedTickets.get(0);
			if (!ticket.getTotalAmount().equals(ticket.getDueAmount())) {
				POSMessageDialog.showMessage("You cannot void the ticket since it is partially paid.");
				return;
			}

			//initialize the ticket.
			ticket = TicketDAO.getInstance().initializeTicket(ticket);

			SplitTicketDialog dialog = new SplitTicketDialog();
			dialog.setTicket(ticket);
			dialog.open();

			updateView();
		} catch (Exception e) {
			POSMessageDialog.showError(POSConstants.RESTART_ERROR_MESSAGE, e);
		}
	}

	private void doEditTicket() {
		List<Ticket> selectedTickets = openTicketList.getSelectedTickets();
		if (selectedTickets.size() == 0 || selectedTickets.size() > 1) {
			POSMessageDialog.showMessage("Please select one ticket to edit.");
			return;
		}

		Ticket ticket = selectedTickets.get(0);

		editTicket(ticket);
	}

	private void editTicket(Ticket ticket) {
		//initialize the ticket.
		ticket = TicketDAO.getInstance().initializeTicket(ticket);

		OrderView.getInstance().setCurrentTicket(ticket);
		RootView.getInstance().showView(OrderView.VIEW_NAME);
	}

	private void doCreateNewTicket() {
		createNewTicket();
	}

	private void createNewTicket() {
		NumberSelectionDialog2 dialog = new NumberSelectionDialog2();
		dialog.setTitle("Please enter a table number");
		dialog.pack();
		dialog.open();

		if (dialog.isCanceled()) {
			return;
		}

		int tableNumber = (int) dialog.getValue();
		if (tableNumber == 0) {
			POSMessageDialog.showError(this, "Table number cannot be 0");
			return;
		}

		TicketDAO dao = TicketDAO.getInstance();

		Ticket ticket = dao.findTicketByTableNumber(tableNumber);
		if (ticket != null) {
			int option = JOptionPane.showOptionDialog(this, "The table is already occupied, what do you want to do?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] { "Create New Ticket", "Edit Existing Ticket", "Cancel" }, null);
			if (option == JOptionPane.YES_OPTION) {
				//createNewTicket();
				//return;
				//fall down to create new ticket.
			}
			else if (option == JOptionPane.NO_OPTION) {
				editTicket(ticket);
				return;
			}
			else {
				return;
			}
		}

		dialog.setTitle("Please enter number of guest");
		dialog.setValue(0);
		dialog.open();

		if (dialog.isCanceled()) {
			return;
		}
		int numberOfGuests = (int) dialog.getValue();
		if (numberOfGuests == 0) {
			POSMessageDialog.showError(this, "Guest number cannot be 0");
			return;
		}

		Application application = Application.getInstance();

		ticket = new Ticket();
		ticket.setTableNumber(tableNumber);
		ticket.setNumberOfGuests(numberOfGuests);
		ticket.setTerminal(application.getTerminal());
		ticket.setOwner(Application.getCurrentUser());
		ticket.setShift(application.getCurrentShift());

		Calendar currentTime = Calendar.getInstance();
		ticket.setCreateDate(currentTime.getTime());
		ticket.setCreationHour(currentTime.get(Calendar.HOUR_OF_DAY));

		OrderView.getInstance().setCurrentTicket(ticket);
		RootView.getInstance().showView(OrderView.VIEW_NAME);
	}

	private void doTakeout() {
		Application application = Application.getInstance();

		Ticket ticket = new Ticket();
		ticket.setTableNumber(Ticket.TAKE_OUT);
		ticket.setTerminal(application.getTerminal());
		ticket.setOwner(Application.getCurrentUser());
		ticket.setShift(application.getCurrentShift());

		Calendar currentTime = Calendar.getInstance();
		ticket.setCreateDate(currentTime.getTime());
		ticket.setCreationHour(currentTime.get(Calendar.HOUR_OF_DAY));

		OrderView.getInstance().setCurrentTicket(ticket);
		RootView.getInstance().showView(OrderView.VIEW_NAME);
	}

	private void doPayout() {
		PayoutDialog dialog = new PayoutDialog(Application.getPosWindow(), true);
		dialog.open();
	}

	private void doShowManagerWindow() {
		ManagerDialog dialog = new ManagerDialog();
		dialog.open();
	}

	private void doShowTicketInfo() {
		Ticket ticket = openTicketList.getSelectedTicket();
		if (ticket == null) {
			POSMessageDialog.showMessage("Please select a ticket from the open ticket list.");
			return;
		}
		TicketDetailDialog dialog = new TicketDetailDialog(Application.getPosWindow(), true);
		dialog.setButtonPanelVisible(false);
		dialog.setBalanceDuePanelVisible(false);
		dialog.setTicket(ticket);
		dialog.pack();
		dialog.open();
	}

	private void doGroupSettle() {
		List<Ticket> selectedTickets = openTicketList.getSelectedTickets();
		if (selectedTickets.size() < 2) {
			POSMessageDialog.showError("You must select two or more ticket for group settle");
			return;
		}

		PaymentTypeSelectionDialog dialog = new PaymentTypeSelectionDialog();
		dialog.setSize(250, 400);
		dialog.open();

		if (!dialog.isCanceled()) {

			for (int i = 0; i < selectedTickets.size(); i++) {
				Ticket ticket = selectedTickets.get(i);
				ticket = TicketDAO.getInstance().initializeTicket(ticket);
				selectedTickets.set(i, ticket);
			}

			SettleTicketView view = SettleTicketView.getInstance();
			view.setPaymentView(dialog.getSelectedPaymentView());
			view.setTicketsToSettle(selectedTickets);
			RootView.getInstance().showView(SettleTicketView.VIEW_NAME);
		}
	}

	public void updateView() {
		User user = Application.getCurrentUser();
		UserType userType = user.getNewUserType();
		if (userType != null) {
			Set<UserPermission> permissions = userType.getPermissions();
			if (permissions != null) {
				btnNewTicket.setEnabled(false);
				btnBackOffice.setEnabled(false);
				btnEditTicket.setEnabled(false);
				btnGroupSettle.setEnabled(false);
				btnManager.setEnabled(false);
				btnPayout.setEnabled(false);
				btnReopenTicket.setEnabled(false);
				btnSettleTicket.setEnabled(false);
				btnSplitTicket.setEnabled(false);
				btnTakeout.setEnabled(false);
				btnVoidTicket.setEnabled(false);

				for (UserPermission permission : permissions) {
					if (permission.equals(UserPermission.VOID_TICKET)) {
						btnVoidTicket.setEnabled(true);
					}
					else if (permission.equals(UserPermission.PAY_OUT)) {
						btnPayout.setEnabled(true);
					}
					else if (permission.equals(UserPermission.SETTLE_TICKET)) {
						btnSettleTicket.setEnabled(true);
						btnGroupSettle.setEnabled(true);
					}
					else if (permission.equals(UserPermission.REOPEN_TICKET)) {
						btnReopenTicket.setEnabled(true);
					}
					else if (permission.equals(UserPermission.PERFORM_MANAGER_TASK)) {
						btnManager.setEnabled(true);
					}
					else if (permission.equals(UserPermission.SPLIT_TICKET)) {
						btnSplitTicket.setEnabled(true);
					}
					else if (permission.equals(UserPermission.TAKE_OUT)) {
						btnTakeout.setEnabled(true);
					}
					else if (permission.equals(UserPermission.VIEW_BACK_OFFICE)) {
						btnBackOffice.setEnabled(true);
					}
					else if (permission.equals(UserPermission.PAY_OUT)) {
						btnPayout.setEnabled(true);
					}
					else if (permission.equals(UserPermission.EDIT_TICKET)) {
						btnEditTicket.setEnabled(true);
					}
					else if (permission.equals(UserPermission.CREATE_NEW_TICKET)) {
						btnNewTicket.setEnabled(true);
					}
				}
			}
		}

		updateTicketList();
	}

	private void updateTicketList() {
		User user = Application.getCurrentUser();

		TicketDAO dao = TicketDAO.getInstance();
		List<Ticket> openTickets = null;

		boolean showAllOpenTicket = false;
		if (user.getNewUserType() != null) {
			Set<UserPermission> permissions = user.getNewUserType().getPermissions();
			if (permissions != null) {
				for (UserPermission permission : permissions) {
					if(permission.equals(UserPermission.VIEW_ALL_OPEN_TICKET)) {
						showAllOpenTicket = true;
						break;
					}
				}
			}
		}

		if(showAllOpenTicket) {
			openTickets = dao.findOpenTickets();
		}
		else {
			openTickets = dao.findOpenTicketsForUser(user);
		}
		openTicketList.setTickets(openTickets);

		lblUserName.setText("Welcome " + user.toString() + ". You have " + openTickets.size() + " open tickets.");
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private com.floreantpos.swing.PosButton btnBackOffice;
	private com.floreantpos.swing.PosButton btnClockOut;
	private com.floreantpos.swing.PosButton btnEditTicket;
	private com.floreantpos.swing.PosButton btnGroupSettle;
	private com.floreantpos.swing.PosButton btnInfo;
	private com.floreantpos.swing.PosButton btnLogout;
	private com.floreantpos.swing.PosButton btnManager;
	private com.floreantpos.swing.PosButton btnNewTicket;
	private com.floreantpos.swing.PosButton btnPayout;
	private com.floreantpos.swing.PosButton btnPrintTicket;
	private com.floreantpos.swing.PosButton btnReopenTicket;
	private com.floreantpos.swing.PosButton btnSettleTicket;
	private com.floreantpos.swing.PosButton btnShutdown;
	private com.floreantpos.swing.PosButton btnSplitTicket;
	private com.floreantpos.swing.PosButton btnTakeout;
	private com.floreantpos.swing.PosButton btnVoidTicket;
	private javax.swing.JLabel lblUserName;
	private com.floreantpos.ui.TicketListView openTicketList;

	// End of variables declaration//GEN-END:variables

	@Override
	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);

		if (aFlag) {
			updateView();
			ticketListUpdater.start();
		}
		else {
			ticketListUpdater.stop();
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == btnBackOffice) {
			doShowBackoffice();
		}
		if (source == btnClockOut) {
			doClockOut();
		}
		if (source == btnEditTicket) {
			doEditTicket();
		}
		if (source == btnGroupSettle) {
			doGroupSettle();
		}
		if (source == btnInfo) {
			doShowTicketInfo();
		}
		if (source == btnLogout) {
			doLogout();
		}
		if (source == btnManager) {
			doShowManagerWindow();
		}
		if (source == btnNewTicket) {
			doCreateNewTicket();
		}
		if (source == btnPayout) {
			doPayout();
		}
		if (source == btnPrintTicket) {
			doPrintTicket();
		}
		if (source == btnReopenTicket) {
			doReopenTicket();
		}
		if (source == btnSettleTicket) {
			doSettleTicket();
		}
		if (source == btnShutdown) {
			doShutdown();
		}
		if (source == btnSplitTicket) {
			doSplitTicket();
		}
		if (source == btnTakeout) {
			doTakeout();
		}
		if (source == btnVoidTicket) {
			doVoidTicket();
		}
	}

	private class TicketListUpdaterTask implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			updateTicketList();
		}

	}
}
