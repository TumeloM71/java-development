import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
        JButton button1;
    public MyFrame(){
        button1 = new JButton();
        button1.setBounds(50,50,100,25);
        button1.addActionListener(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.setVisible(true);
        this.add(button1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1)
            System.out.println("Poo");
    }
}
