package mbt.common.dto;

import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class MbtPageable extends AbstractPageRequest {

    private MbtSort sort;

    public MbtPageable(int pageNumber, int pageSize, MbtSort sort) {
        super(pageNumber, pageSize);
        this.sort = sort;
    }

    public MbtPageable() {
        super(0, 10);
        this.sort = new MbtSort();
    }

    @Override
    public Sort getSort() {
        return sort;
    }

    public void setSort(MbtSort sort) {
        this.sort = sort;
    }

    @Override
    public Pageable next() {
        return new MbtPageable(getPageNumber() + 1, getPageSize(), sort);
    }

    @Override
    public Pageable previous() {
        return new MbtPageable(getPageNumber() - 1, getPageSize(), sort);
    }

    @Override
    public Pageable first() {
        return new MbtPageable(0, getPageSize(), sort);
    }

    @Override
    public Pageable withPage(int pageNumber) {
        return new MbtPageable(pageNumber, getPageSize(), sort);
    }
}
