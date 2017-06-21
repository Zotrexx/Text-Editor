//���� ������ - 11.03.17; ���� ������� ������ - 17.05.17

import javax.swing.*;
//������ ���� ���������� Swing
import java.awt.FlowLayout;
//������ Layout
import java.awt.BorderLayout;
//������ Layout
import java.awt.event.*;
//������ ����������
import java.awt.Component;
//������ �����������
import javax.swing.JFileChooser;
//������ ���� ��� �������� ������
import javax.swing.filechooser.FileNameExtensionFilter;
//������ �������
import java.io.*;
//������ io

  
  
public class Main extends JFrame
{ 
  private static final long serialVersionUID=1L;
   JTextArea textArea;
   
  
  public static void main(String[] args) 
  { 
    new Main().setVisible(true);
  }
  
  private Main()
  {
   createGui();
  }
  
  public void createGui()
  {
    setTitle("ZZ Text Editor 1.0");
    setSize(1000,600); //������ ����
    setResizable(true); //���� ������� true,�� ������ ���� ����� ��������
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
     textArea = new JTextArea();
   getContentPane().add(new JScrollPane(textArea)); 
  
   createMenu();
  }
  
                                                       //���� � ������� ������
  
  public void createMenu()
  {
JMenuBar menuBar;
JMenu menu, submenu;
JMenuItem menuItem;
JRadioButtonMenuItem rbMenuItem;
JCheckBoxMenuItem cbMenuItem;

//������� ����
menuBar = new JMenuBar();

//������ ������ ����
menu = new JMenu("����");

//������ JMenuItems
menuBar.add(menu);
menuItem = new JMenuItem("���������");
menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
menu.add(menuItem);
menuItem.addActionListener(new ButtonFunction1());

menuItem = new JMenuItem("�������");
menu.add(menuItem);
menuItem.addActionListener(new ButtonFunction());


menuItem = new JMenuItem("��������� ���");
menu.add(menuItem);


//�������
menu.addSeparator();
submenu = new JMenu("������");

menuItem = new JMenuItem("��� ���");
submenu.add(menuItem);
menuItem.addActionListener(new ButtonFunction2());

menuItem = new JMenuItem("��� ������");
submenu.add(menuItem);
menu.add(submenu);

//������ ��������� ���� � ���������� ����
menu = new JMenu("������");
menu.getAccessibleContext().setAccessibleDescription("�����");
menuBar.add(menu);

menuItem = new JMenuItem("���������");
menu.add(menuItem);

menuItem = new JMenuItem("�������");
menu.add(menuItem);


this.setJMenuBar(menuBar);
  }
  
  class ButtonFunction implements ActionListener //������� ��������
 {
  public void actionPerformed(ActionEvent event)
   {
    JFileChooser chooser=new JFileChooser();
           chooser.setFileFilter(new FileNameExtensionFilter("Text/Code Files (txt, ltx, script, zz)", "txt", "ltx", "script", "zz"));
            chooser.setCurrentDirectory(new java.io.File("user.home"));
             chooser.setDialogTitle("�������� ������ ��� ����");
              chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                chooser.setDialogType(JFileChooser.OPEN_DIALOG);  // ������� ��� ������� Open ��� Save
                  if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
              {
                    try
                    {
                 FileReader fileReader = new FileReader(chooser.getSelectedFile());
                      BufferedReader reader = new BufferedReader(fileReader);
                      String line = null;
                      String text="";
                      while((line=reader.readLine())!=null)
                      {
                        System.out.print(line);
                        text=text+line+'\n';
                         textArea.setText(text);
                      }
                      reader.close();
                    }
                    catch (IOException ex)
                    {
                      
                    }  
              }    
  }
 }

  class ButtonFunction1 implements ActionListener //������� ����������
  {
    byte[] bytes = getBytes();
    public void actionPerformed(ActionEvent event)
    {
      JFileChooser chooser_1 = new JFileChooser();
           chooser_1.setFileFilter(new FileNameExtensionFilter("Text/Code Files (txt, ltx, script, zz)", "txt", "ltx", "script", "zz"));
            chooser_1.setCurrentDirectory(new java.io.File("user.home"));
             chooser_1.setDialogTitle("��������� ������ ��� ����");
              chooser_1.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                chooser_1.setDialogType(JFileChooser.SAVE_DIALOG);  // ������� ��� ������� Open ��� Save
                  if (chooser_1.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
                  {
                    try(OutputStream out = new FileOutputStream(chooser_1.getSelectedFile()))
                    {  
                      // write a byte sequence
            out.write(bytes);
            // write a single byte
            out.write(bytes[0]);
            // write sub sequence of the byte array
            out.write(bytes,4,10);
                    }  
                    catch (IOException  e) 
                    {
                         e.printStackTrace();
                    }  
                  }             
    }
  }
  
  class ButtonFunction2 implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      JFrame frame = new JFrame();
      frame.setTitle("��� ���");
      frame.setSize(300, 300);
      frame.setVisible(true);
      frame.setResizable(false);
      
      JLabel label = new JLabel("�������� ���-��");
      getContentPane().add(label);
      pack();
    }
  }
}
