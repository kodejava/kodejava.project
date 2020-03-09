package org.kodejava.example.itextpdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class TableCellBorderDemo {
    public static void main(String[] args) {
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream("TableCellBorder.pdf"));
            doc.open();

            PdfPTable table = new PdfPTable(3);
            PdfPCell cell1 = new PdfPCell(new Phrase("Cell 1"));
            cell1.setUseBorderPadding(true);

            // Setting cell's border width and color
            cell1.setBorderWidth(5f);
            cell1.setBorderColor(BaseColor.BLUE);
            table.addCell(cell1);

            PdfPCell cell2 = new PdfPCell(new Phrase("Cell 2"));
            cell2.setUseBorderPadding(true);

            // Setting cell's background color
            cell2.setBackgroundColor(BaseColor.GRAY);

            // Setting cell's individual border color
            cell2.setBorderWidthTop(1f);
            cell2.setBorderColorTop(BaseColor.RED);
            cell2.setBorderColorRight(BaseColor.GREEN);
            cell2.setBorderColorBottom(BaseColor.BLUE);
            cell2.setBorderColorLeft(BaseColor.BLACK);
            table.addCell(cell2);

            PdfPCell cell3 = new PdfPCell(new Phrase("Cell 3"));
            cell3.setUseBorderPadding(true);

            // Setting cell's individual border width
            cell3.setBorderWidthTop(2f);
            cell3.setBorderWidthRight(1f);
            cell3.setBorderWidthBottom(2f);
            cell3.setBorderWidthLeft(1f);
            table.addCell(cell3);
            table.completeRow();

            doc.add(table);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            doc.close();
        }
    }
}
