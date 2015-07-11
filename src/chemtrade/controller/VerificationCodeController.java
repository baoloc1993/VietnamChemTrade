package chemtrade.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@WebServlet("/image")
public class VerificationCodeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		BufferedOutputStream out = null;            
        //BufferedImage myImage = null;                
        ByteArrayOutputStream bos = null;
        byte imageBuffer[] = null;
        JPEGImageEncoder jpg = null;
        String verificationCode = req.getParameter("vCode");
//        for (int i = 0; i < 6; i++) {
//            String rand = String.valueOf((char) (97 + new Random().nextInt(26)));
//            verificationCode += rand;
//        }
//        HttpSession session = req.getSession();
//        session.setAttribute("vCode",verificationCode);
      //  request.setAttribute("vCode", verificationCode);
		//String verificationCode = req.getParameter("vCode");
		BufferedImage image = getImageVerification(resp, verificationCode);
		bos = new ByteArrayOutputStream(); 

        jpg = JPEGCodec.createJPEGEncoder(bos);
        jpg.encode(image);

        imageBuffer = bos.toByteArray();
        out = new BufferedOutputStream(resp.getOutputStream(),imageBuffer.length);
		out.write(imageBuffer);
		out.flush();
	}
	Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
	
	public BufferedImage getImageVerification( HttpServletResponse response ,String verificationCode) throws IOException{
//		  response.setHeader("Pragma", "No-cache");
//		    response.setHeader("Cache-Control", "no-cache");
//		    response.setDateHeader("Expires", 0);
		    int width = 480, height = 200;
		    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		    Graphics g = image.getGraphics();
		    Random random = new Random();
		    g.setColor(new Color(255, 255, 255));
		    g.fillRect(0, 0, width, height);
		    g.setFont(new Font("Times New Roman", Font.ITALIC, 150));
		    String sRand = "";
		    Graphics2D g2d;
		    double k = 0;
		    //String vCode = request.getParameter ("vCode");
		    for (int i = 0; i < 6; i++) {
		    	String rand = String.valueOf(verificationCode.charAt(i));
		       // String rand = String.valueOf((char) (97 + random.nextInt(26)));
		        //sRand += rand;
		        g.setColor(new Color(0, 46, 184));
		        if (i == 0) {
		            k = (random.nextInt(3)-2) * Math.PI / 180.0;
		        } else if (k < 0) {
		            k = (random.nextInt(3)) * Math.PI / 180.0;
		        } else {
		            k = (random.nextInt(3)-5) * Math.PI / 180.0;
		        }
		        g2d = (Graphics2D) g;
		        g2d.rotate(k);
		        g2d.drawString(rand, 70 * i + random.nextInt(8), 140);
		        g2d.rotate(-k);
		    }
		    
		    //session.setAttribute("rand", sRand);
		    //out(oalert(session.getAttribute("rand"));
		    g.dispose();
		    return image;
		    //ImageIO.write(image, "JPEG", response.getOutputStream());
	}
	
	
}
