package org.myeducation.taskexecuter.processor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

/**
 * @author Andrey Frolov
 * @since 28.02.13
 */
public class ProgramProcessor extends Processor {

    private File file;
    private String path = "/Volumes/Dev/Example/"; //TODO must be configured from configuration file

    public ProgramProcessor(File file) {
        this.file = file;
    }

    @Override
    public void execute(String[] args) {
        try {
            String name = file.getName().substring(0, file.getName().indexOf("."));
            List<String> commands = new ArrayList<String>();
            //TODO commands for compile needed to import from configuration file
            commands.add("javac");
            commands.add(path + name + ".java");

            executeProcess(commands, args);
            createJar(name);

            commands.clear();
            commands.add("java");
            commands.add("-jar");
            commands.add(path + name + ".jar");

            Process process = executeProcess(commands, args);

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    process.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    private void createJar(String name) throws IOException {
        Manifest manifest = new Manifest();
        manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
        manifest.getMainAttributes().put(Attributes.Name.MAIN_CLASS, name);
        JarOutputStream target = new JarOutputStream(new FileOutputStream(path + name + ".jar"), manifest);
        addFileToJar(new File(path + name + ".class"), target);
        target.close();
    }

    private void addFileToJar(File source, JarOutputStream target) throws IOException {
        BufferedInputStream in = null;
        try {
            JarEntry entry = new JarEntry(source.getName());
            entry.setTime(source.lastModified());
            target.putNextEntry(entry);
            in = new BufferedInputStream(new FileInputStream(source));

            byte[] buffer = new byte[2048];  //TODO what about size of buffer?
            while (true) {
                int count = in.read(buffer);
                if (count == -1)
                    break;
                target.write(buffer, 0, count);
            }
            target.closeEntry();
        } finally {
            if (in != null)
                in.close();
        }
    }

    private Process executeProcess(List<String> commands, String[] args) throws InterruptedException, IOException {
        ProcessBuilder builder = new ProcessBuilder(commands);
        builder.redirectErrorStream(true);
        Process process = builder.start();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
        for (String arg : args) {
            bw.write(arg);
        }
        bw.write("\n"); // For imitate to pressed button "Enter"

        bw.flush();
        process.waitFor();
        bw.close();
        return process;
    }
}
