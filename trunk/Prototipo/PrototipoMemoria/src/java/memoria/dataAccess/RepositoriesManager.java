/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.dataAccess;

import memoria.dataAccess.dao.ExcelDao;
import memoria.commons.dataAccess.query.QueryParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import memoria.commons.dataAccess.query.VisualQuery;
import memoria.commons.entities.Escuela;
import memoria.commons.structures.GeoReferenced;
import memoria.dataAccess.dao.CsvDao;
import memoria.dataAccess.dao.ShapeFileDao;

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
        repositoriosDeEscuela.add(CsvDao.getInstance());
        repositoriosDeEscuela.add(ShapeFileDao.getInstance());
        entitiesLocationMap.put(Escuela.class.getSimpleName(),repositoriosDeEscuela);
    }

    public List<GeoReferenced> getData(VisualQuery params){
        //Voy a buscar en que repositorios encuentro la data
        String capa = params.getCapa();
        List<IRepositoryDao> daos = entitiesLocationMap.get(capa);
        List<GeoReferenced> results = new ArrayList<GeoReferenced>();

        for (IRepositoryDao iRepositoryDao : daos) {
            results.addAll(iRepositoryDao.getData(params));

        }
        return results;
    }

    public List<IRepositoryDao> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<IRepositoryDao> repositories) {
        this.repositories = repositories;
    }

    

}
