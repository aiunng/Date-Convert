package com.aiunng.prj;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import static com.aiunng.prj.swing.SwingManager.createAndShowGUI;

public class StartTask extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {

        createAndShowGUI();
    }

}
