package com.aiunng.prj.swing;

import static com.aiunng.prj.entity.Constant.TEXT_BOLD;
import static com.aiunng.prj.entity.Constant.TEXT_NORMAL;
import static com.aiunng.prj.entity.ZoneIdMap.getAfricaList;
import static com.aiunng.prj.entity.ZoneIdMap.getAmericaList;
import static com.aiunng.prj.entity.ZoneIdMap.getAsiaList;
import static com.aiunng.prj.entity.ZoneIdMap.getAustraliaList;
import static com.aiunng.prj.entity.ZoneIdMap.getEuropeList;
import static com.aiunng.prj.util.SwingUtil.addJButton;

import com.intellij.util.ui.JBUI;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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

    //comboBox2(contentPanel);
    //superLinkCase(contentPanel);
    dialogCase(contentPanel);

    frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    frame.setVisible(true);

  }

  /**
   * 弹窗
   *
   * @param contentPanel
   */
  private static void dialogCase(JPanel contentPanel) {

    JButton cfgButton = addJButton("help", TEXT_NORMAL, 10, 10, 100, 25, contentPanel);

    cfgButton.addActionListener(e -> {
      JDialog jDialog = new JDialog();
      jDialog.setTitle("help");
      jDialog.setBounds(610, 310, 220, 220);
      jDialog.setVisible(true);
      jDialog.setLayout(null);

      Container contentPane = jDialog.getContentPane();

      JLabel imgLabel = new JLabel();
      ImageIcon img = new ImageIcon("resources/META-INF/file/icon_50x50.png");
      imgLabel.setIcon(img);
      imgLabel.setBounds(10, 10, 50, 50);

      JLabel textLabel = new JLabel("Date-convert helps you develop faster");
      textLabel.setBounds(10, 70, 220, 25);
      textLabel.setFont(TEXT_BOLD);

      JLabel authorLabel = new JLabel("author：w*Yu");
      authorLabel.setBounds(10, 90, 100, 25);
      authorLabel.setFont(TEXT_BOLD);


      JLabel linklabel = new JLabel("<html><a href='https://www.yuque.com/aiunng/elrg1e/ws3isn'>使用帮助、提出建议、问题反馈</a></html>");
      // 光标类型
      linklabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
      linklabel.setBounds(10, 110, 200, 25);
      linklabel.setFont(TEXT_BOLD);

      // 鼠标监听
      linklabel.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
          try {
            //打开网址
            Desktop.getDesktop().browse(new URI("https://www.yuque.com/aiunng/elrg1e/ws3isn"));
          } catch (Exception ex) {
            ex.printStackTrace();
          }
        }
      });

      contentPane.add(imgLabel);
      contentPane.add(textLabel);
      contentPane.add(authorLabel);
      contentPane.add(linklabel);
    });

  }


  /**
   * 超链接
   *
   * @param contentPanel
   */
  private static void superLinkCase(JPanel contentPanel) {

    JLabel linklabel = new JLabel("<html>Blog：<a href='https://www.yuque.com/aiunng/elrg1e/ws3isn'>官方博客</a></html>");
    // 光标类型
    linklabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    linklabel.setBounds(10, 10, 100, 25);

    // 鼠标监听
    linklabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        try {
          //打开网址
          Desktop.getDesktop().browse(new URI("https://www.yuque.com/aiunng/elrg1e/ws3isn"));
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    });
    contentPanel.add(linklabel);
  }

  /**
   * 二级联动下拉选
   *
   * @param contentPanel
   */
  private static void comboBox2(JPanel contentPanel) {
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
