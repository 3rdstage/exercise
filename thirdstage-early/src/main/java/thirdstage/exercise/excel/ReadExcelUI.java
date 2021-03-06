/*
 * sample application from the article "How to Work with Excel Files Using NetBeans"
 * at "http://www.netbeans.org/kb/articles/excel-tutorial.html"
 *
 * Created on 2006-06-26
 */

package thirdstage.exercise.excel;

import java.awt.Cursor;
import javax.swing.*;
import javax.swing.table.TableModel;
import jxl.Sheet;
import jxl.Workbook;
import jxl.Cell;
/**
 * sample application from the article "How to Work with Excel Files Using NetBeans"
 * at "http://www.netbeans.org/kb/articles/excel-tutorial.html"
 *
 * @author  3rdstage
 */
public class ReadExcelUI extends javax.swing.JFrame {
	
	/** Creates new form ReadExcelUI */
	public ReadExcelUI() {
		initComponents();
	}
	
	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
   // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
   private void initComponents() {
      jScrollPane1 = new javax.swing.JScrollPane();
      jTable1 = new javax.swing.JTable();
      jMenuBar1 = new javax.swing.JMenuBar();
      jMenu1 = new javax.swing.JMenu();
      jMenuItem1 = new javax.swing.JMenuItem();
      jSeparator1 = new javax.swing.JSeparator();
      jMenuItem2 = new javax.swing.JMenuItem();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      jTable1.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
         },
         new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
         }
      ));
      jScrollPane1.setViewportView(jTable1);

      jMenu1.setText("File");
      jMenuItem1.setText("Open");
      jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem1ActionPerformed(evt);
         }
      });

      jMenu1.add(jMenuItem1);

      jMenu1.add(jSeparator1);

      jMenuItem2.setText("Exit");
      jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem2ActionPerformed(evt);
         }
      });

      jMenu1.add(jMenuItem2);

      jMenuBar1.add(jMenu1);

      setJMenuBar(jMenuBar1);

      org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
            .addContainerGap(13, Short.MAX_VALUE)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 375, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
            .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 275, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
      );
      pack();
   }// </editor-fold>//GEN-END:initComponents

	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
// TODO add your handling code here:
		dispose();
		System.exit(0);
		
	}//GEN-LAST:event_jMenuItem2ActionPerformed

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
		java.io.File file = chooseExcelFile();
		
		if(file == null) { return; }
		
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		
		jxl.Sheet sheet = readExcelSheet(file);
		if(sheet != null){ displaySheet(sheet, jTable1); }
		
		setCursor(Cursor.getDefaultCursor());
		
	}//GEN-LAST:event_jMenuItem1ActionPerformed
	
	private jxl.Sheet readExcelSheet(java.io.File file){
		
		jxl.Workbook wbk;
		try{
			wbk = jxl.Workbook.getWorkbook(file);
		}
		catch(Exception ex){
			JOptionPane message = new JOptionPane("Can't read Excel file " + file.getPath(), JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
		if(wbk.getNumberOfSheets() <= 0){
			JOptionPane message = new JOptionPane("Excel file doesn't any sheet.", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
		return wbk.getSheet(0);
	}
	
	
	private void displaySheet(Sheet sheet, JTable table){
		table.setModel(new SheetTableModel(sheet));
	}
	
	private static class SheetTableModel implements TableModel{
		
		private Sheet sheet;
		
		public SheetTableModel(Sheet sheet){
			this.sheet = sheet;
		}
		
		public int getRowCount(){
			return this.sheet.getRows();
		}
		
		public int getColumnCount(){
			return this.sheet.getColumns();
		}

		public String getColumnName(int column){
			String result = "";
			for(;column >= 0; column = column/26 - 1){
				result = (char)((char)(column%26) + 'A') + result;
			}
			return result;
		}
		
		public Class<?> getColumnClass(int columnIndex){
			return String.class;
		}
		
		public boolean isCellEditable(int rowIndex, int columnIndex){
			return false;
		}
		
		public Object getValueAt(int rowIndex, int columnIndex){
			Cell cell = sheet.getCell(columnIndex, rowIndex);
			return cell.getContents();
		}
		
		public void setValueAt(Object value, int rowIndex, int columnIndex){
			
		}
		
		public void addTableModelListener(javax.swing.event.TableModelListener l){
			
		}
		
		public void removeTableModelListener(javax.swing.event.TableModelListener l){
			
		}
		
	}
	
	private java.io.File chooseExcelFile(){
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new XSLFilter());
		
		int returnVal = chooser.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION){
			return chooser.getSelectedFile();
		}
		else{ return null; }
	}
	
	private static class XSLFilter extends javax.swing.filechooser.FileFilter{
		
		public boolean accept(java.io.File f){
			return f.isDirectory() || f.getName().endsWith(".xls");
		}
		
		public String getDescription(){
			return "Excel spreadsheet XSL files.";
		}
	}
	
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ReadExcelUI().setVisible(true);
			}
		});
	}
	
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JMenu jMenu1;
   private javax.swing.JMenuBar jMenuBar1;
   private javax.swing.JMenuItem jMenuItem1;
   private javax.swing.JMenuItem jMenuItem2;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JSeparator jSeparator1;
   private javax.swing.JTable jTable1;
   // End of variables declaration//GEN-END:variables
	
}
