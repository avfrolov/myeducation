package org.myeducation.portal.server;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.myeducation.properties.PropertiesFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 08.06.13
 * Time: 20:34
 * To change this template use File | Settings | File Templates.
 */
public class LectureUploadServlet extends HttpServlet {

    private static final String UPLOAD_DIRECTORY = PropertiesFactory.getProperties("filesystem").getProperty("lecturefilepath");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // process only multipart requests
        if (ServletFileUpload.isMultipartContent(req)) {

            // Create a factory for disk-based file items
            FileItemFactory factory = new DiskFileItemFactory();

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            File uploadedFile = null;
            try {
                List<FileItem> items = upload.parseRequest(req);
                for (FileItem item : items) {
                    // process only file upload - discard other form item types
                    if (item.isFormField()) continue;

                    String fileName = item.getName();
                    // get only the file name not whole path
                    if (fileName != null) {
                        fileName = FilenameUtils.getName(fileName);
                    }

                    int dotIndex = fileName.lastIndexOf(".");
                    fileName = fileName.substring(0, dotIndex) + System.currentTimeMillis() + fileName.substring(dotIndex);
                    uploadedFile = new File(UPLOAD_DIRECTORY + File.separator, fileName);

                    if (uploadedFile.createNewFile()) {
                        item.write(uploadedFile);
                    } else
                        throw new IOException("The file already exists in repository.");

                }
            } catch (Exception e) {

            }

        }
    }

}
