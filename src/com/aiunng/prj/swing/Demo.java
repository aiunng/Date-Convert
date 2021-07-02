package com.aiunng.prj.swing;

import static com.aiunng.prj.entity.ZoneIdMap.getAfricaList;
import static com.aiunng.prj.entity.ZoneIdMap.getAmericaList;
import static com.aiunng.prj.entity.ZoneIdMap.getAsiaList;
import static com.aiunng.prj.entity.ZoneIdMap.getAustraliaList;
import static com.aiunng.prj.entity.ZoneIdMap.getEuropeList;

import com.intellij.util.ui.JBUI;
import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author：wangXinYu
 * @date：2021/7/1 1:37 下午
 */
public class Demo {


  public static void main(String[] args) {
    JFrame frame = new JFrame("settings");
    frame.setBounds(600, 300, 190, 220);

    Container contentPane = frame.getContentPane();
    contentPane.setLayout(new BorderLayout());
    JPanel contentPanel = new JPanel();
    contentPanel.setBorder(JBUI.Borders.empty(5));
    contentPane.add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);

    case1(contentPanel);

    frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    frame.setVisible(true);

  }

  /**
   * 二级联动下拉选
   * @param contentPanel
   */
  private static void case1(JPanel contentPanel) {
    JComboBox cmb1 = new JComboBox();
    cmb1.setBounds(10, 20, 130, 30);

    cmb1.addItem("Asia");
    cmb1.addItem("America");
    cmb1.addItem("Europe");
    cmb1.addItem("Australia");
    cmb1.addItem("Africa");

    JComboBox cmb2 = new JComboBox();
    cmb2.setBounds(10, 50, 130, 30);
    List<String> zonelist = getAsiaList();
    zonelist.forEach(cmb2::addItem);

    JButton button = new JButton("add");
    button.setBounds(60, 90, 60, 20);

    contentPanel.add(cmb1);
    contentPanel.add(cmb2);
    contentPanel.add(button);

    cmb1.addActionListener(e -> {
      String input = cmb1.getSelectedItem().toString();

      List<String> current = new ArrayList<>();

      switch (input) {
        case "Asia":
          current = getAsiaList();
          break;
        case "America":
          current = getAmericaList();
          break;
        case "Europe":
          current = getEuropeList();
          break;
        case "Australia":
          current = getAustraliaList();
          break;
        case "Africa":
          current = getAfricaList();
          break;
        default:
          current = getAsiaList();

      }
      cmb2.removeAllItems();
      current.forEach(cmb2::addItem);
    });

    button.addActionListener(e -> {
      String input = cmb2.getSelectedItem().toString();

      System.out.println(input);
    });
  }

}
