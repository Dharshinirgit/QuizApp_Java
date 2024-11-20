// importing required packages
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
class passchange implements ActionListener
{
   JFrame frame;
   JLabel pinlabel=new JLabel("PIN");
   JLabel passwordlabel=new JLabel("Password");
   JLabel changepasslabel=new JLabel("Change password");
   JLabel title=new JLabel("Chane your Password");
   JLabel repasslabel=new JLabel("Re-Type new password");
   
   JPasswordField passtxtfield=new JPasswordField();
   JPasswordField changepasstxtfield=new JPasswordField();
   JPasswordField repasstxtfield=new JPasswordField();
   JTextField pintxtfield=new JTextField();
   
   JButton changebtn=new JButton("Change password");
   
   public void passchangeinit()
   {
       createwindow();
       setlocationandsize();
       addcomponent();
       actionevent();
   } 
   // creating new window
   public void createwindow()
   {
      frame=new JFrame();
      frame.setTitle("IPO details form");
      frame.setBounds(50,10,850,850);
      frame.getContentPane().setBackground(Color.white);
      frame.getContentPane().setLayout(null);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
   }        
   // setting location and size of components
   public void setlocationandsize()
   {
      title.setBounds(200,5,400,40);
      title.setFont(new Font("cambria",Font.CENTER_BASELINE,25));
      title.setBackground(Color.white);
      
      pinlabel.setBounds(200,60,400,40);
      pinlabel.setFont(new Font("cambria",Font.CENTER_BASELINE,20));
      pinlabel.setBackground(Color.white);
      
      pintxtfield.setBounds(200,110,400,40);
      pintxtfield.setFont(new Font("cambria",Font.CENTER_BASELINE,20));
      pintxtfield.setBackground(Color.white);
      
      passwordlabel.setBounds(200,160,400,40);
      passwordlabel.setFont(new Font("cambria",Font.CENTER_BASELINE,20));
      passwordlabel.setBackground(Color.white);
      
      passtxtfield.setBounds(200,210,400,40);
      passtxtfield.setFont(new Font("cambria",Font.CENTER_BASELINE,20));
      passtxtfield.setBackground(Color.white);
      
      changepasslabel.setBounds(200,260,400,40);
      changepasslabel.setFont(new Font("cambria",Font.CENTER_BASELINE,20));
      changepasslabel.setBackground(Color.white);
      
      changepasstxtfield.setBounds(200,310,400,40);
      changepasstxtfield.setFont(new Font("cambria",Font.CENTER_BASELINE,20));
      changepasstxtfield.setBackground(Color.white);
      
      repasslabel.setBounds(200,360,400,40);
      repasslabel.setFont(new Font("cambria",Font.CENTER_BASELINE,20));
      repasslabel.setBackground(Color.white);
      
      repasstxtfield.setBounds(200,410,400,40);
      repasstxtfield.setFont(new Font("cambria",Font.CENTER_BASELINE,20));
      repasstxtfield.setBackground(Color.white);
      
      changebtn.setBounds(300,490,200,40);
      changebtn.setFont(new Font("cambria",Font.CENTER_BASELINE,20));

   }      
   // adding components to frame
   public void addcomponent()
   {
       frame.add(title);
       frame.add(pinlabel);
       frame.add(pintxtfield);
       frame.add(passwordlabel);
       frame.add(passtxtfield);
       frame.add(changepasslabel);
       frame.add(changepasstxtfield);
       frame.add(repasslabel);
       frame.add(repasstxtfield);
       frame.add(changebtn);
   }   
   // action listener
   public void actionevent()
   {
       changebtn.addActionListener(this);
   }      
   // updating new password to the database
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==changebtn)
      {
          try
          {
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
             String pin=pintxtfield.getText();
             String pass=passtxtfield.getText();
             String changepass=changepasstxtfield.getText();
             String re_pass=repasstxtfield.getText();
             
             if(pin.equals(""))
             {
                 JOptionPane.showMessageDialog(null,"Pin is missing");
             }  
             else if(pass.equals(""))
             {
                 JOptionPane.showMessageDialog(null,"Password is missing");
             }  
             else if(changepass.equals(""))
             {
                 JOptionPane.showMessageDialog(null,"New password is missing");
             }  
             else if(!changepass.equals(re_pass))
             {
                 JOptionPane.showMessageDialog(null,"Password Doesn't match so new password field taken");
             } 
             Statement stmt=con.createStatement();
             String query="SELECT * FROM REGISTER";
             ResultSet rs=stmt.executeQuery(query);
             while(rs.next())
             {
                 String userid=rs.getString("PIN");
                 String password=rs.getString("PASSWORD");
                 if(userid.equals(pin))
                 {
                    JOptionPane.showMessageDialog(null,"User already exist");
                    PreparedStatement pstmt=con.prepareStatement("UPDATE REGISTER SET PASSWORD = ? WHERE PIN= ?");
                    pstmt.setString(1,changepasstxtfield.getText());
                    pstmt.setString(2,pintxtfield.getText());
                    
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Password updated successfully");
                    
                 }    
             }
             frame.setVisible(false);
          }
          catch(Exception ex)
          {
              System.out.println(ex.toString());
          }    
      }    
    }
    // main method
    public static void main(String[] args)
    {
        passchange p=new passchange();
        p.passchangeinit();
    }        
}
