package by.st.deliver.core.mappers;

import by.st.deliver.core.entities.Comment;
import dto.CommentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mappings({@Mapping(source = "product.id", target = "productId"),
            @Mapping(source = "restaurant.id", target = "restaurantId"),
            @Mapping(source = "client.id", target = "clientId")})
    CommentDTO commentToCommentDTO(Comment comment);

    @Mappings({@Mapping(source = "productId", target = "product.id"),
            @Mapping(source = "restaurantId", target = "restaurant.id"),
            @Mapping(source = "clientId", target = "client.id")})
    Comment commentDTOToComment(CommentDTO commentDTO);
}
