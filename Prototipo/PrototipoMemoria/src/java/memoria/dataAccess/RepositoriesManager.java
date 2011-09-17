/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.dataAccess;

import memoria.commons.dataAccess.query.QueryParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import memoria.commons.entities.Escuela;

/**
 *
 * @author diego
 */
public class RepositoriesManager {

    private List<IRepositoryDao> repositories;
    private HashMap<String,List<IRepositoryDao>> entitiesLocationMap;

    public RepositoriesManager() {
        entitiesLocationMap = new HashMap<String,List<IRepositoryDao>>();
        List<IRepositoryDao> repositoriosDeEscuela = new ArrayList<IRepositoryDao>();
        repositoriosDeEscuela.add(ExcelDao.getInstance());
        entitiesLocationMap.put(Escuela.class.getSimpleName(),repositoriosDeEscuela);
    }

    public List<SpatialDTO> getData(List<QueryParams> params){
        return new ExcelDao().getData(params);
    }

    public List<IRepositoryDao> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<IRepositoryDao> repositories) {
        this.repositories = repositories;
    }

    

}
