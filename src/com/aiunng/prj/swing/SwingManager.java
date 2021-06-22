
package com.aiunng.prj.swing;

import com.aiunng.prj.util.DateConverter;
import com.aiunng.prj.util.StringUtil;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.util.ui.JBUI;

import javax.swing.*;
import java.awt.*;

import static com.aiunng.prj.util.Constant.*;
import static com.aiunng.prj.util.DateConverter.*;
import static com.aiunng.prj.util.SwingUtil.*;


public class SwingManager {

    public static void createAndShowGUI() {

        // 创建及设置窗口
        JFrame frame = new JFrame("时间转换工具");
        frame.setBounds(600, 300, 650, 350);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(JBUI.Borders.empty(5));
        contentPane.add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        // 功能区视图
        addLabel("Timestamp TO Date", LEVE_3, 10, 10, 200, 25, contentPanel);
        buildTimestampRegion("SECONDS:", getCurrentTimestamp(10), VIEW_TYPE_T2D,10, 0, contentPanel);
        buildTimestampRegion("MILLISECONDS:", getCurrentTimestamp(13), VIEW_TYPE_T2D,13, 30, contentPanel);
        addLabel("Date TO Timestamp", LEVE_3, 10, 100, 200, 25, contentPanel);
        buildTimestampRegion("SECONDS:", getCurrentDate(), VIEW_TYPE_D2T,10, 90, contentPanel);
        buildTimestampRegion("MILLISECONDS:", getCurrentDate(), VIEW_TYPE_D2T,13, 120, contentPanel);
        addLabel("CST TO Date", LEVE_3, 10, 190, 200, 25, contentPanel);
        buildTimestampRegion("CST:", getDate(), VIEW_TYPE_C2D,0, 180, contentPanel);
        //作者信息
        addLabel("author：w*Yu", TEXT_SMALL, 540, 300, 100, 25, contentPanel);

        //关闭按钮
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        // 显示窗口
        frame.setVisible(true);
    }


    /**
     * 创建时间戳转换区域视图
     *
     * @param text         显示文本
     * @param type         com.aiunng.prj.util.Constant#VIEW_TYPE_D2T
     * @param yOffset      y坐标偏移量
     * @param contentPanel JPanel
     */
    private static void buildTimestampRegion(String text, String defaultInput, String type, int size, int yOffset, JPanel contentPanel) {

        //10位时间戳转换
        addLabel(text, TEXT_NORMAL, 20, 35 + yOffset, 200, 25, contentPanel);
        //输入
        JTextArea input = addJTextArea(defaultInput, TEXT_NORMAL, 140, 35 + yOffset, 230, 25, contentPanel);
        //转换按钮
        JButton button = addJButton("->", TEXT_NORMAL, 370, 35 + yOffset, 60, 25, contentPanel);
        //返回信息
        JBScrollPane scrollPane = addJBScrollPane(TEXT_NORMAL, 430, 35 + yOffset, 180, 25, contentPanel);

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
            if (StringUtil.equals(VIEW_TYPE_D2T,type)){
                result = DateConverter.date2Timestamp(in,size);
            }else if (StringUtil.equals(VIEW_TYPE_T2D,type)){
                result = DateConverter.timestamp2Date(in);
            }else if (StringUtil.equals(VIEW_TYPE_C2D,type)){
                result = DateConverter.CST2Date(in);
            }

            answer.setText(result);
        });
    }


    public static void main(String[] args) {
        createAndShowGUI();
    }
}