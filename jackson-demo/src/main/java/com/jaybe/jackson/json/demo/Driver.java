package com.jaybe.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaybe.jackson.json.model.Student;

import java.io.File;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Driver {

    private static Logger logger = Logger.getLogger(Driver.class.getName());

    public static void main(String[] args) {

        try {
            // create object mapper
            ObjectMapper mapper = new ObjectMapper();

            // read JSON file and map/convert to Java POJO:
            // data/sample-lite.json
            File simpleJson = new File(Driver.class.getClassLoader().getResource("data/sample-full.json").getFile());
            Student student = mapper.readValue(simpleJson, Student.class);

            var address = student.getAddress();

            // print first name and last name
            logger.info(student.getFirstName());
            System.out.println(address);
            Stream.of(student.getLanguages()).forEach(logger::info);

        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

}
