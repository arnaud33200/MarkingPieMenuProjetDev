/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ladoucar
 */
public abstract class MarkingPieMenuView extends javax.swing.JComponent {
   
// coordonnée de la sourie pour construire une fausse transparence
    protected int mouseX;
    protected int mouseY;
    
    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }
    
    public abstract void highlight(int n);
}
