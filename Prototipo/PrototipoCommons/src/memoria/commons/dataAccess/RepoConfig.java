/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.commons.dataAccess;

import java.util.HashMap;

/**
 *
 * @author diego
 */
public class RepoConfig{
        private HashMap<String, String> attributes = new HashMap<String, String>();
        private String repoDaoClass;

        public HashMap<String, String> getAttributes() {
            return attributes;
        }

        public void setAttributes(HashMap<String, String> attributes) {
            this.attributes = attributes;
        }

        public String getRepoDaoClass() {
            return repoDaoClass;
        }

        public void setRepoDaoClass(String repoDaoClass) {
            this.repoDaoClass = repoDaoClass;
        }

        public RepoConfig(String repoDaoClass) {
            this.repoDaoClass = repoDaoClass;
        }


    }
