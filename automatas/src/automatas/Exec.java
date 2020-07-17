/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatas;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author luisa
 */
public class Exec {
    public static void main(String[]args){
        Student s = new Student("H234");
        Student s2 = new Student("H234");
        System.out.println(s.equals(s2));
        
        Map<Student,ReportCard>studentsReport = new HashMap<Student,ReportCard>();
    
        studentsReport.put(s,new ReportCard());
        studentsReport.put(s2,new ReportCard());
        
        System.out.println(studentsReport.size());
        
    }
}
