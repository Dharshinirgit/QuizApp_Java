//importing all required packages
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class register implements ActionListener
{

    JFrame frame;
    
    JLabel title=new JLabel("Registration Form");
    JLabel pinlabel=new JLabel("PIN");
    JLabel namelabel=new JLabel("User Name");
    JLabel addresslabel=new JLabel("Address");
    JLabel emaillabel=new JLabel("Email");
    JLabel contactlabel=new JLabel("Contact No");
    JLabel classlabel=new JLabel("Class");
    JLabel passlabel=new JLabel("Password");
    JLabel branchlabel=new JLabel("Branch");
    
    JTextField pintxtfield=new JTextField();
    JTextField nametxtfield=new JTextField();
    JTextField contacttxtfield=new JTextField();
    JTextField emailtxtfield=new JTextField();
    JTextField passtxtfield=new JTextField();
     
    JTextArea addtxtarea=new JTextArea();
    
    String[] branch = {"CS&IT","CSE","ECE","EEE","Mechanical","Civil","AI&DS"};
    String[] cls = {"First","Second","Third","Final"};

    JComboBox clsname=new JComboBox(cls);
    JComboBox branchname=new JComboBox(branch);
    
    JButton submitbtn=new JButton("Submit");
    JButton resetbtn=new JButton("Reset");
    
    public void reginit()
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
        frame.setTitle("Student Details Form");
        frame.setBounds(50,10,1000,1000);
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }    
    // setting locations and font styles    
    public void setlocationandsize()
    {
        title.setBounds(300,2,400,40);
        title.setBackground(Color.white); 
        title.setFont(new Font("cambria",Font.CENTER_BASELINE,25));
        
        pinlabel.setBounds(300,50,400,40);
        pinlabel.setBackground(Color.white);
        pinlabel.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        pintxtfield.setBounds(300,80,400,30);
        pintxtfield.setBackground(Color.white);
        pintxtfield.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        namelabel.setBounds(300,110,400,40);
        namelabel.setBackground(Color.white);
        namelabel.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        nametxtfield.setBounds(300,140,400,30);
        nametxtfield.setBackground(Color.white);
        nametxtfield.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        emaillabel.setBounds(300,170,400,40);
        emaillabel.setBackground(Color.white);
        emaillabel.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        emailtxtfield.setBounds(300,200,400,30);
        emailtxtfield.setBackground(Color.white);
        emailtxtfield.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        passlabel.setBounds(300,230,400,30);
        passlabel.setBackground(Color.white);
        passlabel.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        passtxtfield.setBounds(300,260,400,30);
        passtxtfield.setBackground(Color.white);
        passtxtfield.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        classlabel.setBounds(300,290,400,40);
        classlabel.setBackground(Color.white);
        classlabel.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        clsname.setBounds(300,320,400,30);
        clsname.setBackground(Color.white);
        clsname.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        branchlabel.setBounds(300,350,400,40);
        branchlabel.setBackground(Color.white);
        branchlabel.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        branchname.setBounds(300,380,400,30);
        branchname.setBackground(Color.white);
        branchname.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        contactlabel.setBounds(300,410,400,40);
        contactlabel.setBackground(Color.white);
        contactlabel.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        contacttxtfield.setBounds(300,440,400,30);
        contacttxtfield.setBackground(Color.white);
        contacttxtfield.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        addresslabel.setBounds(300,470,400,40);
        addresslabel.setBackground(Color.white);
        addresslabel.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        addtxtarea.setBounds(300,500,700,30);
        addtxtarea.setBackground(Color.white);
        addtxtarea.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        submitbtn.setBounds(300,550,100,30);
        submitbtn.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        resetbtn.setBounds(430, 550, 100, 30);
        resetbtn.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
          
    } 
    // adding components to frame
    public void addcomponent()
    {
        frame.add(title);
        frame.add(pinlabel);
        frame.add(pintxtfield);
        frame.add(namelabel);
        frame.add(nametxtfield);
        frame.add(emaillabel);
        frame.add(emailtxtfield);
        frame.add(passlabel);
        frame.add(passtxtfield);
        frame.add(branchname);
        frame.add(contactlabel);
        frame.add(contacttxtfield);
        frame.add(addresslabel);
        frame.add(addtxtarea);
        frame.add(submitbtn);
        frame.add(resetbtn);
        frame.add(classlabel);
        frame.add(clsname);  
    } 
    // action listener
    public void actionevent()
    {
        submitbtn.addActionListener(this);
        resetbtn.addActionListener(this);
    }   
    // registered user details stored to database
    @Override
    public void actionPerformed(ActionEvent e) 
    {
       if(e.getSource()==submitbtn)
       {
           try
           {
               Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
               PreparedStatement pstmt=con.prepareStatement("INSERT INTO REGISTER VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
              
               pstmt.setString(1,pintxtfield.getText());
               pstmt.setString(2,addtxtarea.getText());
               pstmt.setString(3,emailtxtfield.getText());
               pstmt.setString(4,contacttxtfield.getText());
               pstmt.setString(5,nametxtfield.getText());
               pstmt.setString(6,clsname.getSelectedItem().toString());
               pstmt.setString(7,branchname.getSelectedItem().toString());
               pstmt.setString(8,passtxtfield.getText());
               
               String pin=pintxtfield.getText();
               String pass=passtxtfield.getText();
               String email=emailtxtfield.getText();
               String classname=clsname.getSelectedItem().toString();
               String branch=branchname.getSelectedItem().toString();
               String address=addtxtarea.getText();
              
               
               if(pin.equals(""))
               {
                   JOptionPane.showMessageDialog(null,"User ID is missing");
               }    
               else if(pass.equals(""))
               {
                   JOptionPane.showMessageDialog(null,"Password is missing");
               }   
               else if(email.equals(""))
               {
                   JOptionPane.showMessageDialog(null,"Email is missing");
               }   
               
               Statement stmt=con.createStatement();
               String query="SELECT * FROM REGISTER";
               ResultSet rs=stmt.executeQuery(query);
               while(rs.next())
               {
                   String userid=rs.getString("PIN");
                   String password=rs.getString("PASSWORD");
                   if(userid.equals(pin) || password.equals(pass))
                   {
                        JOptionPane.showMessageDialog(null,"User already exist");
                        frame.setVisible(false);
                        break;
                   }  
                   else
                   {
                       pstmt.executeUpdate();
                       //String insert="INSERT INTO REGISTER VALUES(\""+pin+"\",\""+address+"\",\""+email+"\",\""+classname+"\",\""+branch+"\",\""+pass+"\");";
                       //stmt.executeUpdate(insert);
                       JOptionPane.showMessageDialog(null,"User Registered Successfully");
                       HomePage h=new HomePage();
                       h.init();
                       frame.setVisible(false);
                       break;
                   }    
               }
               /*if(!rs.next())
               {
                   pstmt.executeUpdate();
                   //String insert="INSERT INTO REGISTER VALUES(\""+pin+"\",\""+address+"\",\""+email+"\",\""+classname+"\",\""+branch+"\",\""+pass+"\");";
                   //stmt.executeUpdate(insert);
                   JOptionPane.showMessageDialog(null,"User Registered Successfully");
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
       // reset operation
       if(e.getSource()==resetbtn)
       {
           pintxtfield.setText("");
           nametxtfield.setText("");
           addtxtarea.setText("");
           contacttxtfield.setText("");
           clsname.setSelectedItem("");
           branchname.setSelectedItem("");
           passtxtfield.setText("");
           emailtxtfield.setText("");
       }    
    }    
    // main function
    public static void main(String[] args)
    {
        register reg=new register();
        reg.reginit();
    }        
    
}
