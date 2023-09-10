package utils;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    static public Iterator<Object[]> positiveUsers() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"test", "test"});
        list.add(new Object[]{"test", "test"});
        list.add(new Object[]{"test", "test"});

        return list.iterator();
    }


    @DataProvider
    static public Iterator<Object[]> negativeUsers() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"j@mail.ua", " "});
        list.add(new Object[]{"j@mail.ua", "239829839823"});
        list.add(new Object[]{"j@mail.ua", "     "});
        list.add(new Object[]{"j@mail.ua", "@#*($"});
        list.add(new Object[]{"j@mail.ua", "sdfdfdf"});

        return list.iterator();
    }


    @DataProvider
    static public Iterator<Object[]> invalidEmailFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/WrongEmail.csv")));
        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");

            list.add(new Object[]{(split[0]),(split[1])});
            line = reader.readLine();
        }

        return list.iterator();
    }


}

