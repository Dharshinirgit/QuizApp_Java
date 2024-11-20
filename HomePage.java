//importin required packages 
import java.awt.Color;
import java.awt.Font;
//import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
//import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import java.sql.*;

public class HomePage implements ActionListener
{
    static String pin=null;
    boolean logres=false;
    JFrame frame;
    JLabel welcome=new JLabel("Welcome to the Quiz Application."+" This accelerates your studies!");
    JMenuBar menubar=new JMenuBar();
    JMenu menu1=new JMenu("Home");
    JMenu menu2=new JMenu("Help");
    JMenu menu3=new JMenu("Feedback");
    
    JMenuItem menuitem1=new JMenuItem("New User Registration");
    JMenuItem menuitem2=new JMenuItem("Login");
    JMenuItem menuitem3=new JMenuItem("Take Quiz");
    JMenuItem menuitem4=new JMenuItem("Logout");
    
    JMenuItem menuitem5=new JMenuItem("Change Password");
     
    JMenuItem menuitem6=new JMenuItem("Give Feedback");
    
    //JTextArea feedbacktextarea=new JTextArea();
    //JLabel help=new JLabel();
    Icon quiz;
    JLabel image=new JLabel();
    
    
    
    public void init()
    {
        createwindow();
        setLocationandSize();
        addcomponenttoframe();
        actionevent();
    }  
    /* creating new Frame */
    public void createwindow()
    {
       
        frame=new JFrame();
        frame.setTitle("Quiz Application");
        frame.setBounds(50,10,1300,1000);
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    } 
    /* setting size and font style */
    public void setLocationandSize()
    {
        menubar.setBounds(2,2,1280,30);
        
        menu1.setBounds(2,2,100,30);
        menu1.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        menuitem1.setBounds(2,2,100,40);
        menuitem1.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        menuitem2.setBounds(2,8,100,40);
        menuitem2.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        menuitem3.setBounds(2,14,100,40);
        menuitem3.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        menuitem4.setBounds(2,20,100,40);
        menuitem4.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        menu2.setBounds(30,2,100,30);
        menu2.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        menuitem5.setBounds(30,2,100,30);
        menuitem5.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        menu3.setBounds(60,2,100,30);
        menu3.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        menuitem6.setBounds(90,2,100,40);
        menuitem6.setFont(new Font("cambria",Font.CENTER_BASELINE,16));
        
        menu1.add(menuitem1);
        menu1.add(menuitem2);
        menu1.add(menuitem3);
        menu1.add(menuitem4);
        
        menu2.add(menuitem5);
        
        menu3.add(menuitem6);
        
        welcome.setBounds(250,60,800,50);
        welcome.setBackground(Color.white);
        welcome.setFont(new Font("cambria",Font.CENTER_BASELINE,25));
        
        menubar.add(menu1);
        menubar.add(menu2);
        menubar.add(menu3);
        
        quiz=new ImageIcon("C:\\Users\\Dharshini\\Pictures\\quizimage.png");
        
        image.setBounds(500,90,1024,761);
        image.setIcon(quiz);
         
    }
    //adding compoenents to the frame
    public void addcomponenttoframe()
    {
        frame.add(menubar);
        frame.add(welcome);
        frame.add(image);
    }   
    //action listener
    public void actionevent()
    {
        menuitem1.addActionListener((ActionListener) this);
        menuitem2.addActionListener((ActionListener) this);
        menuitem3.addActionListener((ActionListener) this);
        menuitem4.addActionListener((ActionListener) this);
        menuitem5.addActionListener((ActionListener) this);
        menuitem6.addActionListener((ActionListener) this);
        
    }   
    //main method
    public static void main(String args[])
    {
        HomePage h=new HomePage();
        h.init();
    }        

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //new registration
          if(e.getSource()==menuitem1)
        {
            register re=new register();
            re.reginit();
        } 
        //login
        if(e.getSource()==menuitem2)
        {
            login lo=new login();
            lo.loginit();
            frame.setVisible(false);
        } 
        //take quiz - user allowed to take quiz only after logging into the app
        if(e.getSource()==menuitem3)
        {
           pin=JOptionPane.showInputDialog("Enter your PIN");
           try
           {
               Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
               Statement stmt=con.createStatement();
               String query="SELECT PIN FROM LOGIN";
               ResultSet rs=stmt.executeQuery(query);
               while(rs.next())
               {
                   String userid=rs.getString("PIN");
                   if(userid.equals(pin))
                   {
                       JOptionPane.showMessageDialog(null,"All The Best For Quiz!");
                       logres=true;
                       quiz1 q1=new quiz1();
                       q1.quiz1_init();
                       frame.setVisible(false);   
                       break;
                   }
                   /*else
                   {
                       JOptionPane.showMessageDialog(null,"User in not Logged in");
                       break;
                   }  */  
               }
               if(logres==false)
               {
                   JOptionPane.showMessageDialog(null,"User in not Logged in");
               }    
           } 
           catch(Exception ex)
           {
              System.out.println(ex.toString());
           }    
        }   
        //logout 
        if(e.getSource()==menuitem4)
        {
            try
            {
               Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
               Statement stmt=con1.createStatement();
               String query="SELECT PIN FROM LOGIN";
               ResultSet rs=stmt.executeQuery(query);
               while(rs.next())
               {
                pin=rs.getString("PIN");
                PreparedStatement pst=con1.prepareStatement("DELETE FROM LOGIN WHERE PIN='"+pin+"'");
                pst.execute();
                frame.setVisible(false);
                JOptionPane.showMessageDialog(null,"Logout successful");
               } 
            } 
            catch(Exception ex)
            {
                System.out.println(ex.toString());
            }    
            frame.setVisible(false);  
        } 
        // change password
        if(e.getSource()==menuitem5)
        {
            passchange p=new passchange();
            p.passchangeinit();
        }
        // feedback
        if(e.getSource()==menuitem6)
        {
            feedback fd=new feedback();
            fd.fdinit();
        }    
    }
}
          