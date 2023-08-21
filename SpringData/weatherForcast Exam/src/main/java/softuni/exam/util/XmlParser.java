package softuni.exam.util;

import jakarta.xml.bind.JAXBException;

import java.io.FileNotFoundException;

public interface XmlParser {
    <T> T fromFile(String filePath, Class<T> tClass) throws  FileNotFoundException, JAXBException;

    <T> void writeToFile(String filePath, T entity) throws JAXBException;
}
