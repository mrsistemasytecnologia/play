package net.mrsistemas.play.remote.beans;

import javax.ejb.Remote;

@Remote
public interface IUsuariosEJBRemote {
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * <p>Guarda en base de datos la entidad pasada como parametro.</p>
     * @param jpqlStmt
     * @param entity
     * @return Object
     */
    <T> T persistEntity(T entity);
    
    /**
     * <p>Retorna los valores de la entidad consultada.</p>
     * @param entity
     * @return Object
     */
    <T> T findDatosUsuario(String id);

    /**
     * <p>Actualiza en base de datos la entidad pasada como parametro.</p>
     * @param jpqlStmt
     * @param entity
     * @return Object
     */
    <T> T mergeEntity(T entity);
    
    /**
     * <p>Retorna una lista de los datos retornados como parametro.</p>
     * @param jpqlStmt
     * @return List<Object>
     */
    public Object getEntities(String jpqlStmt);
    
    /**
     * <p>Retorna el dato que devuelva la consulta</p>
     * @param jpqlStmt
     * @param parametro
     * @return Object
     */
    public Object getEntityById(String jpqlStmt, String parametro);
    
    /**
     * <p>Retorna el dato que devuelva la consulta</p>
     * @param jpqlStmt
     * @param parametro
     * @return Object
     */
    public Object getConsultaDosParametros(String jpqlStmt, String parametroUno, String parametroDos);

	public Object getEntitiesById(String jpqlStmt, String parametro);

	/**
     * <p>Retorna los datos de la ciudad consultada por ID</p>
     * @param id
     * @return Object
     */
	<T> T findCityById(String id);

	<T> T validaDatosSession(String id);
    
}
