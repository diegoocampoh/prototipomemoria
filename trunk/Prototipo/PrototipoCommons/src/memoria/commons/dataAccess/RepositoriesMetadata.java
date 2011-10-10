/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.commons.dataAccess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author diego
 */
public class RepositoriesMetadata {

    private String entity;
    private List<RepoConfig> repositories = new ArrayList<RepoConfig>();

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public List<RepoConfig> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<RepoConfig> repositories) {
        this.repositories = repositories;
    }

    

    

}
