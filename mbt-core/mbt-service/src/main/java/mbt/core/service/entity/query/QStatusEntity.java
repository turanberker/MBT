package mbt.core.service.entity.query;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import mbt.core.service.entity.StatusEntity;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QStatusEntity is a Querydsl query type for StatusEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStatusEntity extends EntityPathBase<StatusEntity> {

    private static final long serialVersionUID = -1016790329L;

    public static final QStatusEntity statusEntity = new QStatusEntity("statusEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public QStatusEntity(String variable) {
        super(StatusEntity.class, forVariable(variable));
    }

    public QStatusEntity(Path<? extends StatusEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStatusEntity(PathMetadata metadata) {
        super(StatusEntity.class, metadata);
    }

}

