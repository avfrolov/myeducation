package org.myeducation.taskexecuter.processor;

import java.io.File;

/**
 * @author Andrey Frolov
 * @since  28.02.13
 */
public class ProcessorFactory {

    public static Processor getProcessor(File file) {
        Processor processor = null;
        String extension = file.getName().substring(file.getName().indexOf(".") + 1).toLowerCase();
        if (extension.equals("java")) {
            processor =  new ProgramProcessor(file);
        }
        return processor;
    }

}
