/*
 * Copyright 2021 minej.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package isekai.studios.unlimited;

/**
 *
 * @author MINEJHAZZ
 */

import java.awt.*;
import java.awt.event.MouseEvent;
import java.lang.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.table.*;

class Employees{
    @SuppressWarnings("FieldMayBeFinal")
    private int Age;
    @SuppressWarnings("FieldMayBeFinal")
    private String FName, MI, LName, Gender, Country, User;
    
    public Employees(String FName, String MI, String LName, int Age,  String Gender, String Country, String User){
        
        this.FName=FName;
        this.MI=MI;
        this.LName=LName;
        this.Age=Age;
        this.Gender=Gender;
        this.Country=Country;
        this.User=User;
    }
    public String getFName(){
        return FName;
    }
    public String getMI(){
        return MI;
    }
    public String getLName(){
        return LName;
    }
    public int getAge(){
        return Age;
    }
    public String getGender(){
        return Gender;
    }
    public String getCountry(){
        return Country;
    }
    public String getUser(){
        return User;
    }
}


// Search Emplyee Class
@SuppressWarnings({"FieldMayBeFinal"})
class SearchEmployees{
    
    private int Age;
    private String FName, MI, LName, Gender, Country, User;
    
    public SearchEmployees(String FName, String MI, String LName, int Age,  String Gender, String Country, String User){
        
        this.FName=FName;
        this.MI=MI;
        this.LName=LName;
        this.Age=Age;
        this.Gender=Gender;
        this.Country=Country;
        this.User=User;
    }
    public String getFName(){
        return FName;
    }
    public String getMI(){
        return MI;
    }
    public String getLName(){
        return LName;
    }
    public int getAge(){
        return Age;
    }
    public String getGender(){
        return Gender;
    }
    public String getCountry(){
        return Country;
    }
    public String getUser(){
        return User;
    }
}

@SuppressWarnings({"FieldMayBeFinal"})
class Animes{
    private String ENTitle, RTitle, AirDate, Stat, Premiered, License, Studio;
    
    public Animes(String ENTitle, String RTitle, String AirDate, String Stat, String Premiered, String License, String Studio){
        
        this.ENTitle=ENTitle;
        this.RTitle=RTitle;
        this.AirDate=AirDate;
        this.Stat=Stat;
        this.Premiered=Premiered;
        this.License=License;
        this.Studio=Studio;
    }
    public String getENTitle(){
        return ENTitle;
    }
    public String getRTitle(){
        return RTitle;
    }
    public String getAirDate(){
        return AirDate;
    }
    public String getStat(){
        return Stat;
    }
    public String getPremiered(){
        return Premiered;
    }
    public String getLicense(){
        return License;
    }
    public String getStudio(){
        return Studio;
    }
}

// Anime Search Class
@SuppressWarnings({"FieldMayBeFinal"})
class SearchAnimes{
    private String ENTitle, RTitle, AirDate, Stat, Premiered, License, Studio;
    
    public SearchAnimes(String ENTitle, String RTitle, String AirDate, String Stat, String Premiered, String License, String Studio){
        
        this.ENTitle=ENTitle;
        this.RTitle=RTitle;
        this.AirDate=AirDate;
        this.Stat=Stat;
        this.Premiered=Premiered;
        this.License=License;
        this.Studio=Studio;
    }
    public String getENTitle(){
        return ENTitle;
    }
    public String getRTitle(){
        return RTitle;
    }
    public String getAirDate(){
        return AirDate;
    }
    public String getStat(){
        return Stat;
    }
    public String getPremiered(){
        return Premiered;
    }
    public String getLicense(){
        return License;
    }
    public String getStudio(){
        return Studio;
    }
}

@SuppressWarnings({"FieldMayBeFinal"})
class Mangas{
    private String ENTitle, RTitle, PubDate, Serial, Stat, License;
    
    public Mangas(String ENTitle, String RTitle, String PubDate, String Serial, String Stat, String License){
        
        this.ENTitle=ENTitle;
        this.RTitle=RTitle;
        this.PubDate=PubDate;
        this.Serial=Serial;
        this.Stat=Stat;
        this.License=License;
    }
    public String getENTitle(){
        return ENTitle;
    }
    public String getRTitle(){
        return RTitle;
    }
    public String getPubDate(){
        return PubDate;
    }
    public String getSerial(){
        return Serial;
    }
    public String getStat(){
        return Stat;
    }
    public String getLicense(){
        return License;
    }
}

//Search Manga class
@SuppressWarnings({"FieldMayBeFinal"})
class SearchMangas{
    private String ENTitle, RTitle, PubDate, Serial, Stat, License;
    
    public SearchMangas(String ENTitle, String RTitle, String PubDate, String Serial, String Stat, String License){
        
        this.ENTitle=ENTitle;
        this.RTitle=RTitle;
        this.PubDate=PubDate;
        this.Serial=Serial;
        this.Stat=Stat;
        this.License=License;
    }
    public String getENTitle(){
        return ENTitle;
    }
    public String getRTitle(){
        return RTitle;
    }
    public String getPubDate(){
        return PubDate;
    }
    public String getSerial(){
        return Serial;
    }
    public String getStat(){
        return Stat;
    }
    public String getLicense(){
        return License;
    }
}

@SuppressWarnings({"FieldMayBeFinal"})
class AdminGetPerm{
    private String AdminPerm;
    
    public AdminGetPerm(String AdminPerm){
        this.AdminPerm=AdminPerm;
    }
    public String getAdminPerm(){
        return AdminPerm;
    }
}


