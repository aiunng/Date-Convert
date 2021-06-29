
package com.aiunng.prj.swing;

import static com.aiunng.prj.util.Constant.VIEW_TYPE_C2D;
import static com.aiunng.prj.util.Constant.VIEW_TYPE_D2T;
import static com.aiunng.prj.util.Constant.VIEW_TYPE_T2D;
import static com.aiunng.prj.util.Constant.X_AXIS_CONVER_BUTTON;
import static com.aiunng.prj.util.Constant.X_AXIS_INPUT;
import static com.aiunng.prj.util.Constant.X_AXIS_L1;
import static com.aiunng.prj.util.Constant.X_AXIS_L2;
import static com.aiunng.prj.util.Constant.X_AXIS_OUTPUT;
import static com.aiunng.prj.util.Constant.Y_AXIS_L1_L2;
import static com.aiunng.prj.util.Constant.Y_AXIS_L2_L1;
import static com.aiunng.prj.util.Constant.Y_AXIS_L2_L2;
import static com.aiunng.prj.util.Constant.Y_AXIS_START;
import static com.aiunng.prj.util.DateConverter.StringZoneIdEnum.getCodeByDesc;
import static com.aiunng.prj.util.DateConverter.converZone;
import static com.aiunng.prj.util.DateConverter.getCurrentDate;
import static com.aiunng.prj.util.DateConverter.getCurrentTimestamp;
import static com.aiunng.prj.util.DateConverter.getDate;
import static com.aiunng.prj.util.DateConverter.parseToZoneTime;
import static com.aiunng.prj.util.DateConverter.zonedDateTimeFormat;
import static com.aiunng.prj.util.SwingUtil.LEVE_2;
import static com.aiunng.prj.util.SwingUtil.LEVE_3;
import static com.aiunng.prj.util.SwingUtil.TEXT_NORMAL;
import static com.aiunng.prj.util.SwingUtil.addComboBox;
import static com.aiunng.prj.util.SwingUtil.addJBScrollPane;
import static com.aiunng.prj.util.SwingUtil.addJButton;
import static com.aiunng.prj.util.SwingUtil.addJTextArea;
import static com.aiunng.prj.util.SwingUtil.addLabel;
import static com.aiunng.prj.util.SwingUtil.addLabelY;

import com.aiunng.prj.util.DateConverter;
import com.aiunng.prj.util.StringUtil;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.util.ui.JBUI;
import java.awt.BorderLayout;
import java.awt.Container;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;


public class SwingManager {

  public static void createAndShowGUI() {

    // 创建及设置窗口
    JFrame frame = new JFrame("时间转换工具");
    frame.setBounds(600, 300, 660, 380);

    Container contentPane = frame.getContentPane();
    contentPane.setLayout(new BorderLayout());
    JPanel contentPanel = new JPanel();
    contentPanel.setBorder(JBUI.Borders.empty(5));
    contentPane.add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);

    /**
     * 功能区视图
     */
    int y = buildClockRegion(contentPanel, Y_AXIS_START);

    y = addLabelY("Timestamp TO Date", LEVE_3, X_AXIS_L1, y, Y_AXIS_L1_L2, 200, 25, contentPanel);
    y = buildTimestampRegion("SECONDS:", getCurrentTimestamp(10), VIEW_TYPE_T2D, 10, y, Y_AXIS_L1_L2, contentPanel);
    y = buildTimestampRegion("MILLISECONDS:", getCurrentTimestamp(13), VIEW_TYPE_T2D, 13, y, Y_AXIS_L2_L2, contentPanel);

    y = addLabelY("Date TO Timestamp", LEVE_3, X_AXIS_L1, y, Y_AXIS_L2_L1, 200, 25, contentPanel);
    y = buildTimestampRegion("SECONDS:", getCurrentDate(), VIEW_TYPE_D2T, 10, y, Y_AXIS_L1_L2, contentPanel);
    y = buildTimestampRegion("MILLISECONDS:", getCurrentDate(), VIEW_TYPE_D2T, 13, y, Y_AXIS_L2_L2, contentPanel);

    y = addLabelY("CST TO Date", LEVE_3, X_AXIS_L1, y, Y_AXIS_L2_L1, 200, 25, contentPanel);
    y = buildTimestampRegion("CST:", getDate(), VIEW_TYPE_C2D, 0, y, Y_AXIS_L1_L2, contentPanel);

