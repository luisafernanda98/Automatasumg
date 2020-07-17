/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatas;

/**
 *
 * @author luisa
 */
public class Student {
    private String registrarNumero;
    
    public Student(String registrarNumero){
        this.registrarNumero=registrarNumero;
    }

    public String getRegistrarNumero() {
        return registrarNumero;
    }

    public void setRegistrarNumero(String registrarNumero) {
        this.registrarNumero = registrarNumero;
    }
    
    public boolean equals(Object o){
        System.out.println("From Map");
        if(o != null && o instanceof Student){
            String regNumber=((Student)o).getRegistrarNumero();
            if(regNumber != null && regNumber.equals(this.getRegistrarNumero())){
                return true;
            }
        }
            return false;
         }
    
        public int hashCode(){
            System.out.println("From Maop...");
            return this.registrarNumero.hashCode();
        }
    }