public class MainPanel extends javax.swing.JFrame {
int xMouse, yMouse, DMx, DMy, MTotx, MToty;
int ShowWin = 0;

PreparedStatement ps;
ResultSet rs;
SimpleDateFormat DFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
String CurUser = "";

public String getAniAirDateF(){
    String AirDate2;
    try{
        AirDate2 = DFormat.format(AniDateChooseF.getDate());
    } catch(Exception e) {
        AirDate2 = "Present";
    }
    return AirDate2;
}

public String getSelectedButton(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

private ArrayList<Employees> EmployeeList(){
    ArrayList<Employees> EmployeeList = new ArrayList<>();
    String query = "SELECT `FirstName`, `MiddleI`, `LastName`, `Age`, `Gender`, `Country`, `Username` FROM `Employees` ORDER BY `Employees`.`FirstName` ASC";

    try {
        MainPan.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        MangaB.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        ps = MainPanel.getConnection().prepareStatement(query);
        rs = ps.executeQuery();
        
        Employees Employees;
        while(rs.next()){
            Employees = new Employees(
                    rs.getString("FirstName"), 
                    rs.getString("MiddleI"), 
                    rs.getString("LastName"), 
                    rs.getInt("Age"),
                    rs.getString("Gender"), 
                    rs.getString("Country"), 
                    rs.getString("Username")
            );
            EmployeeList.add(Employees);
        }   
    } catch (SQLException ex) {
        Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
            MainPan.setCursor(Cursor.getDefaultCursor());
            MangaB.setCursor(Cursor.getDefaultCursor());
    }    
        return EmployeeList;
}


//Search Engine for Employees

private ArrayList<SearchEmployees> SearchEmployeeList(String SearchItem){
    ArrayList<SearchEmployees> SearchEmployeeList = new ArrayList<>();
    String query = "SELECT `FirstName`, `MiddleI`, `LastName`, `Age`, `Gender`, `Country`, `Username` FROM `Employees` WHERE 1 AND "
                 + "(FirstName LIKE '%"+SearchItem+"%' OR LastName LIKE '%"+SearchItem+"%') ORDER BY `Employees`.`FirstName` ASC";

    try {
        MainPan.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        MangaB.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        ps = MainPanel.getConnection().prepareStatement(query);
        rs = ps.executeQuery();
        
        SearchEmployees SearchEmployees;
        while(rs.next()){
            SearchEmployees = new SearchEmployees(
                    rs.getString("FirstName"), 
                    rs.getString("MiddleI"), 
                    rs.getString("LastName"), 
                    rs.getInt("Age"),
                    rs.getString("Gender"), 
                    rs.getString("Country"), 
                    rs.getString("Username")
            );
            SearchEmployeeList.add(SearchEmployees);
        }   
    } catch (SQLException ex) {
        Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
            MainPan.setCursor(Cursor.getDefaultCursor());
            MangaB.setCursor(Cursor.getDefaultCursor());
    }    
        return SearchEmployeeList;
}

private ArrayList<Animes> AnimesList(){
    ArrayList<Animes> AnimesList = new ArrayList<>();
    String query = "SELECT * FROM `AnimeList` ORDER BY `AnimeList`.`ENTitle` ASC";

    try {
        MainPan.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        MangaB.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        ps = MainPanel.getConnection().prepareStatement(query);
        rs = ps.executeQuery();
        
        Animes Animes;
        while(rs.next()){
            Animes = new Animes(
                    rs.getString("ENTitle"), 
                    rs.getString("RTitle"), 
                    rs.getString("AirDate"), 
                    rs.getString("Stat"),
                    rs.getString("Premiered"), 
                    rs.getString("License"), 
                    rs.getString("Studio")
            );
            AnimesList.add(Animes);
        }   
    } catch (SQLException ex) {
        Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
            MainPan.setCursor(Cursor.getDefaultCursor());
            MangaB.setCursor(Cursor.getDefaultCursor());
    }    
        return AnimesList;
}

// Search Engine For Anime

private ArrayList<SearchAnimes> SearchAnimesList(String SearchItem){
    ArrayList<SearchAnimes> SearchAnimesList = new ArrayList<>();
    String query = "SELECT * FROM `AnimeList` WHERE 1 AND (ENTitle LIKE '%"+SearchItem+"%' OR RTitle LIKE '%"+SearchItem+"%') ORDER BY `AnimeList`.`ENTitle` ASC";

    try {
        MainPan.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        MangaB.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        ps = MainPanel.getConnection().prepareStatement(query);
        rs = ps.executeQuery();
        
        SearchAnimes SearchAnimes;
        while(rs.next()){
            SearchAnimes = new SearchAnimes(
                    rs.getString("ENTitle"), 
                    rs.getString("RTitle"), 
                    rs.getString("AirDate"), 
                    rs.getString("Stat"),
                    rs.getString("Premiered"), 
                    rs.getString("License"), 
                    rs.getString("Studio")
            );
            SearchAnimesList.add(SearchAnimes);
        }   
    } catch (SQLException ex) {
        Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
            MainPan.setCursor(Cursor.getDefaultCursor());
            MangaB.setCursor(Cursor.getDefaultCursor());
    }    
        return SearchAnimesList;
}

private ArrayList<Mangas> MangasList(){
    ArrayList<Mangas> MangasList = new ArrayList<>();
    String query = "SELECT * FROM `MangaList` ORDER BY `MangaList`.`ENTitle` ASC";

    try {
        MainPan.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        MangaB.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        ps = MainPanel.getConnection().prepareStatement(query);
        rs = ps.executeQuery();
        
        Mangas Mangas;
        while(rs.next()){
            Mangas = new Mangas(
                    rs.getString("ENTitle"), 
                    rs.getString("RTitle"), 
                    rs.getString("PubDate"), 
                    rs.getString("Serial"),
                    rs.getString("Stat"), 
                    rs.getString("License")
            );
            MangasList.add(Mangas);
        }   
    } catch (SQLException ex) {
        Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
            MainPan.setCursor(Cursor.getDefaultCursor());
            MangaB.setCursor(Cursor.getDefaultCursor());
    }    
        return MangasList;
}

//Search For Manga Array

private ArrayList<SearchMangas> SearchMangasList(String SearchItem){
    ArrayList<SearchMangas> SearchMangasList = new ArrayList<>();
    String query = "SELECT * FROM `MangaList` WHERE 1 AND (ENTitle LIKE '%"+SearchItem+"%' OR RTitle LIKE '%"+SearchItem+"%') ORDER BY `MangaList`.`ENTitle` ASC";
    
    try {
        MainPan.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        SearchMangaB.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        ps = MainPanel.getConnection().prepareStatement(query);
        rs = ps.executeQuery();
        
        SearchMangas SearchMangas;
        while(rs.next()){
            SearchMangas = new SearchMangas(
                    rs.getString("ENTitle"), 
                    rs.getString("RTitle"), 
                    rs.getString("PubDate"), 
                    rs.getString("Serial"),
                    rs.getString("Stat"), 
                    rs.getString("License")
            );
            SearchMangasList.add(SearchMangas);
        }   
    } catch (SQLException ex) {
        Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
            MainPan.setCursor(Cursor.getDefaultCursor());
            SearchMangaB.setCursor(Cursor.getDefaultCursor());
    }    
        return SearchMangasList;
}

//Search Engine for Admin Verification

private ArrayList<AdminGetPerm> getAdminPerms(String User){
    @SuppressWarnings("unchecked")
    ArrayList<AdminGetPerm> AdminPerm = new ArrayList();
    String query = "SELECT `Admin` FROM `Employees` WHERE 1 AND (Username LIKE '"+User+"')";
    
    try {
        MainPan.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        MangaB.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        ps = MainPanel.getConnection().prepareStatement(query);
        rs = ps.executeQuery();
        
        AdminGetPerm AdminGetPerm;
        if(rs.next()){
            AdminGetPerm = new AdminGetPerm(rs.getString("Admin"));
            AdminPerm.add(AdminGetPerm);
        }   
    } catch (SQLException ex) {
        Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
            MainPan.setCursor(Cursor.getDefaultCursor());
            MangaB.setCursor(Cursor.getDefaultCursor());
    }
    return AdminPerm;
}

public static Connection getConnection(){
     
        Connection con = null;
        try {
            String url = "jdbc:mysql://remotemysql.com:3306/Kbx8dKGuZG";
            con = DriverManager.getConnection(url,"Kbx8dKGuZG","jD48alsLz6");
            System.out.println("Database Connection Successful");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return con;
    }


    /**
     * Creates new form GUI
     */
    public MainPanel() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.Main.removeAll();
        this.Main.add(Import_Home);
        this.Main.repaint();
        this.Main.revalidate();
        this.revalidate();
    }
    
    // </editor-fold>
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GenderSelect = new javax.swing.ButtonGroup();
        AdminSelect = new javax.swing.ButtonGroup();
        PanelSelect = new javax.swing.ButtonGroup();
        MainPan = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Minimize = new javax.swing.JButton();
        Ext = new javax.swing.JButton();
        CustomBar = new javax.swing.JPanel();
        Sidemenu = new javax.swing.JPanel();
        ButtonsLayout = new javax.swing.JPanel();
        Copyrights = new javax.swing.JLabel();
        LogOut = new javax.swing.JButton();
        MangaB = new javax.swing.JToggleButton();
        AnimeB = new javax.swing.JToggleButton();
        UsersB = new javax.swing.JToggleButton();
        AdminB = new javax.swing.JToggleButton();
        HomeB = new javax.swing.JToggleButton();
        SidePanBack = new javax.swing.JLabel();
        LogoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CompanyName = new javax.swing.JLabel();
        Main = new javax.swing.JLayeredPane();
        Import_Home = new javax.swing.JPanel();
        LogoHome = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CurrentUser = new javax.swing.JLabel();
        Home_Back = new javax.swing.JLabel();
        Import_Employee = new javax.swing.JPanel();
        SearchEmployeePan = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        SearchEmployee = new javax.swing.JTextField();
        SearchEmployeeB = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        User_Table = new javax.swing.JTable();
        Employee_Back = new javax.swing.JLabel();
        Import_Anime = new javax.swing.JPanel();
        AnimeTableLay = new javax.swing.JLayeredPane();
        DisplayAnimeLay = new javax.swing.JPanel();
        SearchAniPan = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        SearchAnime = new javax.swing.JTextField();
        SearchAnimeB = new javax.swing.JButton();
        Add_AnimeB = new javax.swing.JButton();
        DisplayAni = new javax.swing.JScrollPane();
        Anime_Table = new javax.swing.JTable();
        Anime_BackDis = new javax.swing.JLabel();
        AddAniLay = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        AddAniMain = new javax.swing.JLayeredPane();
        AddAniPan = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        AddAENTitle = new javax.swing.JTextField();
        AddARTitle = new javax.swing.JTextField();
        AniDateChooseS = new com.toedter.calendar.JDateChooser();
        AniDateChooseF = new com.toedter.calendar.JDateChooser();
        AddAniConfirm = new javax.swing.JButton();
        AddAniBack = new javax.swing.JButton();
        AddAStat = new javax.swing.JComboBox<>();
        AddAStudio = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AddALicense = new javax.swing.JTextArea();
        AddAniClear = new javax.swing.JButton();
        AddAniFormBack = new javax.swing.JLabel();
        AddAniErr = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        AddAniErrB = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        AddAniSuccess = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        AddAniSucessB = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        Anime_BackAdd = new javax.swing.JLabel();
        Import_Manga = new javax.swing.JPanel();
        MangaTableLay = new javax.swing.JLayeredPane();
        DisplayMangaLay = new javax.swing.JPanel();
        DisplayManga = new javax.swing.JScrollPane();
        Manga_Table = new javax.swing.JTable();
        SearchMangaPan = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        SearchManga = new javax.swing.JTextField();
        SearchMangaB = new javax.swing.JButton();
        Add_MangaB = new javax.swing.JButton();
        Manga_BackDis = new javax.swing.JLabel();
        AddMangaLay = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        AddMangaMain = new javax.swing.JLayeredPane();
        AddMangaPan = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        AddMENTitle = new javax.swing.JTextField();
        AddMRTitle = new javax.swing.JTextField();
        MangaDateChoose = new com.toedter.calendar.JDateChooser();
        AddMangaConfirm = new javax.swing.JButton();
        AddMangaBack = new javax.swing.JButton();
        AddMSerial = new javax.swing.JTextField();
        AddMStat = new javax.swing.JComboBox<>();
        AddMLicense = new javax.swing.JTextField();
        AddMangaClear = new javax.swing.JButton();
        AddMangaFormBack = new javax.swing.JLabel();
        AddMangaErr = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        AddMangaErrB = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        AddMangaSuccess = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        AddMangaSucessB = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        Manga_BackAdd = new javax.swing.JLabel();
        Import_Admin = new javax.swing.JPanel();
        Import_Admin_Auth = new javax.swing.JLayeredPane();
        Import_AdminG = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        AddEmp = new javax.swing.JLayeredPane();
        AddEmploy = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        EntLName = new javax.swing.JTextField();
        EntFName = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        EntAge = new javax.swing.JTextField();
        EntMI = new javax.swing.JTextField();
        EntUser = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        AddEmpB = new javax.swing.JButton();
        SelectMaleEm = new javax.swing.JRadioButton();
        SelectFemEm = new javax.swing.JRadioButton();
        EntCountry = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        SelectFemEm1 = new javax.swing.JRadioButton();
        jLabel34 = new javax.swing.JLabel();
        SelectMaleEm1 = new javax.swing.JRadioButton();
        EntPass = new javax.swing.JPasswordField();
        EntRePass = new javax.swing.JPasswordField();
        ShowPass = new javax.swing.JCheckBox();
        AddEmpErr = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        AddEmpErrB = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        AddMangaSuccess1 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        AddMangaSucessB1 = new javax.swing.JButton();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        Admin_BackG = new javax.swing.JLabel();
        AdminDenied = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        CurrentUserAd = new javax.swing.JLabel();
        Admin_BackD = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        GenderSelect.add(SelectMaleEm);
        GenderSelect.add(SelectFemEm);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        MainPan.setBackground(new Color(0, 0, 0, 0));
        MainPan.setPreferredSize(new java.awt.Dimension(1000, 700));
        MainPan.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                MainPanComponentShown(evt);
            }
        });
        MainPan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setDoubleBuffered(false);
        jPanel1.setOpaque(false);

        Minimize.setBackground(new java.awt.Color(89, 89, 89));
        Minimize.setFont(new java.awt.Font("Wide Latin", 1, 16)); // NOI18N
        Minimize.setForeground(new java.awt.Color(204, 204, 204));
        Minimize.setText("--");
        Minimize.setAlignmentY(0.0F);
        Minimize.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Minimize.setFocusPainted(false);
        Minimize.setFocusable(false);
        Minimize.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Minimize.setIconTextGap(0);
        Minimize.setMaximumSize(new java.awt.Dimension(30, 30));
        Minimize.setMinimumSize(new java.awt.Dimension(30, 30));
        Minimize.setPreferredSize(new java.awt.Dimension(30, 30));
        Minimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinimizeActionPerformed(evt);
            }
        });

        Ext.setBackground(new java.awt.Color(89, 89, 89));
        Ext.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        Ext.setForeground(new java.awt.Color(204, 204, 204));
        Ext.setText("X");
        Ext.setAlignmentY(0.0F);
        Ext.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Ext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Ext.setFocusPainted(false);
        Ext.setFocusable(false);
        Ext.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Ext.setIconTextGap(0);
        Ext.setMaximumSize(new java.awt.Dimension(30, 30));
        Ext.setMinimumSize(new java.awt.Dimension(30, 30));
        Ext.setPreferredSize(new java.awt.Dimension(30, 30));
        Ext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Minimize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Ext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Minimize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Ext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        MainPan.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, -1, -1));

        CustomBar.setBackground(new Color(0, 0, 0, 0));
        CustomBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CustomBar.setAlignmentX(0.0F);
        CustomBar.setAlignmentY(0.0F);
        CustomBar.setPreferredSize(new java.awt.Dimension(857, 35));
        CustomBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                CustomBarMouseDragged(evt);
            }
        });
        CustomBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CustomBarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout CustomBarLayout = new javax.swing.GroupLayout(CustomBar);
        CustomBar.setLayout(CustomBarLayout);
        CustomBarLayout.setHorizontalGroup(
            CustomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 996, Short.MAX_VALUE)
        );
        CustomBarLayout.setVerticalGroup(
            CustomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        MainPan.add(CustomBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 30));

        Sidemenu.setBackground(new java.awt.Color(153, 204, 255));

        ButtonsLayout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Copyrights.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 0, 13)); // NOI18N
        Copyrights.setForeground(new java.awt.Color(51, 51, 51));
        Copyrights.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Copyrights.setText("Feb 2021 || © All Rights Reserved");
        Copyrights.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtonsLayout.add(Copyrights, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 200, 22));
        Copyrights.getAccessibleContext().setAccessibleName("Copyright Message");

        LogOut.setText("Log Out");
        LogOut.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        LogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });
        LogOut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LogOutKeyPressed(evt);
            }
        });
        ButtonsLayout.add(LogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 425, 75, 25));

        PanelSelect.add(MangaB);
        MangaB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Icons/Panel/MangaPanel_200x50.png"))); // NOI18N
        MangaB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MangaB.setFocusable(false);
        MangaB.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Icons/Panel/MangaPanel_Rollover_200x50.png"))); // NOI18N
        MangaB.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Icons/Panel/MangaPanel_Selected_200x50.png"))); // NOI18N
        MangaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MangaBActionPerformed(evt);
            }
        });
        ButtonsLayout.add(MangaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 200, 50));

        PanelSelect.add(AnimeB);
        AnimeB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Icons/Panel/AnimePanel_200x50.png"))); // NOI18N
        AnimeB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AnimeB.setFocusable(false);
        AnimeB.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Icons/Panel/AnimePanel_Rollover_200x50.png"))); // NOI18N
        AnimeB.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Icons/Panel/AnimePanel_Selected_200x50.png"))); // NOI18N
        AnimeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnimeBActionPerformed(evt);
            }
        });
        ButtonsLayout.add(AnimeB, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 200, 50));

        PanelSelect.add(UsersB);
        UsersB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Icons/Panel/EmployeesPanel_200x50.png"))); // NOI18N
        UsersB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UsersB.setFocusable(false);
        UsersB.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Icons/Panel/EmployeesPanel_Rollover_200x50.png"))); // NOI18N
        UsersB.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Icons/Panel/EmployeesPanel_Selected_200x50.png"))); // NOI18N
        UsersB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsersBActionPerformed(evt);
            }
        });
        ButtonsLayout.add(UsersB, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 200, 50));

        PanelSelect.add(AdminB);
        AdminB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Icons/Panel/AdminPanel_200x50.png"))); // NOI18N
        AdminB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AdminB.setFocusable(false);
        AdminB.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Icons/Panel/AdminPanel_Rollover_200x50.png"))); // NOI18N
        AdminB.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Icons/Panel/AdminPanel_Selected_200x50.png"))); // NOI18N
        AdminB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminBActionPerformed(evt);
            }
        });
        ButtonsLayout.add(AdminB, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 200, 50));

        PanelSelect.add(HomeB);
        HomeB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Icons/Panel/HomePanel_200x50.png"))); // NOI18N
        HomeB.setSelected(true);
        HomeB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HomeB.setFocusable(false);
        HomeB.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Icons/Panel/HomePanel_Rollover_200x50.png"))); // NOI18N
        HomeB.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Icons/Panel/HomePanel_Selected_200x50.png"))); // NOI18N
        HomeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeBActionPerformed(evt);
            }
        });
        ButtonsLayout.add(HomeB, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 200, 50));

        SidePanBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Background/SidePanel_Background.png"))); // NOI18N
        SidePanBack.setText("jLabel56");
        ButtonsLayout.add(SidePanBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, -1));

        LogoPanel.setBackground(new java.awt.Color(242, 243, 243));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Icons/Logo/ISU Logo 170x170.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        CompanyName.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 1, 16)); // NOI18N
        CompanyName.setForeground(new java.awt.Color(242, 94, 15));
        CompanyName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CompanyName.setText("Isekai Studios Unlimited");
        CompanyName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout LogoPanelLayout = new javax.swing.GroupLayout(LogoPanel);
        LogoPanel.setLayout(LogoPanelLayout);
        LogoPanelLayout.setHorizontalGroup(
            LogoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoPanelLayout.createSequentialGroup()
                .addGroup(LogoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LogoPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LogoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LogoPanelLayout.setVerticalGroup(
            LogoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(CompanyName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SidemenuLayout = new javax.swing.GroupLayout(Sidemenu);
        Sidemenu.setLayout(SidemenuLayout);
        SidemenuLayout.setHorizontalGroup(
            SidemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidemenuLayout.createSequentialGroup()
                .addGroup(SidemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LogoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonsLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        SidemenuLayout.setVerticalGroup(
            SidemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidemenuLayout.createSequentialGroup()
                .addComponent(LogoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ButtonsLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        MainPan.add(Sidemenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 700));

        Main.setLayout(new java.awt.CardLayout());

        Import_Home.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Icons/Logo/ISU Logo 270x270.png"))); // NOI18N

        javax.swing.GroupLayout LogoHomeLayout = new javax.swing.GroupLayout(LogoHome);
        LogoHome.setLayout(LogoHomeLayout);
        LogoHomeLayout.setHorizontalGroup(
            LogoHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        LogoHomeLayout.setVerticalGroup(
            LogoHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Import_Home.add(LogoHome);
        LogoHome.setBounds(260, 41, 270, 270);

        jLabel3.setFont(new java.awt.Font("000 Elephantmen TB", 0, 36)); // NOI18N
        jLabel3.setText("Employee Portal");
        Import_Home.add(jLabel3);
        jLabel3.setBounds(290, 454, 220, 53);

        jLabel4.setFont(new java.awt.Font("000 Elephantmen TB", 0, 36)); // NOI18N
        jLabel4.setText("Isekai Studios Unlimited");
        Import_Home.add(jLabel4);
        jLabel4.setBounds(238, 395, 323, 53);

        jLabel5.setFont(new java.awt.Font("000 Elephantmen TB", 0, 36)); // NOI18N
        jLabel5.setText("Welcome To");
        Import_Home.add(jLabel5);
        jLabel5.setBounds(317, 336, 170, 53);

        jLabel6.setFont(new java.awt.Font("000 Felt [TeddyBear]", 0, 24)); // NOI18N
        jLabel6.setText("Currently Logged in as:");
        Import_Home.add(jLabel6);
        jLabel6.setBounds(301, 592, 197, 27);

        CurrentUser.setFont(new java.awt.Font("000 Felt [TeddyBear]", 0, 24)); // NOI18N
        CurrentUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CurrentUser.setText("Loading Name...");
        CurrentUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Import_Home.add(CurrentUser);
        CurrentUser.setBounds(0, 625, 800, 35);

        Home_Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Background/Home_Darker_800x700.png"))); // NOI18N
        Import_Home.add(Home_Back);
        Home_Back.setBounds(0, 0, 800, 700);

        Main.add(Import_Home, "card3");

        Import_Employee.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SearchEmployeePan.setBackground(new java.awt.Color(204, 255, 153));
        SearchEmployeePan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 1, 15)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Search  For Employee:");

        SearchEmployee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchEmployeeKeyPressed(evt);
            }
        });

        SearchEmployeeB.setText("Search");
        SearchEmployeeB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SearchEmployeeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchEmployeeBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SearchEmployeePanLayout = new javax.swing.GroupLayout(SearchEmployeePan);
        SearchEmployeePan.setLayout(SearchEmployeePanLayout);
        SearchEmployeePanLayout.setHorizontalGroup(
            SearchEmployeePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SearchEmployeePanLayout.createSequentialGroup()
                .addGroup(SearchEmployeePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SearchEmployeePanLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(SearchEmployeeB))
                    .addGroup(SearchEmployeePanLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(SearchEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        SearchEmployeePanLayout.setVerticalGroup(
            SearchEmployeePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchEmployeePanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SearchEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(SearchEmployeeB)
                .addContainerGap())
        );

        Import_Employee.add(SearchEmployeePan, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 42, -1, -1));

        User_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Middle Initial", "Last Name", "Age", "Gender", "Country", "Username"
            }
        ));
        User_Table.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        User_Table.setShowGrid(true);
        User_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                User_TableMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(User_Table);

        Import_Employee.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 164, 788, 529));

        Employee_Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Background/Employees_800x700.png"))); // NOI18N
        Import_Employee.add(Employee_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Main.add(Import_Employee, "card2");

        Import_Anime.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AnimeTableLay.setLayout(new java.awt.CardLayout());

        DisplayAnimeLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SearchAniPan.setBackground(new java.awt.Color(204, 255, 153));
        SearchAniPan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 1, 15)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Search Anime By Name:");

        SearchAnime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchAnimeKeyPressed(evt);
            }
        });

        SearchAnimeB.setText("Search");
        SearchAnimeB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SearchAnimeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchAnimeBActionPerformed(evt);
            }
        });
        SearchAnimeB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchAnimeBKeyPressed(evt);
            }
        });

        Add_AnimeB.setBackground(SearchAniPan.getBackground());
        Add_AnimeB.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        Add_AnimeB.setForeground(new java.awt.Color(51, 102, 255));
        Add_AnimeB.setText("Add More Anime");
        Add_AnimeB.setBorder(null);
        Add_AnimeB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Add_AnimeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_AnimeBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SearchAniPanLayout = new javax.swing.GroupLayout(SearchAniPan);
        SearchAniPan.setLayout(SearchAniPanLayout);
        SearchAniPanLayout.setHorizontalGroup(
            SearchAniPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchAniPanLayout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(SearchAnimeB)
                .addGap(33, 33, 33)
                .addComponent(Add_AnimeB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SearchAniPanLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(SearchAnime, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        SearchAniPanLayout.setVerticalGroup(
            SearchAniPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchAniPanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SearchAnime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(SearchAniPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SearchAniPanLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(SearchAnimeB)
                        .addContainerGap())
                    .addGroup(SearchAniPanLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(Add_AnimeB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        DisplayAnimeLay.add(SearchAniPan, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 42, -1, -1));

        Anime_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "English Title", "Romanization", "Date Aired", "Status", "Premiered", "Licensors:", "Studio"
            }
        ));
        Anime_Table.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        Anime_Table.setShowGrid(true);
        Anime_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Anime_TableMouseEntered(evt);
            }
        });
        DisplayAni.setViewportView(Anime_Table);

        DisplayAnimeLay.add(DisplayAni, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 164, 788, 530));

        Anime_BackDis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Background/Anime_800x700.png"))); // NOI18N
        DisplayAnimeLay.add(Anime_BackDis, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        AnimeTableLay.add(DisplayAnimeLay, "card3");

        AddAniLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("000 ImaginaryFriend BB [TeddyBe", 1, 36)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Add More Anime To The Database");
        AddAniLay.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 43, 800, -1));

        AddAniMain.setLayout(new java.awt.CardLayout());

        AddAniPan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 0, 20)); // NOI18N
        jLabel41.setText("English Title:");
        AddAniPan.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 55, 130, -1));

        jLabel43.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 0, 20)); // NOI18N
        jLabel43.setText("Romanized Title:");
        AddAniPan.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 124, 160, -1));

        jLabel44.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 0, 20)); // NOI18N
        jLabel44.setText("Air Date:");
        AddAniPan.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 193, 80, -1));

        jLabel45.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 0, 20)); // NOI18N
        jLabel45.setText("Licensed by:");
        AddAniPan.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 348, 120, -1));

        jLabel46.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 0, 20)); // NOI18N
        jLabel46.setText("Status:");
        AddAniPan.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 261, 70, -1));

        jLabel47.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 0, 20)); // NOI18N
        jLabel47.setText("Studio:");
        AddAniPan.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 442, 70, -1));

        AddAENTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddAENTitleKeyPressed(evt);
            }
        });
        AddAniPan.add(AddAENTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 60, 234, -1));

        AddARTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddARTitleKeyPressed(evt);
            }
        });
        AddAniPan.add(AddARTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 129, 234, -1));
        AddAniPan.add(AniDateChooseS, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 197, 104, -1));
        AddAniPan.add(AniDateChooseF, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 197, 104, -1));

        AddAniConfirm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AddAniConfirm.setText("Confirm");
        AddAniConfirm.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddAniConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAniConfirmActionPerformed(evt);
            }
        });
        AddAniConfirm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddAniConfirmKeyPressed(evt);
            }
        });
        AddAniPan.add(AddAniConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, 80, -1));

        AddAniBack.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        AddAniBack.setText("Back");
        AddAniBack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddAniBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAniBackActionPerformed(evt);
            }
        });
        AddAniBack.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddAniBackKeyPressed(evt);
            }
        });
        AddAniPan.add(AddAniBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 500, 60, -1));

        AddAStat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddAStat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=Select Current Status=", "Finished Airing", "Currently Airing" }));
        AddAniPan.add(AddAStat, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 266, 234, -1));

        AddAStudio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddAStudioKeyPressed(evt);
            }
        });
        AddAniPan.add(AddAStudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 442, 234, -1));

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel55.setText("to");
        AddAniPan.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 199, -1, -1));

        AddALicense.setColumns(20);
        AddALicense.setLineWrap(true);
        AddALicense.setRows(3);
        AddALicense.setToolTipText("");
        AddALicense.setWrapStyleWord(true);
        jScrollPane1.setViewportView(AddALicense);

        AddAniPan.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 330, -1, 70));

        AddAniClear.setText("Clear All");
        AddAniClear.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddAniClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAniClearActionPerformed(evt);
            }
        });
        AddAniClear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddAniClearKeyPressed(evt);
            }
        });
        AddAniPan.add(AddAniClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 500, 80, -1));

        AddAniFormBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Background/FormBackground_600x560.png"))); // NOI18N
        AddAniPan.add(AddAniFormBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        AddAniMain.add(AddAniPan, "card2");

        AddAniErr.setBackground(new Color(0, 0, 0, 0));

        jPanel9.setBackground(new java.awt.Color(76, 76, 76));

        jLabel48.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 0, 0));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Please make sure you have");

        AddAniErrB.setBackground(new java.awt.Color(114, 114, 114));
        AddAniErrB.setForeground(new java.awt.Color(255, 255, 255));
        AddAniErrB.setText("Ok");
        AddAniErrB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddAniErrB.setSelected(true);
        AddAniErrB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAniErrBActionPerformed(evt);
            }
        });
        AddAniErrB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddAniErrBKeyPressed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Arial Black", 0, 30)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 0, 0));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("‼ ERROR ‼");

        jLabel50.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 0, 0));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("and try again.");

        jLabel51.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 0, 0));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("properly filled out every field");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(AddAniErrB, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel49)
                .addGap(34, 34, 34)
                .addComponent(jLabel48)
                .addGap(0, 0, 0)
                .addComponent(jLabel51)
                .addGap(0, 0, 0)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(AddAniErrB)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AddAniErrLayout = new javax.swing.GroupLayout(AddAniErr);
        AddAniErr.setLayout(AddAniErrLayout);
        AddAniErrLayout.setHorizontalGroup(
            AddAniErrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddAniErrLayout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        AddAniErrLayout.setVerticalGroup(
            AddAniErrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddAniErrLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        AddAniMain.add(AddAniErr, "card3");

        AddAniSuccess.setBackground(new Color(0, 0, 0, 0));

        jPanel10.setBackground(new java.awt.Color(76, 76, 76));

        jLabel52.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(102, 255, 51));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("The anime was successfully ");

        AddAniSucessB.setBackground(new java.awt.Color(114, 114, 114));
        AddAniSucessB.setForeground(new java.awt.Color(255, 255, 255));
        AddAniSucessB.setText("Ok");
        AddAniSucessB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddAniSucessB.setSelected(true);
        AddAniSucessB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAniSucessBActionPerformed(evt);
            }
        });
        AddAniSucessB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddAniSucessBKeyPressed(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(51, 255, 0));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("SUCCESS!!");

        jLabel54.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(102, 255, 51));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("to the database.");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
            .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(AddAniSucessB, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel53)
                .addGap(18, 18, 18)
                .addComponent(jLabel52)
                .addGap(0, 0, 0)
                .addComponent(jLabel54)
                .addGap(35, 35, 35)
                .addComponent(AddAniSucessB)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AddAniSuccessLayout = new javax.swing.GroupLayout(AddAniSuccess);
        AddAniSuccess.setLayout(AddAniSuccessLayout);
        AddAniSuccessLayout.setHorizontalGroup(
            AddAniSuccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddAniSuccessLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        AddAniSuccessLayout.setVerticalGroup(
            AddAniSuccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddAniSuccessLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );

        AddAniMain.add(AddAniSuccess, "card3");

        AddAniLay.add(AddAniMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 121, -1, -1));

        Anime_BackAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Background/Anime_800x700.png"))); // NOI18N
        AddAniLay.add(Anime_BackAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        AnimeTableLay.add(AddAniLay, "card3");

        Import_Anime.add(AnimeTableLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Main.add(Import_Anime, "card2");

        Import_Manga.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MangaTableLay.setLayout(new java.awt.CardLayout());

        DisplayMangaLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Manga_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "English Title", "Romanji Title", "Published", "Serialization", "Status", "License Holder"
            }
        ));
        Manga_Table.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        Manga_Table.setShowGrid(true);
        Manga_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Manga_TableMouseEntered(evt);
            }
        });
        DisplayManga.setViewportView(Manga_Table);

        DisplayMangaLay.add(DisplayManga, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 164, 788, 530));

        SearchMangaPan.setBackground(new java.awt.Color(204, 255, 153));
        SearchMangaPan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 1, 15)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Search Manga By Name:");

        SearchManga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchMangaKeyPressed(evt);
            }
        });

        SearchMangaB.setText("Search");
        SearchMangaB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SearchMangaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchMangaBActionPerformed(evt);
            }
        });
        SearchMangaB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchMangaBKeyPressed(evt);
            }
        });

        Add_MangaB.setBackground(SearchMangaPan.getBackground());
        Add_MangaB.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        Add_MangaB.setForeground(new java.awt.Color(51, 102, 255));
        Add_MangaB.setText("Add More Manga");
        Add_MangaB.setBorder(null);
        Add_MangaB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Add_MangaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_MangaBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SearchMangaPanLayout = new javax.swing.GroupLayout(SearchMangaPan);
        SearchMangaPan.setLayout(SearchMangaPanLayout);
        SearchMangaPanLayout.setHorizontalGroup(
            SearchMangaPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchMangaPanLayout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(SearchMangaB)
                .addGap(33, 33, 33)
                .addComponent(Add_MangaB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SearchMangaPanLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(SearchManga, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        SearchMangaPanLayout.setVerticalGroup(
            SearchMangaPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchMangaPanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SearchManga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(SearchMangaPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SearchMangaPanLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(SearchMangaB)
                        .addContainerGap())
                    .addGroup(SearchMangaPanLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(Add_MangaB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        DisplayMangaLay.add(SearchMangaPan, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 42, -1, -1));

        Manga_BackDis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Background/Manga_800x700.png"))); // NOI18N
        DisplayMangaLay.add(Manga_BackDis, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        MangaTableLay.add(DisplayMangaLay, "card3");

        AddMangaLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("000 ImaginaryFriend BB [TeddyBe", 1, 36)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Add More Manga To The Database");
        AddMangaLay.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 800, -1));

        AddMangaMain.setLayout(new java.awt.CardLayout());

        AddMangaPan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 0, 20)); // NOI18N
        jLabel16.setText("English Title:");
        AddMangaPan.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 64, 120, -1));

        jLabel17.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 0, 20)); // NOI18N
        jLabel17.setText("Romanized Title:");
        AddMangaPan.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 135, 160, -1));

        jLabel18.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 0, 20)); // NOI18N
        jLabel18.setText("Publish Date:");
        AddMangaPan.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 206, 130, -1));

        jLabel19.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 0, 20)); // NOI18N
        jLabel19.setText("Serial:");
        AddMangaPan.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 349, 70, -1));

        jLabel21.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 0, 20)); // NOI18N
        jLabel21.setText("Status:");
        AddMangaPan.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 277, 70, -1));

        jLabel20.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 0, 20)); // NOI18N
        jLabel20.setText("Licensed by:");
        AddMangaPan.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 421, 130, -1));

        AddMENTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddMENTitleKeyPressed(evt);
            }
        });
        AddMangaPan.add(AddMENTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 69, 200, -1));

        AddMRTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddMRTitleKeyPressed(evt);
            }
        });
        AddMangaPan.add(AddMRTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 140, 200, -1));
        AddMangaPan.add(MangaDateChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 210, 200, -1));

        AddMangaConfirm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AddMangaConfirm.setText("Confirm");
        AddMangaConfirm.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddMangaConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMangaConfirmActionPerformed(evt);
            }
        });
        AddMangaConfirm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddMangaConfirmKeyPressed(evt);
            }
        });
        AddMangaPan.add(AddMangaConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 500, 79, -1));

        AddMangaBack.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        AddMangaBack.setText("Back");
        AddMangaBack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddMangaBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMangaBackActionPerformed(evt);
            }
        });
        AddMangaBack.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddMangaBackKeyPressed(evt);
            }
        });
        AddMangaPan.add(AddMangaBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 502, 70, -1));

        AddMSerial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddMSerialKeyPressed(evt);
            }
        });
        AddMangaPan.add(AddMSerial, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 354, 200, -1));

        AddMStat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddMStat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=Select Current Status=", "Publishing", "Finished" }));
        AddMangaPan.add(AddMStat, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 282, 200, -1));

        AddMLicense.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddMLicenseKeyPressed(evt);
            }
        });
        AddMangaPan.add(AddMLicense, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 421, 200, -1));

        AddMangaClear.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        AddMangaClear.setText("Clear All");
        AddMangaClear.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddMangaClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMangaClearActionPerformed(evt);
            }
        });
        AddMangaClear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddMangaClearKeyPressed(evt);
            }
        });
        AddMangaPan.add(AddMangaClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 502, 78, -1));

        AddMangaFormBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Background/FormBackground_600x560.png"))); // NOI18N
        AddMangaPan.add(AddMangaFormBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        AddMangaMain.add(AddMangaPan, "card2");

        AddMangaErr.setBackground(new Color(0, 0, 0, 0));

        jPanel7.setBackground(new java.awt.Color(76, 76, 76));

        jLabel35.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 0, 0));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Please make sure you have");

        AddMangaErrB.setBackground(new java.awt.Color(114, 114, 114));
        AddMangaErrB.setForeground(new java.awt.Color(255, 255, 255));
        AddMangaErrB.setText("Ok");
        AddMangaErrB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddMangaErrB.setSelected(true);
        AddMangaErrB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMangaErrBActionPerformed(evt);
            }
        });
        AddMangaErrB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddMangaErrBKeyPressed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Arial Black", 0, 30)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 0, 0));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("‼ ERROR ‼");

        jLabel37.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 0, 0));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("and try again.");

        jLabel38.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 0, 0));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("properly filled out every field");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(AddMangaErrB, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel36)
                .addGap(34, 34, 34)
                .addComponent(jLabel35)
                .addGap(0, 0, 0)
                .addComponent(jLabel38)
                .addGap(0, 0, 0)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(AddMangaErrB)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AddMangaErrLayout = new javax.swing.GroupLayout(AddMangaErr);
        AddMangaErr.setLayout(AddMangaErrLayout);
        AddMangaErrLayout.setHorizontalGroup(
            AddMangaErrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddMangaErrLayout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        AddMangaErrLayout.setVerticalGroup(
            AddMangaErrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddMangaErrLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        AddMangaMain.add(AddMangaErr, "card3");

        AddMangaSuccess.setBackground(new Color(0, 0, 0, 0));

        jPanel8.setBackground(new java.awt.Color(76, 76, 76));

        jLabel39.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(102, 255, 51));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("The manga was successfully ");

        AddMangaSucessB.setBackground(new java.awt.Color(114, 114, 114));
        AddMangaSucessB.setForeground(new java.awt.Color(255, 255, 255));
        AddMangaSucessB.setText("Ok");
        AddMangaSucessB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddMangaSucessB.setSelected(true);
        AddMangaSucessB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMangaSucessBActionPerformed(evt);
            }
        });
        AddMangaSucessB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddMangaSucessBKeyPressed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(51, 255, 0));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("SUCCESS!!");

        jLabel42.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(102, 255, 51));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("to the database.");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
            .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(AddMangaSucessB, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel40)
                .addGap(18, 18, 18)
                .addComponent(jLabel39)
                .addGap(0, 0, 0)
                .addComponent(jLabel42)
                .addGap(35, 35, 35)
                .addComponent(AddMangaSucessB)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AddMangaSuccessLayout = new javax.swing.GroupLayout(AddMangaSuccess);
        AddMangaSuccess.setLayout(AddMangaSuccessLayout);
        AddMangaSuccessLayout.setHorizontalGroup(
            AddMangaSuccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddMangaSuccessLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        AddMangaSuccessLayout.setVerticalGroup(
            AddMangaSuccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddMangaSuccessLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );

        AddMangaMain.add(AddMangaSuccess, "card3");

        AddMangaLay.add(AddMangaMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        Manga_BackAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Background/Manga_800x700.png"))); // NOI18N
        AddMangaLay.add(Manga_BackAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        MangaTableLay.add(AddMangaLay, "card3");

        Import_Manga.add(MangaTableLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Main.add(Import_Manga, "card2");

        Import_Admin_Auth.setLayout(new java.awt.CardLayout());

        Import_AdminG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("000 Elephantmen TB", 0, 45)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Admin Control Panel");
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel22.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Import_AdminG.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 84, 800, 55));

        jLabel23.setFont(new java.awt.Font("000 Elephantmen TB", 0, 45)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Welcome To The");
        jLabel23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel23.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Import_AdminG.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 29, 800, 55));

        AddEmp.setLayout(new java.awt.CardLayout());

        AddEmploy.setBackground(new java.awt.Color(255, 204, 102));

        jLabel24.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 0, 15)); // NOI18N
        jLabel24.setText("Employees First Name:");

        EntLName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EntLNameKeyPressed(evt);
            }
        });

        EntFName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EntFNameKeyPressed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 0, 15)); // NOI18N
        jLabel25.setText("Employees Last Name:");

        jLabel26.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 0, 15)); // NOI18N
        jLabel26.setText("Middle Initial:");

        jLabel27.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 0, 15)); // NOI18N
        jLabel27.setText("Age:");

        jLabel28.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 0, 15)); // NOI18N
        jLabel28.setText("Gender:");

        jLabel29.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 0, 15)); // NOI18N
        jLabel29.setText("Country:");

        jLabel30.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 0, 15)); // NOI18N
        jLabel30.setText("Password:");

        jLabel31.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 0, 15)); // NOI18N
        jLabel31.setText("Username:");

        EntMI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EntMIKeyPressed(evt);
            }
        });

        EntUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EntUserKeyPressed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("000 ImaginaryFriend BB [TeddyBe", 1, 24)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Add Employee");

        AddEmpB.setFont(new java.awt.Font("Fawn Script 2", 0, 18)); // NOI18N
        AddEmpB.setText("Confirm");
        AddEmpB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddEmpB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddEmpB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddEmpBActionPerformed(evt);
            }
        });
        AddEmpB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddEmpBKeyPressed(evt);
            }
        });

        SelectMaleEm.setBackground(AddEmploy.getBackground());
        GenderSelect.add(SelectMaleEm);
        SelectMaleEm.setText("Male");
        SelectMaleEm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        SelectFemEm.setBackground(AddEmploy.getBackground());
        GenderSelect.add(SelectFemEm);
        SelectFemEm.setText("Female");
        SelectFemEm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        EntCountry.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EntCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=Select Your Country=", "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua & Deps", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Central African Rep", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Congo {Democratic Rep}", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland {Republic}", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea North", "Korea South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar, {Burma}", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russian Federation", "Rwanda", "St Kitts & Nevis", "St Lucia", "Saint Vincent & the Grenadines", "Samoa", "San Marino", "Sao Tome & Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe" }));
        EntCountry.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel33.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 1, 14)); // NOI18N
        jLabel33.setText("Re-Type password:");

        SelectFemEm1.setBackground(AddEmploy.getBackground());
        AdminSelect.add(SelectFemEm1);
        SelectFemEm1.setText("No");
        SelectFemEm1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel34.setFont(new java.awt.Font("000 CCDigitalDelivery [TeddyBea", 0, 15)); // NOI18N
        jLabel34.setText("Admin permission:");

        SelectMaleEm1.setBackground(AddEmploy.getBackground());
        AdminSelect.add(SelectMaleEm1);
        SelectMaleEm1.setText("Yes");
        SelectMaleEm1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        ShowPass.setBackground(AddEmploy.getBackground());
        ShowPass.setText("Show");
        ShowPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ShowPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ShowPassMousePressed(evt);
            }
        });
        ShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddEmployLayout = new javax.swing.GroupLayout(AddEmploy);
        AddEmploy.setLayout(AddEmployLayout);
        AddEmployLayout.setHorizontalGroup(
            AddEmployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddEmployLayout.createSequentialGroup()
                .addGroup(AddEmployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AddEmployLayout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(AddEmpB, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(AddEmployLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(AddEmployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AddEmployLayout.createSequentialGroup()
                                .addGroup(AddEmployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel28))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                                .addGroup(AddEmployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(EntFName, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(EntMI, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EntAge, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(AddEmployLayout.createSequentialGroup()
                                        .addComponent(SelectMaleEm, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SelectFemEm, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(EntLName)
                                    .addComponent(EntCountry, 0, 1, Short.MAX_VALUE)))
                            .addGroup(AddEmployLayout.createSequentialGroup()
                                .addGroup(AddEmployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel34))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(AddEmployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(AddEmployLayout.createSequentialGroup()
                                        .addComponent(SelectMaleEm1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(SelectFemEm1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(EntUser, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(EntPass)
                                    .addComponent(EntRePass))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ShowPass)
                .addGap(16, 16, 16))
        );
        AddEmployLayout.setVerticalGroup(
            AddEmployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddEmployLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel32)
                .addGap(19, 19, 19)
                .addGroup(AddEmployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(EntFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AddEmployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(EntLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AddEmployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(EntMI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AddEmployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(EntAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AddEmployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(SelectMaleEm)
                    .addComponent(SelectFemEm))
                .addGap(18, 18, 18)
                .addGroup(AddEmployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(EntCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AddEmployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(EntUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AddEmployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(EntPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AddEmployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(EntRePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ShowPass))
                .addGap(18, 18, 18)
                .addGroup(AddEmployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(SelectMaleEm1)
                    .addComponent(SelectFemEm1))
                .addGap(24, 24, 24)
                .addComponent(AddEmpB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        AddEmp.add(AddEmploy, "card2");

        AddEmpErr.setBackground(new Color(0, 0, 0, 0));

        jPanel4.setBackground(new java.awt.Color(76, 76, 76));

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Please make sure you have");

        AddEmpErrB.setBackground(new java.awt.Color(114, 114, 114));
        AddEmpErrB.setForeground(new java.awt.Color(255, 255, 255));
        AddEmpErrB.setText("Ok");
        AddEmpErrB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddEmpErrB.setSelected(true);
        AddEmpErrB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddEmpErrBActionPerformed(evt);
            }
        });
        AddEmpErrB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddEmpErrBKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("‼ ERROR ‼");

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("and try again.");

        jLabel13.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("properly filled out every field");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(AddEmpErrB, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel8)
                .addGap(34, 34, 34)
                .addComponent(jLabel7)
                .addGap(0, 0, 0)
                .addComponent(jLabel13)
                .addGap(0, 0, 0)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(AddEmpErrB)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout AddEmpErrLayout = new javax.swing.GroupLayout(AddEmpErr);
        AddEmpErr.setLayout(AddEmpErrLayout);
        AddEmpErrLayout.setHorizontalGroup(
            AddEmpErrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddEmpErrLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        AddEmpErrLayout.setVerticalGroup(
            AddEmpErrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddEmpErrLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );

        AddEmp.add(AddEmpErr, "card3");

        AddMangaSuccess1.setBackground(new Color(0, 0, 0, 0));

        jPanel12.setBackground(new java.awt.Color(76, 76, 76));

        jLabel56.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(102, 255, 51));
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("The new employee has");

        AddMangaSucessB1.setBackground(new java.awt.Color(114, 114, 114));
        AddMangaSucessB1.setForeground(new java.awt.Color(255, 255, 255));
        AddMangaSucessB1.setText("Ok");
        AddMangaSucessB1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddMangaSucessB1.setSelected(true);
        AddMangaSucessB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMangaSucessB1ActionPerformed(evt);
            }
        });
        AddMangaSucessB1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddMangaSucessB1KeyPressed(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(51, 255, 0));
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("SUCCESS!!");

        jLabel64.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(102, 255, 51));
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText(" added to the database.");

        jLabel65.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(102, 255, 51));
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("been successfuly added");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(AddMangaSucessB1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
            .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel63)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel56)
                .addGap(0, 0, 0)
                .addComponent(jLabel65)
                .addGap(0, 0, 0)
                .addComponent(jLabel64)
                .addGap(18, 20, Short.MAX_VALUE)
                .addComponent(AddMangaSucessB1)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout AddMangaSuccess1Layout = new javax.swing.GroupLayout(AddMangaSuccess1);
        AddMangaSuccess1.setLayout(AddMangaSuccess1Layout);
        AddMangaSuccess1Layout.setHorizontalGroup(
            AddMangaSuccess1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddMangaSuccess1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        AddMangaSuccess1Layout.setVerticalGroup(
            AddMangaSuccess1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddMangaSuccess1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );

        AddEmp.add(AddMangaSuccess1, "card3");

        Import_AdminG.add(AddEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 167, -1, -1));

        Admin_BackG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Background/Admin_800x700.png"))); // NOI18N
        Import_AdminG.add(Admin_BackG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Import_Admin_Auth.add(Import_AdminG, "card6");

        AdminDenied.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(76, 76, 76));

        jLabel57.setFont(new java.awt.Font("Arial Black", 0, 38)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 0, 0));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("‼ ACCESS DENIED ‼");

        jLabel58.setFont(new java.awt.Font("Arial Black", 0, 22)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 0, 0));
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("permissions.");

        jLabel59.setFont(new java.awt.Font("Arial Black", 0, 22)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 0, 0));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("does not have administrative");

        jLabel60.setFont(new java.awt.Font("Arial Black", 0, 22)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 0, 0));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("Login using an account that");

        jLabel61.setFont(new java.awt.Font("Arial Black", 0, 22)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 0, 0));
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("has administrative rights");

        jLabel62.setFont(new java.awt.Font("Arial Black", 0, 22)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 0, 0));
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("to access this panel.");

        CurrentUserAd.setFont(new java.awt.Font("Arial Black", 0, 22)); // NOI18N
        CurrentUserAd.setForeground(new java.awt.Color(255, 0, 0));
        CurrentUserAd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CurrentUserAd.setText("==");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CurrentUserAd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(CurrentUserAd)
                .addGap(0, 0, 0)
                .addComponent(jLabel59)
                .addGap(0, 0, 0)
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        AdminDenied.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 165, -1, -1));

        Admin_BackD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Background/Admin_800x700.png"))); // NOI18N
        AdminDenied.add(Admin_BackD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Import_Admin_Auth.add(AdminDenied, "card3");

        javax.swing.GroupLayout Import_AdminLayout = new javax.swing.GroupLayout(Import_Admin);
        Import_Admin.setLayout(Import_AdminLayout);
        Import_AdminLayout.setHorizontalGroup(
            Import_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Import_Admin_Auth)
        );
        Import_AdminLayout.setVerticalGroup(
            Import_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Import_Admin_Auth)
        );

        Main.add(Import_Admin, "card7");

        MainPan.add(Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 800, 700));

        Background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Images/Background/BackgroundResizedDarken.png"))); // NOI18N
        Background.setAlignmentY(0.0F);
        Background.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Background.setIconTextGap(0);
        Background.setRequestFocusEnabled(false);
        this.pack();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ExtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExtActionPerformed
        new ConfirmExt().setVisible(true);
    }//GEN-LAST:event_ExtActionPerformed

    private void MinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinimizeActionPerformed
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_MinimizeActionPerformed

    private void CustomBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomBarMouseDragged
        /*if (getExtendedState() == JFrame.MAXIMIZED_BOTH) {
            this.setExtendedState(JFrame.NORMAL);

            DMx = evt.getXOnScreen();
            DMy = evt.getYOnScreen();
            MTotx = DMx - xMouse;
            MToty = DMy - yMouse;
            this.setLocation(xMouse, yMouse);

        }
        */

        DMx = evt.getXOnScreen();
        DMy = evt.getYOnScreen();
        MTotx = DMx - xMouse;
        MToty = DMy - yMouse;
        this.setLocation(MTotx, MToty);

    }//GEN-LAST:event_CustomBarMouseDragged

    private void CustomBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomBarMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_CustomBarMousePressed

    private void MainPanComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_MainPanComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_MainPanComponentShown

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        this.setVisible(false);
        new LoginScreen().setVisible(true);
    }//GEN-LAST:event_LogOutActionPerformed

    private void LogOutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LogOutKeyPressed
        
    }//GEN-LAST:event_LogOutKeyPressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
        if(ShowWin == 0){
            ShowWin = 1;
        
        String query = "SELECT `LoggedInAs` FROM `CurentLog` WHERE 1";
    try {
        MainPan.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        ps = MainPanel.getConnection().prepareStatement(query);
        rs = ps.executeQuery();
        if(rs.next()){
            CurUser = rs.getString("LoggedInAs");
            
            CurrentUser.setText(CurUser);
            
            System.out.println("Rename of current User Success");
        }
    } catch (SQLException ex) {
        Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
            MainPan.setCursor(Cursor.getDefaultCursor());
    }
        }
    }//GEN-LAST:event_formWindowActivated

    private void SearchEmployeeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchEmployeeBActionPerformed
        String SearchItem;
        SearchItem = SearchEmployee.getText();
        
        try{
            
            MainPan.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            SearchEmployeeB.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            SearchEmployeePan.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        
        DefaultTableModel UserModel2 = (DefaultTableModel)User_Table.getModel();
        UserModel2.setRowCount(0);
        ArrayList<SearchEmployees> Ulist = SearchEmployeeList(SearchItem);
        DefaultTableModel UserModel = (DefaultTableModel)User_Table.getModel();
        Object[] UserRow = new Object[7];
        for(int i = 0; i<Ulist.size();i++){
            UserRow[0] = Ulist.get(i).getFName();
            UserRow[1] = Ulist.get(i).getMI();
            UserRow[2] = Ulist.get(i).getLName();
            UserRow[3] = Ulist.get(i).getAge();
            UserRow[4] = Ulist.get(i).getGender();
            UserRow[5] = Ulist.get(i).getCountry();
            UserRow[6] = Ulist.get(i).getUser();
            UserModel.addRow(UserRow);
            System.out.println("UserList Loaded: "+i);
        }
        
        User_Table.setDefaultEditor(Object.class, null);
        }  finally {
            MainPan.setCursor(Cursor.getDefaultCursor());
            SearchEmployeeB.setCursor(Cursor.getDefaultCursor());
            SearchEmployeePan.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_SearchEmployeeBActionPerformed

    private void User_TableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_User_TableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_User_TableMouseEntered

    private void SearchAnimeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchAnimeBActionPerformed
        String SearchItem;
        SearchItem = SearchAnime.getText();
        
        try{
            
            MainPan.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            SearchAnimeB.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            SearchAniPan.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        
        DefaultTableModel Model2 = (DefaultTableModel)Anime_Table.getModel();
        Model2.setRowCount(0);
        ArrayList<SearchAnimes> list = SearchAnimesList(SearchItem);
        DefaultTableModel Model = (DefaultTableModel)Anime_Table.getModel();
        Object[] Row = new Object[7];
        for(int i = 0; i<list.size();i++){
            Row[0] = list.get(i).getENTitle();
            Row[1] = list.get(i).getRTitle();
            Row[2] = list.get(i).getAirDate();
            Row[3] = list.get(i).getStat();
            Row[4] = list.get(i).getPremiered();
            Row[5] = list.get(i).getLicense();
            Row[6] = list.get(i).getStudio();
            Model.addRow(Row);
            System.out.println("AnimeList Loaded: "+i);
        }
        
        Anime_Table.setDefaultEditor(Object.class, null);
        }  finally {
            MainPan.setCursor(Cursor.getDefaultCursor());
            SearchAnimeB.setCursor(Cursor.getDefaultCursor());
            SearchAniPan.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_SearchAnimeBActionPerformed

    private void Add_AnimeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_AnimeBActionPerformed
        AnimeTableLay.removeAll();
        AnimeTableLay.add(AddAniLay);
        AnimeTableLay.repaint();
        AnimeTableLay.revalidate();
        Main.repaint();
        Main.revalidate();
        AddALicense.getDocument().putProperty("filterNewlines", Boolean.TRUE);
    }//GEN-LAST:event_Add_AnimeBActionPerformed

    private void Anime_TableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Anime_TableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Anime_TableMouseEntered

    private void AddEmpErrBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddEmpErrBActionPerformed
        AddEmp.removeAll();
        AddEmp.add(AddEmploy);
        AddEmp.repaint();
        AddEmp.revalidate();
    }//GEN-LAST:event_AddEmpErrBActionPerformed

    private void AddEmpErrBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddEmpErrBKeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            AddEmpErrB.doClick();
        }
    }//GEN-LAST:event_AddEmpErrBKeyPressed

