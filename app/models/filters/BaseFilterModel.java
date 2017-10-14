package models.filters;

import org.hibernate.Criteria;

public abstract class BaseFilterModel<B extends BaseFilterModel> {
    private Integer pageNumber;
    private Integer pageSize;
    private Integer count;

    public BaseFilterModel() {
        setPageSize(0);
        setPageNumber(0);
        setCount(0);
    }

    protected Criteria addConditions(Criteria rootCriteria) {
        if (getPageSize() != null && getPageSize() != 0) {
            rootCriteria = this.addLimitAndOffset(rootCriteria);
        }
        return rootCriteria;
    }

    protected Criteria addLimitAndOffset(Criteria rootCriteria) {
        if(getPageNumber() == null) {
            setPageNumber(0);
        }
        rootCriteria.setFirstResult(getPageNumber() * getPageSize());
        rootCriteria.setMaxResults(getPageSize());
        return rootCriteria;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
