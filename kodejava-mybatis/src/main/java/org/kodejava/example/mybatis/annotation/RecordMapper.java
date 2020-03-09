package org.kodejava.example.mybatis.annotation;

import org.apache.ibatis.annotations.Select;
import org.kodejava.example.mybatis.domain.Record;

public interface RecordMapper {
    /**
     * Get a single Record from the database based on the record
     * identified.
     *
     * @param id record identifier.
     * @return a record object.
     */
    @Select("SELECT * FROM records WHERE id = #{id}")
    Record getRecord(Long id);
}
