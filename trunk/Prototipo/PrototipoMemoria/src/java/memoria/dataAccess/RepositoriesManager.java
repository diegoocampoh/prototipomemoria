/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.dataAccess;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import memoria.dataAccess.dao.ExcelDao;
import memoria.commons.dataAccess.query.QueryParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import memoria.commons.dataAccess.RepoConfig;
import memoria.commons.dataAccess.RepositoriesMetadata;
import memoria.commons.dataAccess.query.VisualQuery;
import memoria.commons.entities.Escuela;
import memoria.commons.structures.GeoReferenced;
import memoria.commons.xml.XStreamInstance;
import memoria.dataAccess.dao.CsvDao;
import memoria.dataAccess.dao.ShapeFileDao;

/**
 *
 * @author diego
 */
public class RepositoriesManager {

    private List<IRepositoryDao> repositories = new ArrayList<IRepositoryDao>();
    private HashMap<String,List<IRepositoryDao>> entitiesLocationMap = new HashMap<String, List<IRepositoryDao>>();

    public RepositoriesManager() {
          loadRepoConfig();
//        entitiesLocationMap = new HashMap<String,List<IRepositoryDao>>();
//        List<IRepositoryDao> repositoriosDeEscuela = new ArrayList<IRepositoryDao>();
//        repositoriosDeEscuela.add(ExcelDao.getInstance());
//        repositoriosDeEscuela.add(CsvDao.getInstance());
//        repositoriosDeEscuela.add(ShapeFileDao.getInstance());
//        entitiesLocationMap.put(Escuela.class.getSimpleName(),repositoriosDeEscuela);
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

    private void loadRepoConfig(){

        try{
          // Open the file that is the first
          // command line parameter
          File file = new File(this.getClass().getResource("/memoria/resources/repoConfig.xml").getPath());
          FileInputStream fstream = new FileInputStream(file);
          // Get the object of DataInputStream
          DataInputStream in = new DataInputStream(fstream);
          BufferedReader br = new BufferedReader(new InputStreamReader(in));
          String strLine, xmlLine = "";
          //Read File Line By Line
          while ((strLine = br.readLine()) != null)   {
          // Print the content on the console
            xmlLine += strLine.trim();
          }
          //Close the input stream
          in.close();
          List<RepositoriesMetadata> metadata = (List<RepositoriesMetadata>)XStreamInstance.toObject(xmlLine);

            for (RepositoriesMetadata repositoriesMetadata : metadata) {
                String entity = repositoriesMetadata.getEntity();
                List<IRepositoryDao> repositoriosDeEntity = new ArrayList<IRepositoryDao>();
                for (RepoConfig config: repositoriesMetadata.getRepositories()){
                    Class daoClass = Class.forName(config.getRepoDaoClass());
                    IRepositoryDao dao = (IRepositoryDao) daoClass.newInstance();
                    dao.setInitParams(config.getAttributes());
                    this.repositories.add(dao);
                    repositoriosDeEntity.add(dao);
                }
                
                List<IRepositoryDao> repos = this.entitiesLocationMap.get(entity);
                if (repos != null)
                    repositoriosDeEntity.addAll(repos);
                this.entitiesLocationMap.put(entity, repositoriosDeEntity);
            }
          
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }



    }

}
