/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.dataAccess;

import java.util.List;
import java.util.Map;
import memoria.commons.dataAccess.query.QueryParams;
import memoria.commons.dataAccess.query.VisualQuery;
import memoria.commons.structures.GeoReferenced;

/**
 *
 * @author diego
 */
public interface IRepositoryDao {
    List<GeoReferenced> getData(VisualQuery params);
    void setInitParams(Map<String,String> params);
}
