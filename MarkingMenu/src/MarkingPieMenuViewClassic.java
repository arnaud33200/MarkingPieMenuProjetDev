import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class MarkingPieMenuViewClassic extends MarkingPieMenuView {

    ArrayList<Section> slices;
    int highlight;

    public int INNERCIRCLESIZE = 40;
    public int OUTERCIRCLESIZE = 100;

    MarkingPieMenuViewClassic(int INNERCIRCLESIZE, int OUTERCIRCLESIZE, ArrayList<Section> sections) {
        highlight = -1;
        this.slices = sections;
        this.INNERCIRCLESIZE = INNERCIRCLESIZE;
        this.OUTERCIRCLESIZE = OUTERCIRCLESIZE;
        setSize(OUTERCIRCLESIZE, OUTERCIRCLESIZE);
       /* this.setContentAreaFilled(false);
        this.setBorderPainted(false);*/
        this.repaint();
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(OUTERCIRCLESIZE, OUTERCIRCLESIZE);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        Rectangle area = new Rectangle(OUTERCIRCLESIZE, OUTERCIRCLESIZE);
        double total = slices.size();
        double curValue = 0.0D;
        int startAngle = 0;

        for (int i = 0; i < slices.size(); i++) {
            startAngle = (int) (curValue * 360 / total);
            int arcAngle = (int) (360 / total);

// une section est foncé lorsqu'elle n'est pas selectionné
            g2d.setColor(slices.get(i).getColor().darker());
            if (highlight == i) {
                g2d.setColor(slices.get(i).getColor());
            }

            Arc2D.Double arc;
            arc = new Arc2D.Double();
            arc.setArc(area.x, area.y, area.width, area.height, startAngle, arcAngle, Arc2D.PIE);

            Ellipse2D.Double circle;
            int circleWidth = INNERCIRCLESIZE;
            int circleHeight = INNERCIRCLESIZE;
            Double circleCenterX = area.getCenterX() - circleWidth / 2;
            Double circleCenterY = area.getCenterY() - circleHeight / 2;
            circle = new Ellipse2D.Double(circleCenterX, circleCenterY, circleWidth, circleHeight);

            Area arcArea = new Area(arc);
            Area circleArea = new Area(circle);
            arcArea.subtract(circleArea);

            g2d.fill(arcArea);

            curValue++;
        }

        curValue = 0.0D;
        startAngle = 0;

        for (int i = 0; i < slices.size(); i++) {
            startAngle = (int) (curValue * 360 / total);
            int arcAngle = (int) (360 / total);

            g2d.setColor(Color.WHITE);

            double rayon = area.width / 3;
            double arcAngleByTwo = arcAngle / 2;
            double textAngle = startAngle + arcAngleByTwo;
            double cosAngle = Math.cos(Math.toRadians(textAngle));
            double sinAngle = -Math.sin(Math.toRadians(textAngle));

            int xCenter = (int) area.getCenterX() - 2;
            int yCenter = (int) area.getCenterY() - 2;

            int x = (int) (rayon * cosAngle + xCenter);
            int y = (int) (rayon * sinAngle + yCenter);

            g2d.drawString(slices.get(i).getName(), x, y);

            curValue++;
        }
    }

    void drawPie(Graphics2D g, Rectangle area, Section[] slices) {

    }

    @Override
    public void highlight(int n) {
        Color c = slices.get(n).getColor();
        highlight = n;
        repaint();
    }

}
