package obligatorio;

import java.io.*;
import javax.swing.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class Excel {

    private Workbook wb;

    public String exportarExcel(File archivo, JTable tablaD) {
        String respuesta = "No se realizó con exito la exportación.";
        int numFila = tablaD.getRowCount();
        int numColumna = tablaD.getColumnCount();
        //Se pregunta el formato de el archivo excel que se elige y se crea el achivo con cuyo formato
        if (archivo.getName().endsWith("xls")) {
            wb = new HSSFWorkbook();
        } else {
            wb = new XSSFWorkbook();
        }
        Sheet hoja = wb.createSheet("Prueba");
        try {
            for (int i = -1; i < numFila; i++) {
                Row fila = hoja.createRow(i + 1);
                for (int j = 0; j < numColumna; j++) {
                    Cell celda = fila.createCell(j);
                    if (i == -1) {
                        celda.setCellValue(String.valueOf(tablaD.getColumnName(j)));
                    } else {
                        celda.setCellValue(String.valueOf(tablaD.getValueAt(i, j)));
                    }
                    wb.write(new FileOutputStream(archivo));
                }
            }
            respuesta = "Exportación exitosa";
        } catch (Exception e) {

        }

        return respuesta;
    }
}
