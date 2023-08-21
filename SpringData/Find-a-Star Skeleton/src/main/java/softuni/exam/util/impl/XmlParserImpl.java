package softuni.exam.util.impl;

import org.springframework.stereotype.Component;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;

@Component
public class XmlParserImpl implements XmlParser {
    @Override
    public <T> T fromFile(String filePath, Class<T> tClass) throws FileNotFoundException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(tClass);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (T) unmarshaller.unmarshal(new File(filePath));
    }

    @Override
    public <T> void writeToFile(String filePath, T entity) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(entity.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(entity, new File(filePath));
    }
}
