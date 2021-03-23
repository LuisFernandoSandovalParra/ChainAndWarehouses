package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Event;

public class JPanelChainStats extends JPanel {

	private static final long serialVersionUID = 1L;

	public JPanelChainStats(ActionListener actionListener, int totalChainValue) {
		setLayout(new BorderLayout());
		initComponents(actionListener, totalChainValue);
	}

	private void initComponents(ActionListener actionListener, int totalChainValue) {
		createBackBtnAndTitlePanel(actionListener);
		createFormularyPanel(totalChainValue);
	}

	private void createBackBtnAndTitlePanel(ActionListener actionListener) {
		JPanel backBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 115, 25));
		backBtnPanel.setBackground(ConstantsGUI.BLUE_CODE_BASE);
		backBtnPanel.add(new JButtonFormat(actionListener, Event.BTN_BACK_MENU_CHAIN.name(), ConstantsGUI.BACK_TEXT_BTN));

		JLabel title = new JLabel(ConstantsGUI.SUBTITLE_TOTAL_VALUE_CHAIN);
		title.setFont(ConstantsGUI.FONT_TOTAL_VALUE_CHAIN);
		backBtnPanel.add(title);

		add(backBtnPanel, BorderLayout.NORTH);
	}

	private void createFormularyPanel(int totalChainValue) {
		JPanel statusPanel = new JPanel(new GridLayout(2, 1, 5, 25));
		statusPanel.setBorder(ConstantsGUI.BORDER_AREA_FORM_CHAIN);
		JLabel instruction = new JLabel(ConstantsGUI.TEXT_INSTRUCTION_TOTAL_VALUE_CHAIN);
		instruction.setHorizontalAlignment(SwingConstants.CENTER);
		instruction.setVerticalAlignment(SwingConstants.NORTH);
		statusPanel.add(instruction);

		JLabel totalValueLabel = new JLabel(ConstantsGUI.PESOS_SYMBOL + totalChainValue);
		totalValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalValueLabel.setVerticalAlignment(SwingConstants.NORTH);
		totalValueLabel.setFont(ConstantsGUI.FONT_SUBTITLES);
		statusPanel.add(totalValueLabel);

		add(statusPanel, BorderLayout.CENTER);
	}
}