    y = addLabelY("ZonedDateTime", LEVE_3, X_AXIS_L1, y, Y_AXIS_L2_L1, 200, 25, contentPanel);
    y = buildTimeZoneRegion(y, Y_AXIS_L1_L2, contentPanel);

    // 作者信息
    //addLabel("author：w*Yu", TEXT_SMALL, 540, 300, 100, 25, contentPanel);

    // 关闭按钮
    frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    // 显示窗口
    frame.setVisible(true);
  }

  /**
   * 动态展示当前时区时间
   *
   * @param contentPanel
   */
  private static int buildClockRegion(JPanel contentPanel, int y) {
    JLabel timeLable = addLabel(
        zonedDateTimeFormat(ZonedDateTime.now(ZoneId.systemDefault())), LEVE_2, 230, y, 300, 25, contentPanel);
    setTimer(timeLable);
    return y;
  }

  /**
   * 创建时间戳转换区域视图
   *
   * @param text         显示文本
   * @param type         com.aiunng.prj.util.Constant#VIEW_TYPE_D2T
   * @param y            y坐标
   * @param contentPanel JPanel
   */
  private static int buildTimestampRegion(String text, String defaultInput, String type, int size, int y, int offset, JPanel contentPanel) {

    //10位时间戳转换
    addLabel(text, TEXT_NORMAL, X_AXIS_L2, y + offset, 200, 25, contentPanel);
    //输入
    JTextArea input = addJTextArea(defaultInput, TEXT_NORMAL, X_AXIS_INPUT, y + offset, 230, 25, contentPanel);
    //转换按钮
    JButton button = addJButton("->", TEXT_NORMAL, X_AXIS_CONVER_BUTTON, y + offset, 60, 25, contentPanel);
    //返回信息
    JBScrollPane scrollPane = addJBScrollPane(TEXT_NORMAL, X_AXIS_OUTPUT, y + offset, 180, 25, contentPanel);

    JTextArea answer = new JTextArea(1, 1);
    answer.setLineWrap(true);
    //不可编辑
    //answerContent.setEnabled(false);
    scrollPane.setViewportView(answer);

    //按钮提交监听事件
    button.addActionListener(e -> {
      String result = "";
      // 获取输入的问题
      String in = input.getText();
      if (StringUtil.equals(VIEW_TYPE_D2T, type)) {
        result = DateConverter.date2Timestamp(in, size);
      } else if (StringUtil.equals(VIEW_TYPE_T2D, type)) {
        result = DateConverter.timestamp2Date(in);
      } else if (StringUtil.equals(VIEW_TYPE_C2D, type)) {
        result = DateConverter.CST2Date(in);
      }

      answer.setText(result);
    });

    return y + offset;
  }

  /**
   * 时区时间转换
   *
   * @param contentPanel
   */
  private static int buildTimeZoneRegion(int y, int offset, JPanel contentPanel) {
    // 下拉选
    JComboBox comboBox = addComboBox(LEVE_3, X_AXIS_L1, y + offset, 110, 25, contentPanel);
    //输入
    JTextArea jTextArea = addJTextArea(zonedDateTimeFormat(ZonedDateTime.now(ZoneId.systemDefault())), TEXT_NORMAL, X_AXIS_INPUT, y + offset, 230, 25,
        contentPanel);
    //转换按钮
    JButton button = addJButton("->", TEXT_NORMAL, X_AXIS_CONVER_BUTTON, y + offset, 60, 25, contentPanel);
    //返回信息
    JBScrollPane scrollPane = addJBScrollPane(TEXT_NORMAL, X_AXIS_OUTPUT, y + offset, 180, 25, contentPanel);

    JTextArea answer = new JTextArea(1, 1);
    answer.setLineWrap(true);
    scrollPane.setViewportView(answer);

    //按钮提交监听事件
    button.addActionListener(e -> {
      // 当前时间
      String currentTime = jTextArea.getText();
      // 当前ZoneId
      String zoneId = comboBox.getSelectedItem().toString();
      // 更新为转换后的时间
      answer.setText(zonedDateTimeFormat(converZone(parseToZoneTime(currentTime), getCodeByDesc(zoneId))));
    });
    return y + offset;
  }

  /**
   * 更新当前时间
   *
   * @param time
   */
  private static void setTimer(JLabel time) {
    final JLabel varTime = time;
    Timer timeAction = new Timer(100, e -> varTime.setText(
        zonedDateTimeFormat(ZonedDateTime.now(ZoneId.systemDefault()))));
    timeAction.start();
  }


  public static void main(String[] args) {
    createAndShowGUI();
  }
}