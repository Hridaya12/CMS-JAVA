package course.management.system;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class user {
	public boolean isUserExist1(String userName){
        boolean isExist= false;
        connect con = new connect();
         PreparedStatement ps;
      try{
        ps = con.c.prepareStatement("SELECT * FROM `student` WHERE `student_id` = ?");
        ps.setString(1,userName);
        ResultSet rs =ps.executeQuery();        
      
        if(rs.next())
             {
            isExist= true;
             }
         } catch (SQLException ex) {
//           Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
       }
        return isExist;
    
    }
	public boolean isUserExist2(String userName){
        boolean isExist= false;
        connect con = new connect();
         PreparedStatement ps;
      try{
        ps = con.c.prepareStatement("SELECT * FROM `instructor` WHERE `instructor_id` = ?");
        ps.setString(1,userName);
        ResultSet rs =ps.executeQuery();        
      
        if(rs.next())
             {
            isExist= true;
             }
         } catch (SQLException ex) {

       }
        return isExist;
    
    }
	public boolean isModuleExist(String userName){
        boolean isExist= false;
        connect con = new connect();
         PreparedStatement ps;
      try{
        ps = con.c.prepareStatement("SELECT * FROM `bibmmodule` WHERE `id` = ?");
        ps.setString(1,userName);
        ResultSet rs =ps.executeQuery();        
      
        if(rs.next())
             {
            isExist= true;
             }
         } catch (SQLException ex) {

       }
        return isExist;
    
    }
	public boolean isModuleExist1(String userName){
        boolean isExist= false;
        connect con = new connect();
         PreparedStatement ps;
      try{
        ps = con.c.prepareStatement("SELECT * FROM `bscmodule` WHERE `id` = ?");
        ps.setString(1,userName);
        ResultSet rs =ps.executeQuery();        
      
        if(rs.next())
             {
            isExist= true;
             }
         } catch (SQLException ex) {

       }
        return isExist;
    
    }
	public boolean isCourseExist2(String userName){
        boolean isExist= false;
        connect con = new connect();
         PreparedStatement ps;
      try{
        ps = con.c.prepareStatement("SELECT * FROM `coursedb` WHERE `course_id` = ?");
        ps.setString(1,userName);
        ResultSet rs =ps.executeQuery();        
      
        if(rs.next())
             {
            isExist= true;
             }
         } catch (SQLException ex) {

       }
        return isExist;
    }
	public boolean isUserExist(String userName){
        boolean isExist= false;
        connect con = new connect();
         PreparedStatement ps;
      try{
        ps = con.c.prepareStatement("SELECT * FROM `accounts` WHERE `username` = ?");
        ps.setString(1,userName);
        ResultSet rs =ps.executeQuery();        
      
        if(rs.next())
             {
            isExist= true;
             }
         } catch (SQLException ex) {

       }
        return isExist;
    }

}
