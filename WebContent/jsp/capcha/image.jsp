<%-- 
    Document   : image
    Created on : 2015-5-20, 10:20:09
    Author     : Fla
--%>

<%@ page contentType="image/jpeg" import="java.awt.*, 
         java.awt.image.*,java.util.*,javax.imageio.*" %> 
<%!
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
%> 
<%
    out.clear();
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
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
    for (int i = 0; i < 6; i++) {
        String rand = String.valueOf((char) (97 + random.nextInt(26)));
        sRand += rand;
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
    session.setAttribute("rand", sRand);
    g.dispose();
    ImageIO.write(image, "JPEG", response.getOutputStream());
%>