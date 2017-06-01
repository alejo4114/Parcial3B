/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crunchify.jsp.servlet;

import edu.co.sergio.mundo.dao.RecoleccionDAO;
import java.awt.BasicStroke;
import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.data.general.DefaultPieDataset;

public class ChartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/png");
        OutputStream outputStream = response.getOutputStream();
        JFreeChart chart = getChart();
        int width = 500;
        int height = 350;
        ChartUtilities.writeChartAsPNG(outputStream, chart, width, height);
    
        response.setContentType("image2/png");
        OutputStream outputStream2 = response.getOutputStream();
        JFreeChart chart2 = getChart2();
        int width2 = 800;
        int height2 = 550;
        ChartUtilities.writeChartAsPNG(outputStream2, chart2, width2, height2);

    }

    public JFreeChart getChart() {

        DefaultPieDataset dataset = new DefaultPieDataset();
        //Crear la capa de servicios que se enlace con el DAO
        dataset.setValue("Paneles con alimento", 80.0);
        dataset.setValue("Paneles sin alimento", 20.0);

        boolean legend = true;
        boolean tooltips = false;
        boolean urls = false;

        JFreeChart chart = ChartFactory.createPieChart("Informacion panal colmena 1", dataset, legend, tooltips, urls);

        chart.setBorderPaint(Color.GREEN);
        chart.setBorderStroke(new BasicStroke(5.0f));
        chart.setBorderVisible(true);

        return chart;
    }

    public JFreeChart getChart2() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        RecoleccionDAO rdao = new RecoleccionDAO();
        
        for (int i = 0; i < 10; i++) {
            
        }
        
        dataset.addValue(25.0, "Colmena 1", "Category 1");
        dataset.addValue(34.0, "Colmena 2", "Category 1");
        dataset.addValue(19.0, "Colmena 7", "Category 1");


        JFreeChart chart2 = ChartFactory.createBarChart3D(
                "Kilos de Miel", // chart title
                "Colmena", // domain axis label
                "Value", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips
                false // urls
        );

        CategoryPlot plot = chart2.getCategoryPlot();
        CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(
                CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 8.0)
        );

        CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setItemLabelsVisible(true);
        BarRenderer r = (BarRenderer) renderer;
        r.setMaximumBarWidth(0.05);
        return chart2;

    }

}
