package myMath;
import java.awt.Color;
import javax.swing.JFrame;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
//import de.erichseifert.gral.plots.points.PointRenderer;
import de.erichseifert.gral.ui.InteractivePanel;

public class LinePlotTest extends JFrame {
    /**
	 * Tomer and Ortal
	 * 
	 * Erich Seifert github https://github.com/eseifert/gral/wiki
	 */
	private static final long serialVersionUID = 1L;

	public LinePlotTest(Polynom a) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);

        @SuppressWarnings("unchecked")
		DataTable data = new DataTable(Double.class, Double.class);
        @SuppressWarnings("unchecked")
		DataTable data2 = new DataTable(Double.class, Double.class);
        
        for (double x = -2; x <= 4; x+=0.2) {	
        	double y = a.f(x);
            data.add(x, y);
            if(a.derivative().f(x-0.1)<0 && a.derivative().f(x+0.1)>0 ) {
            	System.out.println(x+","+a.f(x)+"min");
            	data2.add(x,a.f(x)); 
        
            }
            else if(a.derivative().f(x-0.1)>0 && a.derivative().f(x+0.1)<0 ) {
            	System.out.println(x+","+a.f(x)+"max");
            	data2.add(x,a.f(x));
            }
        }
        
        XYPlot plot = new XYPlot(data,data2);
        getContentPane().add(new InteractivePanel(plot));
        LineRenderer lines = new DefaultLineRenderer2D();
        plot.setLineRenderers(data, lines);
        Color color = new Color(0.3f, 1.0f, 0.0f);
        Color color2 = new Color(1.0f, 0.1f, 0.1f);  		
        plot.getPointRenderers(data2).get(0).setColor(color2);
        plot.getPointRenderers(data).get(0).setColor(color);
        plot.getLineRenderers(data).get(0).setColor(color);
       
    }

    public static void main(String[] args) {
		Polynom p1 = new Polynom("-13x^5+2x^6-7x^3-28x^2+19x^1-0.5");
		Polynom p2 = new Polynom("1x^1+26x^4+0.5");
		Polynom p3 = (Polynom)p1.copy();
		p3.add(p2);
    	LinePlotTest frame = new LinePlotTest(p3);
      frame.setVisible(true);
		System.out.println("p3 String : " + p3.toString());
		System.out.println("f(0.5) : " + p3.f(0.5));
		System.out.println("f(1.5) : " + p3.f(1.5));
		System.out.println("root(0.5, 1.5, 0.001) : " + p3.root(0.5, 1.5, 0.001));
		System.out.println("Derivative : " + p3.derivative().toString());
		System.out.println("area(0, 1, 0.001) : " + p3.area(0, 1, 0.001));
//       Polynom a = new Polynom("0.2x^4-1.5x^3+3x^2-1x-5");
//    	LinePlotTest frame = new LinePlotTest(a);
//        frame.setVisible(true);
    }
}