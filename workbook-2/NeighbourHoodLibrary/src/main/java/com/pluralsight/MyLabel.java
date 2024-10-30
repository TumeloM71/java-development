package com.pluralsight;

import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel {

    public MyLabel(){
        this.setText("Books:");
        this.setHorizontalTextPosition(LEFT);
        this.setVerticalTextPosition(TOP);
        this.setForeground(new Color(200,0,255));
        this.setBackground(Color.LIGHT_GRAY);

    }
}
