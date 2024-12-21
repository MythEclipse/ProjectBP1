package kelompok12.layout.admin;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.*;
import net.sf.jasperreports.engine.type.*;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import kelompok12.database.lib.DatabaseUtil;

public class Laporan {
    private DatabaseUtil koneksi;

    public Laporan() {
        koneksi = new DatabaseUtil();
    }

    public void generateReport(List<Map<String, ?>> data1, List<Map<String, ?>> data2) {
        try {
            // Create JasperDesign
            JasperDesign jasperDesign = new JasperDesign();
            jasperDesign.setName("DynamicReport");
            jasperDesign.setPageWidth(595);
            jasperDesign.setPageHeight(842);
            jasperDesign.setColumnWidth(555);
            jasperDesign.setLeftMargin(20);
            jasperDesign.setRightMargin(20);
            jasperDesign.setTopMargin(20);
            jasperDesign.setBottomMargin(20);
            jasperDesign.setWhenNoDataType(WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL);

            // Add Fields for first table
            String[] fields1 = { "id", "username", "password", "jenisKelamin", "alamat", "uang" };
            for (String field : fields1) {
                JRDesignField jrField = new JRDesignField();
                jrField.setName(field);
                jrField.setValueClass(String.class);
                jasperDesign.addField(jrField);
            }

            // Add Fields for second table
            String[] fields2 = { "id", "Username", "type", "penggunaan", "saldoAwal", "saldoAkhir" };
            for (String field : fields2) {
                JRDesignField jrField = new JRDesignField();
                jrField.setName(field);
                jrField.setValueClass(String.class);
                jasperDesign.addField(jrField);
            }

            // Title Band
            JRDesignBand titleBand = new JRDesignBand();
            titleBand.setHeight(50);
            JRDesignStaticText titleText = new JRDesignStaticText();
            titleText.setText("Laporan Bank Simple");
            titleText.setX(0);
            titleText.setY(10);
            titleText.setWidth(555);
            titleText.setHeight(30);
            titleText.setVerticalTextAlign(VerticalTextAlignEnum.MIDDLE);
            titleText.setHorizontalTextAlign(HorizontalTextAlignEnum.CENTER);
            titleBand.addElement(titleText);
            jasperDesign.setTitle(titleBand);

            // Header Band for first table
            JRDesignBand headerBand1 = new JRDesignBand();
            headerBand1.setHeight(30);
            int x = 0;

            String[] headers1 = { "ID", "Username", "Password", "Jenis Kelamin", "Alamat", "Uang" };
            for (int i = 0; i < headers1.length; i++) {
                JRDesignStaticText headerText = new JRDesignStaticText();
                headerText.setText(headers1[i]);
                headerText.setX(x);
                headerText.setY(0);
                headerText.setWidth(90);
                headerText.setHeight(30);
                headerText.setHorizontalTextAlign(HorizontalTextAlignEnum.CENTER);
                headerText.setVerticalTextAlign(VerticalTextAlignEnum.MIDDLE);
                headerText.setBackcolor(Color.BLUE);
                headerText.setForecolor(Color.WHITE);
                headerText.setMode(ModeEnum.OPAQUE);

                headerText.getLineBox().getPen().setLineWidth(0.5f);

                headerBand1.addElement(headerText);
                x += 90; // Adjust width for each column
            }
            jasperDesign.setColumnHeader(headerBand1);

            // Detail Band for first table
            JRDesignBand detailBand1 = new JRDesignBand();
            detailBand1.setHeight(20);
            x = 0;

            for (String field : fields1) {
                JRDesignTextField textField = new JRDesignTextField();
                textField.setX(x);
                textField.setY(0);
                textField.setWidth(90);
                textField.setHeight(20);
                textField.setHorizontalTextAlign(HorizontalTextAlignEnum.CENTER);
                textField.setVerticalTextAlign(VerticalTextAlignEnum.MIDDLE);
                textField.setStretchType(StretchTypeEnum.NO_STRETCH); // Use StretchTypeEnum instead

                textField.setExpression(new JRDesignExpression("$F{" + field + "}"));
                textField.getLineBox().getPen().setLineWidth(0.5f);

                detailBand1.addElement(textField);
                x += 90; // Adjust width for each column
            }
            ((JRDesignSection) jasperDesign.getDetailSection()).addBand(detailBand1);

            // Header Band for second table
            JRDesignBand headerBand2 = new JRDesignBand();
            headerBand2.setHeight(30);
            x = 0;

            String[] headers2 = { "ID", "Username", "Type", "Penggunaan", "Saldo Awal", "Saldo Akhir" };
            for (int i = 0; i < headers2.length; i++) {
                JRDesignStaticText headerText = new JRDesignStaticText();
                headerText.setText(headers2[i]);
                headerText.setX(x);
                headerText.setY(0);
                headerText.setWidth(90);
                headerText.setHeight(30);
                headerText.setHorizontalTextAlign(HorizontalTextAlignEnum.CENTER);
                headerText.setVerticalTextAlign(VerticalTextAlignEnum.MIDDLE);
                headerText.setBackcolor(Color.BLUE);
                headerText.setForecolor(Color.WHITE);
                headerText.setMode(ModeEnum.OPAQUE);

                headerText.getLineBox().getPen().setLineWidth(0.5f);

                headerBand2.addElement(headerText);
                x += 90; // Adjust width for each column
            }
            jasperDesign.setColumnHeader(headerBand2);

            // Detail Band for second table
            JRDesignBand detailBand2 = new JRDesignBand();
            detailBand2.setHeight(20);
            x = 0;

            for (String field : fields2) {
                JRDesignTextField textField = new JRDesignTextField();
                textField.setX(x);
                textField.setY(0);
                textField.setWidth(90);
                textField.setHeight(20);
                textField.setHorizontalTextAlign(HorizontalTextAlignEnum.CENTER);
                textField.setVerticalTextAlign(VerticalTextAlignEnum.MIDDLE);
                textField.setStretchType(StretchTypeEnum.NO_STRETCH); // Use StretchTypeEnum instead

                textField.setExpression(new JRDesignExpression("$F{" + field + "}"));
                textField.getLineBox().getPen().setLineWidth(0.5f);

                detailBand2.addElement(textField);
                x += 90; // Adjust width for each column
            }
            ((JRDesignSection) jasperDesign.getDetailSection()).addBand(detailBand2);

            // Compile the report
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

            // Data sources
            JRBeanCollectionDataSource dataSource1 = new JRBeanCollectionDataSource(data1);
            JRBeanCollectionDataSource dataSource2 = new JRBeanCollectionDataSource(data2);

            // Parameters
            Map<String, Object> parameters = new HashMap<>();

            // Fill the report
            JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport, parameters, dataSource1);
            JasperPrint jasperPrint2 = JasperFillManager.fillReport(jasperReport, parameters, dataSource2);

            // Display report in JasperViewer
            JasperViewer.viewReport(jasperPrint1, false);
            JasperViewer.viewReport(jasperPrint2, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Laporan reportGenerator = new Laporan();
        List<Map<String, ?>> data1 = reportGenerator.fetchData1();
        List<Map<String, ?>> data2 = reportGenerator.fetchData2();
        reportGenerator.generateReport(data1, data2);
    }

    List<Map<String, ?>> fetchData1() {
        List<Map<String, ?>> data = new ArrayList<>();
        String sql = "SELECT id, username, password, jenisKelamin, alamat, uang FROM User";

        try (Connection con = koneksi.con;
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("id", rs.getString("id"));
                row.put("username", rs.getString("username"));
                row.put("password", rs.getString("password"));
                row.put("jenisKelamin", rs.getString("jenisKelamin"));
                row.put("alamat", rs.getString("alamat"));
                row.put("uang", rs.getLong("uang"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    List<Map<String, ?>> fetchData2() {
        List<Map<String, ?>> data = new ArrayList<>();
        String sql = "SELECT id, Username, type, penggunaan, saldoAwal, saldoAkhir FROM Transaksi";

        try (Connection con = koneksi.con;
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("id", rs.getString("id"));
                row.put("Username", rs.getString("Username"));
                row.put("type", rs.getString("type"));
                row.put("penggunaan", rs.getLong("penggunaan"));
                row.put("saldoAwal", rs.getLong("saldoAwal"));
                row.put("saldoAkhir", rs.getLong("saldoAkhir"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
