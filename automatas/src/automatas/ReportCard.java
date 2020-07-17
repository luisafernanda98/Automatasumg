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
class ReportCard {
    private int mathScore;

    public ReportCard(){
        this.mathScore=(int)((Math.random()*101)+1);
        
    }
    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }
    
    
}
