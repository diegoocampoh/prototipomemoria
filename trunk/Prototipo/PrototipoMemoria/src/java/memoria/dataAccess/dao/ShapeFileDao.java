/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.dataAccess.dao;

import java.util.List;
import memoria.commons.dataAccess.query.QueryParams;
import memoria.commons.dataAccess.query.VisualQuery;
import memoria.commons.structures.GeoReferenced;
import memoria.dataAccess.IRepositoryDao;
import memoria.dataAccess.SpatialDTO;

/**
 *
 * @author diego
 */
public class ShapeFileDao implements IRepositoryDao {

    public List<GeoReferenced> getData(VisualQuery params) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
