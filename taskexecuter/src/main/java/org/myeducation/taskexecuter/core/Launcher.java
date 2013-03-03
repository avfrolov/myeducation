package org.myeducation.taskexecuter.core;

import org.myeducation.taskexecuter.processor.Processor;
import org.myeducation.taskexecuter.processor.ProcessorFactory;

import java.io.File;

/**
 * @author kirilkadurilka
 * @since  13.02.13
 */
public class Launcher {

    public static void main(String[] args) {

        String[] arg = {"3"};

//        File file = new File("/Volumes/Dev/Example/HelloWorld.java");
        File file = new File("/Volumes/Dev/Example/Calculator.java");
        Processor processor = ProcessorFactory.getProcessor(file);
        processor.execute(arg);
    }

}
