/**
 use manager.bank  for manager password
 */
package banksystem;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.Border;

//Note that Manager password is manager.bank
public class BankSystem extends JFrame {

    static int i = 4, count = 5, idd, data1 = 0, j, manage = 0, ac = 0, depc = 0;
    static int defdc = 0, defwc = 0;
    static long a[] = new long[20], dep[] = new long[20];
    static long defwcd[] = new long[20], defdcd[] = new long[20];
    double wd, dp;
    double withdraw1[] = new double[50], deposit1[] = new double[50];
    double defltd[] = new double[50], defltw[] = new double[50];
    public static int i1 = 1, i2 = 0, i3 = 9, i4 = 0, i5 = 9, i6 = 0, i7 = 0;
    static String sex;
    Bankaccount[] ob1 = new Bankaccount[100];

    JTextField jfname, jlname, jmname, jage;
    JRadioButton yes, no, male, female;
    ButtonGroup group, group1;
    JPasswordField jpass;
    JTextField jphone, jaddress, jdeposit;
    JLabel passl, jdepositl, jpassword, listn;
    JButton next, getpass;
    JButton jcreate, jexist, jmanager, juser;
    JButton balance, deposite, whithdraw, ptransaction, transfer;
    Border line = new LineBorder(Color.BLACK);
    Font f = new Font("serif", Font.BOLD + Font.ITALIC, 20);
    Font ff = new Font("Dialog", Font.BOLD + Font.ITALIC, 20);
    JButton back, jtransfer, jchack;
    JButton listc, listf, listm, listct, listi;
    JComboBox box;
    String[] s = {"null", "above amount", "below amount", "at value", "setdeposit", "setwithdraw",
        "getdeposit", "getwithdraw", "default", "changefname", "changeMname", "changeLname"};

    static JFrame MainFrame, User, ShowMenu, Manager1, Listm, Listc, Listf;
    JFrame frame1, frame2, frame3, frame4, frame5, frame6;
    JFrame Create = new JFrame();
    JButton back1,managerback;

