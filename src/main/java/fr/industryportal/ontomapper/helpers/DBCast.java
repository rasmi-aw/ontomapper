package fr.industryportal.ontomapper.helpers;

/**
 * @author Abdelwadoud Rasmi
 * convert a
 */
public interface DBCast<Entity, Repository> {

    /**
     * convert a request into a db model
     */
    Entity toDBModel(Repository repository,String createdby);
}
