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
