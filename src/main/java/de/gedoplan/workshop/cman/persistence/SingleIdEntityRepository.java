package de.gedoplan.workshop.cman.persistence;

import de.gedoplan.workshop.cman.entity.SingleIdEntity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public abstract class SingleIdEntityRepository<K, E extends SingleIdEntity<K>>
{
  @Inject
  EntityManager    entityManager;

  /**
   * Klassenobjekt der Entity-Klasse.
   */
  private Class<E> entityClass;

  /**
   * Klassenobject der Entity liefern.
   * 
   * @return Klassenobjekt E.class
   */
  @SuppressWarnings("unchecked")
  protected Class<E> getEntityClass()
  {
    if (this.entityClass == null)
    {
      Class<?> repoClass = getClass();
      while (true)
      {
        Class<?> baseClass = repoClass.getSuperclass();
        assert baseClass != null : "Repository must be derived from " + SingleIdEntityRepository.class.getName();

        if (baseClass == SingleIdEntityRepository.class)
        {
          break;
        }

        repoClass = baseClass;
      }

      Type genericSuperClass = repoClass.getGenericSuperclass();
      assert genericSuperClass instanceof ParameterizedType : SingleIdEntityRepository.class.getName() + " must be generic";

      Type[] typeParms = ((ParameterizedType) genericSuperClass).getActualTypeArguments();
      assert typeParms.length == 2 : SingleIdEntityRepository.class.getName() + " must have 2 type parameters but has " + typeParms.length;

      Type entityType = typeParms[1];

      if (entityType instanceof ParameterizedType)
      {
        entityType = ((ParameterizedType) entityType).getRawType();
      }

      assert entityType instanceof Class<?> : "Entity must be a class type";

      this.entityClass = (Class<E>) entityType;
    }

    return this.entityClass;
  }

  public void persist(E entity)
  {
    this.entityManager.joinTransaction();
    this.entityManager.persist(entity);
  }

  public E merge(E entity)
  {
    this.entityManager.joinTransaction();
    return this.entityManager.merge(entity);
  }

  public void remove(E entity)
  {
    this.entityManager.joinTransaction();
    this.entityManager.remove(entity);
  }

  public E findById(K id)
  {
    return this.entityManager.find(getEntityClass(), id);
  }

  public List<E> findAll()
  {
    // TODO: Vereinfachende Annahme: Entity Name = Simple Class Name
    return this.entityManager.createQuery("select x from " + getEntityClass().getSimpleName() + " x", getEntityClass()).getResultList();
  }

}
