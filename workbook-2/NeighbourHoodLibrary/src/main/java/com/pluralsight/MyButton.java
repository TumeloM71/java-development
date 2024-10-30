package com.pluralsight;

import javax.swing.*;

public class MyButton extends JButton{

    public MyButton(String text){
        super(text);
        this.setFocusable(false);
    }
}
