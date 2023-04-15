package librarysystem;

import business.ControllerInterface;
import business.SystemController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;


public class LibrarySystem extends JFrame implements LibWindow {
    ControllerInterface ci = SystemController.getInstance();
    public final static LibrarySystem INSTANCE = new LibrarySystem();
    JPanel mainPanel = new JPanel();
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Menu");
    JMenuItem login = new JMenuItem("Login");
    JMenuItem allBookIds = new JMenuItem("All Book Ids");
    JMenuItem allMemberIds = new JMenuItem("All Member Ids");
    JMenuItem addMember = new JMenuItem("Add library member");
    JMenuItem logout = new JMenuItem("Logout");
    JMenuItem addBookCopy = new JMenuItem("Add Book Copy");
    JMenuItem checkoutBook = new JMenuItem("Checkout Book");

    String pathToImage;
    private boolean isInitialized = false;

    private static LibWindow[] allWindows = {
            LibrarySystem.INSTANCE,
            LoginWindow.INSTANCE,
            AllMemberIdsWindow.INSTANCE,
            AllBookIdsWindow.INSTANCE,
            AddMemberWindow.INSTANCE,
            CheckoutBookWindow.INSTANCE,
            AddBookCopyWindow.INSTANCE
    };

    public static void hideAllWindows() {
        for (LibWindow frame : allWindows) {
            frame.setVisible(false);
        }
    }


    private LibrarySystem() {
    }

    public void init() {
        formatContentPane();
        setPathToImage();
        insertSplashImage();
        createMenus();
        setSize(660, 500);
        isInitialized = true;
    }

    private void formatContentPane() {
        mainPanel.setLayout(new GridLayout(1, 1));
        getContentPane().add(mainPanel);
    }

    private void setPathToImage() {
        String currDirectory = System.getProperty("user.dir");
        pathToImage = currDirectory + "/src/librarysystem/library.jpg";
    }

    private void insertSplashImage() {
        ImageIcon image = new ImageIcon(pathToImage);
        mainPanel.add(new JLabel(image));
    }

    private void createMenus() {
        menuBar.setBorder(BorderFactory.createRaisedBevelBorder());
        addMenu();
        addListeners();
        setJMenuBar(menuBar);
    }

    private void addListeners() {
        login.addActionListener(new LoginListener());
        allBookIds.addActionListener(new AllBookIdsListener());
        allMemberIds.addActionListener(new AllMemberIdsListener());
        logout.addActionListener(e -> logout());
        addMember.addActionListener(e -> addMember());
        checkoutBook.addActionListener(e -> checkoutBook());
        addBookCopy.addActionListener(e -> addBookCopy());
    }

    private void addMenu() {
        menuBar.add(menu);
        menu.add(login);
    }

    public void updateMenu() {
        menu.removeAll();
        System.out.println(SystemController.currentAuth);
        if (SystemController.currentAuth != null) {
            switch (SystemController.currentAuth) {
                case ADMIN: {
                    menu.add(allBookIds);
                    menu.add(allMemberIds);
                    menu.add(addMember);
                    menu.add(addBookCopy);
                    menu.add(logout);
                    break;
                }
                case LIBRARIAN: {
                    menu.add(allBookIds);
                    menu.add(allMemberIds);
                    menu.add(checkoutBook);
                    menu.add(logout);
                    break;
                }
                case BOTH: {
                    menu.add(addMember);
                    menu.add(addBookCopy);
                    menu.add(checkoutBook);
                    menu.add(allBookIds);
                    menu.add(allMemberIds);
                    menu.add(logout);
                    break;
                }
            }
        } else {
            menu.removeAll();
            menu.add(login);
        }
    }


    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            LibrarySystem.hideAllWindows();
            LoginWindow.INSTANCE.init();
            Util.centerFrameOnDesktop(LoginWindow.INSTANCE);
            LoginWindow.INSTANCE.setVisible(true);
        }
    }

    class AllBookIdsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            LibrarySystem.hideAllWindows();
            AllBookIdsWindow.INSTANCE.init();
            List<String> ids = ci.allBookIds();
            Collections.sort(ids);
            StringBuilder sb = new StringBuilder();
            for (String s : ids) {
                sb.append(s + "\n");
            }
            AllBookIdsWindow.INSTANCE.setData(sb.toString());
            AllBookIdsWindow.INSTANCE.pack();
            Util.centerFrameOnDesktop(AllBookIdsWindow.INSTANCE);
            AllBookIdsWindow.INSTANCE.setVisible(true);
        }
    }

    class AllMemberIdsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            LibrarySystem.hideAllWindows();
            AllMemberIdsWindow.INSTANCE.init();
            AllMemberIdsWindow.INSTANCE.pack();
            AllMemberIdsWindow.INSTANCE.setVisible(true);
            LibrarySystem.hideAllWindows();
            AllBookIdsWindow.INSTANCE.init();

            List<String> ids = ci.allMemberIds();
            Collections.sort(ids);
            StringBuilder sb = new StringBuilder();
            for (String s : ids) {
                sb.append(s + "\n");
            }
            AllMemberIdsWindow.INSTANCE.setData(sb.toString());
            AllMemberIdsWindow.INSTANCE.pack();
            Util.centerFrameOnDesktop(AllMemberIdsWindow.INSTANCE);
            AllMemberIdsWindow.INSTANCE.setVisible(true);
        }
    }

    private void addMember() {
        LibrarySystem.hideAllWindows();
        AddMemberWindow.INSTANCE.init();
        AddMemberWindow.INSTANCE.pack();
        Util.centerFrameOnDesktop(AllBookIdsWindow.INSTANCE);
        AddMemberWindow.INSTANCE.setVisible(true);
    }

    private void addBookCopy() {
        LibrarySystem.hideAllWindows();
        AddBookCopyWindow.INSTANCE.init();
        Util.centerFrameOnDesktop(AddBookCopyWindow.INSTANCE);
        AddBookCopyWindow.INSTANCE.setVisible(true);
    }

    private void checkoutBook() {
        LibrarySystem.hideAllWindows();
        CheckoutBookWindow.INSTANCE.init();
        Util.centerFrameOnDesktop(AddBookCopyWindow.INSTANCE);
        CheckoutBookWindow.INSTANCE.setVisible(true);
    }

    public static void backToMain() {
        LibrarySystem.hideAllWindows();
        LibrarySystem.INSTANCE.setVisible(true);
    }

    private void logout() {
        SystemController.currentAuth = null;
        JOptionPane.showMessageDialog(menuBar, "Successfully logout");
        updateMenu();
        LibrarySystem.backToMain();
    }

    @Override
    public boolean isInitialized() {
        return isInitialized;
    }

    @Override
    public void isInitialized(boolean val) {
        isInitialized = val;
    }
}