    BankSystem() {

        super("National Bank");

        ob1[0] = new Bankaccount(22, 1111111, "BISHOFTU", "kaleab", "John", "tacker");
        ob1[1] = new Bankaccount(22, 2222222, "BISHOFTU", "michael", "keven", "adnew");
        ob1[2] = new Bankaccount(22, 3333333, "BISHOFTU", "Natnael", "abraham", "jacob");
        ob1[3] = new Bankaccount(22, 4444444, "BISHOFTU", "lili", "manaj", "liang");
        ob1[4] = new Bankaccount(22, 5555555, "BISHOFTU", "keven", "morgen", "willeam");

        ob1[0].setdata("Male", 1111);
        ob1[1].setdata("Male", 2222);
        ob1[2].setdata("Male", 3333);
        ob1[3].setdata("Female", 4444);
        ob1[4].setdata("Male", 0);

        ob1[0].deposit(300);
        ob1[1].deposit(700);
        ob1[2].deposit(1000);
        ob1[3].deposit(8000);
        ob1[4].deposit(600);

        ob1[0].setname("kaleaShawel");
        ob1[1].setname("MichaelEngdawerk");
        ob1[2].setname("Natnaelabreham");
        ob1[3].setname("MetsnanatMesfin");
        ob1[4].setname("NatnaelAbebe");

        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));

        jcreate = new JButton("Create Account");
        juser = new JButton("User");
        jmanager = new JButton("Manager");
        jexist = new JButton("Use existing Account");

        p1.setBorder(new LineBorder(Color.GRAY, 2));
        p1.setBackground(Color.LIGHT_GRAY);
        p1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        p1.add(jcreate);
        p1.add(juser);
        p1.add(jmanager);
        p1.add(jexist);

        add(p1, BorderLayout.NORTH);

        helper help = new helper();

        jcreate.addActionListener(help);
        juser.addActionListener(help);
        jmanager.addActionListener(help);
        jexist.addActionListener(help);

    }
    public static void main(String[] args) {

        MainFrame = new BankSystem();
        MainFrame.setSize(700, 300);
        MainFrame.setLocationRelativeTo(null);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setVisible(true);
    }
    void create() {

        i++;
        count++;
        MainFrame.setVisible(false);
        Create = new JFrame();
        Create.setTitle("Create Account");
        Create.setSize(570, 670);
        Create.setLocationRelativeTo(null);
        Create.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Create.setVisible(true);

        jfname = new JTextField(8);
        jmname = new JTextField(8);
        jlname = new JTextField(8);
        jage = new JTextField(5);

        JPanel p1 = new JPanel(new GridLayout(3, 3, 5, 5));

        p1.add(new JLabel("First Name"));
        p1.add(new JLabel("Middle Name"));
        p1.add(new JLabel("Last Name"));
        p1.add(jfname);
        p1.add(jmname);
        p1.add(jlname);

        JPanel p31 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        p31.add(new JLabel("AGE"));
        p31.add(jage);
        p1.add(p31);

        male = new JRadioButton("MALE", false);
        female = new JRadioButton("FEMALE", false);
        yes = new JRadioButton("YES", false);
        no = new JRadioButton("NO", false);

        JPanel p2 = new JPanel(new GridLayout(3, 1));
        p2.setBackground(Color.LIGHT_GRAY);
        p2.add(new JLabel("SEX"));
        p2.add(male);
        p2.add(female);

        JPanel p10 = new JPanel(new GridLayout(3, 1));
        p10.setBackground(Color.LIGHT_GRAY);
        p10.add(new JLabel("USE MOBILE BANKING"));

        p10.add(yes);
        p10.add(no);
        group = new ButtonGroup();
        group.add(male);
        group.add(female);

        group1 = new ButtonGroup();
        group1.add(no);
        group1.add(yes);

        jpass = new JPasswordField("password field");
        jaddress = new JTextField(10);
        jdeposit = new JTextField(10);

        jpass.setEditable(false);
        next = new JButton("Next");
        back = new JButton("Back");
        passl = new JLabel("PASSWORD");
        jdepositl = new JLabel("DEPOSIT");
        jpassword = new JLabel("PASSWORD");
        jphone = new JTextField(10);

        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        p3.add(new JLabel("ADDRESS"));
        p3.add(jaddress);

        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        jdepositl.setToolTipText("Diposite must be greater than 25");
        p4.add(jdepositl);
        p4.add(jdeposit);

        JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));

        jpassword.setToolTipText("to get accountnumber click -> next ");
        p5.add(jpassword);
        p5.add(jpass);

        JPanel p6 = new JPanel();
        p6.add(back);
        p6.add(next);
        JPanel p9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p9.add(new JLabel("PHONE_NUMBER"));
        p9.add(jphone);
        JPanel p7 = new JPanel(new GridLayout(7, 2));
        p7.setBorder(line);

        p7.add(p1);
        p7.add(p2);
        p7.add(p10);
        p7.add(p9);
        p7.add(p3);

        JPanel p8 = new JPanel(new GridLayout(1, 1, 5, 5));
        p6.setBackground(Color.WHITE);

        p7.add(p4);
        p7.add(p5);
        p8.add(p6);

        Create.add(p7, BorderLayout.CENTER);
        Create.add(p8, BorderLayout.SOUTH);

        creater chandler = new creater();

        jfname.addActionListener(chandler);
        jlname.addActionListener(chandler);
        jmname.addActionListener(chandler);
        jage.addActionListener(chandler);

        jaddress.addActionListener(chandler);
        jdeposit.addActionListener(chandler);
        next.addActionListener(chandler);
        jpass.addActionListener(chandler);
        jphone.addActionListener(chandler);

        itemclass item = new itemclass();
        male.addItemListener(item);
        female.addItemListener(item);

        itemclass1 item1 = new itemclass1();
        yes.addItemListener(item1);
        no.addItemListener(item1);

        back.addActionListener((ActionEvent e) -> {
            Create.setVisible(false);
            MainFrame.setVisible(true);
        });

    }
    void listof() {
        for (int x = 0; x < count; x++) {
            for (int y = count - 1; y > x; y--) {
                Bankaccount temp;
                temp = new Bankaccount();
                if (ob1[y - 1].getname().compareToIgnoreCase(ob1[y].getname()) > 0) {
                    temp = ob1[y];
                    ob1[y] = ob1[y - 1];
                    ob1[y - 1] = temp;
                }
            }
        }
    }
    int idsetter() {
        int id = 0;
        for (; i1 < 10; i1++) {
            int ct;
            ct = 0;
            for (; i2 < 10; i2++) {
                for (; i3 >= 0; i3--) {
                    for (; i4 < 10; i4++) {
                        for (; i5 >= 0; i5--) {
                            for (; i6 < 10; i6++) {
                                for (; i7 < 10; i7++) {
                                    ct++;
                                    if (ct == 1) {
                                        id = ((i1 * 10000000) + (i2 * 100000) + (i3 * 10000) + (i4 * 1000) + (i5 * 100) + (i6 * 10) + (i7));
                                    } else {
                                        return id;
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
        return id;

    }
    int idsetter1() {
        int id = 0;
        for (; i1 < 10; i1++) {
            int ct;
            ct = 0;
            for (; i2 < 10; i2++) {
                for (; i3 >= 0; i3--) {
                    for (; i4 < 10; i4++) {
                        ct++;
                        if (ct == 1) {
                            id = ((i1 * 1000) + (i2 * 100) + (i3 * 10) + (i4));
                        } else {
                            return id;
                        }
                    }
                }
            }
        }
        return id;
    }
    void user() {
        MainFrame.setVisible(false);

        User = new JFrame();
        User.setSize(360, 300);
        User.setLocationRelativeTo(null);
        User.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        User.setVisible(true);

        jchack = new JButton("chack balance");
        jtransfer = new JButton("transfer");

        back = new JButton("Back");

        JPanel p1 = new JPanel();

        p1.add(jchack);
        p1.add(jtransfer);

        User.add(p1, BorderLayout.CENTER);
        User.add(back, BorderLayout.SOUTH);

        back.addActionListener((ActionEvent e) -> {
            User.setVisible(false);
            MainFrame.setVisible(true);
        });

        userhandler user = new userhandler();

        jchack.addActionListener(user);
        jtransfer.addActionListener(user);

    }
    void showmenu(int k) {
        j = k;
        Create.setVisible(false);
        ShowMenu = new JFrame();
        ShowMenu.setSize(900, 400);
        ShowMenu.setLocationRelativeTo(null);
        ShowMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ShowMenu.setVisible(true);

        //setLayout(new GridLayout(1, 2, 5, 5));
        balance = new JButton("Balance");
        deposite = new JButton("Deposite");
        whithdraw = new JButton("Withdraw");
        ptransaction = new JButton("Previous Transaction");
        transfer = new JButton("Transfer");

        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        p1.setBorder(line);

        p1.add(balance);
        p1.add(deposite);
        p1.add(whithdraw);
        p1.add(transfer);
        p1.add(ptransaction);
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        Font fb = new Font("serif", Font.BOLD, 16);
        back = new JButton("back");
        back.setFont(fb);

        p3.add(back);

        menu show = new menu();

        balance.addActionListener(show);
        deposite.addActionListener(show);
        whithdraw.addActionListener(show);
        ptransaction.addActionListener(show);
        transfer.addActionListener(show);
        back.addActionListener(show);

        JPanel p2 = new JPanel(new GridLayout(7, 1));
        p2.setBorder(line);
        p2.setBackground(Color.WHITE);

        p2.add(new JLabel("USERNAME : " + ob1[j].getfname().toUpperCase() + " " + ob1[j].getmname().toUpperCase() + " " + ob1[j].getlname().toUpperCase()));
        p2.add(new JLabel("AGE :  " + ob1[j].getage()));
        p2.add(new JLabel("SEX :  " + ob1[j].getsex()));
        p2.add(new JLabel("ADDRESS :  " + ob1[j].getaddress().toUpperCase()));
        p2.add(new JLabel("accont code :  " + ob1[j].getcode()));
        p2.add(new JLabel("mobile code :  " + ob1[j].getmobile()));

        JPanel p4 = new JPanel(new GridLayout(1, 2));
        p4.add(p2);
        p4.add(p1);

        ShowMenu.add(p1, BorderLayout.NORTH);
        ShowMenu.add(p2, BorderLayout.CENTER);
        ShowMenu.add(p3, BorderLayout.SOUTH);

    }
    int searching(long key) {
        int index = 0;
        int found = 0;
        do {
            if (key == ob1[index].getcode()) {
                found = 1;
            } else {
                index++;
            }
        } while (found == 0 && index < count);
        if (found == 0) {
            index = -1;
        }
        return index;
    }
    int searchingM(int key) {
        int index = 0;
        int found = 0;
        do {
            if (key == ob1[index].getmobile()) {
                found = 1;
            } else {
                index++;
            }
        } while (found == 0 && index < count);
        if (found == 0) {
            index = -1;
        }
        return index;
    }
    void transfer(long chake) {
        int x = searching(chake);
        if (x != -1) {
            String fn = JOptionPane.showInputDialog("Enter amoount ");
            double amount = Double.parseDouble(fn);
            String ln = JOptionPane.showInputDialog("transfer to ");
            long amount1 = Long.parseLong(ln);

            if (searching(amount1) != -1) {
                JOptionPane.showMessageDialog(null, ob1[searching(chake)].getfname().toUpperCase() + " " + ob1[searching(chake)].getmname().toUpperCase()
                        + " transfer " + amount + " birr to account number " + ob1[searching(amount1)].getcode()
                        + " NAME " + ob1[searching(amount1)].getfname().toUpperCase() + " " + ob1[searching(amount1)].getmname().toUpperCase(),
                        "TRANSFER", JOptionPane.PLAIN_MESSAGE);
                String mn = JOptionPane.showInputDialog("PRESS 1 TO CONTINUE ELSE PRESS ANY KEY");
                int press = Integer.parseInt(mn);
                if (press == 1) {

                    if ((ob1[searching(chake)].getdeposit() - amount) > 50) {

                        ob1[searching(chake)].withdraw(amount);
                        ob1[searching(amount1)].deposit(amount);

                        JOptionPane.showMessageDialog(null, ob1[searching(chake)].getfname().toUpperCase() + ob1[searching(chake)].getmname().toUpperCase() + " transfer " + amount + " birr to "
                                + ob1[searching(amount1)].getfname().toUpperCase() + ob1[searching(amount1)].getmname().toUpperCase()
                                + " was transfered successfully" + "  balance  : " + ob1[searching(chake)].getdeposit(), "TRANSFER", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        ob1[searching(chake)].withdraw(amount);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, " transfer cancelled cessesfully ", "TRANSFER", JOptionPane.PLAIN_MESSAGE);

                }
            } else {
                JOptionPane.showMessageDialog(null, " This kind of account number does not exist ", "TRANSFER", JOptionPane.PLAIN_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(null, " This kind of account number does not exist ", "TRANSFER", JOptionPane.PLAIN_MESSAGE);

        }

    }
    void manager1() {

        listof();

        MainFrame.setVisible(false);
        Manager1 = new JFrame("national bank");
        Manager1.setSize(950, 400);
        Manager1.setLocationRelativeTo(null);
        Manager1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Manager1.setVisible(true);

        listc = new JButton("list of Customer");
        listf = new JButton("list of Female Customer");
        listm = new JButton("list of Male Customer");
        listi = new JButton("Individual Customer");
        listct = new JButton("Number of Customer in the Bank");

        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));

        p1.setBorder(new TitledBorder("main menu"));
        p1.setBackground(Color.LIGHT_GRAY);
        p1.add(listc);
        p1.add(listf);
        p1.add(listm);
        p1.add(listi);
        p1.add(listct);
        JPanel p6 = new JPanel(new FlowLayout());

        box = new JComboBox(s);
        listn = new JLabel("List Customer if");

        p6.add(listn);
        p6.add(box);

        managerback = new JButton("back");

        Manager1.add(p1, BorderLayout.NORTH);
        Manager1.add(p6, BorderLayout.CENTER);
        Manager1.add(managerback, BorderLayout.SOUTH);

        managehandler mhandler = new managehandler();

        listc.addActionListener(mhandler);
        listf.addActionListener(mhandler);
        listm.addActionListener(mhandler);
        listi.addActionListener(mhandler);
        listct.addActionListener(mhandler);
         

        box.addItemListener((ItemEvent e) -> {
            displaymanager(box.getSelectedIndex());
        });
        
        managerback.addActionListener((ActionEvent e) -> {
            Manager1.setVisible(false);
            MainFrame.setVisible(true);
        });

    }
    void manager() {

        String sn = JOptionPane.showInputDialog("Password");
        String s1 = String.format(sn);
        String passed = "manager.bank";

        if (passed.equals(s1)) {
            manager1();
        } else {
            JOptionPane.showMessageDialog(null, " Incorrect Password ", "PASSCODE", JOptionPane.PLAIN_MESSAGE);
            // data11();
        }

    }
    class managehandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == listc) {

                Manager1.setVisible(false);
                Listc = new JFrame();
                Listc.setSize(600, 300);
                Listc.setLocationRelativeTo(null);
                Listc.setDefaultCloseOperation(
                        JFrame.EXIT_ON_CLOSE);
                Listc.setVisible(true);

                JPanel p2 = new JPanel(new GridLayout(0, 8, 5, 5));

                p2.add(new JLabel("ACCOUNT"));
                p2.add(new JLabel("FIRST NAME "));
                p2.add(new JLabel("MIDDLE   "));
                p2.add(new JLabel("LAST  "));
                p2.add(new JLabel("AGE"));
                p2.add(new JLabel("SEX"));
                p2.add(new JLabel("ADDRESS"));
                p2.add(new JLabel("UNIQUE CODE"));

                for (int l1 = 0; l1 < count; l1++) {

                    p2.add(new JLabel(" " + ob1[l1].getcode()));
                    p2.add(new JLabel(" " + ob1[l1].getfname().toUpperCase()));
                    p2.add(new JLabel(" " + ob1[l1].getmname().toUpperCase()));
                    p2.add(new JLabel(" " + ob1[l1].getlname().toUpperCase()));
                    p2.add(new JLabel(" " + ob1[l1].getage()));
                    p2.add(new JLabel(" " + ob1[l1].getsex()));
                    p2.add(new JLabel(" " + ob1[l1].getaddress().toUpperCase()));
                    p2.add(new JLabel(" " + ob1[l1].getmobile()));
                }

                JScrollPane sp1 = new JScrollPane(p2);
                JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                p1.setBackground(Color.LIGHT_GRAY);

                back = new JButton("back");

                p1.add(back);

                JPanel p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                p3.setBackground(Color.WHITE);
                p3.add(new JLabel("Total " + count + " Customers"));

                JPanel p4 = new JPanel(new GridLayout(1, 2));
                p4.add(p1);
                p4.add(p3);

                back.addActionListener((ActionEvent e1) -> {
                    Listc.setVisible(false);
                    Manager1.setVisible(true);
                });

                Listc.add(sp1, BorderLayout.CENTER);
                Listc.add(p4, BorderLayout.SOUTH);

            } else if (e.getSource() == listi) {
                String fn = JOptionPane.showInputDialog("Enter account number");
                long d = Integer.parseInt(fn);

                if (searching(d) != -1) {
                    Manager1.setVisible(false);
                    showmenu(searching(d));
                } else {
                    JOptionPane.showMessageDialog(null, "INVALID account number", "warning", JOptionPane.PLAIN_MESSAGE);
                }
            } else if (e.getSource() == listf) {

                Manager1.setVisible(false);
                Listf = new JFrame();
                Listf.setSize(600, 300);
                Listf.setLocationRelativeTo(null);
                Listf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Listf.setVisible(true);

                JPanel p2 = new JPanel(new GridLayout(0, 8));

                p2.add(new JLabel("ACCOUNT"));
                p2.add(new JLabel("FIRST NAME"));
                p2.add(new JLabel("MIDDLE "));
                p2.add(new JLabel("LAST "));
                p2.add(new JLabel("AGE"));
                p2.add(new JLabel("SEX"));
                p2.add(new JLabel("ADDRESS"));
                p2.add(new JLabel("UNIQUE CODE"));

                int fcounter = 0;

                for (int l1 = 0; l1 < count; l1++) {
                    if (ob1[l1].getsex().equals("Female")) {

                        fcounter++;

                        p2.add(new JLabel(" " + ob1[l1].getcode()));
                        p2.add(new JLabel(" " + ob1[l1].getfname().toUpperCase()));
                        p2.add(new JLabel(" " + ob1[l1].getmname().toUpperCase()));
                        p2.add(new JLabel(" " + ob1[l1].getlname().toUpperCase()));
                        p2.add(new JLabel(" " + ob1[l1].getage()));
                        p2.add(new JLabel(" " + ob1[l1].getsex()));
                        p2.add(new JLabel(" " + ob1[l1].getaddress().toUpperCase()));
                        p2.add(new JLabel(" " + ob1[l1].getmobile()));
                    }
                }

                JScrollPane sp1 = new JScrollPane(p2);
                JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));

                p1.setBackground(Color.LIGHT_GRAY);
                back = new JButton("back");
                back.setFont(ff);
                p1.add(back);

                JPanel p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                p3.setBackground(Color.WHITE);
                p3.add(new JLabel("Total " + fcounter + " Customers"));

                JPanel p4 = new JPanel(new GridLayout(1, 2));
                p4.add(p1);
                p4.add(p3);

                back.addActionListener((ActionEvent e1) -> {
                    Listf.setVisible(false);
                    Manager1.setVisible(true);
                });

                Listf.add(sp1, BorderLayout.CENTER);
                Listf.add(p4, BorderLayout.SOUTH);

            } else if (e.getSource() == listm) {

                Manager1.setVisible(false);
                Listm = new JFrame();
                Listm.setSize(600, 300);
                Listm.setLocationRelativeTo(null);
                Listm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Listm.setVisible(true);

                JPanel p2 = new JPanel(new GridLayout(0, 8));

                p2.add(new JLabel("ACCOUNT "));
                p2.add(new JLabel("FIRST NAME"));
                p2.add(new JLabel("MIDDLE "));
                p2.add(new JLabel("LAST "));
                p2.add(new JLabel("AGE"));
                p2.add(new JLabel("SEX"));
                p2.add(new JLabel("ADDRESS"));
                p2.add(new JLabel("UNIQUE CODE"));

                int mcounter = 0;

                for (int l1 = 0; l1 < count; l1++) {
                    if (ob1[l1].getsex().equals("Male")) {

                        mcounter++;

                        p2.add(new JLabel(" " + ob1[l1].getcode()));
                        p2.add(new JLabel(" " + ob1[l1].getfname().toUpperCase()));
                        p2.add(new JLabel(" " + ob1[l1].getmname().toUpperCase()));
                        p2.add(new JLabel(" " + ob1[l1].getlname().toUpperCase()));
                        p2.add(new JLabel(" " + ob1[l1].getage()));
                        p2.add(new JLabel(" " + ob1[l1].getsex()));
                        p2.add(new JLabel(" " + ob1[l1].getaddress().toUpperCase()));
                        p2.add(new JLabel(" " + ob1[l1].getmobile()));
                    }
                }

                JScrollPane sp1 = new JScrollPane(p2);
                JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                p1.setBackground(Color.LIGHT_GRAY);

                back = new JButton("back");
                back.setFont(ff);
                p1.add(back);

                JPanel p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                p3.setBackground(Color.WHITE);
                p3.add(new JLabel("Total " + mcounter + " Customers"));

                JPanel p4 = new JPanel(new GridLayout(1, 2));
                p4.add(p1);
                p4.add(p3);

                back.addActionListener((ActionEvent e1) -> {
                    Listm.setVisible(false);
                    Manager1.setVisible(true);
                });

                Listm.add(sp1, BorderLayout.CENTER);
                Listm.add(p4, BorderLayout.SOUTH);

            } else if (e.getSource() == listct) {
                JOptionPane.showMessageDialog(null, " There are " + count + " Customer", "MUNBER OF CUSTOMER", JOptionPane.PLAIN_MESSAGE);

            } 
        }
    }
    class userhandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            User.setVisible(false);
            if (e.getSource() == jchack) {

                String fn = JOptionPane.showInputDialog("enter account number ");
                long code = Integer.parseInt(fn);
                int check = searching(code);
                if (check != -1) {

                    JOptionPane.showMessageDialog(null, "  NAME :  " + ob1[check].getfname().toUpperCase() + " " + ob1[check].getmname().toUpperCase()
                            + " " + ob1[check].getlname().toUpperCase() + " \nSEX : " + ob1[check].getsex() + "\nADDRESS : " + ob1[check].getaddress().toUpperCase()
                            + "\n BALANCE : " + ob1[check].getdeposit(), "user information", JOptionPane.PLAIN_MESSAGE);
                    //data11();
                    MainFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, " INVALID ACCOUNTNUMBER", "Warnning", JOptionPane.PLAIN_MESSAGE);
                    //data11();
                    MainFrame.setVisible(true);
                }
            } else if (e.getSource() == jtransfer) {

                String fn = JOptionPane.showInputDialog("enter account number ");
                long code1 = Integer.parseInt(fn);
                int check2 = searching(code1);

                if (check2 != -1) {

                    String ln = JOptionPane.showInputDialog("enter unique code ");
                    int mob = Integer.parseInt(ln);
                    int check1 = searchingM(mob);
                    if (mob == 0) {
                        JOptionPane.showMessageDialog(null, "NOT REGISTERED", "Warnning", JOptionPane.PLAIN_MESSAGE);
                    } else if (check1 != -1 && (check1 == check2)) {
                        transfer(code1);
                        //data11();
                        MainFrame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, " INVALID UNIQUE CODE", "Warnning", JOptionPane.PLAIN_MESSAGE);
                        //data11();
                        MainFrame.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, " INVALID ACCOUNTNUMBER", "Warnning", JOptionPane.PLAIN_MESSAGE);
                    //data11();
                    MainFrame.setVisible(true);
                }

            }
        }
    }
    class menu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == balance) {
                JOptionPane.showMessageDialog(null, " your Balance is " + ob1[j].getdeposit(), "BALANCE", JOptionPane.PLAIN_MESSAGE);

            } else if (e.getSource() == deposite) {
                String fn = JOptionPane.showInputDialog("Enter amoount to deposite");
                double deposite = Double.parseDouble(fn);
                ob1[j].deposit(deposite);
                JOptionPane.showMessageDialog(null, deposite + "deposited and" + " your Balance become " + ob1[j].getdeposit(), "BALANCE", JOptionPane.PLAIN_MESSAGE);

                defdcd[defdc] = ob1[j].getcode();
                defltd[defdc] = deposite;
                defdc++;

                if (deposite >= wd) {
                    a[ac] = ob1[j].getcode();
                    deposit1[ac] = deposite;
                    ac++;
                }
            } else if (e.getSource() == whithdraw) {

                String fn = JOptionPane.showInputDialog("Enter amoount to withdraw");
                double deposite = Double.parseDouble(fn);

                if ((ob1[j].getdeposit() - deposite) > 50) {

                    defwcd[defwc] = ob1[j].getcode();
                    defltw[defwc] = deposite;
                    defwc++;
                    if (deposite >= dp) {
                        dep[depc] = ob1[j].getcode();
                        withdraw1[depc] = deposite;
                        depc++;

                    }

                }

                ob1[j].withdraw(deposite);

            } else if (e.getSource() == ptransaction) {
                ob1[j].getPreviousTransaction();
            }
            if (e.getSource() == transfer) {
                transfer(ob1[j].getcode());
            }
            if (e.getSource() == back) {
                ShowMenu.setVisible(false);
                MainFrame.setVisible(true);

            }
        }
    }
    class helper implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == jcreate) {
                create();
            } else if (e.getSource() == jexist) {
                MainFrame.setVisible(false);

                String fn = JOptionPane.showInputDialog("Enter accont number");
                long passcode = Integer.parseInt(fn);
                if (searching(passcode) != -1) {
                    showmenu(searching(passcode));

                } else {
                    JOptionPane.showMessageDialog(null, " INVALID CODE ", "PASSCODE", JOptionPane.PLAIN_MESSAGE);
                    MainFrame.setVisible(true);
                }

            } else if (e.getSource() == juser) {

                user();

            } else if (e.getSource() == jmanager) {

                manager();

            }

        }
    }
    class itemclass implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {

            if (male.isSelected()) {
                sex = "Male";
            } else if (female.isSelected()) {
                sex = "Female";

            }

        }
    }
    class itemclass1 implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {

            if (yes.isSelected()) {
                idd = idsetter1();
            } else if (no.isSelected()) {
                idd = 0;
            }
        }
    }
    class creater implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            double depositt = Double.parseDouble(jdeposit.getText());
            String fname = String.format(jfname.getText());
            String mname = String.format(jmname.getText());
            String lname = String.format(jlname.getText());
            String address = String.format(jaddress.getText());
            int age = Integer.parseInt(jage.getText());
            int phone = Integer.parseInt(jphone.getText());

            String s1 = fname.concat(mname);

            if (depositt < 25) {
                JOptionPane.showMessageDialog(null, " deposite must be greate than 25 ", "Warnning", JOptionPane.PLAIN_MESSAGE);
            } else {

                int pass = idsetter();

                defdcd[defdc] = pass;
                defltd[defdc] = depositt;
                defdc++;

                if (depositt >= wd) {
                    a[ac] = pass;
                    deposit1[ac] = depositt;
                    ac++;
                }

                ob1[i] = new Bankaccount(age, pass, address, fname, mname, lname);
                ob1[i].deposit(depositt);
                ob1[i].setdata(sex, idd);
                ob1[i].setname(s1);
                if (e.getSource() == next) {

                    JOptionPane.showMessageDialog(null, " Dr " + fname + " " + lname + " Account created successfully \n" + pass + " is your account code", "ACCOUNTCODE", JOptionPane.PLAIN_MESSAGE);

                    showmenu(i);

                }

            }

        }
    }
    void displaymanager(int index) {

        switch (index) {
            case 1:
                manage++;
                if (manage == 2) {
                    manage = 0;
                    String fn = JOptionPane.showInputDialog("Enter amount");
                    double d = Double.parseDouble(fn);

                    Manager1.setVisible(false);
                    frame6 = new JFrame();
                    frame6.setSize(400, 300);
                    frame6.setLocationRelativeTo(null);
                    frame6.setDefaultCloseOperation(
                            JFrame.EXIT_ON_CLOSE);
                    frame6.setVisible(true);

                    JPanel p2 = new JPanel(new GridLayout(0, 6));

                    p2.add(new JLabel("ACCOUNT"));
                    p2.add(new JLabel("FIRST NAME"));
                    p2.add(new JLabel("MIDDLE "));
                    p2.add(new JLabel("LAST "));
                    p2.add(new JLabel("BALANCE"));
                    p2.add(new JLabel("ADDRESS"));

                    int fcounter = 0;

                    for (int l1 = 0; l1 < count; l1++) {
                        if (ob1[l1].getdeposit() >= d) {

                            fcounter++;

                            p2.add(new JLabel(" " + ob1[l1].getcode()));
                            p2.add(new JLabel(" " + ob1[l1].getfname().toUpperCase()));
                            p2.add(new JLabel(" " + ob1[l1].getmname().toUpperCase()));
                            p2.add(new JLabel(" " + ob1[l1].getlname().toUpperCase()));
                            p2.add(new JLabel(" " + ob1[l1].getdeposit()));

                            p2.add(new JLabel(" " + ob1[l1].getaddress().toUpperCase()));

                        }
                    }

                    JScrollPane sp1 = new JScrollPane(p2);
                    JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));

                    p1.setBackground(Color.LIGHT_GRAY);
                    back = new JButton("back");
                    back.setFont(ff);
                    p1.add(back);

                    JPanel p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                    p3.setBackground(Color.WHITE);
                    p3.add(new JLabel("Total " + fcounter + " Customers"));

                    JPanel p4 = new JPanel(new GridLayout(1, 2));
                    p4.add(p1);
                    p4.add(p3);

                    back.addActionListener((ActionEvent e1) -> {
                        frame6.setVisible(false);
                        Manager1.setVisible(true);
                    });

                    frame6.add(sp1, BorderLayout.CENTER);
                    frame6.add(p4, BorderLayout.SOUTH);
                }
                break;
            case 2:
                manage++;
                if (manage == 2) {
                    manage = 0;

                    String fn = JOptionPane.showInputDialog("Enter amount");
                    double d = Double.parseDouble(fn);

                    Manager1.setVisible(false);
                    frame1 = new JFrame();
                    frame1.setSize(400, 300);
                    frame1.setLocationRelativeTo(null);
                    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame1.setVisible(true);

                    JPanel p2 = new JPanel(new GridLayout(0, 6));

                    p2.add(new JLabel("ACCOUNT"));
                    p2.add(new JLabel("FIRST NAME"));
                    p2.add(new JLabel("MIDDLE "));
                    p2.add(new JLabel("LAST "));
                    p2.add(new JLabel("BALANCE"));
                    p2.add(new JLabel("ADDRESS"));

                    int fcounter = 0;

                    for (int l1 = 0; l1 < count; l1++) {
                        if (ob1[l1].getdeposit() <= d) {

                            fcounter++;

                            p2.add(new JLabel(" " + ob1[l1].getcode()));
                            p2.add(new JLabel(" " + ob1[l1].getfname().toUpperCase()));
                            p2.add(new JLabel(" " + ob1[l1].getmname().toUpperCase()));
                            p2.add(new JLabel(" " + ob1[l1].getlname().toUpperCase()));
                            p2.add(new JLabel(" " + ob1[l1].getdeposit()));
                            p2.add(new JLabel(" " + ob1[l1].getaddress().toUpperCase()));

                        }
                    }

                    JScrollPane sp1 = new JScrollPane(p2);
                    JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));

                    p1.setBackground(Color.LIGHT_GRAY);
                    back = new JButton("back");
                    back.setFont(ff);
                    p1.add(back);

                    JPanel p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                    p3.setBackground(Color.WHITE);
                    p3.add(new JLabel("Total " + fcounter + " Customers"));

                    JPanel p4 = new JPanel(new GridLayout(1, 2));
                    p4.add(p1);
                    p4.add(p3);

                    back.addActionListener((ActionEvent e1) -> {
                        frame1.setVisible(false);
                        Manager1.setVisible(true);
                    });

                    frame1.add(sp1, BorderLayout.CENTER);
                    frame1.add(p4, BorderLayout.SOUTH);
                }
                break;
            case 3:
                manage++;
                if (manage == 2) {
                    manage = 0;

                    String fn = JOptionPane.showInputDialog("Enter amount");
                    double d = Double.parseDouble(fn);

                    Manager1.setVisible(false);
                    frame2 = new JFrame();
                    frame2.setSize(400, 300);
                    frame2.setLocationRelativeTo(null);
                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame2.setVisible(true);

                    JPanel p2 = new JPanel(new GridLayout(0, 6));

                    p2.add(new JLabel("ACCOUNT"));
                    p2.add(new JLabel("FIRST NAME"));
                    p2.add(new JLabel("MIDDLE "));
                    p2.add(new JLabel("LAST "));
                    p2.add(new JLabel("BALANCE"));
                    p2.add(new JLabel("ADDRESS"));

                    int fcounter = 0;

                    for (int l1 = 0; l1 < count; l1++) {
                        if (ob1[l1].getdeposit() == d) {

                            fcounter++;

                            p2.add(new JLabel(" " + ob1[l1].getcode()));
                            p2.add(new JLabel(" " + ob1[l1].getfname().toUpperCase()));
                            p2.add(new JLabel(" " + ob1[l1].getmname().toUpperCase()));
                            p2.add(new JLabel(" " + ob1[l1].getlname().toUpperCase()));
                            p2.add(new JLabel(" " + ob1[l1].getdeposit()));
                            p2.add(new JLabel(" " + ob1[l1].getaddress().toUpperCase()));

                        }
                    }

                    JScrollPane sp1 = new JScrollPane(p2);
                    JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));

                    p1.setBackground(Color.LIGHT_GRAY);
                    back = new JButton("back");
                    back.setFont(ff);
                    p1.add(back);

                    JPanel p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                    p3.setBackground(Color.WHITE);
                    p3.add(new JLabel("Total " + fcounter + " Customers"));

                    JPanel p4 = new JPanel(new GridLayout(1, 2));
                    p4.add(p1);
                    p4.add(p3);

                    back.addActionListener((ActionEvent e1) -> {
                        frame2.setVisible(false);
                        Manager1.setVisible(true);
                    });
                    frame2.add(sp1, BorderLayout.CENTER);
                    frame2.add(p4, BorderLayout.SOUTH);
                }
                break;
            case 4:
                manage++;
                if (manage == 2) {
                    manage = 0;
                    String fn = JOptionPane.showInputDialog("Enter amount");
                    wd = Double.parseDouble(fn);
                }
                break;
            case 5:
                manage++;
                if (manage == 2) {
                    manage = 0;
                    String fn = JOptionPane.showInputDialog("Enter amount");
                    dp = Double.parseDouble(fn);
                }
                break;
            case 6: {
                Manager1.setVisible(false);
                frame3 = new JFrame();
                frame3.setSize(400, 300);
                frame3.setLocationRelativeTo(null);
                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame3.setVisible(true);
                JPanel p2 = new JPanel(new GridLayout(0, 6));
                p2.add(new JLabel("ACCOUNT"));
                p2.add(new JLabel("FIRST NAME"));
                p2.add(new JLabel("MIDDLE "));
                p2.add(new JLabel("LAST "));
                p2.add(new JLabel("DEPOSIT"));
                p2.add(new JLabel("ADDRESS"));

                int fcounter = 0;
                for (int l1 = 0; l1 < ac; l1++) {
                    fcounter++;

                    p2.add(new JLabel(" " + ob1[searching(a[l1])].getcode()));
                    p2.add(new JLabel(" " + ob1[searching(a[l1])].getfname().toUpperCase()));
                    p2.add(new JLabel(" " + ob1[searching(a[l1])].getmname().toUpperCase()));
                    p2.add(new JLabel(" " + ob1[searching(a[l1])].getlname().toUpperCase()));
                    p2.add(new JLabel(" " + deposit1[l1]));
                    p2.add(new JLabel(" " + ob1[searching(a[l1])].getaddress().toUpperCase()));

                }
                JScrollPane sp1 = new JScrollPane(p2);
                JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                p1.setBackground(Color.LIGHT_GRAY);
                back = new JButton("back");
                back.setFont(ff);
                p1.add(back);
                JPanel p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                p3.setBackground(Color.WHITE);
                p3.add(new JLabel("Total " + fcounter + " Customers"));
                JPanel p4 = new JPanel(new GridLayout(1, 2));
                p4.add(p1);
                p4.add(p3);
                back.addActionListener((ActionEvent e1) -> {
                    frame3.setVisible(false);
                    Manager1.setVisible(true);
                });
                frame3.add(sp1, BorderLayout.CENTER);
                frame3.add(p4, BorderLayout.SOUTH);
                break;
            }
            case 7: {
                Manager1.setVisible(false);
                frame4 = new JFrame();
                frame4.setSize(400, 300);
                frame4.setLocationRelativeTo(null);
                frame4.setDefaultCloseOperation(
                        JFrame.EXIT_ON_CLOSE);
                frame4.setVisible(true);
                JPanel p2 = new JPanel(new GridLayout(0, 6));
                p2.add(new JLabel("ACCOUNT"));
                p2.add(new JLabel("FIRST NAME"));
                p2.add(new JLabel("MIDDLE "));
                p2.add(new JLabel("LAST "));
                p2.add(new JLabel("WHITHDRAW "));
                p2.add(new JLabel(" ADDRESS"));
                int fcounter = 0;
                for (int l1 = 0; l1 < depc; l1++) {
                    fcounter++;

                    p2.add(new JLabel(" " + ob1[searching(dep[l1])].getcode()));
                    p2.add(new JLabel(" " + ob1[searching(dep[l1])].getfname().toUpperCase()));
                    p2.add(new JLabel(" " + ob1[searching(dep[l1])].getmname().toUpperCase()));
                    p2.add(new JLabel(" " + ob1[searching(dep[l1])].getlname().toUpperCase()));
                    p2.add(new JLabel(" " + withdraw1[l1]));
                    p2.add(new JLabel(" " + ob1[searching(dep[l1])].getaddress().toUpperCase()));

                }
                JScrollPane sp1 = new JScrollPane(p2);
                JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                p1.setBackground(Color.LIGHT_GRAY);
                back = new JButton("back");
                back.setFont(ff);
                p1.add(back);
                JPanel p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                p3.setBackground(Color.WHITE);
                p3.add(new JLabel("Total " + fcounter + " Customers"));
                JPanel p4 = new JPanel(new GridLayout(1, 2));
                p4.add(p1);
                p4.add(p3);
                back.addActionListener((ActionEvent e1) -> {
                    frame4.setVisible(false);
                    Manager1.setVisible(true);
                });
                frame4.add(sp1, BorderLayout.CENTER);
                frame4.add(p4, BorderLayout.SOUTH);
                break;
            }
            case 8: {
                Manager1.setVisible(false);
                frame5 = new JFrame();
                frame5.setSize(400, 300);
                frame5.setLocationRelativeTo(null);
                frame5.setDefaultCloseOperation(
                        JFrame.EXIT_ON_CLOSE);
                frame5.setVisible(true);
                JPanel p2 = new JPanel(new GridLayout(0, 6));
                p2.add(new JLabel("ACCOUNT"));
                p2.add(new JLabel("FIRST NAME"));
                p2.add(new JLabel("MIDDLE "));
                p2.add(new JLabel("LAST "));
                p2.add(new JLabel("DEPOSIT "));
                p2.add(new JLabel(" ADDRESS"));
                int fcounter = 0;
                for (int l1 = 0; l1 < defdc; l1++) {
                    fcounter++;

                    p2.add(new JLabel(" " + ob1[searching(defdcd[l1])].getcode()));
                    p2.add(new JLabel(" " + ob1[searching(defdcd[l1])].getfname().toUpperCase()));
                    p2.add(new JLabel(" " + ob1[searching(defdcd[l1])].getmname().toUpperCase()));
                    p2.add(new JLabel(" " + ob1[searching(defdcd[l1])].getlname().toUpperCase()));
                    p2.add(new JLabel(" " + defltd[l1]));
                    p2.add(new JLabel(" " + ob1[searching(defdcd[l1])].getaddress().toUpperCase()));

                }
                p2.add(new JLabel("ACCOUNT"));
                p2.add(new JLabel("FIRST NAME"));
                p2.add(new JLabel("MIDDLE "));
                p2.add(new JLabel("LAST "));
                p2.add(new JLabel("WITHDRAW "));

                p2.add(new JLabel(" ADDRESS"));
                for (int l1 = 0; l1 < defwc; l1++) {
                    fcounter++;

                    p2.add(new JLabel(" " + ob1[searching(defwcd[l1])].getcode()));
                    p2.add(new JLabel(" " + ob1[searching(defwcd[l1])].getfname().toUpperCase()));
                    p2.add(new JLabel(" " + ob1[searching(defwcd[l1])].getmname().toUpperCase()));
                    p2.add(new JLabel(" " + ob1[searching(defwcd[l1])].getlname().toUpperCase()));
                    p2.add(new JLabel(" " + defltw[l1]));
                    p2.add(new JLabel(" " + ob1[searching(defwcd[l1])].getaddress().toUpperCase()));

                }
                JScrollPane sp1 = new JScrollPane(p2);
                JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                p1.setBackground(Color.LIGHT_GRAY);
                back = new JButton("back");
                back.setFont(ff);
                p1.add(back);
                JPanel p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                p3.setBackground(Color.WHITE);
                p3.add(new JLabel("Total " + fcounter + " Customers"));
                JPanel p4 = new JPanel(new GridLayout(1, 2));
                p4.add(p1);
                p4.add(p3);
                back.addActionListener((ActionEvent e1) -> {
                    frame5.setVisible(false);
                    Manager1.setVisible(true);
                });
                frame5.add(sp1, BorderLayout.CENTER);
                frame5.add(p4, BorderLayout.SOUTH);
                break;
            }
            case 9: {
                 manage++;
                if (manage != 2) {
                    break;
                }
                else
                    manage = 0;
                String fn = JOptionPane.showInputDialog("Enter accountnumber");
                long accnum = Long.parseLong(fn);
                if (searching(accnum) != -1) {
                    String fna = JOptionPane.showInputDialog("Enter First name");
                    String s1 = String.format(fna);
                    JOptionPane.showMessageDialog(null, ob1[searching(accnum)].getfname() + " was changed to " + s1, "First name changer",
                            JOptionPane.PLAIN_MESSAGE);
                    ob1[searching(accnum)].setfname(s1);

                } else {

                    JOptionPane.showMessageDialog(null, "invalid account number", "First name changer",
                            JOptionPane.PLAIN_MESSAGE);

                }
                break;
            }
            case 10: {
                manage++;
                if (manage != 2) {
                    break;
                }
                else
                    manage = 0;
                String fn = JOptionPane.showInputDialog("Enter accountnumber");
                long accnum = Long.parseLong(fn);
                if (searching(accnum) != -1) {
                    String fna = JOptionPane.showInputDialog("Enter middle name");
                    String s1 = String.format(fna);
                    JOptionPane.showMessageDialog(null, ob1[searching(accnum)].getmname() + " was changed to " + s1, "Middle name changer",
                            JOptionPane.PLAIN_MESSAGE);
                    ob1[searching(accnum)].setmname(s1);

                } else {

                    JOptionPane.showMessageDialog(null, "invalid account number", "middlet name changer",
                            JOptionPane.PLAIN_MESSAGE);

                }
                break;
            }
            case 11: {
                manage++;
                if (manage != 2) {
                    break;
                }
                else
                    manage = 0;
                String fn = JOptionPane.showInputDialog("Enter accountnumber");
                long accnum = Long.parseLong(fn);
                if (searching(accnum) != -1) {
                    String fna = JOptionPane.showInputDialog("Enter last name");
                    String s1 = String.format(fna);
                    JOptionPane.showMessageDialog(null, ob1[searching(accnum)].getlname() + " was changed to " + s1, "Last name changer",
                            JOptionPane.PLAIN_MESSAGE);
                    ob1[searching(accnum)].setlname(s1);

                } else {

                    JOptionPane.showMessageDialog(null, "invalid account number", "Last name changer",
                            JOptionPane.PLAIN_MESSAGE);

                }
                break;
            }
            default:
                break;
        }

    }
    public class Bankaccount {

        private String name, fname, mname, lname, addres, sex;
        private double p_transaction, deposit = 0;
        private int age, mobile;
        private long code;

        Bankaccount(int ag, long cd, String add, String f, String m, String l) {
            fname = f;
            lname = l;
            mname = m;
            age = ag;
            code = cd;
            addres = add;
        }

        Bankaccount() {

        }

        void setdata(String sx, int mobcode) {

            mobile = mobcode;
            sex = sx;
        }

        void setname(String name) {

            this.name = name;
        }

        void setfname(String f) {
            fname = f;
        }

        void setlname(String f) {
            lname = f;
        }

        void setmname(String f) {
            mname = f;
        }

        int getmobile() {
            return mobile;
        }

        String getname() {

            return name;
        }

        String getfname() {
            return fname;
        }

        String getmname() {
            return mname;
        }

        String getlname() {
            return lname;
        }

        String getaddress() {
            return addres;
        }

        String getsex() {
            return sex;
        }

        long getcode() {
            return code;
        }

        int getage() {
            return age;
        }

        void deposit(double amount) {
            deposit = deposit + amount;
            p_transaction = amount;
        }

        void withdraw(double amount) {
            deposit = deposit - amount;
            if (deposit < 50) {
                JOptionPane.showMessageDialog(null, "Sorry can not withdrow your balance become below 50", "WARNING", JOptionPane.PLAIN_MESSAGE);
                deposit += amount;
                return;
            }
            p_transaction = -amount;

        }

        double getdeposit() {
            return deposit;

        }

        void getPreviousTransaction() {
            if (p_transaction < 0) {
                JOptionPane.showMessageDialog(null, "Withdraw: " + Math.abs(p_transaction), "Previous Transaction", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "\"No Transaction Occurred", "Previous Transaction", JOptionPane.PLAIN_MESSAGE);
            }
        }

    }

}
