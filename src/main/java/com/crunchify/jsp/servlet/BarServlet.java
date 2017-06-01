/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crunchify.jsp.servlet;


import com.crunchify.jsp.servlet.CustomRenderer;
import edu.co.sergio.mundo.dao.RecoleccionDAO;
import java.awt.Color;
import java.awt.Paint;
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


public class BarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/png");
        OutputStream outputStream2 = response.getOutputStream();
        JFreeChart chart = getChart();
        int width2 = 500;
        int height2 = 350;
        ChartUtilities.writeChartAsPNG(outputStream2, chart, width2, height2);
	}

	public JFreeChart getChart() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        RecoleccionDAO rdao = new RecoleccionDAO();
        dataset.addValue(20.0, "Colmena 1", "municipio 1");
        dataset.addValue(8.0, "Colmena 2", "municipio 1");
        dataset.addValue(0.0, "Colmena 7", "municipio 1");
//        
//        for (int i = 0; i < 10; i++) {
//            
//        }
        
        


        JFreeChart chart = ChartFactory.createBarChart3D(
                "Kilos de Miel", // chart title
                "Colmena", // domain axis label
                "Value", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips
                false // urls
        );

        CategoryPlot plot = chart.getCategoryPlot();
        CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(
                CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 8.0)
        );

        CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setItemLabelsVisible(true);
        BarRenderer r = (BarRenderer) renderer;
        r.setMaximumBarWidth(0.05);
        return chart;

    }

}
