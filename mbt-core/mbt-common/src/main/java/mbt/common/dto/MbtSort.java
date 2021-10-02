package mbt.common.dto;

import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class MbtSort extends Sort {

    public MbtSort() {
        super(new ArrayList<>());
    }
}
