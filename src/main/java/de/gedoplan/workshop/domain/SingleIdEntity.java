package de.gedoplan.workshop.domain;

public abstract class SingleIdEntity<K>
{
  public abstract K getId();

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
    {
      return true;
    }
    if (obj == null)
    {
      return false;
    }
    if (getClass() != obj.getClass())
    {
      return false;
    }
    @SuppressWarnings("unchecked")
    SingleIdEntity<K> other = (SingleIdEntity<K>) obj;
    if (getId() == null)
    {
      return false;
    }
    else if (!getId().equals(other.getId()))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "SingleIdEntity [id=" + getId() + "]";
  }
}
