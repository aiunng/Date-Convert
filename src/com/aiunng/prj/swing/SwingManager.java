
package com.aiunng.prj.swing;

import static com.aiunng.prj.entity.Constant.ADVER;
import static com.aiunng.prj.entity.Constant.AUTHOR;
import static com.aiunng.prj.entity.Constant.BLOG_LINK;
import static com.aiunng.prj.entity.Constant.BLOG_TEXT;
import static com.aiunng.prj.entity.Constant.CST;
import static com.aiunng.prj.entity.Constant.CST_TO_DATE;
import static com.aiunng.prj.entity.Constant.DATE_TO_TIMESTAMP;
import static com.aiunng.prj.entity.Constant.ICON_URL;
import static com.aiunng.prj.entity.Constant.INPUT_WIDTH;
import static com.aiunng.prj.entity.Constant.LEVE_3;
import static com.aiunng.prj.entity.Constant.LONG_FORMAT;
import static com.aiunng.prj.entity.Constant.MILLISECONDS;
import static com.aiunng.prj.entity.Constant.OUTPUT_WIDTH;
import static com.aiunng.prj.entity.Constant.SECONDS;
import static com.aiunng.prj.entity.Constant.SHORT_FORMAT;
import static com.aiunng.prj.entity.Constant.SPLIT;
import static com.aiunng.prj.entity.Constant.SQL_GENER_LINK;
import static com.aiunng.prj.entity.Constant.STRING_CONVERT_LINK;
import static com.aiunng.prj.entity.Constant.TEXT_BOLD;
import static com.aiunng.prj.entity.Constant.TEXT_NORMAL;
import static com.aiunng.prj.entity.Constant.TIMESTAMP_TO_DATE;
import static com.aiunng.prj.entity.Constant.TOMO;
import static com.aiunng.prj.entity.Constant.TOMO_TEXT_SQL_GENER;
import static com.aiunng.prj.entity.Constant.TOMO_TEXT_STRING_CONVERT;
import static com.aiunng.prj.entity.Constant.TO_TODAY;
import static com.aiunng.prj.entity.Constant.VERSION;
import static com.aiunng.prj.entity.Constant.VIEW_TYPE_C2D;
import static com.aiunng.prj.entity.Constant.VIEW_TYPE_D2T;
import static com.aiunng.prj.entity.Constant.VIEW_TYPE_T2D;
import static com.aiunng.prj.entity.Constant.X_AXIS_CONVER_BUTTON;
import static com.aiunng.prj.entity.Constant.X_AXIS_INPUT;
import static com.aiunng.prj.entity.Constant.X_AXIS_L1;
import static com.aiunng.prj.entity.Constant.X_AXIS_L2;
import static com.aiunng.prj.entity.Constant.X_AXIS_OUTPUT;
import static com.aiunng.prj.entity.Constant.Y_AXIS_L1_L2;
import static com.aiunng.prj.entity.Constant.Y_AXIS_L2_L1;
import static com.aiunng.prj.entity.Constant.Y_AXIS_L2_L2;
import static com.aiunng.prj.entity.Constant.Y_AXIS_SETBUT;
import static com.aiunng.prj.entity.Constant.Y_AXIS_START;
import static com.aiunng.prj.entity.Constant.ZONE_DDATE_TIME;
import static com.aiunng.prj.entity.Constant.newFormat;
import static com.aiunng.prj.entity.IntervalFormatEnum.getCodeByFormat;
import static com.aiunng.prj.entity.StringZoneIdEnum.SHANGHAI;
import static com.aiunng.prj.entity.StringZoneIdEnum.getCodeByDesc;
import static com.aiunng.prj.entity.ZoneIdMap.getZoneList;
import static com.aiunng.prj.util.ConfigUtil.getCodeByDescCache;
import static com.aiunng.prj.util.ConfigUtil.getZoneIdsCache;
import static com.aiunng.prj.util.DateConverter.converZone;
import static com.aiunng.prj.util.DateConverter.convertDate2String;
import static com.aiunng.prj.util.DateConverter.getCurrentDate;
import static com.aiunng.prj.util.DateConverter.getCurrentTimestamp;
import static com.aiunng.prj.util.DateConverter.getDate;
import static com.aiunng.prj.util.DateConverter.getInterval;
import static com.aiunng.prj.util.DateConverter.parseToZoneTime;
import static com.aiunng.prj.util.DateConverter.zonedDateTimeFormat;
import static com.aiunng.prj.util.SwingUtil.addJBScrollPane;
import static com.aiunng.prj.util.SwingUtil.addJButton;
import static com.aiunng.prj.util.SwingUtil.addJTextArea;
import static com.aiunng.prj.util.SwingUtil.addLabel;
import static com.aiunng.prj.util.SwingUtil.addLabelY;
import static com.aiunng.prj.util.SwingUtil.addTimeZoneComboBox;
import static com.aiunng.prj.util.SwingUtil.addToTodayComboBox;

