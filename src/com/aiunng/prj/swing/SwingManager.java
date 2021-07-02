
package com.aiunng.prj.swing;

import static com.aiunng.prj.entity.Constant.LEVE_3;
import static com.aiunng.prj.entity.Constant.LONG_FORMAT;
import static com.aiunng.prj.entity.Constant.TEXT_BOLD;
import static com.aiunng.prj.entity.Constant.TEXT_NORMAL;
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
import static com.aiunng.prj.entity.Constant.Y_AXIS_START;
import static com.aiunng.prj.entity.Constant.newFormat;
import static com.aiunng.prj.entity.StringZoneIdEnum.SHANGHAI;
import static com.aiunng.prj.entity.StringZoneIdEnum.getCodeByDesc;
import static com.aiunng.prj.entity.ZoneIdMap.getZoneList;
import static com.aiunng.prj.util.ConfigUtil.getCodeByDescCache;
import static com.aiunng.prj.util.ConfigUtil.getZoneIdsCache;
import static com.aiunng.prj.util.DateConverter.converZone;
import static com.aiunng.prj.util.DateConverter.getCurrentDate;
import static com.aiunng.prj.util.DateConverter.getCurrentTimestamp;
import static com.aiunng.prj.util.DateConverter.getDate;
import static com.aiunng.prj.util.DateConverter.parseToZoneTime;
import static com.aiunng.prj.util.DateConverter.zonedDateTimeFormat;
import static com.aiunng.prj.util.SwingUtil.addComboBox;
import static com.aiunng.prj.util.SwingUtil.addJBScrollPane;
import static com.aiunng.prj.util.SwingUtil.addJButton;
import static com.aiunng.prj.util.SwingUtil.addJTextArea;
import static com.aiunng.prj.util.SwingUtil.addLabel;
import static com.aiunng.prj.util.SwingUtil.addLabelY;

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
import java.net.URI;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
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
    JFrame frame = new JFrame("时间转换工具");
    frame.setBounds(600, 300, 660, 420);

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

    y = addLabelY("Timestamp TO Date", LEVE_3, X_AXIS_L1, y, Y_AXIS_L2_L1, 200, 25, contentPanel);
    y = buildTimestampRegion("SECONDS:", getCurrentTimestamp(10), VIEW_TYPE_T2D, 10, y, Y_AXIS_L1_L2, contentPanel);
    y = buildTimestampRegion("MILLISECONDS:", getCurrentTimestamp(13), VIEW_TYPE_T2D, 13, y, Y_AXIS_L2_L2, contentPanel);

    y = addLabelY("Date TO Timestamp", LEVE_3, X_AXIS_L1, y, Y_AXIS_L2_L1, 200, 25, contentPanel);
    y = buildTimestampRegion("SECONDS:", getCurrentDate(), VIEW_TYPE_D2T, 10, y, Y_AXIS_L1_L2, contentPanel);
    y = buildTimestampRegion("MILLISECONDS:", getCurrentDate(), VIEW_TYPE_D2T, 13, y, Y_AXIS_L2_L2, contentPanel);

    y = addLabelY("CST TO Date", LEVE_3, X_AXIS_L1, y, Y_AXIS_L2_L1, 200, 25, contentPanel);
    y = buildTimestampRegion("CST:", getDate(), VIEW_TYPE_C2D, 0, y, Y_AXIS_L1_L2, contentPanel);

    y = addLabelY("ZonedDateTime", LEVE_3, X_AXIS_L1, y, Y_AXIS_L2_L1, 200, 25, contentPanel);
    y = buildTimeZoneRegion(y, Y_AXIS_L1_L2, contentPanel);

    // 帮助
    buildHelpRegion(contentPanel);

    // 系统设置
    buildCfgZoneRegion(contentPanel);

    // 作者信息
    //addLabel("author：w*Yu", TEXT_SMALL, 540, 300, 100, 25, contentPanel);

    // 关闭按钮
    frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    // 显示窗口
    frame.setVisible(true);
  }

  /**
   * 帮助弹窗
   * @param contentPanel
   */
  private static void buildHelpRegion(JPanel contentPanel) {
    JButton cfgButton = addJButton("help", TEXT_NORMAL, 415, 360, 100, 25, contentPanel);

    cfgButton.addActionListener(e -> {
      JDialog jDialog = new JDialog();
      jDialog.setTitle("help");
      jDialog.setBounds(610, 310, 220, 180);
      jDialog.setVisible(true);
      jDialog.setLayout(null);

      Container contentPane = jDialog.getContentPane();

      JLabel imgLabel = new JLabel();
      ImageIcon img = new ImageIcon("resources/META-INF/file/icon_50x50.png");
      imgLabel.setIcon(img);
      imgLabel.setBounds(10, 10, 50, 50);

      JLabel authorLabel = new JLabel("author：w*Yu");
      authorLabel.setBounds(10, 70, 100, 25);

      authorLabel.setFont(TEXT_BOLD);

      JLabel textLabel = new JLabel("Date-convert helps you develop faster");
      textLabel.setBounds(10, 90, 220, 25);
      textLabel.setFont(TEXT_BOLD);

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
      contentPane.add(authorLabel);
      contentPane.add(textLabel);
      contentPane.add(linklabel);
    });
  }

  /**
   * 系统设置
   *
   * @param contentPanel
   */
  private static void buildCfgZoneRegion(JPanel contentPanel) {
    JButton cfgButton = addJButton("settings", TEXT_NORMAL, 515, 360, 100, 25, contentPanel);
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
    JTextArea jTextArea = addJTextArea(zonedDateTimeFormat(ZonedDateTime.now(ZoneId.systemDefault()), newFormat), TEXT_NORMAL, X_AXIS_INPUT,
        y + offset, 230, 25,
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

  public static void main(String[] args) {
    createAndShowGUI();
  }
}