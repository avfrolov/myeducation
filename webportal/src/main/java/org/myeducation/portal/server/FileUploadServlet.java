package org.myeducation.portal.server;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.myeducation.databaseapi.entities.TestDataResult;

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
 * Date: 19.05.13
 * Time: 14:41
 * To change this template use File | Settings | File Templates.
 */

public class FileUploadServlet extends HttpServlet {

    //TODO
    private static final String UPLOAD_DIRECTORY = "/Volumes/Dev/Example/";

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

            // Parse the request
            File circuit = null, rules = null;
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
                    if (item.getFieldName().contains("circuit")) {
                        fileName = "circuit" + System.currentTimeMillis() + fileName.substring(dotIndex);
                    } else if (item.getFieldName().contains("rules")) {
                        fileName = "rules" + System.currentTimeMillis() + fileName.substring(dotIndex);
                    } else {
                        fileName = fileName.substring(0, dotIndex) + System.nanoTime() + fileName.substring(dotIndex);
                    }

                    File uploadedFile = new File(UPLOAD_DIRECTORY, fileName);

                    if (fileName.contains("circuit")) {
                        circuit = uploadedFile;
                    } else if (fileName.contains("rules")) {
                        rules = uploadedFile;
                    }

                    if (uploadedFile.createNewFile()) {
                        item.write(uploadedFile);
//                        resp.setStatus(HttpServletResponse.SC_CREATED);
                        resp.flushBuffer();
                    } else
                        throw new IOException("The file already exists in repository.");

                }
                TestDataResult result = TaskSender.sendTask(circuit, rules);
                resp.getWriter().write(Boolean.toString(result.isSuccess()));
                resp.flushBuffer();
            } catch (Exception e) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                        "An error occurred while creating the file : " + e.getMessage());
                resp.getWriter().write(e.getMessage());
                resp.flushBuffer();
            }

        } else {
            resp.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE,
                    "Request contents type is not supported by the servlet.");
        }
    }
}