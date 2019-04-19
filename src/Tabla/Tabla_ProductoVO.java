package Tabla;

import CRUD.ProductoCRUD;
import VO.ProductoVO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Tabla_ProductoVO{

   ProductoCRUD dao = null;
   
    public void visualizar_ProductoVO(JTable tabla){
        
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        dt.addColumn("ID");
        dt.addColumn("Nombre");
        dt.addColumn("Precio");
        dt.addColumn("Descripcion");
        dt.addColumn("Foto");
        dt.addColumn("Tamaño");

        dao = new ProductoCRUD();
        ProductoVO vo = new ProductoVO();
        ArrayList<ProductoVO> list = dao.Listar_ProductoVO();

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[6];
                vo = list.get(i);
                fila[0] = vo.getIdproducto();
                fila[1] = vo.getNombre();
                fila[2] = vo.getPrecio();
                fila[3] = vo.getDescripcion();
                try{
                    byte[] bi = vo.getFoto();
                    BufferedImage image = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    image = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(80, 80, 0));
                    fila[4] = new JLabel(imgi);

                }catch(Exception ex){
                    fila[4] = new JLabel("No imagen");
                }
                    fila[5] = vo.getTamaño();
                    
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(80);
        }
    }
}
