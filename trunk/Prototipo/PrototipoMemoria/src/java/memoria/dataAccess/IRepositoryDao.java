/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.dataAccess;

import java.util.List;
import memoria.commons.dataAccess.query.QueryParams;

/**
 *
 * @author diego
 */
public interface IRepositoryDao {
    List<SpatialDTO> getData(List<QueryParams> params);
}
