package com.yaoxj.markimage;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

public class MarkImageByText {

	 /**
     * ��ͼƬ���ˮӡ���֡�������ˮӡ���ֵ���ת�Ƕ�
     * @param logoText Ҫд�������
     * @param srcImgPath ԴͼƬ·��
     * @param newImagePath ��ͼƬ·��
     * @param degree ��ת�Ƕ�
     * @param color  ������ɫ
     * @param formaName ͼƬ��׺
     */
    public static void markImageByText(String logoText, String srcImgPath,String newImagePath,Integer degree,Color color,String formaName) {
        InputStream is = null;
        OutputStream os = null;
        try {
            // 1��ԴͼƬ
            java.awt.Image srcImg = ImageIO.read(new File(srcImgPath));
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);
            // 2���õ����ʶ���
            Graphics2D g = buffImg.createGraphics();
            // 3�����ö��߶εľ��״��Ե����
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), java.awt.Image.SCALE_SMOOTH), 0, 0, null);
            // 4������ˮӡ��ת
            if (null != degree) {
                g.rotate(Math.toRadians(degree),  buffImg.getWidth()/2,buffImg.getHeight() /2);
            }
            // 5������ˮӡ������ɫ
            g.setColor(color);
            // 6������ˮӡ����Font
            g.setFont(new java.awt.Font("����", java.awt.Font.BOLD, buffImg.getHeight() /2));
            // 7������ˮӡ����͸����
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.15f));
            // 8����һ����->���õ����ݣ�������������->������ͼƬ�ϵ�����λ��(x,y)
            g.drawString(logoText,  buffImg.getWidth()/2 , buffImg.getHeight()/2);
            // 9���ͷ���Դ
            g.dispose();
            // 10������ͼƬ
            os = new FileOutputStream(newImagePath);
            ImageIO.write(buffImg, formaName, os);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != is)
                    is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (null != os)
                    os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
	public static void main(String[] args) {
		markImageByText("hello world","D:/1.jpg","D:2.jpg",45,new Color(0,0,0),"JPG");
	}
}
