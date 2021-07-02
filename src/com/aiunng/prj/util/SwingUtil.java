
package com.aiunng.prj.util;

import static com.aiunng.prj.util.ConfigUtil.getZoneIdsCache;

import com.aiunng.prj.entity.StringZoneIdEnum;
import com.intellij.ui.components.JBScrollPane;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class SwingUtil {

  /**
   * 添加标签
   *
   * @param text         名称
   * @param font         字体
   * @param x            x坐标
   * @param y            y坐标
   * @param width        长度
   * @param height       高度
   * @param contentPanel JPanel
   */
  public static JLabel addLabel(String text, Font font, int x, int y, int width, int height, JPanel contentPanel) {
    JLabel label = new JLabel(text);
    label.setFont(font);
    label.setBounds(x, y, width, height);
    contentPanel.add(label);
    return label;
  }

  public static int addLabelY(String text, Font font, int x, int y, int offset, int width, int height, JPanel contentPanel) {
    JLabel label = new JLabel(text);
    label.setFont(font);
    label.setBounds(x, y + offset, width, height);
    contentPanel.add(label);
    return y + offset;
  }

  public static JLabel addLabel(String text, Font font, int x, int y, int width, int height, Container contentPane) {
    JLabel label = new JLabel(text);
    label.setFont(font);
    label.setBounds(x, y, width, height);
    contentPane.add(label);
    return label;
  }

  public static JTextArea addJTextArea(String text, Font font, int x, int y, int width, int height, JPanel contentPanel) {
    JTextArea textArea = new JTextArea();
    textArea.setFont(font);
    textArea.setBounds(x, y, width, height);
    textArea.setText(text);
    contentPanel.add(textArea);
    return textArea;
  }

  public static JButton addJButton(String text, Font font, int x, int y, int width, int height, JPanel contentPanel) {
    JButton button = new JButton(text);
    button.setFont(font);
    button.setBounds(x, y, width, height);
    contentPanel.add(button);
    return button;
  }

  public static JBScrollPane addJBScrollPane(Font font, int x, int y, int width, int height, JPanel contentPanel) {
    JBScrollPane scrollPane = new JBScrollPane();
    scrollPane.setFont(font);
    scrollPane.setBounds(x, y, width, height);
    contentPanel.add(scrollPane);
    return scrollPane;
  }

  /**
   * 下拉选
   *
   * @param font
   * @param x
   * @param y
   * @param width
   * @param height
   * @param contentPanel
   */
  public static JComboBox addComboBox(Font font, int x, int y, int width, int height, JPanel contentPanel) {
    // 创建下拉框
    JComboBox comboBox = new JComboBox();

    // 绑定下拉框选项
    // 默认选项
    StringZoneIdEnum[] values = StringZoneIdEnum.values();
    for (StringZoneIdEnum value : values) {
      comboBox.addItem(value.getDesc());
    }
    // 用户配置选项
    getZoneIdsCache().forEach((o) -> {
      comboBox.addItem(o.getDesc());
    });

    comboBox.setFont(font);
    comboBox.setBounds(x, y, width, height);
    comboBox.setSelectedIndex(0);
    contentPanel.add(comboBox);

    return comboBox;
  }

}