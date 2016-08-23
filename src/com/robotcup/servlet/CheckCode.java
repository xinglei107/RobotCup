package com.robotcup.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
/**
 * 
 * @类名
 * 验证码
 *
 */
public class CheckCode extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public static final char[] CHARS = { '1', '2', '3', '4', '5', '6', '7',
            '8', '9', '0', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z', };
    public static Random random = new Random();

    public static String getRandomString() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            buffer.append(CHARS[random.nextInt(CHARS.length)]);
        }
        return buffer.toString();
    }

    public static Color getRandomColor() {
        return new Color(255, 255,255);
    }

    public static Color getReverseColor(Color c) {
//        return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c
//                .getBlue());
    	return Color.red;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/jpeg");
        String radomString = getRandomString();
        HttpSession  session=request.getSession();
        session.setAttribute("checkcode",radomString);
        Color color = getRandomColor();
        Color reverse = getReverseColor(color);
        BufferedImage bi = new BufferedImage(50, 20, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        g.setFont(new Font("微软雅黑",Font.BOLD,16));
        g.setColor(color);
        g.fillRect(0,0,50,20);
        g.setColor(reverse);
        g.drawString(radomString,2,15);
        g.setColor(Color.blue);
        for (int i = 0,n = 20; i<n; i++) {
            g.drawRect(random.nextInt(50), random.nextInt(20), 1, 1);
        }
        ServletOutputStream out = response.getOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(bi);
        g.dispose();
        bi.flush();
        out.flush();
        out.close();
    }
}
