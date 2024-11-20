// importing required packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class login implements ActionListener
{
  boolean result=false;  
  JFrame frame;
  JLabel pinlabel=new JLabel("User PIN");
  JLabel title=new JLabel("Login Form");
  JTextField pintxtfield=new JTextField();
  JLabel passlabel=new JLabel("Password");
  JPasswordField passtxtfield=new JPasswordField();
  JButton loginbtn=new JButton("Login");
  
  public void loginit()
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
      frame.setTitle("Login Form");
      frame.setBounds(100,100,800,900);
      frame.getContentPane().setBackground(Color.white);
      frame.getContentPane().setLayout(null);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
  } 
  // setting locations and styles
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
      
      passlabel.setBounds(200,300,400,40);
      passlabel.setFont(new Font("cambria",Font.CENTER_BASELINE,20));
      passlabel.setBackground(Color.white);
      
      passtxtfield.setBounds(200,350,400,40);
      passtxtfield.setFont(new Font("cambria",Font.CENTER_BASELINE,20));
      passtxtfield.setBackground(Color.white);
      
      loginbtn.setBounds(200,450,400,40);
      loginbtn.setFont(new Font("cambria",Font.CENTER_BASELINE,20));
  }     
  // adding components to the frame
  public void addcomponent()
  {
      frame.add(title);
      frame.add(pinlabel);
      frame.add(pintxtfield);
      frame.add(passlabel);
      frame.add(passtxtfield);
      frame.add(loginbtn);
  } 
  // action listener
  public void actionevent()
  {
      loginbtn.addActionListener(this);
  }        
  // adding details of user to database - when logged in
    @Override
    public void actionPerformed(ActionEvent e) 
    {
            if(e.getSource()==loginbtn)
           {
               
             try
             {
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
           
                Statement stmt=con.createStatement();
                Statement stmt1=con.createStatement();
                String pin=pintxtfield.getText();
                String pass=passtxtfield.getText();
             
               String query="SELECT * FROM REGISTER";
               ResultSet rs=stmt.executeQuery(query);
               while(rs.next())
               {
                 String userid=rs.getString("PIN");
                 String password=rs.getString("PASSWORD");
                 if(userid.equals(pin) || password.equals(pass))
                 {
                     JOptionPane.showMessageDialog(null,"Logged in Successfully");
                     PreparedStatement pstmt=con.prepareStatement("INSERT INTO LOGIN VALUES(?, ?)");
                     pstmt.setString(1,pintxtfield.getText());
                     pstmt.setString(2,passtxtfield.getText());
                     pstmt.executeUpdate();
                     result=true;
                     HomePage h=new HomePage();
                     h.init();
                     frame.setVisible(false);
                     break;
                 }   
                 /*else 
                 {
                     JOptionPane.showMessageDialog(null,"Invalid Credentials! if not registered do register");
                     //String insert="INSERT INTO REGISTER VALUES(\""+pin+"\",\""+address+"\",\""+email+"\",\""+classname+"\",\""+branch+"\",\""+pass+"\");";
                     //stmt.executeUpdate(insert);
                     HomePage h=new HomePage();
                     h.init();
                       frame.setVisible(false);
                       break;
                 } */   
              } 
              if(result==false)
              {
                   JOptionPane.showMessageDialog(null,"Invalid Credentials! if not registered do register");
                  HomePage h=new HomePage();
                  h.init();
                  frame.setVisible(false);
              }    
              /*if(!rs.next())
              {
                  JOptionPane.showMessageDialog(null,"Invalid Credentials! if not registered do register");
                  HomePage h=new HomePage();
                  h.init();
                  frame.setVisible(false);
              } */ 
             }    
             catch(Exception ex)
             {
                System.out.println(ex.toString());
             }   
           }   
           else
           {
                JOptionPane.showMessageDialog(null,"Invalid Credentials");
           }            
    }
    //main method
    public static void main(String[] args)
    {
        login l=new login();
        l.loginit();
    }        
}
