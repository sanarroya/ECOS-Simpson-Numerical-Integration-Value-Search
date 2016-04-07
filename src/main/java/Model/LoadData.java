/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SantiagoAvila
 */
public class LoadData {
    
    /**
     *Load data from .txt file into a List of ClassInfo objects
     * 
     * @param fileName
     * @return classInfo list with the information read from the file
     */
    public static List<IntegralInfo> loadDataFromFile(String fileName) {
        List<IntegralInfo> dataList = new ArrayList<>();
        File archive = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = reader.readLine()) != null) {
                StringTokenizer stringTokenized = new StringTokenizer(line, "\n");
                if(stringTokenized.hasMoreTokens()) {
                    IntegralInfo integralInfo = new IntegralInfo();
                    String[] stringsInLine = stringTokenized.nextToken().split(",");
                    integralInfo.setIntegralLowerLimit(Double.parseDouble(stringsInLine[0]));
                    integralInfo.setIntegralUpperLimit(Double.parseDouble(stringsInLine[1]));
                    integralInfo.setDegreesOfFreedom(Double.parseDouble(stringsInLine[2]));
                    integralInfo.setExpectedResult(Double.parseDouble(stringsInLine[3]));
                    integralInfo.setNumberOfSegments(10.0);
                    dataList.add(integralInfo);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataList;
    }
}