import com.aiunng.prj.entity.MyZoneId;
import com.aiunng.prj.entity.StringZoneIdEnum;
import com.aiunng.prj.util.ConfigUtil;
import com.aiunng.prj.util.DateConverter;
import com.aiunng.prj.util.StringUtil;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.util.ui.JBUI;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;


public class SwingManager {

  public static void createAndShowGUI() {

    // 创建及设置窗口
    JFrame frame = new JFrame("Date-Convert");
    frame.setBounds(550, 300, 800, 510);

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

    y = addLabelY(TIMESTAMP_TO_DATE, LEVE_3, X_AXIS_L1, y, Y_AXIS_L2_L1, 200, 25, contentPanel);
    y = buildTimestampRegion(SECONDS, getCurrentTimestamp(10), VIEW_TYPE_T2D, 10, y, Y_AXIS_L1_L2, contentPanel);
    y = buildTimestampRegion(MILLISECONDS, getCurrentTimestamp(13), VIEW_TYPE_T2D, 13, y, Y_AXIS_L2_L2, contentPanel);

    y = addLabelY(DATE_TO_TIMESTAMP, LEVE_3, X_AXIS_L1, y, Y_AXIS_L2_L1, 200, 25, contentPanel);
    y = buildTimestampRegion(SECONDS, getCurrentDate(), VIEW_TYPE_D2T, 10, y, Y_AXIS_L1_L2, contentPanel);
    y = buildTimestampRegion(MILLISECONDS, getCurrentDate(), VIEW_TYPE_D2T, 13, y, Y_AXIS_L2_L2, contentPanel);

    y = addLabelY(CST_TO_DATE, LEVE_3, X_AXIS_L1, y, Y_AXIS_L2_L1, 200, 25, contentPanel);
    y = buildTimestampRegion(CST, getDate(), VIEW_TYPE_C2D, 0, y, Y_AXIS_L1_L2, contentPanel);

    y = addLabelY(ZONE_DDATE_TIME, LEVE_3, X_AXIS_L1, y, Y_AXIS_L2_L1, 200, 25, contentPanel);
    y = buildTimeZoneRegion(y, Y_AXIS_L1_L2, contentPanel);

    y = addLabelY(TO_TODAY, LEVE_3, X_AXIS_L1, y, Y_AXIS_L2_L1, 200, 25, contentPanel);
    y = buildToTodayRegion(y, Y_AXIS_L1_L2, contentPanel);

    // 帮助
    buildHelpRegion(contentPanel, y, Y_AXIS_SETBUT);

    // 系统设置
    buildCfgZoneRegion(contentPanel, y, Y_AXIS_SETBUT);

    // 作者信息
    //addLabel("author：w*Yu", TEXT_SMALL, 540, 300, 100, 25, contentPanel);

    // 关闭按钮
    frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    // 显示窗口
    frame.setVisible(true);
  }

  /**
   * 帮助弹窗
   *
   * @param contentPanel
   */
  private static void buildHelpRegion(JPanel contentPanel, int y, int offset) {
    JButton cfgButton = addJButton("help", TEXT_NORMAL, 455, y + offset, 100, 25, contentPanel);

    cfgButton.addActionListener(e -> {
      JDialog jDialog = new JDialog();
      jDialog.setTitle("help");
      jDialog.setBounds(610, 310, 220, 250);
      jDialog.setVisible(true);
      jDialog.setLayout(null);
      // 禁止用户调整窗口大小
      jDialog.setResizable(false);

      Container contentPane = jDialog.getContentPane();

      JLabel imgLabel = new JLabel();
      ImageIcon img = null;
      try {
        img = new ImageIcon(new URL(ICON_URL));
      } catch (MalformedURLException me) {
        me.printStackTrace();
      }
      // ImageIcon img = new ImageIcon("resources/META-INF/file/icon_50x50.png");
      imgLabel.setIcon(img);
      imgLabel.setBounds(85, 10, 50, 50);

      int y1 = 70;
      int offset1 = 20;

      JLabel versionLabel = new JLabel(VERSION);
      versionLabel.setBounds(55, y1, 150, 25);
      versionLabel.setFont(TEXT_BOLD);

      y1 = y1 + offset1;
      JLabel textLabel = new JLabel(ADVER);
      textLabel.setBounds(10, y1, 220, 25);
      textLabel.setFont(TEXT_BOLD);

      y1 = y1 + offset1;
      JLabel linklabel = new JLabel(BLOG_TEXT);
      // 光标类型
      linklabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
      linklabel.setBounds(35, y1, 200, 25);
      linklabel.setFont(TEXT_BOLD);

      // 鼠标监听
      linklabel.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
          try {
            //打开网址
            Desktop.getDesktop().browse(new URI(BLOG_LINK));
          } catch (Exception ex) {
            ex.printStackTrace();
          }
        }
      });

