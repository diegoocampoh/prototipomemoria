/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.dataAccess.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import memoria.commons.dataAccess.query.VisualQuery;
import memoria.commons.entities.EntidadPunto;
import memoria.commons.structures.GeoReferenced;
import memoria.commons.structures.Point;
import memoria.commons.structures.coordinates.LatLonCoordinate;
import memoria.dataAccess.IRepositoryDao;

/**
 *
 * @author diego
 */
public class PostgisDao implements IRepositoryDao {

    //Patron Singleton
    private static PostgisDao instance;
    public static IRepositoryDao getInstance(){
        if (instance == null)
            instance = new PostgisDao();
        return instance;
    }

    private String driver;
    private String connectionString;
    private String username;
    private String password;

    public List<GeoReferenced> getData(VisualQuery params) {

        List<GeoReferenced> results = new ArrayList<GeoReferenced>();
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectionString, username, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT (ST_AsText(geog)), nombre, distrito, zona_polic, "
                    + "telefono, celular, tipo, direccion, cod_calle from "
                    + "comisarias_reprojected");

            while (rs.next()){
                String puntos = rs.getString(1);
                puntos = puntos.replace("POINT(", "");
                puntos = puntos.replace(")", "");
                String coords[] = puntos.split(" ");
                String longitud = coords[0];
                String latitud = coords[1];

                String nombre = rs.getString(2);

                String descripcion = "";
                 for (int i=3; i<rs.getMetaData().getColumnCount()+1; i++) {
                    descripcion = descripcion + " "+rs.getString(i);
                }
                descripcion = descripcion.replace("\n", "");
                        
                Point punto = new Point(new LatLonCoordinate(latitud, longitud));
                EntidadPunto entidadPunto = new EntidadPunto(nombre, descripcion, punto);
                results.add(entidadPunto);
            }


        } catch (SQLException ex) {
            Logger.getLogger(PostgisDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostgisDao.class.getName()).log(Level.SEVERE, null, ex);
        }


        return results;
    }

    public void setInitParams(Map<String, String> params) {
        this.driver = params.get("DRIVER");
        this.connectionString = params.get("CONNECTIONSTRING");
        this.username = params.get("USERNAME");
        this.password = params.get("PASSWORD");
    }

}
