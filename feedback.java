// importing require packages
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class feedback implements ActionListener 
{
    JFrame frame;
    JLabel pinlabel=new JLabel("User PIN");
    JLabel title=new JLabel("Thanks for valuable Feedback");
    JTextField pintxtfield=new JTextField();
    JLabel feedback=new JLabel("Feedback");
    JTextArea fd=new JTextArea();
    JButton submitbtn=new JButton("Submit");
   
    public void fdinit()
    {
        createwindow();
        setlocationandsize();
        addcomponent();
        actionevent();
    }  
    // creating window
    public void createwindow()
    {
        frame=new JFrame();
        frame.setTitle("Feedback");
        frame.setBounds(100,100,800,900);
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    } 
    // setting size and font to components
    public void setlocationandsize()
    {
        title.setBounds(300,50,400,40);
        title.setFont(new Font("cambria",Font.CENTER_BASELINE,25));
        title.setBackground(Color.white);
        
        pinlabel.setBounds(200,200,400,40);
        pinlabel.setFont(new Font("cambria",Font.CENTER_BASELINE,20));
        pinlabel.setBackground(Color.white);
        
        pintxtfield.setBounds(200,250,400,40);
        pintxtfield.setFont(new Font("cambria",Font.CENTER_BASELINE,20));
        pintxtfield.setBackground(Color.white);
        
        feedback.setBounds(200,300,400,40);
        feedback.setFont(new Font("cambria",Font.CENTER_BASELINE,20));
        feedback.setBackground(Color.white);
        
        fd.setBounds(200,350,400,40);
        fd.setFont(new Font("cambria",Font.CENTER_BASELINE,20));
        fd.setBackground(Color.white);
        
        submitbtn.setBounds(200,450,400,40);
        submitbtn.setFont(new Font("cambria",Font.CENTER_BASELINE,20));
        
    } 
    // adding components to the frame
    public void addcomponent()
    {
        frame.add(title);
        frame.add(pinlabel);
        frame.add(pintxtfield);
        frame.add(feedback);
        frame.add(fd);
        frame.add(submitbtn);
    } 
    // action listener
    public void actionevent()
    {
        submitbtn.addActionListener(this);
    }     
    // adding feedback to the database
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==submitbtn)
      {
          try
          {
               Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
               Statement stmt=con.createStatement();
               String pin=pintxtfield.getText();
               String query="SELECT * FROM REGISTER";
               ResultSet rs=stmt.executeQuery(query);
               while(rs.next())
               {
                   String userid=rs.getString("PIN");
                   if(userid.equals(pin))
                   {
                       JOptionPane.showMessageDialog(null,"Thanks for your valuable feedback");
                       PreparedStatement pstmt=con.prepareStatement("INSERT INTO FEEDBACK VALUES (?, ?)");
                       pstmt.setString(1,pintxtfield.getText());
                       pstmt.setString(2,fd.getText());
                       pstmt.executeUpdate();
                       HomePage h=new HomePage();
                       h.init();
                       frame.setVisible(false);
                   }    
               }                    
          }
          catch(Exception ex)
          {
             System.out.println(ex.toString());
          }    
      } 
      else 
      {
          JOptionPane.showMessageDialog(null,"Invalid pin");
      }    
    }
    // main method
    public static void main(String[] args)
    {
        feedback f=new feedback();
        f.fdinit();
        
    }        
}
