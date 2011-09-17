/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.commons.dataAccess.query;

/**
 *
 * @author diego
 */
public class QueryParams {

    protected String attribute_value;
    protected String attribute_name;
    protected String comparison_operation;
    protected Class entity_clazz;


    /**
     * Get the value of string
     *
     * @return the value of string
     */
    public String getAttribute_value() {
        return attribute_value;
    }

    /**
     * Set the value of string
     *
     * @param string new value of string
     */
    public void setAttribute_value(String string) {
        this.attribute_value = string;
    }





}
