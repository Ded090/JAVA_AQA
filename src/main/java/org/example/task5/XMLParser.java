package org.example.task5;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class XMLParser {
    public static void main(String[] args) throws IOException {
        //Serialization-Deserialization:
        //a) Make some complex models using your variant.
        //b) Make it serializable.
        //c) Read json from “input.xml”
        //d) and deserialize it to POJO.
        //e) Then change a few fields and save it to “output.xml”.

        XmlMapper xmlMapper = new XmlMapper();

        Map<String, String> adresses = new HashMap<>();
        adresses.put("zip", "99107");
        adresses.put("state", "CA");
        adresses.put("city", "San Francisco");

        Person person = new Person("Ale", 35, adresses);

        System.out.println(person);
        xmlMapper.writeValue(new File("person0.xml"), person);


        Person person1 = xmlMapper.readValue(new File("input.xml"), Person.class);

        System.out.println(person1);
        person1.setName("Ko");
        person1.setAge(20);
        xmlMapper.writeValue(new File("output.xml"), person1);


    }
}