@SuppressWarnings("deprecation")
    private void AddEmpBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddEmpBActionPerformed
        int Age;
        String FName, MI, LName, Gender, Country, User, Pass, Repass, Admin;
        try{
            MainPan.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            AddEmpB.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        FName = EntFName.getText();
        MI = EntMI.getText();
        LName = EntLName.getText();
        Age = Integer.parseInt(EntAge.getText());
        Gender = getSelectedButton(GenderSelect);
        Country = EntCountry.getSelectedItem().toString();
        User = EntUser.getText();
        Pass = EntPass.getText();
        Repass = EntRePass.getText();
        Admin = getSelectedButton(AdminSelect);
        
        if(Country.equals("=Select Your Country=")){
            AddEmp.removeAll();
            AddEmp.add(AddEmpErr);
            AddEmpErrB.requestFocus();
            AddEmp.repaint();
            AddEmp.revalidate();
        } else {
        
        if(Pass.equals(Repass)){
        
            String query = "INSERT INTO `Employees`(`FirstName`, `MiddleI`, `LastName`, `Age`, `Gender`, `Country`, `Username`, `Password`, `Admin`)"+
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            ps = MainPanel.getConnection().prepareStatement(query);
            ps.setString(1, FName);
            ps.setString(2, MI);
            ps.setString(3, LName);
            ps.setInt(4, Age);
            if(Gender.equals("Male")){
                ps.setString(5, "M");
            } else if (Gender.equals("Female")){
                ps.setString(5, "F");
            }
            ps.setString(6, Country);
            ps.setString(7, User);
            ps.setString(8, Pass);
            if(Admin.equals("Yes")){
                ps.setString(9, "Y");
            } else if (Admin.equals("No")){
                ps.setString(9, "N");
            } 
            ps.execute();
        
        } else {
            AddEmp.removeAll();
            AddEmp.add(AddEmpErr);
            AddEmpErrB.requestFocus();
            AddEmp.repaint();
            AddEmp.revalidate();
        }
        }
        
        } catch (Exception e){
            System.out.println(e);
            
            //Error Input Show
            AddEmp.removeAll();
            AddEmp.add(AddEmpErr);
            AddEmpErrB.requestFocus();
            AddEmp.repaint();
            AddEmp.revalidate();
        } finally {
            MainPan.setCursor(Cursor.getDefaultCursor());
            AddEmpB.setCursor(Cursor.getDefaultCursor());
        }
        
        
        
    }//GEN-LAST:event_AddEmpBActionPerformed

    private void EntFNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EntFNameKeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            EntLName.requestFocus();
        }
    }//GEN-LAST:event_EntFNameKeyPressed

    private void EntLNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EntLNameKeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            EntMI.requestFocus();
        }
    }//GEN-LAST:event_EntLNameKeyPressed

    private void EntMIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EntMIKeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            EntAge.requestFocus();
        }
    }//GEN-LAST:event_EntMIKeyPressed

    private void EntUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EntUserKeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            EntPass.requestFocus();
        }
    }//GEN-LAST:event_EntUserKeyPressed

    private void AddEmpBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddEmpBKeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            AddEmpB.doClick();
        }
    }//GEN-LAST:event_AddEmpBKeyPressed

    private void ShowPassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShowPassMousePressed
        EntPass.requestFocus();

        if(ShowPass.isSelected()){
            EntPass.setEchoChar('*');
            EntRePass.setEchoChar('*');
        } else {
            EntPass.setEchoChar((char)0);
            EntRePass.setEchoChar((char)0);
        }
    }//GEN-LAST:event_ShowPassMousePressed

    private void ShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowPassActionPerformed

    }//GEN-LAST:event_ShowPassActionPerformed

    private void Add_MangaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_MangaBActionPerformed
        MangaTableLay.removeAll();
        MangaTableLay.add(AddMangaLay);
        MangaTableLay.repaint();
        MangaTableLay.revalidate();
        Main.repaint();
        Main.revalidate();
    }//GEN-LAST:event_Add_MangaBActionPerformed

    private void SearchMangaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchMangaBActionPerformed
        String SearchItem;
        SearchItem = SearchManga.getText();
        
        try{
            
            MainPan.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            SearchMangaB.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            SearchMangaPan.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            
        DefaultTableModel Model2 = (DefaultTableModel)Manga_Table.getModel();
        Model2.setRowCount(0);
        ArrayList<SearchMangas> Ulist = SearchMangasList(SearchItem);
        DefaultTableModel Model = (DefaultTableModel)Manga_Table.getModel();
        Object[] Row = new Object[6];
        for(int i = 0; i<Ulist.size();i++){
            Row[0] = Ulist.get(i).getENTitle();
            Row[1] = Ulist.get(i).getRTitle();
            Row[2] = Ulist.get(i).getPubDate();
            Row[3] = Ulist.get(i).getSerial();
            Row[4] = Ulist.get(i).getStat();
            Row[5] = Ulist.get(i).getLicense();
            Model.addRow(Row);
            System.out.println("SearchMangaList Loaded: "+i);
        }
        
        Manga_Table.setDefaultEditor(Object.class, null);
        }  finally {
            MainPan.setCursor(Cursor.getDefaultCursor());
            SearchMangaB.setCursor(Cursor.getDefaultCursor());
            SearchMangaPan.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_SearchMangaBActionPerformed

    private void Manga_TableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Manga_TableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Manga_TableMouseEntered

    private void AddMangaBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMangaBackActionPerformed
        MangaTableLay.removeAll();
        MangaTableLay.add(DisplayMangaLay);
        MangaTableLay.repaint();
        MangaTableLay.revalidate();
        Main.repaint();
        Main.revalidate();
    }//GEN-LAST:event_AddMangaBackActionPerformed

    private void AddMangaConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMangaConfirmActionPerformed
        String ENTitle, RTitle, MangDate, Serial, Stat, License;
        
        try{
            ENTitle = AddMENTitle.getText();
            RTitle = AddMRTitle.getText();
            MangDate = DFormat.format(MangaDateChoose.getDate());
            Serial = AddMSerial.getText();
            Stat = AddMStat.getSelectedItem().toString();
            License = AddMLicense.getText();
            
            MainPan.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            AddEmpB.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            
            if(Stat.equals("=Select Current Status=")|| MangDate.equals("")){
            //Error Call
            AddMangaMain.removeAll();
            AddMangaMain.add(AddMangaErr);
            AddMangaMain.repaint();
            AddMangaMain.revalidate();
            } else {
            
            String query = "INSERT INTO `MangaList`(`ENTitle`, `RTitle`, `PubDate`, `Serial`, `Stat`, `License`) VALUES"
                    + " (?, ?, ?, ?, ?, ?)";
            
            ps = MainPanel.getConnection().prepareStatement(query);
            ps.setString(1, ENTitle);
            ps.setString(2, RTitle);
            ps.setString(3, MangDate);
            ps.setString(4, Serial);
            ps.setString(5, Stat);
            ps.setString(6, License);
            
            ps.execute();
            AddMangaMain.removeAll();
            AddMangaMain.add(AddMangaSuccess);
            AddMangaMain.repaint();
            AddMangaMain.revalidate();
            }
            
        } catch (Exception e){
            //Error Call
        AddMangaMain.removeAll();
        AddMangaMain.add(AddMangaErr);
        AddMangaMain.repaint();
        AddMangaMain.revalidate();
        }  finally {
            MainPan.setCursor(Cursor.getDefaultCursor());
            AddEmpB.setCursor(Cursor.getDefaultCursor());
        }
        
    }//GEN-LAST:event_AddMangaConfirmActionPerformed

    private void AddMangaErrBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMangaErrBActionPerformed
        AddMangaMain.removeAll();
        AddMangaMain.add(AddMangaPan);
        AddMangaMain.repaint();
        AddMangaMain.revalidate();
        
    }//GEN-LAST:event_AddMangaErrBActionPerformed

    private void AddMangaErrBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddMangaErrBKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddMangaErrBKeyPressed

    private void AddMENTitleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddMENTitleKeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            AddMRTitle.requestFocus();
        }
    }//GEN-LAST:event_AddMENTitleKeyPressed

    private void AddMRTitleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddMRTitleKeyPressed
        
    }//GEN-LAST:event_AddMRTitleKeyPressed

    private void AddMSerialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddMSerialKeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            AddMLicense.requestFocus();
        }
    }//GEN-LAST:event_AddMSerialKeyPressed

    private void AddMLicenseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddMLicenseKeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            AddMangaConfirm.doClick();
        }
    }//GEN-LAST:event_AddMLicenseKeyPressed

    private void AddMangaConfirmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddMangaConfirmKeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            AddMangaConfirm.doClick();
        }
    }//GEN-LAST:event_AddMangaConfirmKeyPressed

    private void AddMangaBackKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddMangaBackKeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            AddMangaBack.doClick();
        }
    }//GEN-LAST:event_AddMangaBackKeyPressed

    private void AddMangaSucessBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMangaSucessBActionPerformed
        try {
            MainPan.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            AddMangaSucessB.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DefaultTableModel Model2 = (DefaultTableModel)Manga_Table.getModel();
        Model2.setRowCount(0);
        ArrayList<Mangas> Ulist = MangasList();
        DefaultTableModel Model = (DefaultTableModel)Manga_Table.getModel();
        Object[] Row = new Object[6];
        for(int i = 0; i<Ulist.size();i++){
            Row[0] = Ulist.get(i).getENTitle();
            Row[1] = Ulist.get(i).getRTitle();
            Row[2] = Ulist.get(i).getPubDate();
            Row[3] = Ulist.get(i).getSerial();
            Row[4] = Ulist.get(i).getStat();
            Row[5] = Ulist.get(i).getLicense();
            Model.addRow(Row);
            System.out.println("MangaList Loaded: "+i);
        }
        MangaTableLay.removeAll();
        MangaTableLay.add(DisplayMangaLay);
        MangaTableLay.repaint();
        MangaTableLay.revalidate();
        
        AddMangaMain.removeAll();
        AddMangaMain.add(AddMangaPan);
        AddMangaMain.repaint();
        AddMangaMain.revalidate();
        
        Main.repaint();
        Main.revalidate();
        
        AddMENTitle.setText("");
        AddMRTitle.setText("");
        MangaDateChoose.setDate(null);
        AddMStat.setSelectedItem("=Select Current Status=");
        AddMSerial.setText("");
        AddMLicense.setText("");
        
        Manga_Table.setDefaultEditor(Object.class, null);
        
        } finally {
            MainPan.setCursor(Cursor.getDefaultCursor());
            AddMangaSucessB.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_AddMangaSucessBActionPerformed

    private void AddMangaSucessBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddMangaSucessBKeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            AddMangaSucessB.doClick();
        }
    }//GEN-LAST:event_AddMangaSucessBKeyPressed

    private void SearchMangaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchMangaKeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            SearchMangaB.doClick();
        }
    }//GEN-LAST:event_SearchMangaKeyPressed

    private void AddAniErrBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAniErrBActionPerformed
        AddAniMain.removeAll();
        AddAniMain.add(AddAniPan);
        AddAniMain.repaint();
        AddAniMain.revalidate();
    }//GEN-LAST:event_AddAniErrBActionPerformed

    private void AddAniErrBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddAniErrBKeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            AddAniErrB.doClick();
        }
    }//GEN-LAST:event_AddAniErrBKeyPressed

    private void AddAniSucessBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAniSucessBActionPerformed
        try{
            MainPan.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            AddAniSucessB.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DefaultTableModel Model2 = (DefaultTableModel)Anime_Table.getModel();
        Model2.setRowCount(0);
        ArrayList<Animes> list = AnimesList();
        DefaultTableModel Model = (DefaultTableModel)Anime_Table.getModel();
        Object[] Row = new Object[7];
        for(int i = 0; i<list.size();i++){
            Row[0] = list.get(i).getENTitle();
            Row[1] = list.get(i).getRTitle();
            Row[2] = list.get(i).getAirDate();
            Row[3] = list.get(i).getStat();
            Row[4] = list.get(i).getPremiered();
            Row[5] = list.get(i).getLicense();
            Row[6] = list.get(i).getStudio();
            Model.addRow(Row);
            System.out.println("AnimeList Loaded: "+i);
        }
        AnimeTableLay.removeAll();
        AnimeTableLay.add(DisplayAnimeLay);
        AnimeTableLay.repaint();
        AnimeTableLay.revalidate();
        
        AddAniMain.removeAll();
        AddAniMain.add(AddAniPan);
        AddAniMain.repaint();
        AddAniMain.revalidate();
        
        Main.repaint();
        Main.revalidate();
        
        AddAENTitle.setText("");
        AddARTitle.setText("");
        AniDateChooseS.setDate(null);
        AniDateChooseF.setDate(null);
        AddAStat.setSelectedItem("=Select Current Status=");
        AddALicense.setText("");
        AddAStudio.setText("");
        
        Anime_Table.setDefaultEditor(Object.class, null);
        
        } finally {
            MainPan.setCursor(Cursor.getDefaultCursor());
            AddAniSucessB.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_AddAniSucessBActionPerformed

    private void AddAniSucessBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddAniSucessBKeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            AddAniSucessB.doClick();
        }
    }//GEN-LAST:event_AddAniSucessBKeyPressed

    private void AddAStudioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddAStudioKeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            AddAniConfirm.doClick();
        }
    }//GEN-LAST:event_AddAStudioKeyPressed

    private void AddAniBackKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddAniBackKeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            AddAniBack.doClick();
        }
    }//GEN-LAST:event_AddAniBackKeyPressed

    private void AddAniBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAniBackActionPerformed
        AnimeTableLay.removeAll();
        AnimeTableLay.add(DisplayAnimeLay);
        AnimeTableLay.repaint();
        AnimeTableLay.revalidate();
        Main.repaint();
        Main.revalidate();
    }//GEN-LAST:event_AddAniBackActionPerformed

    private void AddAniConfirmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddAniConfirmKeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            AddAniConfirm.doClick();
        }
    }//GEN-LAST:event_AddAniConfirmKeyPressed

    private void AddAniConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAniConfirmActionPerformed
        String AniSeasonM, AniSeasonY, Season, AniDateSeason, AirDate1, AirDate2;
        String ENTitle, RTitle, AirDate, Stat, Premiered, License, Studio;
        try{
        SimpleDateFormat SeasonM = new SimpleDateFormat("MMMM", Locale.getDefault());
        AniSeasonM = SeasonM.format(AniDateChooseS.getDate());
        SimpleDateFormat SeasonY = new SimpleDateFormat("yyyy", Locale.getDefault());
        AniSeasonY = SeasonY.format(AniDateChooseS.getDate());
        Season = switch (AniSeasonM) {
            case "January", "Febuary", "March" -> "Winter";
            case "April", "May", "June" -> "Spring";
            case "July", "August", "September" -> "Summer";
            case "October", "November", "December" -> "Fall";
            default -> "Invalid";
        };
        AniDateSeason = Season +" "+AniSeasonY;
        AirDate1 = DFormat.format(AniDateChooseS.getDate());
        AirDate2 = getAniAirDateF();
        
        ENTitle = AddAENTitle.getText();
        RTitle = AddARTitle.getText();
        AirDate = AirDate1+" to "+AirDate2;
        Stat = AddAStat.getSelectedItem().toString();
        Premiered = AniDateSeason;
        License = AddALicense.getText();
        Studio = AddAStudio.getText();
        
        System.out.println(AirDate);
        System.out.println("License output: \n"+License);
        
            MainPan.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            AddAniConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            if(Stat.equals("=Select Current Status=")|| AirDate1.equals("")){
            //Error Call
            AddAniMain.removeAll();
            AddAniMain.add(AddAniErr);
            AddAniMain.repaint();
            AddAniMain.revalidate();
            } else {
                
            String query = "INSERT INTO `AnimeList`(`ENTitle`, `RTitle`, `AirDate`, `Stat`, `Premiered`, `License`, `Studio`) VALUES"
                    + " (?, ?, ?, ?, ?, ?, ?)";
            
            ps = MainPanel.getConnection().prepareStatement(query);
            ps.setString(1, ENTitle);
            ps.setString(2, RTitle);
            ps.setString(3, AirDate);
            ps.setString(4, Stat);
            ps.setString(5, Premiered);
            ps.setString(6, License);
            ps.setString(7, Studio);
            
            ps.execute();
            AddAniMain.removeAll();
            AddAniMain.add(AddAniSuccess);
            AddAniMain.repaint();
            AddAniMain.revalidate();
            }
        
        } catch (Exception e) {
            System.out.println(e);
            //Error Call
            AddAniMain.removeAll();
            AddAniMain.add(AddAniErr);
            AddAniMain.repaint();
            AddAniMain.revalidate();
        }  finally {
            MainPan.setCursor(Cursor.getDefaultCursor());
            AddAniConfirm.setCursor(Cursor.getDefaultCursor());
        }
        
    }//GEN-LAST:event_AddAniConfirmActionPerformed

    private void AddARTitleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddARTitleKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddARTitleKeyPressed

    private void AddAENTitleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddAENTitleKeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            AddARTitle.requestFocus();
        }
    }//GEN-LAST:event_AddAENTitleKeyPressed

    private void AddMangaClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMangaClearActionPerformed
        AddMENTitle.setText("");
        AddMRTitle.setText("");
        MangaDateChoose.setDate(null);
        AddMStat.setSelectedItem("=Select Current Status=");
        AddMSerial.setText("");
        AddMLicense.setText("");
    }//GEN-LAST:event_AddMangaClearActionPerformed

    private void AddMangaClearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddMangaClearKeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            AddMangaClear.doClick();
        }
    }//GEN-LAST:event_AddMangaClearKeyPressed

    private void AddAniClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAniClearActionPerformed
        AddAENTitle.setText("");
        AddARTitle.setText("");
        AniDateChooseS.setDate(null);
        AniDateChooseF.setDate(null);
        AddAStat.setSelectedItem("=Select Current Status=");
        AddALicense.setText("");
        AddAStudio.setText("");
    }//GEN-LAST:event_AddAniClearActionPerformed

    private void SearchMangaBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchMangaBKeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            SearchMangaB.doClick();
        }
    }//GEN-LAST:event_SearchMangaBKeyPressed

    private void SearchAnimeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchAnimeKeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            SearchAnimeB.doClick();
        }
    }//GEN-LAST:event_SearchAnimeKeyPressed

    private void SearchAnimeBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchAnimeBKeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            SearchAnimeB.doClick();
        }
    }//GEN-LAST:event_SearchAnimeBKeyPressed

    private void AddAniClearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddAniClearKeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            AddAniClear.doClick();
        }
    }//GEN-LAST:event_AddAniClearKeyPressed

    private void SearchEmployeeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchEmployeeKeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            SearchEmployeeB.doClick();
        }
    }//GEN-LAST:event_SearchEmployeeKeyPressed

    private void MangaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MangaBActionPerformed
        Main.removeAll();
        Main.add(Import_Manga);

        MangaTableLay.removeAll();
        MangaTableLay.add(DisplayMangaLay);
        MangaTableLay.repaint();
        MangaTableLay.revalidate();

        AddMangaMain.removeAll();
        AddMangaMain.add(AddMangaPan);
        AddMangaMain.repaint();
        AddMangaMain.revalidate();

        Main.repaint();
        Main.revalidate();
        try{
            MainPan.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            MangaB.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            
        DefaultTableModel Model2 = (DefaultTableModel)Manga_Table.getModel();
        Model2.setRowCount(0);
        ArrayList<Mangas> Ulist = MangasList();
        DefaultTableModel Model = (DefaultTableModel)Manga_Table.getModel();
        Object[] Row = new Object[6];
        for(int i = 0; i<Ulist.size();i++){
            Row[0] = Ulist.get(i).getENTitle();
            Row[1] = Ulist.get(i).getRTitle();
            Row[2] = Ulist.get(i).getPubDate();
            Row[3] = Ulist.get(i).getSerial();
            Row[4] = Ulist.get(i).getStat();
            Row[5] = Ulist.get(i).getLicense();
            Model.addRow(Row);
            System.out.println("MangaList Loaded: "+i);
        }

        Manga_Table.setDefaultEditor(Object.class, null);
        } finally {
            MainPan.setCursor(Cursor.getDefaultCursor());
            MangaB.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_MangaBActionPerformed

    private void AnimeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnimeBActionPerformed
        Main.removeAll();
        Main.add(Import_Anime);

        AnimeTableLay.removeAll();
        AnimeTableLay.add(DisplayAnimeLay);
        AnimeTableLay.repaint();
        AnimeTableLay.revalidate();

        AddAniMain.removeAll();
        AddAniMain.add(AddAniPan);
        AddAniMain.repaint();
        AddAniMain.revalidate();

        Main.repaint();
        Main.revalidate();
        
        try{
            MainPan.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            AnimeB.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            
        DefaultTableModel Model2 = (DefaultTableModel)Anime_Table.getModel();
        Model2.setRowCount(0);
        ArrayList<Animes> list = AnimesList();
        DefaultTableModel Model = (DefaultTableModel)Anime_Table.getModel();
        Object[] Row = new Object[7];
        for(int i = 0; i<list.size();i++){
            Row[0] = list.get(i).getENTitle();
            Row[1] = list.get(i).getRTitle();
            Row[2] = list.get(i).getAirDate();
            Row[3] = list.get(i).getStat();
            Row[4] = list.get(i).getPremiered();
            Row[5] = list.get(i).getLicense();
            Row[6] = list.get(i).getStudio();
            Model.addRow(Row);
            System.out.println("AnimeList Loaded: "+i);
        }

        Anime_Table.setDefaultEditor(Object.class, null);
        } finally {
            MainPan.setCursor(Cursor.getDefaultCursor());
            AnimeB.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_AnimeBActionPerformed

    private void UsersBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsersBActionPerformed
        Main.removeAll();
        Main.add(Import_Employee);
        Main.repaint();
        Main.revalidate();
        try{
            MainPan.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            UsersB.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            
        DefaultTableModel UserModel2 = (DefaultTableModel)User_Table.getModel();
        UserModel2.setRowCount(0);
        ArrayList<Employees> Ulist = EmployeeList();
        DefaultTableModel UserModel = (DefaultTableModel)User_Table.getModel();
        Object[] UserRow = new Object[7];
        for(int i = 0; i<Ulist.size();i++){
            UserRow[0] = Ulist.get(i).getFName();
            UserRow[1] = Ulist.get(i).getMI();
            UserRow[2] = Ulist.get(i).getLName();
            UserRow[3] = Ulist.get(i).getAge();
            UserRow[4] = Ulist.get(i).getGender();
            UserRow[5] = Ulist.get(i).getCountry();
            UserRow[6] = Ulist.get(i).getUser();
            UserModel.addRow(UserRow);
            System.out.println("UserList Loaded: "+i);
        }

        User_Table.setDefaultEditor(Object.class, null);
        } finally {
            MainPan.setCursor(Cursor.getDefaultCursor());
            UsersB.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_UsersBActionPerformed

    private void AdminBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminBActionPerformed
        try{
            MainPan.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            AdminB.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            
        String User,AddAccess;
        User = CurrentUser.getText();
        ArrayList<AdminGetPerm> AddArr = getAdminPerms(User);
        AddAccess = AddArr.get(0).getAdminPerm();
        System.out.println("Admin Access? ="+AddAccess);
        
        CurrentUserAd.setText(User);
        
        Main.removeAll();
        Main.add(Import_Admin);
        
        if(AddAccess.equals("Y")){
           EntFName.requestFocus(); 
           Import_Admin_Auth.removeAll();
           Import_Admin_Auth.add(Import_AdminG);
           Import_Admin_Auth.repaint();
           Import_Admin_Auth.revalidate();
        } else if(AddAccess.equals("N")){
           Import_Admin_Auth.removeAll();
           Import_Admin_Auth.add(AdminDenied);
           Import_Admin_Auth.repaint();
           Import_Admin_Auth.revalidate();
        }
        
        
        Main.repaint();
        Main.revalidate();
        } finally {
            MainPan.setCursor(Cursor.getDefaultCursor());
            AdminB.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_AdminBActionPerformed

    private void HomeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeBActionPerformed
        Main.removeAll();
        Main.add(Import_Home);
        Main.repaint();
        Main.revalidate();
    }//GEN-LAST:event_HomeBActionPerformed

    private void AddMangaSucessB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMangaSucessB1ActionPerformed
        EntFName.setText("");
        EntLName.setText("");
        EntMI.setText("");
        EntAge.setText("");
        EntUser.setText("");
        EntPass.setText("");
        EntRePass.setText("");
        EntFName.setText("");
        EntCountry.setSelectedItem("=Select Your Country=");
        GenderSelect.clearSelection();
        AdminSelect.clearSelection();
        
        AddEmp.removeAll();
        AddEmp.add(AddEmploy);
        AddEmp.repaint();
        AddEmp.revalidate();
        
    }//GEN-LAST:event_AddMangaSucessB1ActionPerformed

    private void AddMangaSucessB1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddMangaSucessB1KeyPressed
        int key=evt.getKeyCode();
        if(key==10){
            AddMangaSucessB1.doClick();
        }
    }//GEN-LAST:event_AddMangaSucessB1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddAENTitle;
    private javax.swing.JTextArea AddALicense;
    private javax.swing.JTextField AddARTitle;
    private javax.swing.JComboBox<String> AddAStat;
    private javax.swing.JTextField AddAStudio;
    private javax.swing.JButton AddAniBack;
    private javax.swing.JButton AddAniClear;
    private javax.swing.JButton AddAniConfirm;
    private javax.swing.JPanel AddAniErr;
    private javax.swing.JButton AddAniErrB;
    private javax.swing.JLabel AddAniFormBack;
    private javax.swing.JPanel AddAniLay;
    private javax.swing.JLayeredPane AddAniMain;
    private javax.swing.JPanel AddAniPan;
    private javax.swing.JPanel AddAniSuccess;
    private javax.swing.JButton AddAniSucessB;
    private javax.swing.JLayeredPane AddEmp;
    private javax.swing.JButton AddEmpB;
    private javax.swing.JPanel AddEmpErr;
    private javax.swing.JButton AddEmpErrB;
    private javax.swing.JPanel AddEmploy;
    private javax.swing.JTextField AddMENTitle;
    private javax.swing.JTextField AddMLicense;
    private javax.swing.JTextField AddMRTitle;
    private javax.swing.JTextField AddMSerial;
    private javax.swing.JComboBox<String> AddMStat;
    private javax.swing.JButton AddMangaBack;
    private javax.swing.JButton AddMangaClear;
    private javax.swing.JButton AddMangaConfirm;
    private javax.swing.JPanel AddMangaErr;
    private javax.swing.JButton AddMangaErrB;
    private javax.swing.JLabel AddMangaFormBack;
    private javax.swing.JPanel AddMangaLay;
    private javax.swing.JLayeredPane AddMangaMain;
    private javax.swing.JPanel AddMangaPan;
    private javax.swing.JPanel AddMangaSuccess;
    private javax.swing.JPanel AddMangaSuccess1;
    private javax.swing.JButton AddMangaSucessB;
    private javax.swing.JButton AddMangaSucessB1;
    private javax.swing.JButton Add_AnimeB;
    private javax.swing.JButton Add_MangaB;
    private javax.swing.JToggleButton AdminB;
    private javax.swing.JPanel AdminDenied;
    private javax.swing.ButtonGroup AdminSelect;
    private javax.swing.JLabel Admin_BackD;
    private javax.swing.JLabel Admin_BackG;
    private com.toedter.calendar.JDateChooser AniDateChooseF;
    private com.toedter.calendar.JDateChooser AniDateChooseS;
    private javax.swing.JToggleButton AnimeB;
    private javax.swing.JLayeredPane AnimeTableLay;
    private javax.swing.JLabel Anime_BackAdd;
    private javax.swing.JLabel Anime_BackDis;
    private javax.swing.JTable Anime_Table;
    private javax.swing.JLabel Background;
    private javax.swing.JPanel ButtonsLayout;
    private javax.swing.JLabel CompanyName;
    private javax.swing.JLabel Copyrights;
    private javax.swing.JLabel CurrentUser;
    private javax.swing.JLabel CurrentUserAd;
    private javax.swing.JPanel CustomBar;
    private javax.swing.JScrollPane DisplayAni;
    private javax.swing.JPanel DisplayAnimeLay;
    private javax.swing.JScrollPane DisplayManga;
    private javax.swing.JPanel DisplayMangaLay;
    private javax.swing.JLabel Employee_Back;
    private javax.swing.JTextField EntAge;
    private javax.swing.JComboBox<String> EntCountry;
    private javax.swing.JTextField EntFName;
    private javax.swing.JTextField EntLName;
    private javax.swing.JTextField EntMI;
    private javax.swing.JPasswordField EntPass;
    private javax.swing.JPasswordField EntRePass;
    private javax.swing.JTextField EntUser;
    private javax.swing.JButton Ext;
    private javax.swing.ButtonGroup GenderSelect;
    private javax.swing.JToggleButton HomeB;
    private javax.swing.JLabel Home_Back;
    private javax.swing.JPanel Import_Admin;
    private javax.swing.JPanel Import_AdminG;
    private javax.swing.JLayeredPane Import_Admin_Auth;
    private javax.swing.JPanel Import_Anime;
    private javax.swing.JPanel Import_Employee;
    private javax.swing.JPanel Import_Home;
    private javax.swing.JPanel Import_Manga;
    private javax.swing.JButton LogOut;
    private javax.swing.JPanel LogoHome;
    private javax.swing.JPanel LogoPanel;
    private javax.swing.JLayeredPane Main;
    private javax.swing.JPanel MainPan;
    private javax.swing.JToggleButton MangaB;
    private com.toedter.calendar.JDateChooser MangaDateChoose;
    private javax.swing.JLayeredPane MangaTableLay;
    private javax.swing.JLabel Manga_BackAdd;
    private javax.swing.JLabel Manga_BackDis;
    private javax.swing.JTable Manga_Table;
    private javax.swing.JButton Minimize;
    private javax.swing.ButtonGroup PanelSelect;
    private javax.swing.JPanel SearchAniPan;
    private javax.swing.JTextField SearchAnime;
    private javax.swing.JButton SearchAnimeB;
    private javax.swing.JTextField SearchEmployee;
    private javax.swing.JButton SearchEmployeeB;
    private javax.swing.JPanel SearchEmployeePan;
    private javax.swing.JTextField SearchManga;
    private javax.swing.JButton SearchMangaB;
    private javax.swing.JPanel SearchMangaPan;
    private javax.swing.JRadioButton SelectFemEm;
    private javax.swing.JRadioButton SelectFemEm1;
    private javax.swing.JRadioButton SelectMaleEm;
    private javax.swing.JRadioButton SelectMaleEm1;
    private javax.swing.JCheckBox ShowPass;
    private javax.swing.JLabel SidePanBack;
    private javax.swing.JPanel Sidemenu;
    private javax.swing.JTable User_Table;
    private javax.swing.JToggleButton UsersB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
