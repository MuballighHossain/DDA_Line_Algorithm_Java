import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import javax.swing.JFrame;

public class labAssignment2 implements GLEventListener{
   
	private GLU glu;
   @Override
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
      gl.glPointSize(4);
      gl.glBegin(GL2.GL_POINTS);
      //My ID - 19101289 
     //eight
      DDA(gl, 10,10,15,10);
      DDA(gl, 10,10,10,5);
      DDA(gl, 10,5,10,0);
      DDA(gl, 10,0,15,0);
      DDA(gl, 15,0,15,5);
      DDA(gl, 15,5,15,10);
      //nine
      DDA(gl, 20,10,25,10);
      DDA(gl, 25,10,25,5);
      DDA(gl, 20,10,20,5);
      DDA(gl, 20,5,25,5);
      DDA(gl, 25,5,25,0);
      
      gl.glEnd();
      
   }
   @Override
   public void dispose(GLAutoDrawable arg0) {
      
   }
   
   @Override
   public void init(GLAutoDrawable gld) {
       GL2 gl = gld.getGL().getGL2();
       glu = new GLU();

       gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
       gl.glViewport(-100, -50, 50, 100);
       gl.glMatrixMode(GL2.GL_PROJECTION);
       gl.glLoadIdentity();
       glu.gluOrtho2D(-100.0, 100.0, -100.0, 100.0);
   }
   @Override
   public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
      // method body
   }
    
   public void DDA(GL2 gl,double x1, double y1, double x2, double y2) {
       
       gl.glPointSize(3.0f);
       gl.glColor3d(0, 1, 0);
       
     //write your own code
     
    	   double dx=x2-x1;
    	   double dy=y2-y1;
    	   double m=dy/dx;
    	   double step;
    	   gl.glVertex2d(x1,y1);
    	   if(Math.abs(dx) > Math.abs(dy)) {
    		   step= Math.abs(dx);
    	   } else {
    		   step= Math.abs(dy);
    	   }
    	   double Xinc= dx/step;
    	   double Yinc= dy/step;
    	   for (int i=0;i<=step;i++) {
    		   
    		   gl.glVertex2d(x1, y1);
    		   x1=x1+Xinc;
    		   y1=y1+Yinc;
    		   		   
    	   }
    }
   public static void main(String[] args) {
      //getting the capabilities object of GL2 profile
      final GLProfile profile = GLProfile.get(GLProfile.GL2);
      GLCapabilities capabilities = new GLCapabilities(profile);
      // The canvas 
      final GLCanvas glcanvas = new GLCanvas(capabilities);
      labAssignment2 l = new labAssignment2();
      glcanvas.addGLEventListener(l);
      glcanvas.setSize(400, 400);
      //creating frame
      final JFrame frame = new JFrame ("straight Line");
      //adding canvas to frame
      frame.getContentPane().add(glcanvas);
      frame.setSize(frame.getContentPane().getPreferredSize());
      frame.setVisible(true);
   }//end of main
}//end of classimport javax.media.opengl.GL2;


