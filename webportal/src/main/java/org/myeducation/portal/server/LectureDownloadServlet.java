package org.myeducation.portal.server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 09.06.13
 * Time: 2:22
 * To change this template use File | Settings | File Templates.
 */
public class LectureDownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("path");
        if (filename.contains("file:")) {
            filename = filename.substring(5);
        }
        resp.setContentType("application/octet-stream");
        resp.setHeader("Content-Disposition", "attachment; filename*=\"utf-8''" + filename + "");

        byte[] bbuf = new byte[1024];
        DataInputStream in = new DataInputStream(new FileInputStream(filename));
        OutputStream op = resp.getOutputStream();

        int length = 0;
        while ((in != null) && ((length = in.read(bbuf)) != -1)) {
            op.write(bbuf, 0, length);
        }

        in.close();
        op.flush();
        op.close();
    }
}