      y1 = y1 + offset1;
      JLabel authorLabel = new JLabel(AUTHOR);
      authorLabel.setBounds(70, y1, 100, 25);
      authorLabel.setFont(TEXT_BOLD);

      y1 = y1 + offset1 + 10;
      JLabel splitLabel = new JLabel(SPLIT);
      splitLabel.setBounds(0, y1, 300, 5);
      splitLabel.setFont(TEXT_BOLD);

      y1 = y1 + 10;
      JLabel tomoLabel = new JLabel(TOMO);
      tomoLabel.setBounds(10, y1, 100, 25);
      tomoLabel.setFont(TEXT_BOLD);

      y1 = y1 + offset1;
      JLabel stringConvertLink = new JLabel(TOMO_TEXT_STRING_CONVERT);
      // 光标类型
      stringConvertLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
      stringConvertLink.setBounds(20, y1, 80, 25);
      stringConvertLink.setFont(TEXT_BOLD);

      // 鼠标监听
      stringConvertLink.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
          try {
            //打开网址
            Desktop.getDesktop().browse(new URI(STRING_CONVERT_LINK));
          } catch (Exception ex) {
            ex.printStackTrace();
          }
        }
      });

      JLabel sqlGenerLink = new JLabel(TOMO_TEXT_SQL_GENER);
      // 光标类型
      sqlGenerLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
      sqlGenerLink.setBounds(110, y1, 80, 25);
      sqlGenerLink.setFont(TEXT_BOLD);

      // 鼠标监听
      sqlGenerLink.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
          try {
            // 打开网址
            Desktop.getDesktop().browse(new URI(SQL_GENER_LINK));
          } catch (Exception ex) {
            ex.printStackTrace();
          }
        }
      });

      contentPane.add(imgLabel);
      contentPane.add(versionLabel);
      contentPane.add(textLabel);
      contentPane.add(linklabel);
      contentPane.add(authorLabel);
      contentPane.add(splitLabel);
      contentPane.add(tomoLabel);
      contentPane.add(stringConvertLink);
      contentPane.add(sqlGenerLink);
    });
  }

  /**
   * 系统设置
   *
   * @param contentPanel
   */
  private static void buildCfgZoneRegion(JPanel contentPanel, int y, int offset) {
    JButton cfgButton = addJButton("settings", TEXT_NORMAL, 555, y + offset, 100, 25, contentPanel);
    // 弹窗
    cfgButton.addActionListener(e -> {

      // 下拉选数据
      List<String> selectionValues = new ArrayList<>();
      // 可用ZoneId
      List<String> availableZoneIds = getZoneList();
      // 删除默认存在的ZoneId
      for (StringZoneIdEnum value : StringZoneIdEnum.values()) {
        availableZoneIds.remove(value.getZoneId() + "," + value.getDesc());
      }
      // 删除用户已配置的ZoneId
      List<String> collect = getZoneIdsCache().stream().map((o) -> o.getZoneId() + "," + o.getDesc()).collect(Collectors.toList());
      availableZoneIds.removeAll(collect);
      // 最终可配置的ZoneId
      selectionValues.addAll(availableZoneIds);

      // 初始化下拉选，并返回用户选择的ZoneId
      Object input = JOptionPane
          .showInputDialog(null, "Add time zone", "settings",
              JOptionPane.PLAIN_MESSAGE, null, selectionValues.toArray(),
              selectionValues.get(0));
      // 写入配置文件 不为null，字符串不是空，字符串不等于null
      if (null != input && StringUtil.isNotBlank(String.valueOf(input)) && !StringUtil.equals("null", String.valueOf(input))) {
        ConfigUtil.writeCfg(String.valueOf(input));
      }

    });
  }

  /**
   * 动态展示当前时区时间
   *
   * @param contentPanel
   */
  private static int buildClockRegion(JPanel contentPanel, int y) {
    JLabel timeLable = addLabel(
        zonedDateTimeFormat(ZonedDateTime.now(ZoneId.systemDefault()), LONG_FORMAT), LEVE_3, 180, y, 330, 25, contentPanel);
    setTimer(timeLable);
    return y;
  }

  /**
   * 创建时间戳转换区域视图
   *
   * @param text         显示文本
   * @param type         com.aiunng.prj.entity.Constant#VIEW_TYPE_D2T
   * @param y            y坐标
   * @param contentPanel JPanel
   */
  private static int buildTimestampRegion(String text, String defaultInput, String type, int size, int y, int offset, JPanel contentPanel) {

    //10位时间戳转换
    addLabel(text, TEXT_NORMAL, X_AXIS_L2, y + offset, 200, 25, contentPanel);
    // 输入
    JTextArea input = addJTextArea(defaultInput, TEXT_NORMAL, X_AXIS_INPUT, y + offset, INPUT_WIDTH, 25, contentPanel);
    // 转换按钮
    JButton button = addJButton("->", TEXT_NORMAL, X_AXIS_CONVER_BUTTON, y + offset, 60, 25, contentPanel);
    // 返回信息
    JBScrollPane scrollPane = addJBScrollPane(TEXT_NORMAL, X_AXIS_OUTPUT, y + offset, OUTPUT_WIDTH, 25, contentPanel);

    JTextArea answer = new JTextArea(1, 1);
    answer.setLineWrap(true);
    // 不可编辑
    //answerContent.setEnabled(false);
    scrollPane.setViewportView(answer);

    // 按钮提交监听事件
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
    JComboBox comboBox = addTimeZoneComboBox(LEVE_3, X_AXIS_L1, y + offset, 110, 25, contentPanel);
    // 输入
    JTextArea jTextArea = addJTextArea(zonedDateTimeFormat(ZonedDateTime.now(ZoneId.systemDefault()), newFormat), TEXT_NORMAL, X_AXIS_INPUT,
        y + offset, INPUT_WIDTH, 25,
        contentPanel);
    // 转换按钮
    JButton button = addJButton("->", TEXT_NORMAL, X_AXIS_CONVER_BUTTON, y + offset, 60, 25, contentPanel);
    // 返回信息
    JBScrollPane scrollPane = addJBScrollPane(TEXT_NORMAL, X_AXIS_OUTPUT, y + offset, OUTPUT_WIDTH, 25, contentPanel);

    JTextArea answer = new JTextArea(1, 1);
    answer.setLineWrap(true);
    scrollPane.setViewportView(answer);

    //按钮提交监听事件
    button.addActionListener(e -> {
      // 当前时间
      String currentTime = jTextArea.getText();
      // 用户选中的ZoneId
      String inputZone = comboBox.getSelectedItem().toString();

      // 更新为转换后的时间
      String code = getCodeByDesc(inputZone);
      // 根据配置转换
      if (StringUtil.isBlank(code)) {
        MyZoneId zoneId = getCodeByDescCache(inputZone);
        code = zoneId.getZoneId();
      }
      if (StringUtil.isBlank(code)) {
        code = SHANGHAI.getZoneId();
      }
      answer.setText(zonedDateTimeFormat(converZone(parseToZoneTime(currentTime), code), newFormat));
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
        zonedDateTimeFormat(ZonedDateTime.now(ZoneId.systemDefault()), LONG_FORMAT)));
    timeAction.start();
  }

  /**
   * 计算指定日期至今时间
   *
   * @param contentPanel
   */
  private static int buildToTodayRegion(int y, int offset, JPanel contentPanel) {
    // 下拉选
    JComboBox comboBox = addToTodayComboBox(LEVE_3, X_AXIS_L1, y + offset, 110, 25, contentPanel);
    // 输入
    JTextArea jTextArea = addJTextArea(convertDate2String(new Date(), SHORT_FORMAT), TEXT_NORMAL, X_AXIS_INPUT,
        y + offset, INPUT_WIDTH, 25,
        contentPanel);
    // 转换按钮
    JButton button = addJButton("->", TEXT_NORMAL, X_AXIS_CONVER_BUTTON, y + offset, 60, 25, contentPanel);
    // 返回信息
    JBScrollPane scrollPane = addJBScrollPane(TEXT_NORMAL, X_AXIS_OUTPUT, y + offset, OUTPUT_WIDTH, 25, contentPanel);

    JTextArea answer = new JTextArea(1, 1);
    answer.setLineWrap(true);
    scrollPane.setViewportView(answer);

    //按钮提交监听事件
    button.addActionListener(e -> {
      // 用户输入的时间
      String inputDate = jTextArea.getText();
      // 用户选中的格式
      String inputFormat = comboBox.getSelectedItem().toString();

      // 更新为转换后的时间
      String code = getCodeByFormat(inputFormat);
      // 根据配置转换
      answer.setText(getInterval(inputDate, code));
    });
    return y + offset;
  }

  public static void main(String[] args) {
    createAndShowGUI();
  }
}