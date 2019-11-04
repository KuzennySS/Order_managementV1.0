package ru.kuzenny.testwork.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import ru.kuzenny.testwork.dto.OrderDto;
import ru.kuzenny.testwork.service.OrderService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class ConverterToXml {

    private static String PATH = "C:/java/project/Order management/src/main/java/ru/kuzenny/testwork/xml/orders.xml";

    public static void marshaller(List<OrderDto> object, String nameXmlFile) {
        XStream xStream = new XStream(new DomDriver());
        xStream.alias(nameXmlFile, List.class);
        xStream.processAnnotations(OrderDto.class);

        String xml = xStream.toXML(object);
        try {
            saveToFile(xml, nameXmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveToFile(String xml, String nameFile) throws IOException {
        File file = new File(PATH);
        file.createNewFile();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(PATH)));
        bufferedWriter.write(xml);
        bufferedWriter.close();
    }

}
